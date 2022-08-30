package com.example.allhomes.ui.login

import android.widget.EditText
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.allhomes.R
import com.example.allhomes.navigation.Screen

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun LoginScreen(navController: NavController) {
    val focusManager = LocalFocusManager.current
    val scaffoldState = rememberScaffoldState()
    var emailTextField by remember {
        mutableStateOf("")
    }
    var passwordTextField by remember {
        mutableStateOf("")
    }

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        scaffoldState = scaffoldState
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(30.dp)
        ) {

            Text(
                modifier = Modifier
                    .padding(top = 8.dp),
                text = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            color = Color.Red
                        )
                    ) {
                        append("allhomes")
                    }
                    append(" - ")
                    withStyle(
                        style = SpanStyle(
                            color = Color.Green
                        )
                    ) {
                        append("Domain Group")
                    }
                },
                fontSize = 20.sp,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(15.dp))

            OutlinedTextField(
                value = emailTextField,
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Red,
                    focusedLabelColor = Color.Red,
                    backgroundColor = Color.White,
                    cursorColor = Color.Red
                ),
                label = {
                    Text(text = "Enter your email address")
                },
                onValueChange = {
                    emailTextField = it
                },
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                keyboardActions = KeyboardActions(
                    onNext = {
                        focusManager.moveFocus(FocusDirection.Next)
                    }
                ),
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(15.dp))
            OutlinedTextField(
                value = passwordTextField,
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Red,
                    focusedLabelColor = Color.Red,
                    backgroundColor = Color.White
                ),
                label = {
                    Text(text = "Enter Password")
                },
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(
                    onDone = {
                        focusManager.clearFocus(true)
                    }
                ),
                onValueChange = {
                    passwordTextField = it
                },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(10.dp))
            Box(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth(),
                contentAlignment = Alignment.CenterEnd
            ) {
                OutlinedButton(
                    border = BorderStroke(1.dp, Color.Red),
                    onClick = {
                        navController.navigate(Screen.DashboardScreen.route)
                    }
                ) {
                    Text(
                        text = "LOGIN",
                        color = Color.Red
                    )
                }
            }
        }
    }

}


@Preview
@Composable
fun DefaultPreview() {

    val scaffoldState = rememberScaffoldState()
    var textFieldState by remember {
        mutableStateOf("")
    }

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        scaffoldState = scaffoldState
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(30.dp)
        ) {

            Text(
                modifier = Modifier
                    .padding(top = 8.dp),
                text = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            color = Color.Red
                        )
                    ) {
                        append("allhomes")
                    }
                    append(" - ")
                    withStyle(
                        style = SpanStyle(
                            color = Color.Green
                        )
                    ) {
                        append("Domain Group")
                    }
                },
                fontSize = 20.sp,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(15.dp))

            OutlinedTextField(
                value = textFieldState,
                label = {
                    Text(text = "Enter your email address")
                },
                onValueChange = {
                    textFieldState = it
                },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(15.dp))
            OutlinedTextField(
                value = textFieldState,
                label = {
                    Text(text = "Enter Password")
                },
                onValueChange = {
                    textFieldState = it
                },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(10.dp))
            Box(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth(),
                contentAlignment = Alignment.CenterEnd
            ) {
                OutlinedButton(
                    border = BorderStroke(1.dp, Color.Red),
                    onClick = {

                    }
                ) {
                    Text(
                        text = "LOGIN",
                        color = Color.Red
                    )
                }
            }
        }
    }
}