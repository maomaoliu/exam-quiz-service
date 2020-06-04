package com.thoughtworks.exam.application;

import com.thoughtworks.exam.domain.model.BlankQuiz;
import com.thoughtworks.exam.domain.model.BlankQuizId;
import com.thoughtworks.exam.domain.model.BlankQuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {
    private BlankQuizRepository blankQuizRepository;

    @Autowired
    public QuizService(BlankQuizRepository blankQuizRepository) {
        this.blankQuizRepository = blankQuizRepository;
    }

    public BlankQuizId create(CreateQuizCommand command) {

        final String question = command.getQuestion();
        final String answer = command.getAnswer();

        final BlankQuizId blankQuizId = blankQuizRepository.nextBlankQuiz();

        BlankQuiz blankQuiz = BlankQuiz.create(blankQuizId, question, answer);
        blankQuizRepository.save(blankQuiz);

        return blankQuizId;
    }

    public List<BlankQuiz> getAll() {
        return blankQuizRepository.getAll();
    }

    public void update(BlankQuizId blankQuizId, UpdateQuizCommand command) {

        final BlankQuiz blankQuiz = blankQuizRepository.find(blankQuizId);
        blankQuiz.update(command.getQuestion(), command.getAnswer());

        blankQuizRepository.save(blankQuiz);
    }

    public void delete(BlankQuizId blankQuizId) {
        BlankQuiz blankQuiz = blankQuizRepository.find(blankQuizId);
        blankQuiz.delete();
        blankQuizRepository.save(blankQuiz);
    }
}
