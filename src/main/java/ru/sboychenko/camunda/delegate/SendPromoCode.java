package ru.sboychenko.camunda.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.sboychenko.camunda.sender.Sender;

import java.util.UUID;

@Component("SendPromoCode")
public class SendPromoCode implements JavaDelegate {

    private final Sender sender;

    @Autowired
    public SendPromoCode(@Qualifier("sms") Sender sender) {
        this.sender = sender;
    }

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        String code = UUID.randomUUID().toString();
        sender.send(execution.getVariableTyped("phone"),  "Send promo-code = " + code);
    }
}
