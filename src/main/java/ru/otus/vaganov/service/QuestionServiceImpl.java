package ru.otus.vaganov.service;

import org.springframework.stereotype.Service;
import ru.otus.vaganov.dao.QuestionDao;
import ru.otus.vaganov.domain.Question;
import ru.otus.vaganov.domain.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

@Service
public class QuestionServiceImpl implements QuestionService {

    private QuestionDao questionDao;


  public QuestionServiceImpl(QuestionDao questionDao) {
    this.questionDao = questionDao;
  }

  @Override
  public List<Question> getQuestionsList(User user) {
    if(user==null) return null;
    else return questionDao.getList();
  }

  @Override
  public Question getQuestionAccordingToId(int id){ return questionDao.getQuestion(id); }

  @Override
  public void initTesting(String answer, Locale locale)  {
    List<String> items = Arrays.asList(answer.split("\\s*,\\s*"));
    Question question = questionDao.getQuestion(Integer.parseInt(items.get(0)));
    if (question.getRight_answer().equals(items.get(1)))
      System.out.println(ResourceBundle.getBundle("messages", locale).getString("lang.lucky"));
    else System.out.println(ResourceBundle.getBundle("messages", locale).getString("lang.stupid"));
  }

  @Override
  public User initUser(String line) {
    List<String> nameAndSurname = Arrays.asList(line.split("\\s*,\\s*"));
    User user = new User(nameAndSurname.get(0), nameAndSurname.get(1));
    return user;
  }

  @Override
  public void initQuestions(User user, Locale locale){
    List<Question> questions =  getQuestionsList(user);
    for (Question q : questions) {
      System.out.println(q.toString());
    }
    System.out.println("______________________________________________");
    System.out.println(user.getName() + ResourceBundle.getBundle("messages", locale).getString("lang.sentence"));
  }

  @Override
  public void initTestingService() throws IOException {
    System.out.println("Please, enter your language: en/ru");
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String answer = reader.readLine();
    var locale = new Locale(answer);
    System.out.println(ResourceBundle.getBundle("messages", locale).getString("greeting"));
    String answer2 = reader.readLine();
    User user = initUser(answer2);
    initQuestions(user, locale);
    String answer3 = reader.readLine();;
    initTesting(answer3, locale);
  }


}


