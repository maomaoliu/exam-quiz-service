package com.thoughtworks.exam.quiz.domain.model.blankquiz;

public interface BlankQuizRepository {

    void save(BlankQuiz blankQuiz);

    void delete(BlankQuizId id);

    BlankQuiz find(BlankQuizId blankQuizId);
}
