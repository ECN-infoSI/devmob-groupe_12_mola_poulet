package com.example.myapplication.ui.theme

import android.content.Context
import android.content.Intent
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
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
fun Accueil(modifier: Modifier=Modifier.background(color= Color(alpha = 255,red=46, green=58,blue=98)), onRevisionClicked: (Int) -> Unit){
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
                Text(stringResource(R.string.fiche_anglais), modifier=modifier,color=Color.White, fontSize = 28.sp)
                Row(modifier=Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.End){
                    Button(modifier=Modifier,onClick={onRevisionClicked(R.string.fiche_anglais)}){
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
                    val context = LocalContext.current
                    val subject=""
                    val summary="Code "+stringResource(R.string.fiche_anglais)
                    Button(modifier=Modifier,onClick={
                        shareFiche(context, subject = subject, summary = summary)}){
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
                Text(stringResource(R.string.fiche_infosi), modifier=modifier,color=Color.White, fontSize = 28.sp)
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
                    val context = LocalContext.current
                    val subject=""
                    val summary="Code "+stringResource(R.string.fiche_infosi)
                    Button(modifier=Modifier,onClick={ shareFiche(context,subject,summary) }){
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
fun shareFiche(context: Context, subject: String, summary: String) {
    val intent = Intent(Intent.ACTION_SEND).apply{
        type = "text/plain"
        putExtra(Intent.EXTRA_SUBJECT, subject)
        putExtra(Intent.EXTRA_TEXT, summary)
    }
    context.startActivity(
        Intent.createChooser(
            intent,
            context.getString(R.string.fiche_anglais)
        )
    )
}
@Preview
@Composable
fun AccueilPreview(){
    AcceuilAppBar()
    Accueil(onRevisionClicked = {})
}