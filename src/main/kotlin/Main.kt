package io.github.hansanto

import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.network.http.HttpNetworkTransport
import com.apollographql.apollo3.network.http.KtorHttpEngine
import io.ktor.client.HttpClient
import io.ktor.client.plugins.HttpTimeout

fun main() {
    println("1. Creation of client using basic http client")
    try {
        createBasicHttpClient().close()
        println("1. Success")
    } catch (e: Throwable) {
        println("1. Error")
        throw e
    }

    try {
        println("2. Creation of client using default constructor")
        createApolloClient().close()
        println("2. Success")
    } catch (e: Throwable) {
        println("2. Error")
        throw e
    }
}

/**
 * The creation using HttpTimeout works in Ktor 2.X.X but not in 3.X.x
 * due to a conflict between the version of ktor in Apollo and the version of ktor in the project.
 */
private fun createBasicHttpClient(): HttpClient {
    return HttpClient {
        install(HttpTimeout) {
            this.connectTimeoutMillis = 60_000L
            this.socketTimeoutMillis = 60_000L
        }
    }
}

/**
 * Example of code to create a Apollo client using Ktor.
 * In this code, the 'KtorHttpEngine' is created using the default parameter and an error is thrown.
 */
fun createApolloClient(): ApolloClient {
    return ApolloClient.Builder()
        .networkTransport(
            HttpNetworkTransport.Builder()
                .serverUrl("http://localhost:8080")
                // Produce: Caused by: java.lang.ClassNotFoundException: io.ktor.client.plugins.HttpTimeout
                // With Ktor 3.0.0
                .httpEngine(KtorHttpEngine())
                .build()
        ).build()
}
