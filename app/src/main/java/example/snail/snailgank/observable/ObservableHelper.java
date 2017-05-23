package example.snail.snailgank.observable;

import android.text.TextUtils;

import java.util.List;

import example.snail.snailgank.bean.AndroidBean;
import example.snail.snailgank.bean.AndroidResult;
import example.snail.snailgank.bean.IosBean;
import example.snail.snailgank.bean.IosResult;
import example.snail.snailgank.bean.WelfareBean;
import example.snail.snailgank.bean.WelfareResult;
import example.snail.snailgank.network.GankRetrofit;
import example.snail.snailgank.network.api.GankApi;
import rx.Observable;

/**
 * Created by Snail on 2017/5/20.
 */

public class ObservableHelper {

    public static rx.Observable<List<AndroidBean>> getAndroidObservable(String type, int count, int page) {

        return GankRetrofit.getRetrofit()
                .create(GankApi.class)
                .getAndroidDatas(type, count, page)
                .flatMap(ObservableHelper::getAndroidList);
    }

    public static rx.Observable<List<IosBean>> getIosObservable(String type, int count, int page) {
        return GankRetrofit.getRetrofit()
                .create(GankApi.class)
                .getIosdDatas(type, count, page)
                .flatMap(ObservableHelper::getIosList);
    }

    public static rx.Observable<List<WelfareBean>> getWelfareObservable(String type, int count, int page) {
        return GankRetrofit.getRetrofit()
                .create(GankApi.class)
                .getWelfareDatas(type, count, page)
                .flatMap(ObservableHelper::getWelfareList);
    }

    private static Observable<List<AndroidBean>> getAndroidList(AndroidResult androidResult) {
        List<AndroidBean> androidBeanList = androidResult.getResults();
        for (AndroidBean bean : androidBeanList) {
            bean.setCreatedAt(formatCreatedAt(bean.getCreatedAt()));
        }

        return Observable.create((subscriber -> {
            subscriber.onNext(androidBeanList);
            subscriber.onCompleted();
        }));
    }

    private static Observable<List<IosBean>> getIosList(IosResult iosResult) {
        List<IosBean> iosBeanList = iosResult.getResults();
        for (IosBean iosBean : iosBeanList) {
            iosBean.setCreatedAt(formatCreatedAt(iosBean.getCreatedAt()));
        }

        return Observable.create((subscriber -> {
            subscriber.onNext(iosBeanList);
            subscriber.onCompleted();
        }));

    }

    private static Observable<List<WelfareBean>> getWelfareList(WelfareResult welfareResult) {
        List<WelfareBean> welfareBeanList = welfareResult.getResults();
        for (WelfareBean welfareBean : welfareBeanList) {
            welfareBean.setCreatedAt(formatCreatedAt(welfareBean.getCreatedAt()));
        }
        return Observable.create((subscriber -> {
            subscriber.onNext(welfareBeanList);
            subscriber.onCompleted();
        }));

    }

    private static String formatCreatedAt(String createdAt) {
        if (TextUtils.isEmpty(createdAt)) {
            return "";
        }
        return createdAt.substring(0, createdAt.indexOf("T"));
    }

}
