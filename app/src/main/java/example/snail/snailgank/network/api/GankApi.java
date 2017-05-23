package example.snail.snailgank.network.api;

import example.snail.snailgank.bean.AndroidResult;
import example.snail.snailgank.bean.IosResult;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by Snail on 2017/5/19.
 */

public interface GankApi {

    @GET("api/data/{type}/{count}/{page}")
    Observable<AndroidResult> getAndroidDatas(
            @Path("type") String type,
            @Path("count") int count,
            @Path("page") int page
    );

    @GET("api/data/{type}/{count}/{page}")
    Observable<IosResult> getIosdDatas(
            @Path("type") String type,
            @Path("count") int count,
            @Path("page") int page
    );


}
