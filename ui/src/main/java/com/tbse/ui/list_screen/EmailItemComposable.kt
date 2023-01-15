package com.tbse.ui.list_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Created by toddsmith on 1/15/23.
 */

@Composable
fun EmailItemComposable(
    modifier: Modifier = Modifier,
    config: EmailItemComposableConfig,
    onDeleteClicked: (Int) -> Unit,
) {
    Box(
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth()
            .background(
                color = Color.Gray
            )
    ) {
        Box(
            modifier = modifier
                .align(
                    Alignment.TopEnd
                )
                .padding(15.dp)
                .clickable {
                    onDeleteClicked(config.id)
                }
        ) {
            Icon(
                modifier = modifier
                    .size(35.dp),
                imageVector = Icons.Default.Close,
                contentDescription = "Delete",
            )
        }
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(18.dp)
        ) {
            TextLine(text = config.name)
            Spacer(
                modifier = modifier
                    .height(25.dp)
            )
            TextLine(text = config.email)
        }
    }
}

@Composable
fun TextLine(
    text: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = text,
        fontSize = 25.sp,
    )
}

data class EmailItemComposableConfig(
    val id: Int,
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
        onDeleteClicked = {},
    )
}

class EmailItemComposableConfigProvider :
    PreviewParameterProvider<EmailItemComposableConfig> {
    override val values: Sequence<EmailItemComposableConfig>
        get() = sequenceOf(
            EmailItemComposableConfig(
                id = 0,
                name = "Name Alpha",
                email = "name@alpha.com",
            ),
        )
}
