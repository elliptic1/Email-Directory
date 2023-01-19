package com.tbse.ui.add_screen

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.tbse.ui.R

/**
 * Created by toddsmith on 1/18/23.
 */

@Composable
fun MyInputTextField(
    modifier: Modifier = Modifier,
    config: MyInputTextFieldConfig,
) {
    OutlinedTextField(
        modifier = modifier
            .fillMaxWidth(),
        value = config.value,
        label = {
            Text(
                text = stringResource(
                    id = config.labelResourceId,
                )
            )
        },
        onValueChange = {
            config.onValueChange(it)
        },
    )
}

data class MyInputTextFieldConfig(
    val value: String,
    val labelResourceId: Int,
    val onValueChange: (String) -> Unit,
)

@Preview(showBackground = true)
@Composable
fun MyInputTextFieldPreview(
    @PreviewParameter(MyInputTextFieldConfigProvider::class)
    config: MyInputTextFieldConfig,
) {
    MyInputTextField(
        modifier = Modifier,
        config = config,
    )
}

class MyInputTextFieldConfigProvider :
    PreviewParameterProvider<MyInputTextFieldConfig> {
    override val values: Sequence<MyInputTextFieldConfig>
        get() = sequenceOf(
            MyInputTextFieldConfig(
                value = "123",
                labelResourceId = R.string.add_screen_name_field,
                onValueChange = {}
            )
        )
}
