package com.thoughtworks.exam.domain.model;

import java.util.List;

public interface BlankQuizRepository {
    BlankQuiz find(BlankQuizId blankQuizId);

    void save(BlankQuiz blankQuiz);

    BlankQuizId nextBlankQuiz();

    List<BlankQuiz> getAll();
}
