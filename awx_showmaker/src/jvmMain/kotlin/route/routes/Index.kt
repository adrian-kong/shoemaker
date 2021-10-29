package route.routes

import io.ktor.application.*
import io.ktor.html.*
import io.ktor.http.*
import io.ktor.http.content.*
import io.ktor.routing.*
import kotlinx.html.*

fun HTML.index() {
    head {
        title("Hello from Ktor!")
    }
    body {
        div {
            id = "root"
        }
        script(src = "/static/awx_showmaker.js") {}
    }
}

fun Route.index() {
    get {
        call.respondHtml(HttpStatusCode.OK, HTML::index)
    }
    static("/static") {
        resources()
    }
}