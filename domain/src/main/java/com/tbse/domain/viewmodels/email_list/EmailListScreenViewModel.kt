package com.tbse.domain.viewmodels.email_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tbse.data.resource.Resource
import com.tbse.domain.use_case.list_screen.EmailListScreenUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

/**
 * Created by toddsmith on 1/15/23.
 */
@HiltViewModel
class EmailListScreenViewModel @Inject constructor(
    private val emailListScreenUseCase: EmailListScreenUseCase,
) : ViewModel() {

    private val _stateFlow = MutableStateFlow<EmailListScreenState>(
        EmailListScreenState.Loading
    )

    val stateFlow: StateFlow<EmailListScreenState>
        get() = _stateFlow.asStateFlow()

    fun startFlow() {
        emailListScreenUseCase.getEmails().onEach { result ->
            _stateFlow.emit(
                when (result) {
                    is Resource.Loading -> {
                        EmailListScreenState.Loading
                    }
                    is Resource.Success -> {
                        EmailListScreenState.ReceivedEmailList(
                            result.data?.emails ?: emptyList()
                        )
                    }
                    is Resource.Error -> {
                        EmailListScreenState.Error(
                            IllegalStateException(result.message)
                        )
                    }
                }
            )
        }.launchIn(viewModelScope)
    }

    fun deleteItem(id: Int) {
        emailListScreenUseCase.deleteItem(id).launchIn(viewModelScope)
    }
}
