package com.example.navigationtest.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.navigationtest.Screen

@Composable
fun RegisterScreen(navController: NavController) {
    LazyColumn(content =
    {
        item {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceAround,

            ) {
                Text(text = "Register Screen")
                // insert your screen here

                // generate a textButton that will navigate to the LoginScreen
                TextButton(onClick = { navController.navigate(Screen.LoginScreen.route) }) {
                    Text(text = "already have an account ? login now!")
                }


            }
        }
    })
}