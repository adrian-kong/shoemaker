package api.airwallex

import kotlinx.serialization.Serializable

@Serializable
data class Order(
    var products: List<Product>,
    var shipping: Shipping,
    var type: String,
)

@Serializable
data class Product(
    var code: String,
    var desc: String,
    var name: String,
    var quantity: Int,
    var sku: String,
    var type: String,
    var unit_price: Int,
    var url: String,
)

@Serializable
data class Shipping(
    var address: Address,
    var first_name: String,
    var last_name: String,
    var phone_number: String,
    var shipping_method: String
)

@Serializable
data class Address(
    var city: String,
    var country_code: String,
    var postcode: String? = null,
    var state: String? = null,
    var street: String,
)