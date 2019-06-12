package com.example.duanwu.cangku;


import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.duanwu.cangku.dao.UserBeanDao;
import com.example.duanwu.cangku.utils.MyDbUtil;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment2 extends Fragment {


    private RecyclerView recyclerView;
    private List<UserBean> userBeans;
    private View v;
    //界面是否初始化

    private Adapaters adapaters;
    Handler  handler=new Handler(){};



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_blank_fragment2, container, false);
        userBeans = MyApp.app.getDaoSession().getUserBeanDao().loadAll();
        recyclerView = v.findViewById(R.id.rews);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        adapaters = new Adapaters(getContext(), userBeans);
        recyclerView.setAdapter(adapaters);

        adapaters.setOnItemCLickListener(new Adapaters.OnItemCLickListener() {
            @Override
            public void onItemClick(View v, int position) {
                MyDbUtil.getMyDbUtil().delete(userBeans.get(position));
                userBeans.remove(position);
                adapaters.notifyDataSetChanged();

            }
        });
        return v;
    }
}
