package api

// TODO: temporary database of shoes...
data class Shoe(val name: String, val price: Float, val resource: String)

val shoes = mutableMapOf(
    1 to Shoe("ADIDAS NMD_R1 V2 DAZZLE CAMO", 218.00f, "adidas.jpg"),
    2 to Shoe("YEEZY 450 CLOUD WHITE", 365.00f, "yeezy.jpg"),
    3 to Shoe("GUCCI BLUE TENNIS 1977 SNEAKER", 690.00f, "gucci.jpg")
)