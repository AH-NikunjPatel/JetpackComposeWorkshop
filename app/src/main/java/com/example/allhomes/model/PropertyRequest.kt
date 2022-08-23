package com.example.allhomes.model

@kotlinx.serialization.Serializable
data class PropertyRequest(
    val dwelling_types: List<String> = listOf("Apartment","Unit","Flat"),
    val search_mode: String
)