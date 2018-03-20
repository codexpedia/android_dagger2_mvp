package com.example.dagger2_mvp.dagger.modules

import android.content.Context

import com.example.dagger2_mvp.dagger.scopes.ApplicationScope
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder

import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class WebServiceModule(var mBaseUrl: String) {

    @Provides
    @ApplicationScope
    fun provideHttpCache(myAppContext: Context): Cache {
        val cacheSize = 10 * 1024 * 1024
        return Cache(myAppContext.cacheDir, cacheSize.toLong())
    }

    @Provides
    @ApplicationScope
    fun provideGson(): Gson {
        val gsonBuilder = GsonBuilder()
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        return gsonBuilder.create()
    }

    @Provides
    @ApplicationScope
    fun provideOkhttpClient(cache: Cache): OkHttpClient {
        val client = OkHttpClient.Builder()
        client.cache(cache)
        return client.build()
    }

    @Provides
    @ApplicationScope
    fun provideRetrofit(gson: Gson, okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(mBaseUrl)
                .client(okHttpClient)
                .build()
    }
}