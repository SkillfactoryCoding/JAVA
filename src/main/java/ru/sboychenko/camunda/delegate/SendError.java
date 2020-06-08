package ru.sboychenko.camunda.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.sboychenko.camunda.sender.Sender;

@Component("SendError")
public class SendError implements JavaDelegate {

    final
    Sender sender;

    @Autowired
    public SendError(@Qualifier("email") Sender sender) {
        this.sender = sender;
    }

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        sender.send(execution.getVariableTyped("email"), "Нет возможности отгрузить ваш заказ");

    }
}
