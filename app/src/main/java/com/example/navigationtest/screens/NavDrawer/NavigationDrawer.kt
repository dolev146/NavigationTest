package com.example.navigationtest.screens.NavDrawer

import android.content.Context
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.navigationtest.R
import com.example.navigationtest.Screen
import com.example.navigationtest.models.MenuItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@Composable
fun DrawerHeader() {
    Box(
        modifier = Modifier
            //.height(200.dp)
            //.background(Color.LightGray)
            .fillMaxWidth()
            .padding(vertical = 64.dp), contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "logo",
            modifier = Modifier.size(100.dp)
        )
    }
}

@Composable
fun DrawerBody(
    items: List<MenuItem>,
    modifier: Modifier = Modifier,
    itemTextStyle: TextStyle = TextStyle(fontSize = 18.sp),
    onItemClick: (MenuItem) -> Unit,
) {
    LazyColumn(modifier) {
        items(items) { item ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onItemClick(item) }
                    .padding(16.dp),

                ) {
                Icon(imageVector = item.icon, contentDescription = item.contentDescription)
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = item.title,
                    //modifier = Modifier.align(Alignment.CenterVertically)
                    modifier = Modifier.weight(1f), style = itemTextStyle

                )
            }
        }
    }

}

// the drawer TopBar should get the navController as a parameter ,
// and the composable screen function that it needs to draw after the drawer
@Composable
fun DrawerTopBar(
    navController: NavController,
    screen: @Composable (navController: NavController) -> Unit
) {
    var isAdminState by remember {
        mutableStateOf(false)
    }

    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    isAdminState = true
    var menuContent = mutableListOf(
            MenuItem(
                id = "logout",
                title = "Logout",
                contentDescription = "Go to Logout screen",
                icon = Icons.Default.ExitToApp
            ),
        )


    if (isAdminState) {
        menuContent.add(
            MenuItem(
                id = "admin screen",
                title = "Admin Screen",
                contentDescription = "Go to admin screen",
                icon = Icons.Default.MoreVert
            )
        )

        menuContent.add(
            MenuItem(
                id = "choose design",
                title = "Choose Design",
                contentDescription = "Go to Chose Design screen",
                icon = Icons.Default.Person
            )
        )

        menuContent.add(
            MenuItem(
                id = "exist design",
                title = "Choose Exist Design",
                contentDescription = "Go to Chose Design screen",
                icon = Icons.Default.Person
            )
        )

        menuContent.add(
            MenuItem(
                id = "make design",
                title = "Make Design",
                contentDescription = "Go to Make Design screen",
                icon = Icons.Default.Person
            )
        )


    } else {
        // this is user menu
        menuContent.add(
            MenuItem(
                id = "choose design",
                title = "Choose Design",
                contentDescription = "Go to Chose Design screen",
                icon = Icons.Default.Person
            )
        )

        menuContent.add(
            MenuItem(
                id = "exist design",
                title = "Choose Exist Design",
                contentDescription = "Go to Chose Design screen",
                icon = Icons.Default.Person
            )
        )

        menuContent.add(
            MenuItem(
                id = "make design",
                title = "Make Design",
                contentDescription = "Go to Make Design screen",
                icon = Icons.Default.Person
            )
        )

//        menuContent.add(
//            MenuItem(
//                id = "logout",
//                title = "Logout",
//                contentDescription = "Go to Logout screen",
//                icon = Icons.Default.ExitToApp
//            )
//        )
    }


    Scaffold(
        drawerGesturesEnabled = scaffoldState.drawerState.isOpen,
        scaffoldState = scaffoldState,
        topBar = {
            AppBar(onNavigationIconClick = {
                scope.launch {
                    scaffoldState.drawerState.open()
                }

            })
        },
        drawerContent = {
            DrawerHeader()
            DrawerBody(items = menuContent, onItemClick = {
                when (it.id) {
                    "logout" -> {
                        navController.navigate(Screen.LoginScreen.route)
                    }
                    "admin screen" ->{
                        navController.navigate(Screen.AdminScreen.route)
                    }
                    "choose design" ->{
                        navController.navigate(Screen.ChoseDesignScreen.route)
                    }
                    "exist design" ->{
                        navController.navigate(Screen.ExistingDesignScreen.route)
                    }
                    "make design" ->{
                        navController.navigate(Screen.MakeDesignScreen.route)
                    }
                }
            })

        }) {

        screen(navController = navController)
    }
}






// not relevant

//        MenuItem(
//            id = "login screen",
//            title = "Login Screen",
//            contentDescription = "Go to Login",
//            icon = Icons.Default.Person
//        ),
//        MenuItem(
//            id = "register screen",
//            title = "Register Screen",
//            contentDescription = "Go to Register",
//            icon = Icons.Default.Person
//        ),