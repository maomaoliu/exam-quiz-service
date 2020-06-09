package com.thoughtworks.exam.quiz;

import com.thoughtworks.exam.quiz.adapter.api.BlankQuizController;
import com.thoughtworks.exam.quiz.application.BlankQuizApplicationService;
import com.thoughtworks.exam.quiz.application.CreateQuizCommand;
import com.thoughtworks.exam.quiz.domain.model.blankquiz.BlankQuizId;
import com.thoughtworks.exam.quiz.domain.model.blankquiz.IllegalScoreException;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = QuizServiceApplication.class)
public abstract class BlankQuizBase {

    @Autowired
    private BlankQuizController blankQuizController;

    @MockBean
    private BlankQuizApplicationService quizApplicationService;

    @BeforeEach
    public void setup() throws IllegalScoreException {
        RestAssuredMockMvc.standaloneSetup(blankQuizController);

        Mockito.when(quizApplicationService.createQuiz(any(CreateQuizCommand.class)))
                .thenReturn(new BlankQuizId("90fdknaf09fopfkmald"));
    }

}