package br.com.hussan.githubapi

import io.reactivex.Observable

/**
 * Object representing a UI that will
 * a) emit its intents to a view model,
 * b) subscribes to a view model for rendering its UI.
 *
 * @param I Top class of the [BaseIntent] that the [BaseView] will be emitting.
 * @param S Top class of the [BaseViewState] the [BaseView] will be subscribing to.
 */
interface BaseView<I : BaseIntent, in S : BaseViewState> {
    /**
     * Unique [Observable] used by the [BaseViewModel]
     * to listen to the [BaseView].
     * All the [BaseView]'s [BaseIntent]s must go through this [Observable].
     */
    fun intents(): Observable<I>

    /**
     * Entry point for the [BaseView] to render itself based on a [BaseViewState].
     */
    fun render(state: S)
}