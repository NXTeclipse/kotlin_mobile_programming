package com.example.catatanpenjualan.network

import android.os.Build
import com.example.catatanpenjualan.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkConfig {
    fun getInterceptor():OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient().newBuilder()
            .addInterceptor(interceptor)
            .build()
    }
    fun getRetrofit():Retrofit{
        return  Retrofit.Builder()
            .baseUrl(BuildConfig.Server_URL)
            .client(getInterceptor())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
        fun service() = getRetrofit()
            .create(CatatanPenjualanService::class.java)

}