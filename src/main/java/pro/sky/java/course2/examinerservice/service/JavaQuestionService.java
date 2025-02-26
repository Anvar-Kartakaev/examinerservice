package pro.sky.java.course2.examinerservice.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.examinerservice.domain.Question;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class JavaQuestionService implements QuestionService {
    private Set<Question> questions;

    public JavaQuestionService() {
        questions = new HashSet<>();
    }

    @Override
    public Question add(String question, String answer) {
        Question result = new Question(question, answer);
        questions.add(result);
        return result;
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return questions.stream().toList();
    }

    public Question getRandomQuestion() {
        Random random = new Random();
        int index = random.nextInt(questions.size());
        return questions.stream().toList().get(index);
    }

}
