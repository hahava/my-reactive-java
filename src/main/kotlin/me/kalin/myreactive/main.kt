package me.kalin.myreactive

import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.processors.PublishProcessor


fun main() {
    // cold publisher
    val flowable = Flowable.just(1, 3, 5, 7)
    flowable.subscribe { println("cold publisher first : $it") }
    flowable.subscribe { println("cold publisher second : $it") }

    println("\n\n")

    // hot publisher
    val processor = PublishProcessor.create<Int>()
    processor.subscribe { println("hot publisher first : $it") }
    processor.onNext(1)
    processor.onNext(3)

    processor.subscribe { println("hot publisher second : $it") }
    processor.onNext(5)
    processor.onNext(7)
}