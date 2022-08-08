package com.hometech.composedemo.ui

import com.hometech.composedemo.Question

object QuestionDb {

    fun getQuestions(): List<Question> {
        val questions = mutableListOf<Question>()

        for (i in 1 until 100) {
            questions.add(
                Question(
                    questionText = "Question $i",
                    answerText = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, " +
                        "sed do eiusmod tempor incididunt ut labore et dolore magna " +
                        "aliqua. Ut enim ad minim veniam, quis nostrud exercitation " +
                        "ullamco laboris nisi ut aliquip ex ea commodo consequat."
                )
            )
        }

        return questions
    }

}