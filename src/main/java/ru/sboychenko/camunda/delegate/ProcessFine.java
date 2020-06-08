package ru.sboychenko.camunda.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.variable.value.LongValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;

@Component("Fine")
public class ProcessFine implements JavaDelegate {

    @Value("${app.file.fine}")
    private String FINE_FILE_PATH;

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        try {
            LongValue orderSum = execution.getVariableTyped("sum");
            double sum = orderSum.getValue() * 0.05;

            Path p = Paths.get(FINE_FILE_PATH);
            if (!Files.exists(p)) {
                Files.createFile(p);
            }
            Files.write(p, (execution.getBusinessKey() + " " + LocalDate.now() + " sum= " + sum + "\n").getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }
}
