package com.tbse.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.tbse.ui.add_screen.AddEmailScreen
import com.tbse.ui.list_screen.EmailListScreen
import com.tbse.ui.list_screen.GetListScreenConfig

/**
 * Created by toddsmith on 1/14/23.
 */
@Composable
fun MyNavGraph(
    modifier: Modifier,
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = Graph.Add.route,
        modifier = modifier,
    ) {
        composable(
            route = Graph.Add.route,
        ) {
            AddEmailScreen()
        }
        composable(
            route = Graph.List.route,
        ) {
            EmailListScreen(config = GetListScreenConfig(""))
        }
    }
}

sealed class Graph(
    val route: String,
    val icon: ImageVector,
    val contentDescription: String,
) {
    object Add : Graph(
        route = "add_screen",
        icon = Icons.Default.Add,
        contentDescription = "Add an Email Screen",
    )

    object List : Graph(
        route = "list_screen",
        icon = Icons.Default.List,
        contentDescription = "List of all emails",
    )
}

val screens = listOf(
    Graph.Add, Graph.List,
)