package com.example.gormv1

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.gormv1.ui.HomeScreen
import com.example.gormv1.ui.LoginScreen
import kotlinx.serialization.Serializable


@Serializable
object LoginScreenRoute

@Serializable
object HomeScreenRoute

@Composable
fun App() {
    MaterialTheme {

        val navController = rememberNavController()



        Column(
            modifier = Modifier
                .background(Color.White)
                .fillMaxSize()
                .safeContentPadding(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            NavHost(
                navController = navController,
                startDestination = LoginScreenRoute,
            ){
                composable<LoginScreenRoute>{ LoginScreen(onNavigateToHomeScreen = {navController.navigate(HomeScreenRoute)})}
                composable<HomeScreenRoute> { HomeScreen(onNavigateToLoginScreen = {navController.navigate(LoginScreenRoute)}) }
            }
        }
    }
}