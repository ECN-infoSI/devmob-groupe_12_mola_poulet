package com.example.myapplication.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AcceuilAppBar(
    modifier:Modifier=Modifier
) {
    TopAppBar(
        title = { Text("Accueil") },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = modifier,
        navigationIcon = {
        }
    )
}

@Composable
fun Accueil(modifier: Modifier=Modifier){
    Column(modifier=Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center,horizontalAlignment = Alignment.CenterHorizontally){
        Row(horizontalArrangement = Arrangement.Center, modifier=modifier) {
            Button(
                modifier = Modifier,
                onClick = {}
            ) {
                Text("Créer sa propre fiche")
            }
        }
        Column(modifier=Modifier.fillMaxWidth().padding(20.dp),horizontalAlignment = Alignment.Start){
            Row(modifier=Modifier.fillMaxWidth()){
                Text("Ma liste", modifier=modifier)
                Row(modifier=Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.End){
                    Button(modifier=Modifier,onClick={}){

                    }
                    Button(modifier=Modifier,onClick={}){

                    }
                    Button(modifier=Modifier,onClick={}){

                    }
                    Button(modifier=Modifier,onClick={}){

                    }
                }
            }


        }

    }





}
@Preview
@Composable
fun AccueilPreview(){
    Accueil()
}