package com.tbse.ui.list_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp

/**
 * Created by toddsmith on 1/15/23.
 */

@Composable
fun EmailItemComposable(
    modifier: Modifier = Modifier,
    config: EmailItemComposableConfig,
) {
    Box(
        modifier = modifier
            .padding(8.dp)
            .background(
                color = Color.Gray
            )
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(4.dp)
        ) {
            Text(text = config.name)
            Spacer(
                modifier = modifier
                    .height(25.dp)
            )
            Text(text = config.email)
        }
    }
}

data class EmailItemComposableConfig(
    val name: String,
    val email: String,
)

@Preview(showBackground = true)
@Composable
fun EmailItemComposablePreview(
    @PreviewParameter(EmailItemComposableConfigProvider::class)
    config: EmailItemComposableConfig,
) {
    EmailItemComposable(
        modifier = Modifier,
        config = config,
    )
}

class EmailItemComposableConfigProvider :
    PreviewParameterProvider<EmailItemComposableConfig> {
    override val values: Sequence<EmailItemComposableConfig>
        get() = sequenceOf(
            EmailItemComposableConfig(
                name = "Name Alpha",
                email = "name@alpha.com",
            ),
        )
}
