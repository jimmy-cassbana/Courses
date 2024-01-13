package jimmy.maazady.data.remote

import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response = chain.run {
        proceed(
            request()
                .newBuilder()
                .addHeader("private-key", "3%o8i}_;3D4bF]G5@22r2)Et1&mLJ4?\$@+16")
                .build()
        )
    }
}