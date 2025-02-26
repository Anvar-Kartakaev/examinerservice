package pro.sky.java.course2.examinerservice.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.examinerservice.domain.Question;

import java.util.Collection;
import java.util.HashSet;

@Service
public class ExaminerServiceImpl implements QuestionService {
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    public Collection<Question> getQuestions(int amount) {
        Collection<Question> result = new HashSet<>();
        if (amount > 0) {
            for (int i = 0; i < amount; i++) {
                result.add(questionService.getRandomQuestion());
            }
        } else {
            throw new IllegalArgumentException("Кол-во должно быть больше нуля");
        }
        return result;
    }

    @Override
    public Question add(String question, String answer) {
        return questionService.add(question, answer);
    }

    @Override
    public Question add(Question question) {
        return questionService.add(question);
    }

    @Override
    public Question remove(Question question) {
        return questionService.remove(question);
    }

    @Override
    public Collection<Question> getAll() {
        return questionService.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        return questionService.getRandomQuestion();
    }


}
