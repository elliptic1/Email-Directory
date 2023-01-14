package com.tbse.ui.main_page

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider

/**
 * Created by toddsmith on 1/14/23.
 */

@Composable
fun MyScaffold(
    modifier: Modifier = Modifier,
) {
    Scaffold(
        modifier = Modifier,
        topBar = {
            TopAppBar(
                title = {
                    Text("Email Directory")
                },
            )
        },
        bottomBar = {
            MyBottomBar(config = MyBottomBarConfig(""))
        },
    ) { padding ->
        MainScreenComposable(
            modifier = Modifier
                .padding(
                    paddingValues = padding,
                )
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
