package com.davidtiagodev.composeandsplash.network

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AcceptVersionInterceptor @Inject constructor() : Interceptor {
    private val genericHeaderDelegate = GenericHeaderDelegate("Accept-Version", "v1")
    override fun intercept(chain: Interceptor.Chain): Response =
        genericHeaderDelegate.invoke(chain)
}
