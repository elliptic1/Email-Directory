package com.tbse.ui.add_screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * Created by toddsmith on 1/14/23.
 */
@Composable
fun AddEmailScreen(
    modifier: Modifier = Modifier
) {

    Box(
        modifier = modifier
            .fillMaxSize()
    ) {

        Column(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 25.dp)
        ) {

            Text(
                text = "Name"
            )
            TextField(
                value = "Joe Smith",
                onValueChange = {

                },
            )
            Spacer(
                modifier = Modifier
                    .height(25.dp)
            )
            Text(
                text = "Email"
            )
            TextField(
                value = "joe@example.com",
                onValueChange = {

                },
            )


        }

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(25.dp)
                .align(Alignment.BottomCenter),
            onClick = { /*TODO*/ },
        ) {
            Text(text = "Add")
        }

    }
}

@Composable
@Preview(showBackground = true)
fun AddScreenComposablePreview() {
    AddEmailScreen()
}
