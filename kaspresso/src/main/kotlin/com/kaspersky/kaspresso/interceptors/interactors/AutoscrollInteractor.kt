package com.kaspersky.kaspresso.interceptors.interactors

interface AutoscrollInteractor<Interaction> : Interactor<Interaction> {

    fun <R> autoscroll(interaction: Interaction, action: () -> R, cachedError: Throwable): R
}