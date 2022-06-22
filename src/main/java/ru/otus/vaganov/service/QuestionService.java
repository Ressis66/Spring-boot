package ru.otus.vaganov.service;

import ru.otus.vaganov.domain.Question;
import ru.otus.vaganov.domain.User;

import java.io.IOException;
import java.util.List;

public interface QuestionService {
     List<Question> getQuestionsList(User user);
     Question getQuestionAccordingToId(int id);
     void initTesting(String answer) throws IOException;
     User initUser(String line);
     void initQuestions(User user);
     void initTestingService() throws IOException;
}
