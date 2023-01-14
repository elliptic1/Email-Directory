package com.tbse.ui.main_page

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.List
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
fun MyBottomBar(
    modifier: Modifier = Modifier,
    config: MyBottomBarConfig,
) {
    val q by remember { mutableStateOf(false) }
    BottomNavigation() {
        BottomNavigationItem(
            icon = {
                Icon(
                    modifier = Modifier,
                    contentDescription = "",
                    imageVector = Icons.Default.Add,
                )
            },
            selected = true,
            onClick = { /*TODO*/ },
        )
        BottomNavigationItem(
            icon = {
                Icon(
                    modifier = Modifier,
                    contentDescription = "",
                    imageVector = Icons.Default.List,
                )
            },
            selected = true,
            onClick = { /*TODO*/ },
        )
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
