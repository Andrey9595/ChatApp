package ru.anb.chatapp.di

abstract class LoadState<T> {

    class Success<T>(val data: T? =null) : LoadState<T>()

    class Error<T>(val error: Int) : LoadState<T>()

    class Loading<T> : LoadState<T>()

    class NotLoadedYet<T> : LoadState<T>()
}