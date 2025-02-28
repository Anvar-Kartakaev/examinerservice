package pro.sky.java.course2.examinerservice.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import pro.sky.java.course2.examinerservice.domain.Question;

import java.util.Collection;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class ExaminerServiceImplTest {
    @Mock
    JavaQuestionService javaQuestionService;
    ExaminerServiceImpl examinerService;

    @Test
    void whenGetQuestionsIsNull_ThenExaminerServiceImplReturnsResults() {
        int amount = Integer.parseInt(null);
        Assertions.assertThrows(IllegalArgumentException.class, () -> examinerService.getQuestions(amount));
    }

    @Test
    void whenGetQuestionsIsNotNull_ThenExaminerServiceImplReturnsResults() {
        int amount = Integer.parseInt(null);
        Assertions.assertNotNull(examinerService.getQuestions(amount));
    }

    @Test
    void whenGetQuestionsIsEmpty_ThenExaminerServiceImplReturnsResults() {
        int amount = 0;
        Assertions.assertThrows(IllegalArgumentException.class, () -> examinerService.getQuestions(amount));
    }

    @Test
    void whenGetQuestionsIsNotEmpty_ThenExaminerServiceImplReturnsResults() {
        int amount = 2;
        if (amount < 0) {
            Assertions.assertThrows(IllegalArgumentException.class, () -> examinerService.getQuestions(amount));
        } else {
            Assertions.assertDoesNotThrow(() -> examinerService.getQuestions(amount));
        }
    }

    @Test
    void whenAddWitchQuestionAndAnswerIsEmpty_ThenExaminerServiceImplReturnsResults() {
        String question = "";
        String answer = "";
        Assertions.assertThrows(IllegalArgumentException.class, () -> javaQuestionService.add(question, answer));
    }

    @Test
    void whenAddWitchQuestionAndAnswerIsNotEmpty_ThenExaminerServiceImplReturnsResults() {
        String question = "Question";
        String answer = "Answer";
        Assertions.assertDoesNotThrow(() -> javaQuestionService.add(question, answer));
    }

    @Test
    void whenAddWitchQuestionIsNull_ThenExaminerServiceImplReturnsResults() {
        Question question = null;
        Assertions.assertThrows(IllegalArgumentException.class, () -> javaQuestionService.add(question));
    }

    @Test
    void whenAddWitchQuestionIsNotNull_ThenExaminerServiceImplReturnsResults() {
        Question question = null;
        Assertions.assertNotNull(javaQuestionService.add(question));
    }

    @Test
    void whenRemoveWitchQuestionIsNull_ThenExaminerServiceImplReturnsResults() {
        Question question = null;
        Assertions.assertThrows(IllegalArgumentException.class, () -> javaQuestionService.remove(question));
    }

    @Test
    void whenRemoveWitchQuestionIsNotNull_ThenExaminerServiceImplReturnsResults() {
        Question question = new Question("Question", "Answer");
        Assertions.assertNotNull(javaQuestionService.remove(question));
    }

    @Test
    void whenGetAllIsNull_ThenExaminerServiceImplReturnsResults() {
        Collection<Question> questions = null;
        Assertions.assertThrows(IllegalArgumentException.class, () -> javaQuestionService.getAll());
    }

    @Test
    void whenGetAllIsNotNull_ThenExaminerServiceImplReturnsResults() {
        Collection<Question> questions = javaQuestionService.getAll();
        Assertions.assertNotNull(questions);
    }

}