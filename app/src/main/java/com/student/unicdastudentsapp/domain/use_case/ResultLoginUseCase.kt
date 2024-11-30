package com.student.unicdastudentsapp.domain.use_case

/**
 * A generic class that holds a value with its loading status.
 * @param <T>
 */
sealed class ResultLoginUseCase<out T : Any> {

    data class Success<out T : Any>(val data: T) : ResultLoginUseCase<T>()
    data class Error(val exception: Exception) : ResultLoginUseCase<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$exception]"
        }
    }
}