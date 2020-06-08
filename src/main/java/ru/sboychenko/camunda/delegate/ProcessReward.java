package ru.sboychenko.camunda.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component("Reward")
public class ProcessReward implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        //TODO Обработка премий
    }
}
