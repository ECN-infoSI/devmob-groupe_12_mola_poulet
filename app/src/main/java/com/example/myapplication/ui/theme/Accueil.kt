package com.example.myapplication.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AcceuilAppBar(
    modifier:Modifier=Modifier
) {TopAppBar(
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
fun Accueil(modifier: Modifier=Modifier.background(color= Color(alpha = 255,red=46, green=58,blue=98))){
    Column(modifier=Modifier.fillMaxSize().background(color= Color(alpha = 255,red=46, green=58,blue=98)), verticalArrangement = Arrangement.Center,horizontalAlignment = Alignment.CenterHorizontally){
        Row(horizontalArrangement = Arrangement.Center, modifier=modifier) {
            Button(
                modifier = Modifier.width(200.dp),
                onClick = {}
            ) {
                Text("Créer sa propre fiche", fontSize = 24.sp)
            }
        }
        Column(modifier=Modifier.fillMaxWidth().padding(20.dp),horizontalAlignment = Alignment.Start){
            Row(modifier=Modifier.fillMaxWidth()){
                Text("liste 1", modifier=modifier,color=Color.White, fontSize = 28.sp)
                Row(modifier=Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.End){
                    Button(modifier=Modifier,onClick={}){
                        Image(painter= painterResource(R.drawable.truc),
                            contentDescription=null,
                            contentScale= ContentScale.Fit,
                            alpha=0.5F,
                            modifier=Modifier.size(32.dp))
                    }
                    Button(modifier=Modifier,onClick={}){
                        Image(painter= painterResource(R.drawable.watch),
                            contentDescription=null,
                            contentScale= ContentScale.Fit,
                            alpha=0.5F,
                            modifier=Modifier.size(32.dp)
                        )
                    }
                    Button(modifier=Modifier,onClick={}){
                        Image(painter= painterResource(R.drawable.partage),
                            contentDescription=null,
                            contentScale= ContentScale.Fit,
                            alpha=0.5F,
                            modifier=Modifier.size(32.dp))
                    }
                    Button(modifier=Modifier,onClick={}){
                        Image(painter= painterResource(R.drawable.delete),
                            contentDescription=null,
                            contentScale= ContentScale.Fit,
                            alpha=0.5F,
                            modifier=Modifier.size(32.dp))
                    }
                }
            }
            Row(modifier=Modifier.fillMaxWidth()){
                Text("liste 2", modifier=modifier,color=Color.White, fontSize = 28.sp)
                Row(modifier=Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.End){
                    Button(modifier=Modifier,onClick={}){
                        Image(painter= painterResource(R.drawable.truc),
                            contentDescription=null,
                            contentScale= ContentScale.Fit,
                            alpha=0.5F,
                            modifier=Modifier.size(32.dp)
                            )
                    }
                    Button(modifier=Modifier,onClick={}){
                        Image(painter= painterResource(R.drawable.watch),
                            contentDescription=null,
                            contentScale= ContentScale.Fit,
                            alpha=0.5F,
                            modifier=Modifier.size(32.dp)
                        )
                    }
                    Button(modifier=Modifier,onClick={}){
                        Image(painter= painterResource(R.drawable.partage),
                            contentDescription=null,
                            contentScale= ContentScale.Fit,
                            alpha=0.5F,
                            modifier=Modifier.size(32.dp))
                    }
                    Button(modifier=Modifier,onClick={}){
                        Image(painter= painterResource(R.drawable.delete),
                            contentDescription=null,
                            contentScale= ContentScale.Fit,
                            alpha=0.5F,
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
fun AccueilPreview(){
    Accueil()
}