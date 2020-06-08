package ru.sboychenko.camunda.sender;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("sms")
public class SmsSender implements Sender {
    @Override
    public void send(String to, String text) {
        System.out.println("Send sms to " + to + " with text = " + text);
        //TODO https://smsc.ru/api/code/libraries/http_smtp/java/#menu
    }
}
