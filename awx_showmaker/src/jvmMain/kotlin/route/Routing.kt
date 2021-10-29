package api.server

import route.routes.awx
import route.routes.index
import io.ktor.routing.*

fun Routing.setupRoutes() = route("/") {
    awx()
    index()
}