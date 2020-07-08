import controllers.*
import io.ktor.application.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*


fun main(args:Array<String>) {
    embeddedServer(Netty, 22333) {
        routing {
            route("/v0.1") {
                get("/render_id") { IDRender(call).index() }
                get("/render_id/peek") { IDRender(call).peek() }
                get("/render_id/{prefix}") { IDRender(call).index() }
                get("/verify/{id}") { IDRender(call).verify() }
            }

//            route("/echo"){
//                get("/"){Example(call).echo()}
//                get("/{name}"){Example(call).echoWithId()}
//                post("/"){Example(call).echoFromPost()}
//            }
//
//            // url上面遇到assets就去resources裡頭找assets
//            static("assets"){
//                resources("assets")
//            }
      }
   }.start(wait = true)
}
