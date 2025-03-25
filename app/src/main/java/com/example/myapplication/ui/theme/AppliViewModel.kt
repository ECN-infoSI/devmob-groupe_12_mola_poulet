package com.example.myapplication.ui.theme

import android.content.Context
import android.content.res.Resources
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlin.random.Random

class AppliViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(AppliUiState())
    val uiState: StateFlow<AppliUiState> = _uiState.asStateFlow()

    private lateinit var currentFlashCardName: String
    private lateinit var currentQuestionAnswer: Pair<String, String>
    private lateinit var currentQuestionsArray: Array<String>
    private lateinit var currentAnswersArray: Array<String>
    private var usedQuestions: MutableSet<String> = mutableSetOf()
    private var usedAnswers: MutableSet<String> = mutableSetOf()

    var userGuess by mutableStateOf("")
        private set

    init{
        resetFlashCard()
    }

    private fun pickRandomQuestionAnswer(context: Context,flashCardName: String): Pair<String, String>{
        val res: Resources = context.resources
        val packageName = context.packageName

        val questionsId = res.getIdentifier("${flashCardName}Questions", "array", packageName)
        val answersId = res.getIdentifier("${flashCardName}Answers", "array", packageName)

        currentFlashCardName = flashCardName
        currentQuestionsArray = res.getStringArray(questionsId)
        currentAnswersArray = res.getStringArray(answersId)

        val randomIndex = Random.nextInt(currentAnswersArray.size)
        currentQuestionAnswer = Pair(currentQuestionsArray.get(randomIndex), currentAnswersArray.get(randomIndex))
        if (usedQuestions.contains(currentQuestionAnswer.first) and usedAnswers.contains(currentQuestionAnswer.second)) {
            return pickRandomQuestionAnswer(context, flashCardName)
        } else {
            return currentQuestionAnswer
        }
    }

    fun skipQuestion() {
        updateUserGuess("")
    }

    fun resetFlashCard() {
        usedQuestions.clear()
        usedAnswers.clear()
    }

    fun updateUserGuess(guessedAnswer: String) {
        userGuess = guessedAnswer
    }

    fun checkUserGuess() {
        if (userGuess.equals(currentQuestionAnswer.second, ignoreCase = true)) {
            val updatedScore = _uiState.value

        } else {
            _uiState.update { currentState ->
                currentState.copy(isGuessedAnswerWrong = true)
            }
        }
        updateUserGuess("")
    }

    fun updateAppliState(context: Context, updatedScore: Int) {
        if (usedQuestions.size == currentQuestionsArray.size) {
            _uiState.update { currentState ->
                currentState.copy(
                    isGuessedAnswerWrong = false,
                    score = updatedScore,
                    isRevisionOver = true
                )
            }
        } else {
            _uiState.update { currentState ->
                currentState.copy(
                    isGuessedAnswerWrong = false,
                    currentQuestionAnswer = pickRandomQuestionAnswer(context = context, currentFlashCardName),
                    currentAnswerCount = currentState.currentAnswerCount.inc(),
                    score = updatedScore
                )
            }
        }
    }
}
