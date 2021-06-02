package com.davidtiagodev.composeandsplash.network

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Named

class PublicAuthorizationInterceptor @Inject constructor(
    @Named("apiPublicKey") apiPublicKey: String
) : Interceptor {
    private val genericHeaderDelegate =
        GenericHeaderDelegate("Authorization", "Client-ID $apiPublicKey")

    override fun intercept(chain: Interceptor.Chain): Response =
        genericHeaderDelegate.invoke(chain)
}
