package com.example.duanwu.cangku;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Model implements  IModel{
    @Override
    public void mGetImageList(int s, final IPstener.ICallback callback) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MyServler.url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        MyServler myServler = retrofit.create(MyServler.class);
        Map<String ,Object> map=new HashMap<>();
        map.put("cid",s);

        Observable<Beans> image = myServler.getImages(map);
        image.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Beans>() {


                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Beans bean) {
                        List<Beans.DataBean.DatasBean> datas = bean.getData().getDatas();
                        callback.success(datas);


                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
