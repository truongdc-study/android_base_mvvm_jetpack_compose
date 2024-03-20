package com.truongdc.android.core.source.remote.provides

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerCollector
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.chuckerteam.chucker.api.RetentionManager
import com.truongdc.android.core.source.remote.interceptors.AuthInterceptor
import com.truongdc.android.core.source.remote.interceptors.HeaderInterceptor
import com.truongdc.android.core.source.remote.interceptors.TokenAuthenticator
import com.truongdc.android.core.utils.Constant
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

object OkHttpClientProvider {
    private const val READ_TIMEOUT = 30L
    private const val WRITE_TIMEOUT = 30L

    fun getOkHttpClientBuilder(
        chuckerInterceptor: ChuckerInterceptor,
        httpLoggingInterceptor: HttpLoggingInterceptor,
        headerInterceptor: HeaderInterceptor,
        authInterceptor: AuthInterceptor? = null,
        tokenAuthenticator: TokenAuthenticator? = null,
    ): OkHttpClient.Builder {
        return OkHttpClient.Builder().apply {
            if (Constant.DEBUG) {
                addInterceptor(chuckerInterceptor)
                addInterceptor(httpLoggingInterceptor)
            }
            addInterceptor(headerInterceptor)
            authInterceptor?.let(::addInterceptor)
            tokenAuthenticator?.let(::authenticator)
            readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
            writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
        }
    }

    fun getHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    fun getChuckerInterceptor(context: Context): ChuckerInterceptor {
        val collector = ChuckerCollector(
            context = context,
            showNotification = true,
            retentionPeriod = RetentionManager.Period.ONE_HOUR
        )
        return ChuckerInterceptor.Builder(context)
            .collector(collector)
            .alwaysReadResponseBody(true)
            .build()
    }

    fun getHeaderInterceptor(): HeaderInterceptor {
        return HeaderInterceptor()
    }
}