package com.example.myapplication

import android.content.Context
import android.content.res.Resources
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.myapplication.ui.theme.AppliUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlin.random.Random

/**
 * Le viewModel de l'application
 */
class AppliViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(AppliUiState())
    val uiState: StateFlow<AppliUiState> = _uiState.asStateFlow()
    private var usedQuestions: MutableSet<String> = mutableSetOf()
    private var usedAnswers: MutableSet<String> = mutableSetOf()

    var userGuess by mutableStateOf("")
        private set

    init{
        resetFlashCard()
    }


    /**
     * Met à jour le nom de la carte à afficher
     */
    fun updateCardName(nom:String){
        //Fonctionnement artificiel de l'application, il faudrait une base de données ici pour afficher les questions/réponse
        var questionAnswer=Pair("","")
        if(nom=="anglais") {
            questionAnswer = Pair("What is the english for 'Quoi'","What")
        }
        if(nom=="info"){
            questionAnswer= Pair("Qu'est ce qu'un composable en Kotlin ?","C'est un composant d'une UI")
        }
        _uiState.update { currentState->
            currentState.copy(currentFlashCardName=nom,
            currentQuestionAnswer = questionAnswer
            )
        }


    }

    /**
     * Met à jour une question/réponse
     */
    fun updateQuestionAnswer(questions:Pair<String,String>){
        _uiState.update { currentState->
            currentState.copy(
                currentQuestionAnswer = questions
            )
        }
    }

    /**
     * Inverse une question et une réponse (pour afficher la réponse)
     */
    fun inverseQuestionAnswer(questions:Pair<String,String>){
        val result=Pair(questions.second,questions.first)
        _uiState.update { currentState->
            currentState.copy(
                currentQuestionAnswer = result
            )
        }
    }

    /**
     * Réinitialise une carte
     */
    fun resetFlashCard() {
        usedQuestions.clear()
        usedAnswers.clear()
    }

    /**
     * Met à jour la réponse d'un utilisateur
     */
    fun updateUserGuess(guessedAnswer: String) {
        userGuess = guessedAnswer
    }
}
