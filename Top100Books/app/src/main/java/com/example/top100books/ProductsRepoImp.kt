package com.example.top100books

import coil.network.HttpException
import com.example.top100books.apiservices.productsApi
import com.example.top100books.dataclasses.Products.Product
import com.example.top100books.dataclasses.Products.Products
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException

class ProductsRepoImp(private val api: productsApi) : ProductRepository {
    override suspend fun getProductsList(): Flow<Result<List<Product>>> {
        return flow {
            val productsFromApi =
                try {
                    api.getProducts()
                } catch (e: IOException) {
                    e.printStackTrace()
                    emit(Result.Error(message = "Error loading products"))
                    return@flow
                } catch (e: HttpException) {
                    e.printStackTrace()
                    emit(Result.Error(message = "Error loading products"))
                    return@flow
                }catch (e: Exception) {
                    e.printStackTrace()
                    emit(Result.Error(message = "Error loading products"))
                    return@flow
                }
            emit(Result.Success(productsFromApi.products))
        }

    }
}