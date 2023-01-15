package com.tbse.ui.list_screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider

/**
 * Created by toddsmith on 1/15/23.
 */

@Composable
fun EmailListComposable(
    modifier: Modifier = Modifier,
    config: EmailListComposableConfig,
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
    ) {
        items(config.emails) { emailConfig ->
            EmailItemComposable(config = emailConfig)
        }
    }
}

data class EmailListComposableConfig(
    val emails: List<EmailItemComposableConfig>,
)

@Preview(showBackground = true)
@Composable
fun EmailListComposablePreview(
    @PreviewParameter(EmailListComposableConfigProvider::class)
    config: EmailListComposableConfig,
) {
    EmailListComposable(
        modifier = Modifier,
        config = config,
    )
}

class EmailListComposableConfigProvider :
    PreviewParameterProvider<EmailListComposableConfig> {
    override val values: Sequence<EmailListComposableConfig>
        get() = sequenceOf(
            EmailListComposableConfig(
                emails = listOf(
                    EmailItemComposableConfig(
                        name = "Example one",
                        email = "ex@mail.com",
                    ),
                    EmailItemComposableConfig(
                        name = "Donkey two",
                        email = "four@three.com",
                    ),
                )
            )
        )
}
