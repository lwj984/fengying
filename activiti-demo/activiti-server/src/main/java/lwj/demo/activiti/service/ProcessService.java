package lwj.demo.activiti.service;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.bpmn.BpmnAutoLayout;
import org.activiti.bpmn.model.BpmnModel;
import org.activiti.bpmn.model.EndEvent;
import org.activiti.bpmn.model.ExclusiveGateway;
import org.activiti.bpmn.model.Gateway;
import org.activiti.bpmn.model.ParallelGateway;
import org.activiti.bpmn.model.Process;
import org.activiti.bpmn.model.SequenceFlow;
import org.activiti.bpmn.model.StartEvent;
import org.activiti.bpmn.model.UserTask;
import org.activiti.engine.HistoryService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentQuery;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.activiti.image.ProcessDiagramGenerator;
import org.activiti.image.impl.DefaultProcessDiagramGenerator;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProcessService {

    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private TaskService taskService;
    @Autowired
    private ProcessEngine processEngine;
    @Autowired
    private RepositoryService repositoryService;
    @Autowired
    private HistoryService historyService;

    public void deployProcess(String bpmn, String name) {
        repositoryService.createDeployment().addClasspathResource(bpmn).name(name).deploy();
    }

    public void queryProcessDeployment() {
        DeploymentQuery query = repositoryService.createDeploymentQuery();
        List<Deployment> list = query.deploymentName("测试流程").list();
        log.info("{}", list);
    }

    public void startPorcInstance(String key, String businssKey, Map map) {
        // 创建流程实例,通过流程定义的id
        // 通过流程部署的key启动
        ProcessInstance ins = runtimeService.startProcessInstanceByKey(key, businssKey, map);
        log.info("{}", JSON.toJSONString(ins.getProcessInstanceId()));
        // 通过流程部署id启动
        // runtimeService.startProcessInstanceById("testProcess:2:5003");
    }

    public void queryUserTask() {
        TaskQuery taskQuery = taskService.createTaskQuery();
        List<Task> list = taskQuery.processInstanceBusinessKey("abc1234").taskDefinitionKey("userTask2").list();
        log.info("{}", list);
    }

    public void completeUserTask(String taskId) {
        Map<String, Object> variables = new HashMap<>();
        variables.put("reuslt", "拒绝");
        taskService.complete(taskId, variables);
    }

    public void deleteProcDeployment() {
        // 删除流程定义，流程部署，以及二进制的资源记录
        repositoryService.deleteDeployment("5001");
    }

    public void dynamicDeploy() {
        // 1. Build up the model from scratch
        BpmnModel model = new BpmnModel();
        Process process = new Process();
        model.addProcess(process);
        process.setId("dynamic-process");

        process.addFlowElement(createStartEvent());
        process.addFlowElement(createUserTask("task1", "first task", "${firstAssignee}"));
        process.addFlowElement(createUserTask("task2", "second task", "${secondAssignee}"));
        process.addFlowElement(createUserTask("task3", "third task", "${thirdAssignee}"));
        process.addFlowElement(createExclusiveGateway("gateway1", "first gateway"));
        process.addFlowElement(createEndEvent());

        process.addFlowElement(createSequenceFlow("start", "task1", null));
        process.addFlowElement(createSequenceFlow("task1", "gateway1", null));
        process.addFlowElement(createSequenceFlow("gateway1", "task2", "${day>3}"));
        process.addFlowElement(createSequenceFlow("gateway1", "task3", null));
        process.addFlowElement(createSequenceFlow("task2", "task3", null));
        process.addFlowElement(createSequenceFlow("task3", "end", null));

        // 2. Generate graphical information
        new BpmnAutoLayout(model).execute();

        // 3. Deploy the process to the engine
        repositoryService.createDeployment().addBpmnModel("dynamic-model.bpmn", model)
                .name("dynamic-process-deployment").deploy();

    }

    private Gateway createParallelGateway(String id, String name) {
        Gateway gateway = new ParallelGateway();
        gateway.setId(id);
        gateway.setName(name);
        return gateway;
    }

    private Gateway createExclusiveGateway(String id, String name) {
        Gateway gateway = new ExclusiveGateway();
        gateway.setId(id);
        gateway.setName(name);
        return gateway;
    }

    protected UserTask createUserTask(String id, String name, String assignee) {
        UserTask userTask = new UserTask();
        userTask.setName(name);
        userTask.setId(id);
        userTask.setAssignee(assignee);
        return userTask;
    }

    protected SequenceFlow createSequenceFlow(String from, String to, String condition) {
        SequenceFlow flow = new SequenceFlow();
        flow.setSourceRef(from);
        flow.setTargetRef(to);
        flow.setConditionExpression(condition);
        return flow;
    }

    protected StartEvent createStartEvent() {
        StartEvent startEvent = new StartEvent();
        startEvent.setId("start");
        return startEvent;
    }

    protected EndEvent createEndEvent() {
        EndEvent endEvent = new EndEvent();
        endEvent.setId("end");
        return endEvent;
    }

    public void printProcessDeployment() throws Exception {
        ProcessDefinitionQuery processDefinitionQuery = repositoryService.createProcessDefinitionQuery();
        List<ProcessDefinition> list1 = processDefinitionQuery.deploymentId("47501").list();
        log.info("{}", list1);

        ProcessDefinition df = list1.get(0);
        String saveResourceDir = "C:\\Users\\Administrator\\Desktop\\";

        // get process model
        BpmnModel model = repositoryService.getBpmnModel(df.getId());

        if (model != null && model.getLocationMap().size() > 0) {
            InputStream is = repositoryService.getResourceAsStream(df.getDeploymentId(), df.getResourceName());
            OutputStream ou = new FileOutputStream(saveResourceDir + df.getResourceName());
            IOUtils.copy(is, ou);

            ProcessDiagramGenerator generator = new DefaultProcessDiagramGenerator();
            // 生成流程图 都不高亮
            InputStream in = generator.generateDiagram(model, Collections.<String> emptyList());
            String imageName = "dynamic-process.svg";
            OutputStream os = new FileOutputStream(saveResourceDir + imageName);
            IOUtils.copy(in, os);

            Thread.sleep(10000);
            in.close();
            os.close();
            is.close();
            ou.close();
        }
    }
}
