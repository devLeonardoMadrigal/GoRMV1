package com.example.gormv1.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gormv1.utils.validateLogin

@Composable
fun LoginScreen(onNavigateToHomeScreen: () -> Unit){
    var passwordField by remember { mutableStateOf("") }
    var emailField by remember { mutableStateOf("") }
    var keepSignedIn by remember { mutableStateOf(true) }

    var isValidEmail by remember {mutableStateOf(false)}
    var isValidPassword by remember {mutableStateOf(false)}

    var hasFailedToLogInOnce by remember { mutableStateOf(false) }


    Column (
        modifier = Modifier.fillMaxSize()
    ){
        Row(modifier = Modifier.fillMaxWidth().padding(bottom = 12.dp)) {
            Text(
                text = "GoRMV",
                fontSize = 42.sp,
                fontWeight = FontWeight.Bold,
                color = Color(37,99,235)
            )
        }
        Row(modifier = Modifier.fillMaxWidth().padding(bottom = 12.dp)) {
            Text(
                text = "Move cargo, grow business",
                fontSize = 27.sp,
                fontWeight = FontWeight.Medium,
                color = Color(100,116,139)
            )
        }
        Row(modifier = Modifier.fillMaxWidth().padding(bottom = 12.dp)) {
            Column {
                Text("Email", fontSize = 24.sp, fontWeight = FontWeight.Medium)
                OutlinedTextField(
                    value = emailField,
                    onValueChange =  {
                        emailField = it
                        isValidEmail = emailField.length > 0
                                     },
                    modifier = Modifier.fillMaxWidth(),
                )
            }
        }
        Row(modifier = Modifier.fillMaxWidth().padding(bottom = 15.dp)) {

            Column {
                Text("Password", fontSize = 24.sp, fontWeight = FontWeight.Medium)
                OutlinedTextField(
                    visualTransformation = PasswordVisualTransformation(),
                    onValueChange =  {passwordField = it
                        isValidPassword = passwordField.length > 0
                    },
                    value = passwordField,
                    modifier = Modifier.fillMaxWidth(),
                )
            }
        }
        Row(modifier = Modifier.fillMaxWidth().padding(bottom = 5.dp), horizontalArrangement = Arrangement.Center) {
            Button(
                onClick = {
                    if(validateLogin(emailField, passwordField)){
                        onNavigateToHomeScreen()
                    } else{
                        hasFailedToLogInOnce = true
                    }
                },
                modifier = Modifier.fillMaxWidth().size(72.dp),
                colors = ButtonColors(
                containerColor =  Color(37,99,235),
                contentColor = Color.White,
                disabledContentColor = Color.Gray,
                disabledContainerColor = Color.LightGray),
                enabled = (isValidEmail && isValidPassword)
            ){
                Text("Log in", fontSize = 36.sp)
            }
        }
        if(hasFailedToLogInOnce) {
            Row {
                Text("Only user allowed to log in is \"leo@leo.com/1234\"")
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row (modifier = Modifier, verticalAlignment = Alignment.CenterVertically){
                Checkbox(
                    checked = keepSignedIn,
                    onCheckedChange = {keepSignedIn = !keepSignedIn},
                )
                Text("Keep me signed in", fontSize = 18.sp)
            }
            TextButton(onClick = {}){
                Text("Forgot password?", fontSize = 18.sp)
            }

        }
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.Bottom,
        ) {
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically){
                Text("New to GoRMV?",fontSize = 18.sp)
                Spacer(Modifier.size(10.dp))
                TextButton(onClick = {}){
                    Text("Create new account", fontSize = 18.sp)
                }
            }
        }
    }
}