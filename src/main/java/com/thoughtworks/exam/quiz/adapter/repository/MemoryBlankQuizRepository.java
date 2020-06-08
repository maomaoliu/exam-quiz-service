package com.thoughtworks.exam.quiz.adapter.repository;

import com.thoughtworks.exam.quiz.domain.model.blankquiz.BlankQuiz;
import com.thoughtworks.exam.quiz.domain.model.blankquiz.BlankQuizId;
import com.thoughtworks.exam.quiz.domain.model.blankquiz.BlankQuizRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryBlankQuizRepository implements BlankQuizRepository {
    private Set<BlankQuiz> blankQuizzes = new HashSet<>();

    {
        blankQuizzes.add(BlankQuiz.builder()
                .id(new BlankQuizId("BlankQuiz001"))
                .teacherId("Teacher001")
                .build());
    }

    @Override
    public void save(BlankQuiz blankQuiz) {
        boolean existed = blankQuizzes.stream().anyMatch(e -> e.equals(blankQuiz));
        if (existed) {
            blankQuizzes.stream().filter(e -> e.equals(blankQuiz)).forEach(
                    o -> o.setTeacherId(blankQuiz.getTeacherId())
            );
        } else {
            blankQuizzes.add(blankQuiz);
        }
    }

    @Override
    public void delete(BlankQuizId id) {
        blankQuizzes.removeIf(e -> e.getId().equals(id));
    }

    @Override
    public BlankQuiz find(final BlankQuizId blankQuizId) {
        return blankQuizzes.stream()
                .filter(quiz -> quiz.getId().equals(blankQuizId))
                .findFirst()
                .orElseThrow(NullPointerException::new);
    }
}

