package com.gabrielgrs2.base.presentation.viewmodel

interface BaseAction<State> {
    fun reduce(state: State): State
}
