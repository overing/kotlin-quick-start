package quick.start

import org.kodein.di.DI
import org.kodein.di.bindSingleton
import org.kodein.di.instance

class Gen {
    val greeting: String
        get() = "Hello world."
}

class App(private val gen: Gen) {
    fun persist() {
        println(gen.greeting)
    }
}

fun main() {
    val di = DI {
        bindSingleton<Gen> { Gen() }
        bindSingleton<App> { App(instance()) }
    }

    val app: App by di.instance()
    app.persist()
}
