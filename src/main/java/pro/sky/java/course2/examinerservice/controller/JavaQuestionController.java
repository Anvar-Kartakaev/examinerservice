package pro.sky.java.course2.examinerservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.examinerservice.domain.Question;
import pro.sky.java.course2.examinerservice.service.JavaQuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {
    private final JavaQuestionService javaQuestionService;

    public JavaQuestionController(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @GetMapping
    public Collection<Question> getQuestions() {
        return javaQuestionService.getAll().stream().toList();
    }

    @GetMapping("/add")
    public Question addQuestion(@RequestParam String question, String answer) {
        return javaQuestionService.add(question, answer);
    }

    @GetMapping("/remove")
    public Question removeQuestion(@RequestParam String question, String answer) {
        javaQuestionService.getAll().stream().
                filter(q -> q.getQuestion().equalsIgnoreCase(question) && q.getAnswer().equalsIgnoreCase(answer))
                .findFirst().ifPresent(javaQuestionService::remove);
        return null;
    }

}

