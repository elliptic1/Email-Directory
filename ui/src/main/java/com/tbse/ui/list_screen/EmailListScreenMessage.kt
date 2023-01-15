package com.tbse.ui.list_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.sp

/**
 * Created by toddsmith on 1/15/23.
 */

@Composable
fun EmailListScreenMessage(
    modifier: Modifier = Modifier,
    config: EmailListScreenMessageConfig,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
    ) {
        Text(
            modifier = modifier
                .align(Alignment.Center),
            text = config.message,
            fontSize = 35.sp,
        )
    }
}

data class EmailListScreenMessageConfig(
    val message: String,
)

@Preview(showBackground = true)
@Composable
fun EmailListScreenMessagePreview(
    @PreviewParameter(EmailListScreenMessageConfigProvider::class)
    config: EmailListScreenMessageConfig,
) {
    EmailListScreenMessage(
        modifier = Modifier,
        config = config,
    )
}

class EmailListScreenMessageConfigProvider :
    PreviewParameterProvider<EmailListScreenMessageConfig> {
    override val values: Sequence<EmailListScreenMessageConfig>
        get() = sequenceOf(
            EmailListScreenMessageConfig(
                message = "Null Pointer",
            )
        )
}
