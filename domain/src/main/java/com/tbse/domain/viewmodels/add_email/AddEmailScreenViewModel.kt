package com.tbse.domain.viewmodels.add_email

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tbse.data.resource.Resource
import com.tbse.domain.models.EmailItemModel
import com.tbse.domain.use_case.add_screen.AddEmailScreenUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by toddsmith on 1/15/23.
 */
@HiltViewModel
class AddEmailScreenViewModel @Inject constructor(
    private val addEmailScreenUseCase: AddEmailScreenUseCase,
) : ViewModel() {

    private val _eventFlow = MutableStateFlow<AddEmailScreenEvent>(
        AddEmailScreenEvent.Default
    )

    val eventFlow: StateFlow<AddEmailScreenEvent>
        get() = _eventFlow.asStateFlow()

    fun addEmail(
        name: String,
        email: String,
    ) {
        addEmailScreenUseCase.addEmail(
            EmailItemModel(
                id = -1,
                name = name,
                email = email,
            )
        ).onEach { result ->
            when (result) {
                is Resource.Error -> _eventFlow.emit(
                    AddEmailScreenEvent.Error
                )
                is Resource.Loading -> _eventFlow.emit(
                    AddEmailScreenEvent.Default
                )
                is Resource.Success -> _eventFlow.emit(
                    AddEmailScreenEvent.EmailAdded
                )
            }
        }.launchIn(viewModelScope)
    }

    fun transientMessageFinished() {
        viewModelScope.launch {
            _eventFlow.emit(AddEmailScreenEvent.TransientMessageFinished)
        }
    }
}
