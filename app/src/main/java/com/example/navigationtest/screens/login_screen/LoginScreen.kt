package com.example.navigationtest.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.navigationtest.Screen

@Composable
fun LoginScreen(navController: NavController) {
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
                Text(text = "Login" , modifier = Modifier.padding(10.dp) , style = MaterialTheme.typography.h1)
                // insert your screen here

                // generate a textButton that will navigate to the RegisterScreen
                TextButton(onClick = { navController.navigate(Screen.RegisterScreen.route) }) {
                    Text(text = "don't have an account ? register now!")
                }


                // generate a Button that will navigate to Chose Design Screen
                TextButton(onClick = { navController.navigate(Screen.ChoseDesignScreen.route) }) {
                    Text(text = "Go to Choose Design Screen")
                }



            }
        }
    })
}