package com.tbse.ui.main_page

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
fun MyTopBar(
    modifier: Modifier = Modifier,
    config: MyTopBarConfig,
) {
    TopAppBar(
        title = {
            Text("Email Directory")
        },
    )
}

data class MyTopBarConfig(
    val a: String,
)

@Preview(showBackground = true)
@Composable
fun MyTopBarPreview(
    @PreviewParameter(MyTopBarConfigProvider::class)
    config: MyTopBarConfig,
) {
    MyTopBar(
        modifier = Modifier,
        config = config,
    )
}

class MyTopBarConfigProvider :
    PreviewParameterProvider<MyTopBarConfig> {
    override val values: Sequence<MyTopBarConfig>
        get() = sequenceOf(
            MyTopBarConfig(
                a = "123",
            )
        )
}
