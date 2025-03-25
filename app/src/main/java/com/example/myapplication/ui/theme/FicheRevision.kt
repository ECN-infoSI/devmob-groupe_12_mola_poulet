@file:Suppress("UNUSED_EXPRESSION")

package com.example.myapplication.ui.theme

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Shapes
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R

@Composable
fun Revision(
    appliViewModel: AppliViewModel = viewModel(),
    modifier: Modifier=Modifier
        .background(color= Color(alpha = 255,red=46, green=58,blue=98))
){
    val appliUiState by appliViewModel.uiState.collectAsState()
    val currentTextOnCard = appliUiState.currentQuestionAnswer.first
    Column(
        modifier=Modifier
            .fillMaxSize()
            .background(color= Color(alpha = 255,red=46, green=58,blue=98)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color(alpha = 255, red = 77, green = 77, blue = 77)),
            color = Color(alpha = 255, red = 65, green = 80, blue = 150),
            text = appliUiState.currentFlashCardName,
            fontSize = 32.sp
        )

        RevisionLayout(

        )
    }
}

@Composable
fun RevisionLayout(
    currentTextOnCard: String,
    isAnswerWrong: Boolean,
    nextQuestionFunction: (Context, String) -> Unit,
    seeAnswerFunction: () -> Unit,
    userGuess: String,
    onUserGuessChanged: (String)-> Unit,
    onKeyboardDone: () -> Unit,
    modifier: Modifier = Modifier
) {


    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(8.dp)
                .background(color = Color(65, 80, 150, 255))
        ) {
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                modifier = Modifier
                  .fillMaxSize(),
                color = Color(77, 77,77, 255),
                text = currentTextOnCard
            )
            Spacer(modifier = Modifier.height(24.dp))
        }
        Spacer(modifier = Modifier.height(12.dp))
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize()
                .background(color = Color(148, 175, 224, 255))
        ) {
            OutlinedTextField(
                value = userGuess,
                singleLine = true,
                shape = shapes.large,
                modifier = Modifier.fillMaxWidth(),
                onValueChange = onUserGuessChanged,
                label = {
                    if (isAnswerWrong) {
                        Text("Mauvaise réponse")
                    } else {
                        Text("Bonne réponse")
                    }
                },
                isError = isAnswerWrong,
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(
                    onDone = { onKeyboardDone() }
                )
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Button(
                    modifier = Modifier.fillMaxHeight(),
                    onClick = seeAnswerFunction
                ) {
                    Row(modifier = Modifier){
                        Image(
                            painter= painterResource(R.drawable.magnifying_glass),
                            contentDescription=null,
                            contentScale= ContentScale.Fit,
                            modifier=Modifier.size(32.dp)
                        )
                        Text(
                            text = "Voir la réponse",
                            color = Color(77,77,77,255)
                        )
                    }
                }
                Spacer(modifier = Modifier.width(40.dp))
                Button(
                    modifier = Modifier.fillMaxHeight(),
                    onClick = { nextQuestionFunction }
                ) {
                    Row(modifier = Modifier){
                        Text(
                            text = "Passer à la prochaine question",
                            color = Color(77,77,77,255)
                        )
                        Image(
                            painter= painterResource(R.drawable.right_arrow),
                            contentDescription=null,
                            contentScale= ContentScale.Fit,
                            modifier=Modifier.size(32.dp)
                        )
                    }
                }

            }

        }
    }
}

@Preview
@Composable
fun RevisionPreview(){
    Revision()
}