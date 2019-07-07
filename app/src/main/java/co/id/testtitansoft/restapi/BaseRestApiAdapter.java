package co.id.testtitansoft.restapi;

import co.id.testtitansoft.BuildConfig;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by user on 27/02/2018.
 */

public class BaseRestApiAdapter {

    protected static Retrofit restAdapter;

    protected static Retrofit getRestAdapter(String serverURL) {
        OkHttpClientFactory okHttpClientFactory = OkHttpClientFactory.getInstance();
        HttpLoggingInterceptor logging = getLoggingLevel();
        okHttpClientFactory.getOkHttpClientForRestAdapter().addInterceptor(logging);
        return new Retrofit.Builder()
                .baseUrl(serverURL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClientFactory.getOkHttpClientForRestAdapter().build())
                .build();
    }

    private static HttpLoggingInterceptor getLoggingLevel() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        if (BuildConfig.BUILD_TYPE.equals("debug")) {
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        } else {
            logging.setLevel(HttpLoggingInterceptor.Level.NONE);
        }
        return logging;
    }
}