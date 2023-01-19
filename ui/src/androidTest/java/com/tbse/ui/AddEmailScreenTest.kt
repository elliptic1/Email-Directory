package com.tbse.ui

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import com.tbse.ui.add_screen.MyInputTextField
import com.tbse.ui.add_screen.MyInputTextFieldConfig
import org.junit.Rule
import org.junit.Test

/**
 * Created by toddsmith on 1/18/23.
 */
class AddEmailScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testThatTheNameTextFieldUpdates() {

        val tag = "testTag"

        composeTestRule.setContent {

            val emailTextState = remember { mutableStateOf("") }

            MyInputTextField(
                modifier = Modifier
                    .testTag(tag),
                config = MyInputTextFieldConfig(
                    value = emailTextState.value,
                    labelResourceId = R.string.add_screen_name_field,
                    onValueChange = {
                        emailTextState.value = it
                    },
                )
            )

        }

        val testString =
            " !\"#$%&\'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~"

        composeTestRule
            .onNodeWithTag(testTag = tag)
            .performTextInput(testString)

        composeTestRule
            .onNodeWithTag(tag)
            .assert(hasText(testString))

    }

}