package com.example.gormv1.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.sp

@Composable
fun LoginScreen(){
    Column (
        modifier = Modifier.fillMaxSize().safeContentPadding()
    ){
        Row(modifier = Modifier.fillMaxWidth()) {
            Text("GoRMV")
        }
        Row(modifier = Modifier.fillMaxWidth()) {
            Text("Move cargo, grow business")
        }
        Row(modifier = Modifier.fillMaxWidth()) {

            val emailField by remember { mutableStateOf("") }

            Column {
                Text("Email")
                OutlinedTextField(
                    state = TextFieldState(
                        initialText = emailField
                    ),
                    modifier = Modifier.fillMaxWidth(),
                )

            }
        }
        Row(modifier = Modifier.fillMaxWidth()) {
            var passwordField by remember { mutableStateOf("") }

            Column {
                Text("Password")
                OutlinedTextField(
                    visualTransformation = PasswordVisualTransformation(),

                    singleLine = true,
                    onValueChange =  {passwordField = it},
                    value = passwordField,
                    modifier = Modifier.fillMaxWidth(),
                )
            }
        }
        Row(modifier = Modifier.fillMaxWidth()) {
            Button(onClick = {}){
                Text("Log in", fontSize = 24.sp)
            }
        }
        Row(modifier = Modifier.fillMaxWidth()) {
            var keepSignedIn by remember { mutableStateOf(true) }
            Row {
                Checkbox(
                    checked = keepSignedIn,
                    onCheckedChange = {keepSignedIn = !keepSignedIn},
                )
                Text("Keep me signed in")
            }
            TextButton(onClick = {}){
                Text("Forgot password?")
            }

        }
        Row(modifier = Modifier.fillMaxWidth()) {
                Text("New to GoRMV?")
            TextButton(onClick = {}){
                Text("Create new account")
            }
        }
    }
}