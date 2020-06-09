package blankQuiz

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should return person by id=1"

    request {
        url "/quizzes"
        method POST()
        headers {
            contentType applicationJson()
        }
        body(
                teacherId: 1,
                question: "TDD是什么？",
                score: 5,
                referenceAnswer: "Test-Driven Development"
        )
    }

    response {
        status CREATED()
        headers {
            contentType applicationJson()
        }
        body(
                blankQuizId: "90fdknaf09fopfkmald"
        )
    }
}