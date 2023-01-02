package com.example.navigationtest.screens.adminscreens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.navigationtest.Screen

@Composable
fun AdminScreen(navController: NavController) {
    LazyColumn(content =
    {
        item {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceAround
            ) {
                Text(text ="Admin Screen")
                // insert your screen here





                Button(onClick = {
                    navController.navigate(Screen.AddClothing.route)
                }) {
                    Text(text = "Add Clothing")
                }


            }

        }
    })

}