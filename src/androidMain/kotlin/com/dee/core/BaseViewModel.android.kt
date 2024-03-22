package com.dee.core

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dee.common.ErrorDisplay
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

actual open class BaseViewModel : ViewModel() {
    actual val scope: CoroutineScope get() = viewModelScope
    actual open val inputs: BaseInputs = BaseInputs()
    actual open val outputs: BaseOutputs = BaseOutputs()
    private val _loading = MutableStateFlow<Boolean>(false)
    private val _eventChannel = Channel<ErrorDisplay>()

    actual open inner class BaseInputs actual constructor() {
        actual open fun cancel() {
        }

        actual open fun emitLoading(value: Boolean) {
            outputs.loading.value = value
        }

        actual open fun emitError(error: ErrorDisplay) {
            scope.launch {
                _eventChannel.send(error)
            }
        }
    }

    actual open inner class BaseOutputs actual constructor() {
        actual open val loading: MutableStateFlow<Boolean>
            get() = _loading

        actual open val eventFlow: Flow<ErrorDisplay>
            get() = _eventChannel.receiveAsFlow()
    }
}