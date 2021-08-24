package lwj.demo.activiti;

import java.util.HashMap;
import java.util.Map;

import org.activiti.engine.TaskService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import lwj.demo.activiti.service.ProcessService;
import lwj.demo.activiti.service.RefuseTaskDelegate;
import lwj.demo.activiti.service.AgreeTaskDelegate;
import lwj.demo.activiti.service.CreateTaskDelegate;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ActivitiServerApplication.class)
public class ProcessServiceTest {

    @Autowired
    private ProcessService processService;
    @Autowired
    private TaskService taskService;
    @Autowired
    private CreateTaskDelegate createTaskDelegate;
    @Autowired
    private AgreeTaskDelegate agreeTaskDelegate;
    @Autowired
    private RefuseTaskDelegate refuseTaskDelegate;

    // @Test
    public void deployProcessTest() {
        processService.deployProcess("process/java-service.bpmn", "新流程1006");
    }

    // @Test
    public void queryProcess() {
        processService.queryProcessDeployment();
    }

    // @Test
    public void startPorcInstance() {
        Map<String, Object> map = new HashMap<>();
        map.put("businessKey", "abc1234");
        map.put("createTaskDelegate", createTaskDelegate);
        map.put("agreeTaskDelegate", agreeTaskDelegate);
        map.put("refuseTaskDelegate", refuseTaskDelegate);
        processService.startPorcInstance("java-service2", "abc1234", map);
    }

    // @Test
    public void queryUserTask() {
        processService.queryUserTask();
    }

    @Test
    public void completeUserTask() {
        processService.completeUserTask("165008");
    }

    // @Test
    public void deleteProcDeployment() {
        String taskId = "3103";
        // 完成任务的同时，设置流程变量，使用流程变量用来指定完成任务后，下一个连线，对应sequenceFlow.bpmn文件中${message=='不重要'}
        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("message", "重要");
        taskService.complete(taskId, variables);
    }

    // @Test
    public void dynamicDeploy() {
        processService.dynamicDeploy();
    }

    // @Test
    public void printProcessDeployment() throws Exception {
        processService.printProcessDeployment();
    }

}
