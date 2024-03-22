package com.dee.core

import com.dee.common.ErrorDisplay
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

actual open class BaseViewModel actual constructor() {
    actual val scope: CoroutineScope
        get() = TODO("Not yet implemented")
    actual open val inputs: BaseInputs
        get() = TODO("Not yet implemented")
    actual open val outputs: BaseOutputs
        get() = TODO("Not yet implemented")

    actual open inner class BaseInputs actual constructor() {
        actual open fun cancel() {
        }

        actual open fun emitLoading(value: Boolean) {
        }

        actual open fun emitError(error: ErrorDisplay) {
        }
    }

    actual open inner class BaseOutputs actual constructor() {
        actual open val loading: MutableStateFlow<Boolean>
            get() = TODO("Not yet implemented")
        actual open val eventFlow: Flow<ErrorDisplay>
            get() = TODO("Not yet implemented")
    }

}