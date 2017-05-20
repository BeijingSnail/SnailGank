package example.snail.snailgank.observable;

import java.util.List;

import example.snail.snailgank.bean.AndroidBean;
import example.snail.snailgank.bean.AndroidResult;
import example.snail.snailgank.network.GankRetrofit;
import example.snail.snailgank.network.api.GankApi;
import rx.Observable;

/**
 * Created by Snail on 2017/5/20.
 */

public class ObservableHelper {

    public static Observable<List<AndroidBean>> getAndroidObservable(String type, int count, int page) {

        return GankRetrofit.getRetrofit()
                .create(GankApi.class)
                .getAndroidDatas(type, count, page)
                .flatMap(ObservableHelper::getAndroidList);

    }

    private static Observable<List<AndroidBean>> getAndroidList(AndroidResult androidResult) {
        List<AndroidBean> androidBeanList = androidResult.getResults();
        for (AndroidBean bean : androidBeanList) {
            bean.setCreatedAt(formatCreatedAt(bean.getCreatedAt()));
        }

        return Observable.create((subscriber -> {
            subscriber.onNext(androidResult.getResults());
            subscriber.onCompleted();
        }));
    }

    private static String formatCreatedAt(String createdAt) {
        return createdAt.substring(0, createdAt.indexOf("T"));
    }

}
