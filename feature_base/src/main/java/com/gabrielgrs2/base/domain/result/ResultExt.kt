package com.gabrielgrs2.base.domain.result

inline fun <T> Result<T>.mapSuccess(
    crossinline onResult: Result.Success<T>.() -> Result<T>,
): Result<T> {
    if (this is Result.Success) {
        return onResult(this)
    }
    return this
}
