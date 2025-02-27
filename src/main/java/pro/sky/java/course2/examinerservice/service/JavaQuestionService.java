package pro.sky.java.course2.examinerservice.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.examinerservice.domain.Question;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class JavaQuestionService implements QuestionService {
    private Set<Question> questions;

    public JavaQuestionService() {
        questions = new HashSet<>();
        addTestQuestions();
    }

    public void addTestQuestions() {
        questions.add(new Question("Вопрос номер один", "Ответ на вопрос номер один"));
        questions.add(new Question("Вопрос номер два", "Ответ на вопрос номер два"));
        questions.add(new Question("Вопрос номер три", "Ответ на вопрос номер три"));
    }

    @Override
    public Question add(String question, String answer) {
        questions.add(new Question(question, answer));
        return new Question(question, answer);
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return new Question(question.getQuestion(), question.getAnswer());
    }

    @Override
    public Question remove(Question question) {
        questions.remove(question);
        return new Question(question.getQuestion(), question.getAnswer());
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
