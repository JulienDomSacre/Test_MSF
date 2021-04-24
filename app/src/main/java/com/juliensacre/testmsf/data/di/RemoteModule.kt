package com.juliensacre.testmsf.data.di

import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import com.juliensacre.testmsf.data.remote.RemoteDataSource
import com.juliensacre.testmsf.data.remote.api.TrombiService
import com.juliensacre.testmsf.data.remote.mapper.RemoteMapper
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

const val EXAMPLE_API = "exempleApi"
val remoteModule = module {
    single(named(EXAMPLE_API)) {
        "https://sandbox.mystudiofactory.com/"
    }

    single {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        logging
    }

    single {
        val client = OkHttpClient.Builder()
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
        //if (BuildConfig.DEBUG)
            client.addInterceptor(get<HttpLoggingInterceptor>())
        client.build()
    }

    single {
        GsonBuilder()
            .setLenient()
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
            .setFieldNamingPolicy(
                FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES
            )
            .create()
    }

    single {
        Retrofit.Builder()
            .baseUrl(get<String>(named(EXAMPLE_API)))
            .client(get())
            .addConverterFactory(GsonConverterFactory.create(get()))
            .build()
    }

    factory {
        get<Retrofit>().create(TrombiService::class.java)
    }

    single {
        RemoteDataSource(
            trombiService = get()
        )
    }

    factory { RemoteMapper() }
}