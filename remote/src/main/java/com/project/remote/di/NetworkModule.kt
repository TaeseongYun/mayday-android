package com.project.remote.di

import com.google.gson.GsonBuilder
import com.project.remote.BuildConfig
import com.project.remote.component.Constants.BASE_URL
import com.project.remote.component.Constants.CACHE_SIZE
import com.project.remote.component.Constants.CALL_TIEM_OUT
import com.project.remote.component.Constants.READ_TIEM_OUT
import com.project.remote.component.Constants.WRITE_TIEM_OUT
import com.project.remote.response.Api
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidApplication
import org.koin.core.parameter.parametersOf
import org.koin.dsl.module
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


val networkModule = module {
    single { Cache(androidApplication().cacheDir, CACHE_SIZE) }

    factory<Interceptor> {
        HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor.Level.BODY
            } else {
                HttpLoggingInterceptor.Level.NONE
            }
        }
    }

    factory { (chain: Interceptor.Chain) ->
        val request =
            chain.request()
                .newBuilder()
                .addHeader("헤더이름1", "헤더이름1")
                .addHeader("헤더이름2", "헤더이름2")
                .build()

        chain.proceed(request)
    }

    single<CallAdapter.Factory> {
        RxJava2CallAdapterFactory.create()
    }

    single<Converter.Factory> {
        val gsonBuilder = GsonBuilder()
            .setPrettyPrinting()
            .setVersion(1.0)
            .create()
        GsonConverterFactory.create(gsonBuilder)
    }

    factory {
        OkHttpClient.Builder()
            .addInterceptor(get<Interceptor>())
            .addInterceptor { get { parametersOf(it) } }
            .readTimeout(READ_TIEM_OUT, TimeUnit.MILLISECONDS)
            .writeTimeout(WRITE_TIEM_OUT, TimeUnit.MILLISECONDS)
            .callTimeout(CALL_TIEM_OUT, TimeUnit.MILLISECONDS)
            .build()
    }

    single<Retrofit> {
        Retrofit.Builder()
            .client(get<OkHttpClient>())
            .addConverterFactory(get())
            .addCallAdapterFactory(get())
            .baseUrl(BASE_URL)
            .build()
    }

    single {
        get<Retrofit>().create(Api::class.java)
    }
}