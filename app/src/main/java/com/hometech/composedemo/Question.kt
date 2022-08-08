package com.hometech.composedemo

data class Question(
    val questionText: String,
    val answerText: String,
    val expanded: Boolean = true
)