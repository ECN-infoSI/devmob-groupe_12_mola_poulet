package com.example.myapplication


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.lifecycle.viewmodel.compose.viewModel

/**
 * Le composable principal de l'application
 */
@Composable
fun App(vm: AppliViewModel= viewModel(), navController:NavHostController= rememberNavController()){
    val uiState by vm.uiState.collectAsState()
    Scaffold(modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        //Mise en place de la navigation
        NavHost(
            navController = navController,
            startDestination = AppliScreen.Start.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            //Accueil
            composable(route = AppliScreen.Start.name) {
                Accueil(
                    modifier = Modifier
                        .padding(innerPadding)
                        .background(
                            color = Color(
                                alpha = 255,
                                red = 46,
                                green = 58,
                                blue = 98
                            )
                        ),
                    onRevisionClicked = {

                        vm.updateCardName(it)

                        navController.navigate(AppliScreen.Revision.name)
                    }
                )
            }
            //Révision
            composable(route = AppliScreen.Revision.name) {
                val nom=uiState.currentFlashCardName
                Revision(
                    cardName=nom,
                    questions=uiState.currentQuestionAnswer,
                    onReturnClicked = {navController.navigate(AppliScreen.Start.name)})
            }
        }
    }
}
