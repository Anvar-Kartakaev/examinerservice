package pro.sky.java.course2.examinerservice.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import pro.sky.java.course2.examinerservice.domain.Question;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionServiceTest {
    @Mock
    JavaQuestionService service;

    @Test
    void whenAddWitchQuestionAndAnswerIsEmpty_ThenJavaServiceReturnsResults() {
        String question = "";
        String answer = "";
        Assertions.assertThrows(IllegalArgumentException.class, () -> service.add(question, answer));
    }

    @Test
    void whenAddWitchQuestionIsNull_ThenJavaServiceReturnsResults() {
        Question question = null;
        Assertions.assertThrows(IllegalArgumentException.class, () -> service.add(question));
    }

    @Test
    void whenRemoveWitchQuestionIsNull_ThenJavaServiceReturnsResults() {
        Question question = null;
        Assertions.assertThrows(IllegalArgumentException.class, () -> service.remove(question));
    }

    @Test
    void whenGetAllIsNull_ThenJavaServiceReturnsResults() {
        Collection<Question> questions = null;
        Assertions.assertThrows(IllegalArgumentException.class, () -> service.getAll());
    }

    @Test
    void whenGetRandomQuestionIsNull_ThenJavaServiceReturnsResults() {
        int amount = Integer.parseInt(null);
        Assertions.assertThrows(IllegalArgumentException.class, () -> service.getRandomQuestion());
    }

    @Test
    void whenGetRandomQuestionIsEmpty_ThenJavaServiceReturnsResults() {
        int amount = 0;
        Assertions.assertThrows(IllegalArgumentException.class, () -> service.getRandomQuestion());
    }

    @Test
    void whenGetRandomQuestionIsNotNull_ThenJavaServiceReturnsResults() {
        int amount = 2;
        if (amount < 0) {
            Assertions.assertThrows(IllegalArgumentException.class, () -> service.getRandomQuestion());
        } else {
            Assertions.assertDoesNotThrow(() -> service.getRandomQuestion());
        }
    }
}