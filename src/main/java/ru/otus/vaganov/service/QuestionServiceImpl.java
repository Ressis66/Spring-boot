package ru.otus.vaganov.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import ru.otus.vaganov.dao.QuestionDao;
import ru.otus.vaganov.domain.Question;
import ru.otus.vaganov.domain.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

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
  public void initTesting(String answer)  {
    List<String> items = Arrays.asList(answer.split("\\s*,\\s*"));
    Question question = questionDao.getQuestion(Integer.parseInt(items.get(0)));
    if (question.getRight_answer().equals(items.get(1)))
      System.out.println("You are lucky boy!");
    else System.out.println("You are stupid boy!");
  }
  @Override
  public User initUser(String line) {
    List<String> nameAndSurname = Arrays.asList(line.split("\\s*,\\s*"));
    User user = new User(nameAndSurname.get(0), nameAndSurname.get(1));
    return user;
  }
  @Override
  public void initQuestions(User user){
    List<Question> questions =  getQuestionsList(user);
    for (Question q : questions) {
      System.out.println(q.toString());
    }
    System.out.println("______________________________________________");
    System.out.println(user.getName() + ", please, enter question_id and, after comma, name of the right answer");
  }
  @Override
  public void initTestingService() throws IOException {
    System.out.println("Please name and, after comma, surname of the User");
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String answer = reader.readLine();
    User user = initUser(answer);
    initQuestions(user);
    String answer2 = reader.readLine();;
    initTesting(answer2);
  }


}


