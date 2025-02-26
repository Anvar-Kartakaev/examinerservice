package pro.sky.java.course2.examinerservice.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pro.sky.java.course2.examinerservice.domain.Question;

import java.util.Collection;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class ExaminerServiceImplTest {
    ExaminerServiceImpl examinerService;

    @Test
    void whenGetQuestionsIsNull_ThenExaminerServiceImplReturnsResults() {
        int amount = Integer.parseInt(null);
        Assertions.assertThrows(IllegalArgumentException.class, () -> examinerService.getQuestions(amount));
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
        Assertions.assertThrows(IllegalArgumentException.class, () -> examinerService.add(question, answer));
    }

    @Test
    void whenAddWitchQuestionIsNull_ThenExaminerServiceImplReturnsResults() {
        Question question = null;
        Assertions.assertThrows(IllegalArgumentException.class, () -> examinerService.add(question));
    }

    @Test
    void whenRemoveWitchQuestionIsNull_ThenExaminerServiceImplReturnsResults() {
        Question question = null;
        Assertions.assertThrows(IllegalArgumentException.class, () -> examinerService.remove(question));
    }

    @Test
    void whenGetAllIsNull_ThenExaminerServiceImplReturnsResults() {
        Collection<Question> questions = null;
        Assertions.assertThrows(IllegalArgumentException.class, () -> examinerService.getAll());
    }

}