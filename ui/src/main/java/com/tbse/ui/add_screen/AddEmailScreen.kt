package com.tbse.ui.add_screen

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.tbse.domain.viewmodels.add_email.AddEmailScreenEvent
import com.tbse.domain.viewmodels.add_email.AddEmailScreenViewModel
import com.tbse.ui.R

/**
 * Created by toddsmith on 1/14/23.
 */
@Composable
fun AddEmailScreen(
    modifier: Modifier = Modifier,
    viewModel: AddEmailScreenViewModel = hiltViewModel(),
) {

    val nameTextState = remember { mutableStateOf("") }
    val emailTextState = remember { mutableStateOf("") }

    val event = viewModel.eventFlow.collectAsState()
    when (event.value) {
        AddEmailScreenEvent.EmailAdded -> {
            Toast.makeText(
                LocalContext.current,
                "Added!",
                Toast.LENGTH_SHORT,
            ).show()
            viewModel.transientMessageFinished()
        }
        AddEmailScreenEvent.Default -> {}
        AddEmailScreenEvent.Error -> {}
        AddEmailScreenEvent.TransientMessageFinished -> {}
    }

    Box(
        modifier = modifier
            .padding(25.dp)
            .fillMaxSize()
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter)
        ) {
            MyInputTextField(
                modifier = modifier,
                config = MyInputTextFieldConfig(
                    value = nameTextState.value,
                    labelResourceId = R.string.add_screen_name_field,
                    onValueChange = {
                        nameTextState.value = it
                    }
                )
            )

            Spacer(
                modifier = Modifier
                    .height(25.dp)
            )

            MyInputTextField(
                modifier = modifier,
                config = MyInputTextFieldConfig(
                    value = emailTextState.value,
                    labelResourceId = R.string.add_screen_email_field,
                    onValueChange = {
                        emailTextState.value = it
                    }
                )
            )

            Spacer(
                modifier = Modifier
                    .height(25.dp)
            )

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(75.dp)
                    .padding(5.dp),
                onClick = {
                    viewModel.addEmail(
                        name = nameTextState.value,
                        email = emailTextState.value,
                    )
                },
            ) {
                Text(text = stringResource(id = R.string.add_screen_add_button))
            }
        }

    }
}

@Composable
@Preview(showBackground = true)
fun AddScreenComposablePreview() {
    AddEmailScreen()
}
