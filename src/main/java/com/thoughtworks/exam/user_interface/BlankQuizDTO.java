package com.thoughtworks.exam.user_interface;

import com.thoughtworks.exam.domain.model.BlankQuizId;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BlankQuizDTO {
    private String uri;

    public static BlankQuizDTO from(BlankQuizId blankQuizId) {
        return new BlankQuizDTO("blank-quizzes/" + blankQuizId);
    };
}
