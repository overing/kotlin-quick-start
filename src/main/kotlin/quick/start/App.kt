package quick.start

import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.netty.EngineMain;
import io.ktor.server.response.respondText
import io.ktor.server.routing.get
import io.ktor.server.routing.routing
import org.kodein.di.bindSingleton
import org.kodein.di.DI
import org.kodein.di.instance

class MyService {
    val greeting: String get() = "Hello world."
}

fun main(args: Array<String>): Unit = EngineMain.main(args)

fun Application.module() {
    val di = DI {
        bindSingleton<MyService> { MyService() }
    }
    
    routing {
        get("/") {
            call.respondText("Is Working!")
        }
        get("/api/hello") {
            val service: MyService by di.instance()
            call.respondText(service.greeting)
        }
    }
}
