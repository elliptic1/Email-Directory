package com.tbse.ui.main_page

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.tbse.ui.navigation.MyNavGraph

/**
 * Created by toddsmith on 1/14/23.
 */

@Composable
fun MyScaffold(
    modifier: Modifier = Modifier,
) {
    val navController = rememberNavController()
    Scaffold(
        modifier = modifier,
        topBar = {
            MyTopBar(
                modifier = Modifier,
                config = MyTopBarConfig(""),
            )
        },
        bottomBar = {
            MyBottomBar(
                modifier = Modifier,
                config = MyBottomBarConfig(""),
                navController = navController,
            )
        },
    ) { padding ->
        MyNavGraph(
            modifier = Modifier
                .padding(padding),
            navController = navController,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MyScaffoldPreview(
) {
    MyScaffold(
        modifier = Modifier,
    )
}
