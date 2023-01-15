package com.tbse.data

/**
 * Created by toddsmith on 1/15/23.
 */
interface ModelMapper<I, out O> {
    fun map(input: I): O
}