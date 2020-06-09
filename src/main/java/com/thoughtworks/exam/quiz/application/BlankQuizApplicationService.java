package com.thoughtworks.exam.quiz.application;

import com.thoughtworks.exam.quiz.adapter.repository.BlankQuizJPARepository;
import com.thoughtworks.exam.quiz.adapter.repository.entity.BlankQuizEntity;
import com.thoughtworks.exam.quiz.domain.model.blankquiz.BlankQuiz;
import com.thoughtworks.exam.quiz.domain.model.blankquiz.BlankQuizId;
import com.thoughtworks.exam.quiz.domain.model.blankquiz.IllegalScoreException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BlankQuizApplicationService {
    private BlankQuizJPARepository blankQuizRepository;

    public BlankQuizId createQuiz(final CreateQuizCommand command) throws IllegalScoreException {
        BlankQuiz blankQuiz = BlankQuiz.create(command.getTeacherId(), command.getQuestion(),
                command.getScore(), command.getReferenceAnswer());
        blankQuizRepository.save(BlankQuizEntity.fromModel(blankQuiz));
        return blankQuiz.getId();
    }

    public BlankQuizId updateQuiz(final String quizId, final UpdateQuizCommand command) {
        BlankQuiz blankQuiz = blankQuizRepository.findById(quizId).get().toModel();
        BlankQuiz newBlankQuiz = blankQuiz.update(new BlankQuizId(quizId), command.getTeacherId(),
                command.getQuestion(), command.getScore(), command.getReferenceAnswer());
        blankQuizRepository.save(BlankQuizEntity.fromModel(newBlankQuiz));
        return newBlankQuiz.getId();
    }
}
