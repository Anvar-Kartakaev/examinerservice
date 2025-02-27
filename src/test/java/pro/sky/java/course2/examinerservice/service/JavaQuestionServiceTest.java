package pro.sky.java.course2.examinerservice.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pro.sky.java.course2.examinerservice.domain.Question;

import java.util.Collection;

class JavaQuestionServiceTest {
    JavaQuestionService service;

    @Test
    void whenAddWitchQuestionAndAnswerIsEmpty_ThenJavaServiceReturnsResults() {
        String question = "";
        String answer = "";
        Assertions.assertThrows(IllegalArgumentException.class, () -> service.add(question, answer));
    }

    @Test
    void whenAddWitchQuestionAndAnswerIsNotEmpty_ThenJavaServiceReturnsResults() {
        String question = "Question";
        String answer = "Answer";
        Assertions.assertDoesNotThrow(() -> service.add(question, answer));
    }

    @Test
    void whenAddWitchQuestionIsNull_ThenJavaServiceReturnsResults() {
        Question question = null;
        Assertions.assertThrows(IllegalArgumentException.class, () -> service.add(question));
    }

    @Test
    void whenAddWitchQuestionIsNotNull_ThenJavaServiceReturnsResults() {
        Question question = new Question("Question", "Answer");
        Assertions.assertNotNull(service.add(question));
    }

    @Test
    void whenRemoveWitchQuestionIsNull_ThenJavaServiceReturnsResults() {
        Question question = null;
        Assertions.assertThrows(IllegalArgumentException.class, () -> service.remove(question));
    }

    @Test
    void whenRemoveWitchQuestionIsNotNull_ThenJavaServiceReturnsResults() {
        Question question = new Question("Question", "Answer");;
        Assertions.assertNotNull(service.remove(question));
    }

    @Test
    void whenGetAllIsNull_ThenJavaServiceReturnsResults() {
        Collection<Question> questions = null;
        Assertions.assertThrows(IllegalArgumentException.class, () -> service.getAll());
    }

    @Test
    void whenGetAllIsNotNull_ThenJavaServiceReturnsResults() {
        Collection<Question> result = service.getAll();
        Assertions.assertNotNull(result);
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