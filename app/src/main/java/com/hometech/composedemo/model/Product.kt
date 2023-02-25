package com.hometech.composedemo.model

data class Product(val id: Int, val name: String, val description: String, val type: String, val price: Int) {

    fun doesMatchQuery(query: String): Boolean {

        val matchingCombinations = listOf(
            "$name.first()${name.last()}",
            "$name.first()${name.last()}",
            "$type.first()",
            "$description.first()",
            "$price.first()"
        )

        return matchingCombinations.any {
            it.contains(query, ignoreCase = true)
        }
    }

}

val allProducts = listOf(
    Product(1, "Shampoo", "Moisturizing shampoo for all hair types", "Beauty", 799),
    Product(2, "Conditioner", "Detangling conditioner for curly hair", "Beauty", 899),
    Product(3, "Toothbrush", "Electric toothbrush with multiple modes", "Health", 2499),
    Product(4, "Toothpaste", "Fluoride toothpaste for cavity prevention", "Health", 399),
    Product(5, "Yoga mat", "Eco-friendly yoga mat with non-slip surface", "Fitness", 2999),
    Product(6, "Resistance bands", "Set of 5 resistance bands for home workouts", "Fitness", 1499),
    Product(7, "T-shirt", "Cotton t-shirt with graphic print", "Clothing", 999),
    Product(8, "Jeans", "Straight leg jeans with faded wash", "Clothing", 2499),
    Product(9, "Backpack", "Lightweight backpack with multiple compartments", "Accessories", 1999),
    Product(10, "Headphones", "Wireless headphones with noise cancellation", "Electronics", 6999),
    Product(11, "Smartwatch", "Fitness tracker with heart rate monitor and GPS", "Electronics", 7999),
    Product(12, "Laptop", "Thin and light laptop with long battery life", "Electronics", 54999),
    Product(13, "Sunglasses", "Polarized sunglasses with UV protection", "Accessories", 2999),
    Product(14, "Earrings", "Gold-plated stud earrings with cubic zirconia", "Jewelry", 1499),
    Product(15, "Necklace", "Sterling silver necklace with pendant", "Jewelry", 3999),
    Product(16, "Smart thermostat", "Wi-Fi enabled thermostat for smart home", "Home", 7999),
    Product(17, "Air purifier", "HEPA air purifier for cleaner indoor air", "Home", 14999),
    Product(18, "Cookware set", "10-piece stainless steel cookware set", "Kitchen", 14999),
    Product(19, "Blender", "Powerful blender for smoothies and soups", "Kitchen", 5999),
    Product(20, "Outdoor grill", "Gas grill with four burners and side burner", "Outdoor", 24999)
)
