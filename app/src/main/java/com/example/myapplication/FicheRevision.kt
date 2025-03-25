@file:Suppress("UNUSED_EXPRESSION")

package com.example.myapplication

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
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun Revision(
    questions:Pair<String,String>,
    cardName:String,
    appliViewModel: AppliViewModel = viewModel(),
    modifier: Modifier=Modifier
        .background(color= Color(alpha = 255,red=46, green=58,blue=98)),
    onReturnClicked: ()->Unit={}
    ){

    Column(
        modifier=Modifier
            .fillMaxSize()
            .background(color= Color(alpha = 255,red=46, green=58,blue=98)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick={onReturnClicked()},modifier=Modifier.align(Alignment.Start)){
            Image(painter= painterResource(R.drawable.left_arrow),
                contentDescription=null,
                contentScale= ContentScale.Fit,
                alpha=0.5F,
                modifier=Modifier.size(32.dp)
            )
        }
        Text(
            modifier = Modifier
                .align(Alignment.CenterHorizontally),
            color = colorResource(R.color.white),
            text = cardName,
            fontSize = 32.sp
        )
        RevisionLayout(questions,appliViewModel=appliViewModel, onUserGuessChanged = {userGuess:String->appliViewModel.updateUserGuess(userGuess)})
    }
}

@Composable
fun RevisionLayout(
    questions:Pair<String,String>,
    appliViewModel: AppliViewModel,
    userGuess: String=appliViewModel.userGuess,
    onUserGuessChanged: (String)-> Unit={},
) {
    val uiState by appliViewModel.uiState.collectAsState()

    Card(
        modifier = Modifier.fillMaxHeight(),
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
                .background(color = Color(65, 80, 150, 255))
        ) {

            Spacer(modifier = Modifier.height(24.dp))
            Text(
                modifier = Modifier,
                color = colorResource(R.color.white),
                text = questions.first
            )
            Spacer(modifier = Modifier.height(24.dp))
        }
        Spacer(modifier = Modifier.height(12.dp))
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(16.dp)
                .background(color = Color(148, 175, 224, 255))
        ){
            OutlinedTextField(
                value = userGuess,
                singleLine = true,
                shape = shapes.large,
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = colorScheme.surface,
                    unfocusedContainerColor = colorScheme.surface,
                    disabledContainerColor = colorScheme.surface,
                ),
                onValueChange = onUserGuessChanged,
                label = {Text("Réponse")},
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(
                    onDone = {}
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
            }
        }
    }
}

@Preview
@Composable
fun RevisionPreview(){
    Revision(questions=Pair("Quoi ?","Feur !"),"coucou")
}