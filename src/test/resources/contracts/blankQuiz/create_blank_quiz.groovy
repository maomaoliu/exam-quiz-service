package blankQuiz

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should create a blank quiz"

    request {
        url "/quizzes"
        method POST()
        headers {
            contentType applicationJson()
        }
        body(
                teacherId: "sjyuan",
                question: "防腐测试是什么？",
                score: 5,
                referenceAnswer: "防腐测试是为了及时预警第三方API的破坏，防止因反馈的缺失而继续发生腐化的测试"
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