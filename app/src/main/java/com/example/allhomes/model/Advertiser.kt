package com.example.allhomes.model

data class Advertiser(
    val id: Int = 0,
    val images: Images = Images(),
    val name: String = "",
    val preferred_color_hex: String = ""
)