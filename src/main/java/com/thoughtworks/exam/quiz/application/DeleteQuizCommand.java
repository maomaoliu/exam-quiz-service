package com.thoughtworks.exam.quiz.application;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DeleteQuizCommand {
    private String quizId;
}
