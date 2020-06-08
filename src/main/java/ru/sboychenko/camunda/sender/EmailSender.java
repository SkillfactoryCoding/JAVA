package ru.sboychenko.camunda.sender;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("email")
public class EmailSender implements Sender {
    @Override
    public void send(String to, String text) {
        System.out.println("Send email to " + to + " with text = " + text);
        //TODO https://www.baeldung.com/java-email
    }
}
