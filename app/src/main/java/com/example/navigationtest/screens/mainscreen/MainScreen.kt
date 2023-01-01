package com.example.navigationtest.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.navigationtest.Screen

@Composable
fun MainScreen(navController: NavController) {
    var text by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 50.dp),
        verticalArrangement = Arrangement.Center
    ) {
        TextField(value = text, onValueChange = { text = it }, modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(8.dp))
        Button(modifier = Modifier.align(Alignment.End), onClick = {
            navController.navigate(Screen.DetailScreen.withArgs(text))
        }) {
            Text("To Detail Screen")
        }
        // genereate a new button that on click will navigate to DummyScreen
        Spacer(modifier = Modifier.height(8.dp))
        Button(modifier = Modifier.align(Alignment.End), onClick = {
            navController.navigate(Screen.DummyScreen.route)
        }) {
            Text("To Dummy Screen")
        }
    }
}