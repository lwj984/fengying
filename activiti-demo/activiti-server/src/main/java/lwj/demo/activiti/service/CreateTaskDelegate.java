package lwj.demo.activiti.service;

import java.io.Serializable;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.Expression;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CreateTaskDelegate implements JavaDelegate, Serializable {

    private static final long serialVersionUID = 8185681366959544365L;

    private Expression taskId;

    private Expression businessKey;

    private Expression assignee;

    @Override
    public void execute(DelegateExecution execution) {
        log.info("taskId ->" + taskId.getValue(execution));
        log.info("businessKey ->" + businessKey.getValue(execution));
        String assigneeStr = assignee.getValue(execution).toString();
        log.info("assignee ->" + assigneeStr);
        execution.setVariable(assigneeStr, "刘伟佳");
    }

}
