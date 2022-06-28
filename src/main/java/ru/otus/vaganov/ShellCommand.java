package ru.otus.vaganov;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellComponent;
import ru.otus.vaganov.service.QuestionService;

import java.io.IOException;

@ShellComponent
public class ShellCommand {

  @Autowired
  QuestionService service;

  @ShellMethod("Initiate testing.")
  public void start() throws IOException {
     service.initTestingService();
  }
}
