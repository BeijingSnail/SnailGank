package example.snail.snailgank.network;

import java.util.concurrent.TimeUnit;

import example.snail.snailgank.common.Constant;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Snail on 2017/5/20.
 */

public class GankRetrofit {

    private static Retrofit retrofit;

    public static Retrofit getRetrofit() {
        if (retrofit == null) {
            synchronized (GankRetrofit.class) {
                retrofit = new Retrofit.Builder()
                        .baseUrl(Constant.GankBaseUrl)
                        .addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                        .client(defaultOkHttpClient())
                        .build();
            }
        }
        return retrofit;
    }


    public static OkHttpClient defaultOkHttpClient() {
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(3, TimeUnit.SECONDS)
                .writeTimeout(3, TimeUnit.SECONDS)
                .readTimeout(3, TimeUnit.SECONDS)
                .build();
        return client;
    }


}
