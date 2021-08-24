package lwj.demo.activiti.service;

import java.io.Serializable;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.Expression;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AgreeTaskDelegate implements JavaDelegate, Serializable {

    private static final long serialVersionUID = 8185681366959544365L;

    private Expression taskId;

    private Expression businessKey;

    private Expression endFlag;

    @Override
    public void execute(DelegateExecution execution) {
        log.info("taskId ->" + taskId.getValue(execution));
        log.info("businessKey ->" + businessKey.getValue(execution));
        log.info("endFlag ->" + endFlag.getValue(execution));
    }

}
