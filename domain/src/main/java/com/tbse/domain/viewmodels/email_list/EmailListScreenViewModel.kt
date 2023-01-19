package com.tbse.domain.viewmodels.email_list

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tbse.data.resource.Resource
import com.tbse.domain.models.EmailItemModel
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

    private val _emailList = mutableStateListOf<EmailItemModel>()
    private val emailList: List<EmailItemModel> = _emailList

    fun startFlow() {
        emailListScreenUseCase.getEmails().onEach { result ->
            _stateFlow.emit(
                when (result) {
                    is Resource.Loading -> {
                        EmailListScreenState.Loading
                    }
                    is Resource.Success -> {
                        _emailList.clear()
                        _emailList.addAll(result.data?.emails ?: emptyList())
                        EmailListScreenState.ReceivedEmailList(
                            emailList
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
        emailListScreenUseCase
            .deleteItem(id)
            .onEach { response ->
                when (response) {
                    is Resource.Success -> {
                        _emailList.removeIf { it.id == id }
                    }
                    else -> {}
                }
            }
            .launchIn(viewModelScope)
    }
}
