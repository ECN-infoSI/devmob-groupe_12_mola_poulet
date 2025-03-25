package com.example.myapplication.ui.theme

data class AppliUiState(
    val currentFlashCardName: String = "",
    val currentQuestionAnswer: Pair<String, String> = Pair("",""),
    val currentAnswerCount: Int = 1,
    val score: Int = 0,
    val isGuessedAnswerWrong: Boolean = false,
    val isRevisionOver: Boolean = false
){
}