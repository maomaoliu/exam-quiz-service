package com.thoughtworks.exam.application;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdateQuizCommand {

    private String question;
    private String answer;
}
