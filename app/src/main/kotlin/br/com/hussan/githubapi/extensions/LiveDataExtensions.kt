package br.com.hussan.githubapi.extensions

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.LiveDataReactiveStreams
import android.arch.lifecycle.Transformations
import io.reactivex.BackpressureStrategy
import io.reactivex.Observable
import org.reactivestreams.Publisher

fun <T> Publisher<T>.toLiveData(): LiveData<T> =
    LiveDataReactiveStreams.fromPublisher(this)

fun <T> Observable<T>.toLiveData(strategy: BackpressureStrategy = BackpressureStrategy.LATEST) =
    this.toFlowable(strategy).toLiveData()

//fun <T> Observable<T>.toResult(schedulerProvider: SchedulerProviderContract?): Observable<Result<T>> =
//    compose { item ->
//        item
//            .map { Result.success(it) }
//            .onErrorReturn { e -> Result.failure(e.message ?: "unknown", e) }
//            .observeOn(schedulerProvider?.ui)
//            .startWith(Result.inProgress())
//    }


inline fun <X, Y> LiveData<X>.map(crossinline transformer: (X) -> Y): LiveData<Y> =
    Transformations.map(this, { transformer(it) })
