package com.tbse.domain.viewmodels.email_list

import androidx.lifecycle.ViewModel
import com.tbse.domain.use_case.EmailListScreenUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
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

}