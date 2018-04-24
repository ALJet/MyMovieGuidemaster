package indi.aljet.mymovieguide_master.network;

import java.io.IOException;

import javax.inject.Inject;

import indi.aljet.mymovieguide_master.BuildConfig;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by PC-LJL on 2018/4/10.
 */

public class RequestInterceptor implements Interceptor {

    @Inject

    public RequestInterceptor() {
    }


    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();
        HttpUrl originalHttpUrl = original.url();
        HttpUrl url = originalHttpUrl
                .newBuilder()
                .addQueryParameter("api_key",
                        BuildConfig.TMDB_API_KEY)
                .build();
        Request request = original.newBuilder()
                .url(url).build();
        return chain.proceed(request);
    }
}
