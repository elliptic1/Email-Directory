package com.tbse.ui.main_page

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.tbse.ui.navigation.screens

/**
 * Created by toddsmith on 1/14/23.
 */

@Composable
fun MyBottomBar(
    modifier: Modifier = Modifier,
    config: MyBottomBarConfig,
    navController: NavController,
) {
    BottomNavigation {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination
        screens.forEach { screen ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        modifier = Modifier,
                        contentDescription = "",
                        imageVector = screen.icon,
                    )
                },
                selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                    }
                },
            )
        }
    }
}

data class MyBottomBarConfig(
    val a: String,
)

@Preview(showBackground = true)
@Composable
fun MyBottomBarPreview(
    @PreviewParameter(MyBottomBarConfigProvider::class)
    config: MyBottomBarConfig,
) {
    MyBottomBar(
        modifier = Modifier,
        config = config,
        navController = rememberNavController()
    )
}

class MyBottomBarConfigProvider :
    PreviewParameterProvider<MyBottomBarConfig> {
    override val values: Sequence<MyBottomBarConfig>
        get() = sequenceOf(
            MyBottomBarConfig(
                a = "123",
            )
        )
}
