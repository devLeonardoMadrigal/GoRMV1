package com.example.gormv1.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen(onNavigateToLoginScreen: () -> Unit){
    Column (modifier = Modifier.fillMaxSize()){
        Text("Home Screen", fontSize = 32.sp)
        Button(onClick = {onNavigateToLoginScreen()}, modifier = Modifier.fillMaxWidth()){
            Text("Log out", fontSize = 32.sp)
        }
    }
}