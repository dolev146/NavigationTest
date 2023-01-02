package com.example.navigationtest

import androidx.compose.runtime.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navigationtest.screens.LoginScreen
import com.example.navigationtest.screens.NavDrawer.DrawerTopBar
import com.example.navigationtest.screens.RegisterScreen
import com.example.navigationtest.screens.adminscreens.AddClothing
import com.example.navigationtest.screens.adminscreens.AdminScreen
import com.example.navigationtest.screens.choose_design_screen.ChooseDesignScreen
import com.example.navigationtest.screens.exsisting_design_screen.ExistingDesignScreen
import com.example.navigationtest.screens.making_design_screen.MakingDesignScreen

@Composable
fun Navigation() {
    val navCotroller = rememberNavController()
    NavHost(navController = navCotroller, startDestination = Screen.LoginScreen.route) {

        composable(route = Screen.LoginScreen.route) {
            LoginScreen(navController = navCotroller)
        }

        composable(route = Screen.RegisterScreen.route) {
            RegisterScreen(navController = navCotroller)
        }

        composable(route = Screen.ChoseDesignScreen.route) {
            DrawerTopBar(navController = navCotroller, screen = { navController ->
                ChooseDesignScreen(navController = navCotroller)
            })
        }

        composable(route = Screen.ExistingDesignScreen.route) {
            DrawerTopBar(navController = navCotroller, screen = { navController ->
                ExistingDesignScreen(navController = navCotroller)
            })
        }

        // make adminscreen composable
        composable(route = Screen.AdminScreen.route) {
            DrawerTopBar(navController = navCotroller, screen = { navController ->
                AdminScreen(navController = navCotroller)
            })
        }

        composable(route = Screen.AddClothing.route) {
            AddClothing(navController = navCotroller)
        }

        composable(route = Screen.MakeDesignScreen.route) {
            DrawerTopBar(navController = navCotroller, screen = { navController ->
                MakingDesignScreen(navController = navCotroller)
            })
        }


    }
}

