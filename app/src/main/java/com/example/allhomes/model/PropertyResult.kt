package com.example.allhomes.model


data class PropertyResult(
    val address: String = "",
    val advertiser: Advertiser = Advertiser(),
    val bathroom_count: Double = 0.0,
    val bedroom_count: Double = 0.0,
    val carspace_count: Int = 0,
    val headline: String = "",
    val id: Int = 0,
    val media: List<Media> = listOf(),
    val price: String = "",
) {
    fun getBathCount()
            : String {
        if (bathroom_count.equals(0.0) || bathroom_count.isNaN())
            return "- "
        else
            return bathroom_count.toInt().toString()
    }
    fun getBedCount()
            : String {
        if (bedroom_count.equals(0.0) || bedroom_count.isNaN())
            return "- "
        else
            return bedroom_count.toInt().toString()
    }
    fun getCarCount()
            : String {
        if (carspace_count.equals(0) || carspace_count.equals(null))
            return "- "
        else
            return carspace_count.toString()
    }
}