package com.dee.core

import com.dee.common.ErrorDisplay
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

expect open class BaseViewModel() {
    val scope: CoroutineScope
    open val inputs: BaseInputs
    open val outputs: BaseOutputs

    open inner class BaseInputs() {
        open fun cancel()
        open fun emitLoading(value: Boolean)
        open fun emitError(error : ErrorDisplay)
    }

    open inner class BaseOutputs() {
        open val loading: MutableStateFlow<Boolean>
        open val eventFlow: Flow<ErrorDisplay>
    }
}