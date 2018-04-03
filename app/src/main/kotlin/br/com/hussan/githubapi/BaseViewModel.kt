package br.com.hussan.githubapi

import io.reactivex.Observable

interface BaseViewModel<I : BaseIntent, S : BaseViewState> {
    fun processIntents(intents: Observable<I>)

    fun states(): Observable<S>
}