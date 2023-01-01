package com.example.navigationtest

import androidx.compose.runtime.*
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.example.navigationtest.screens.DetailScreen
import com.example.navigationtest.screens.DummyScreen
import com.example.navigationtest.screens.MainScreen
import com.example.navigationtest.screens.NavDrawer.DrawerTopBar

@Composable
fun Navigation() {
    val navCotroller = rememberNavController()
    NavHost(navController = navCotroller, startDestination = Screen.MainScreen.route) {
        composable(route = Screen.MainScreen.route) {
            DrawerTopBar(navController = navCotroller, screen =
            {
                MainScreen(navController = navCotroller)
            })
        }

        // generate a dummy screen route and DummyScreen
        composable(route = Screen.DummyScreen.route) {
            DrawerTopBar(navController = navCotroller, screen =
            {
                DummyScreen(navController = navCotroller)
            })

        }





        // if we want the name to be optional we can use navArgument with nullable = true
        // we specify the route with ? to make it optional and we can use it in the composable
        // ?name={name}
        // if we want more than 1 parameter
        // /{name}/{age}
        composable(route = Screen.DetailScreen.route + "/{name}" , arguments = listOf(
            navArgument("name") {
                type = NavType.StringType
                defaultValue = "Yaakov"
                nullable = true
            }
        )
        ){entry ->
            DetailScreen(name = entry.arguments?.getString("name"))
        }
    }
}

