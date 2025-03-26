package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.StringRes
import com.example.myapplication.ui.theme.MyApplicationTheme

/**
 * Liste des écrans de l'application
 */
enum class AppliScreen(@StringRes val title: Int) {
    Start(title = R.string.app_name),
    Revision(title = R.string.app_name)
}

/**
 * Activité principale de l'application
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                App()
            }
        }
    }
}
