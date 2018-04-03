package br.com.hussan.githubapi

import io.reactivex.Scheduler


interface BaseSchedulerProvider {
    fun computation(): Scheduler

    fun io(): Scheduler

    fun ui(): Scheduler
}