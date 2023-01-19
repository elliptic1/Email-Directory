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
    onDeleteClicked: (Int) -> Unit,
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
    ) {
        items(
            items = config.emails,
            key = { emailItem ->
                emailItem.id
            },
        ) { emailConfig ->
            EmailItemComposable(
                config = emailConfig,
                onDeleteClicked = onDeleteClicked,
            )
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
        onDeleteClicked = {},
    )
}

class EmailListComposableConfigProvider :
    PreviewParameterProvider<EmailListComposableConfig> {
    override val values: Sequence<EmailListComposableConfig>
        get() = sequenceOf(
            EmailListComposableConfig(
                emails = listOf(
                    EmailItemComposableConfig(
                        id = 0,
                        name = "Example one",
                        email = "ex@mail.com",
                    ),
                    EmailItemComposableConfig(
                        id = 1,
                        name = "Donkey two",
                        email = "four@three.com",
                    ),
                )
            )
        )
}
