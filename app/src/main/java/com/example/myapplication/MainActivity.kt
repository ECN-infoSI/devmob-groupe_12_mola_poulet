package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.theme.Accueil
import com.example.myapplication.ui.theme.MyApplicationTheme

enum class AppliScreen(@StringRes val title: Int) {
    Start(title = R.string.app_name),
    Revision(title = R.string.app_name)
}


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    NavHost(
                        navController = rememberNavController(),
                        startDestination = AppliScreen.Start.name,
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable(route = AppliScreen.Start.name) {
                            Accueil(
                                modifier = Modifier.padding(innerPadding).background(
                                    color = Color(
                                        alpha = 255,
                                        red = 46,
                                        green = 58,
                                        blue = 98
                                    )
                                )
                            )
                        }
                        /*composable(route = AppliScreen.Revision.name) {
                            val context = LocalContext.current
                            SelectOptionScreen(
                                subtotal = uiState.price,
                                options = DataSource.flavors.map { id ->
                                    context.resources.getString(
                                        id
                                    )
                                },
                                onCancelButtonClicked = {
                                    cancelOrderAndNavigateToStart(
                                        viewModel,
                                        navController
                                    )
                                },
                                onSelectionChanged = { viewModel.setFlavor(it) },
                                onNextButtonClicked = { navController.navigate(CupcakeScreen.Pickup.name) },
                                modifier = Modifier.fillMaxHeight()
                            )
                        }*/
                    }
                }
            }
        }
    }
}
