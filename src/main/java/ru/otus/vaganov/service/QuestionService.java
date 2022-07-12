package ru.otus.vaganov.service;

import ru.otus.vaganov.domain.Question;
import ru.otus.vaganov.domain.User;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public interface QuestionService {
     List<Question> getQuestionsList(User user);
     Question getQuestionAccordingToId(int id);
     void initTesting(String answer, Locale locale) throws IOException;
     User initUser(String line);
     void initQuestions(User user, Locale locale);
     void initTestingService() throws IOException;
}
