package com.example.duanwu.cangku;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {

    private TabLayout tabLayout;
    private ViewPager vp;
    private View v;
    private ArrayList<Fragment> mFragments;
    private Adapter_Fragment vpAdapter;

    public BlankFragment() {
        // Required empty public constructor
    }

    private void init() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MyServler.url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        MyServler myServler = retrofit.create(MyServler.class);
        Observable<Bean> image = myServler.getImage();
        image.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Bean>() {


                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Bean bean) {
                        Log.d("==========", bean.getData().size() + "");
                        List<Bean.DataBean> result = bean.getData();
                        mFragments = new ArrayList<>();
                        for (int i = 0; i < result.size(); i++) {
                            tabLayout.addTab(tabLayout.newTab().setText(result.get(i).getName()));
                            //  mData.add(resultsBean.getRESULT().get(i));
                            mFragments.add(new BlankFragment_fragement(result.get(i).getId()));


                        }
                        //viewpager
                        vp.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
                        vpAdapter = new Adapter_Fragment(getChildFragmentManager(), mFragments);
                        vp.setAdapter(vpAdapter);

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    private void initView() {
        tabLayout = (TabLayout) v.findViewById(R.id.tabLayout);
        vp = (ViewPager) v.findViewById(R.id.vp);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_blank, container, false);
        initView();;
        init();
        return v;
    }

}
