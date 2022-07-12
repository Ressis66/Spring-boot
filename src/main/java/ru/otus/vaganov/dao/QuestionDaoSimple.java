package ru.otus.vaganov.dao;

import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import ru.otus.vaganov.domain.Question;

import java.io.FileNotFoundException;
import java.io.FileReader;


import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;


@Component
public class QuestionDaoSimple implements QuestionDao {

  private List<Question> questions;


    public QuestionDaoSimple(MessageSource messageSource) throws FileNotFoundException {
    List<Question> questions = new CsvToBeanBuilder<Question>
        (new FileReader(messageSource.getMessage("env.locale", null, Locale.getDefault()))).withType(Question.class)
        .build()
        .parse();
    this.questions= questions;
    }

  @Override
  public List<Question> getList() {
    return questions;
  }

  @Override
  public Question getQuestion(int id) {
    return questions.get(id);
  }

}
