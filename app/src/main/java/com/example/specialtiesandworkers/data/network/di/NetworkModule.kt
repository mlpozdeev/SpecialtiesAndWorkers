package com.example.specialtiesandworkers.data.network.di

import com.example.specialtiesandworkers.data.network.api.WorkersApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    companion object {
        private const val BASE_URL = "https://gitlab.65apps.com"
    }

    @Singleton
    @Provides
    fun provideRetrofitService(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    @Provides
    fun provideWorkersApi(retrofit: Retrofit): WorkersApi {
        return retrofit.create(WorkersApi::class.java)
    }

}