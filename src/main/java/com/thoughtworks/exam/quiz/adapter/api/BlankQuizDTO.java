package com.thoughtworks.exam.quiz.adapter.api;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author gitqh
 */
@Getter
@AllArgsConstructor
public class BlankQuizDTO {
    private String blankQuizId;

    public static BlankQuizDTO from(final String blankQuizId) {
        return new BlankQuizDTO(blankQuizId);
    }
}
