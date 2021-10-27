package airwallex

import api.airwallex.PaymentIntentResponse
import kotlinx.html.id
import kotlinx.html.js.onClickFunction
import org.w3c.dom.events.Event
import react.*
import react.dom.*

external interface AppState : RState {
    var submitted: Boolean
    var paymentIntent: PaymentIntentResponse?
}

@JsExport
class AirwallexApp : RComponent<RProps, AppState>() {

    override fun AppState.init() {
        // TODO: this should refer to next_action in docs but here for now to see it kind of function.
        submitted = false
        paymentIntent = null
    }

    override fun RBuilder.render() {
        div("payment-form") {
            +"Shoemaker Airwallex Payment Gateway"

            when (state.submitted) {
                true -> confirmIntent()
                false -> submitIntent()
            }
        }
    }

    private fun RBuilder.confirmIntent() {
        +"Enter details"
//      coolButton("Confirm") { event -> confirmPaymentIntent() }
    }

    private fun RBuilder.submitIntent() {
        coolButton("Submit") {
            createPaymentIntent().then { p ->
                // switch state
                setState {
                    submitted = true
                    paymentIntent = p
                }
            }
        }
    }

    /**
     * Test UI for functionality.
     */
    private fun RBuilder.coolButton(name: String, click: (event: Event) -> Unit) {
        button {
            +name
            attrs {
                onClickFunction = click
            }
        }
    }

}

fun RBuilder.app() = child(AirwallexApp::class) {}