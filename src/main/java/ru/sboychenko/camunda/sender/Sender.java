package ru.sboychenko.camunda.sender;

public interface Sender {
    void send(String to, String text);
}
