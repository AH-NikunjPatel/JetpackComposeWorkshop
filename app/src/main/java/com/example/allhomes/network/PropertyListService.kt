package com.example.allhomes.network

import com.example.allhomes.model.PropertyRequest
import com.example.allhomes.model.PropertyResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

class PropertyListService(
    private val apiService: ApiService
) {

//    suspend fun fetchListing(search_mode: String): Flow<Result<List<PropertyResult>>> {
//        return flow {
//                val response = apiService.getPropertyList(PropertyRequest(search_mode = search_mode))
//            emit(Result.success(response.search_results))
//        }.catch { exception ->
//            emit(Result.failure(RuntimeException(exception.message ?: "Something went wrong")))
//        }
//    }
}