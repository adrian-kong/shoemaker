package airwallex

import api.shoes
import kotlinx.css.*
import kotlinx.css.properties.Transforms
import kotlinx.css.properties.translate
import kotlinx.html.id
import kotlinx.html.js.onClickFunction
import react.*
import react.dom.*
import styled.css
import styled.styledDiv

external interface AppState : RState {
//    var submitted: Boolean
//    var paymentIntent: PaymentIntentResponse?
}

@JsExport
class AirwallexApp : RComponent<RProps, AppState>() {

    override fun AppState.init() {
//        // TODO: this should refer to next_action in docs but here for now to see it kind of function.
//        submitted = false
//        paymentIntent = null
    }

    override fun RBuilder.render() {
        title("Selling cool shoes! - ShoesForYou")

        styledDiv {
            h1 { attrs.text("ShoesForYou") }
            p { attrs.text("Buy a pair of shoe!") }
            css {
                fontFamily = "Monospace"
                textAlign = TextAlign.center
                paddingTop = 120.px
                paddingBottom = 120.px
            }
        }
        styledDiv {
            setupShoes()
            css {
                fontFamily = "Monospace"
                display = Display.flex
                justifyContent = JustifyContent.center
            }
        }
    }

    private fun RBuilder.setupShoes() {
        shoes.forEach { (index, shoe) ->
            styledDiv {
                css {
                    margin = "50px"
                    opacity = 0.5
                    cursor = Cursor.default
                    filter = "grayscale(1)"
                    hover {
                        opacity = 1
                        cursor = Cursor.pointer
                        filter = "grayscale(0)"
                    }
                }

                img(src = "static/${shoe.resource}") {
                    attrs {
                        height = "220"
                        width = "480"
                        onClickFunction = {
                            redirectPaymentLink(index)
                        }
                    }
                }
                h2("shoe_title") { attrs.text(shoe.name) }
                p("shoe_price") { attrs.text("$${shoe.price} USD") }
            }
        }
    }

}

fun RBuilder.app() = child(AirwallexApp::class) {}