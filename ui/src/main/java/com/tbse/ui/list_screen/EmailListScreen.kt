package com.tbse.ui.list_screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.hilt.navigation.compose.hiltViewModel
import com.tbse.domain.viewmodels.email_list.EmailListScreenState
import com.tbse.domain.viewmodels.email_list.EmailListScreenViewModel

/**
 * Created by toddsmith on 1/14/23.
 */

@Composable
fun EmailListScreen(
    modifier: Modifier = Modifier,
    config: GetListScreenConfig,
    viewModel: EmailListScreenViewModel = hiltViewModel(),
) {

    val state = viewModel.stateFlow.collectAsState()
    when (val stateValue = state.value) {
        EmailListScreenState.Loading -> {
            EmailListScreenMessage(
                config = EmailListScreenMessageConfig(
                    "Loading..."
                )
            )
            viewModel.startFlow()
        }
        is EmailListScreenState.ReceivedEmailList -> {
            val emailList = remember { mutableStateListOf<EmailItemComposableConfig>() }
            emailList.addAll(stateValue.emailList
                .map {
                    EmailItemComposableConfig(
                        id = it.id,
                        name = it.name,
                        email = it.email,
                    )
                }
            )

            EmailListComposable(
                modifier = modifier,
                config = EmailListComposableConfig(
                    stateValue.emailList
                        .map {
                            EmailItemComposableConfig(
                                id = it.id,
                                name = it.name,
                                email = it.email,
                            )
                        }
                ),
                onDeleteClicked = {
                    viewModel.deleteItem(it)
                }
            )
        }
        is EmailListScreenState.Error -> {
            EmailListScreenMessage(
                config = EmailListScreenMessageConfig(
                    stateValue.error.message ?: "No error message"
                )
            )
        }
    }
}

data class GetListScreenConfig(
    val a: String,
)

@Preview(showBackground = true)
@Composable
fun GetListScreenPreview(
    @PreviewParameter(GetListScreenConfigProvider::class)
    config: GetListScreenConfig,
) {
    EmailListScreen(
        modifier = Modifier,
        config = config,
    )
}

class GetListScreenConfigProvider :
    PreviewParameterProvider<GetListScreenConfig> {
    override val values: Sequence<GetListScreenConfig>
        get() = sequenceOf(
            GetListScreenConfig(
                a = "List of Emails",
            )
        )
}
