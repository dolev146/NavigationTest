package com.example.navigationtest

sealed class Screen(val route: String) {
    object AdminScreen : Screen("admin_screen")
    object AddClothing : Screen("add_clothing")
    object ChoseDesignScreen : Screen("chose_design_screen")
    object ExistingDesignScreen : Screen("existing_design_screen")
    object LoginScreen : Screen("login_screen")
    object RegisterScreen : Screen("register_screen")
    object MakeDesignScreen : Screen("make_design_screen")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}


