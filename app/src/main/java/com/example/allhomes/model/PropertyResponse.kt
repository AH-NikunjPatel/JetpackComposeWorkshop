package com.example.allhomes.model

data class PropertyResponse(
    val search_results: List<PropertyResult> = listOf(),
)