package com.tbse.data.resource

/**
 * Created by toddsmith on 1/15/23.
 */
sealed class Resource<T>(
    val data: T? = null,
    val message: String? = null,
) {

    class Loading<T>(data: T? = null) : Resource<T>(data)

    class Success<T>(data: T) : Resource<T>(data)

    class Error<T>(data: T? = null, message: String) : Resource<T>(data, message)

}
