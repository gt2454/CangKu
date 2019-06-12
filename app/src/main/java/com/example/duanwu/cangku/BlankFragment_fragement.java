package com.example.duanwu.cangku;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.duanwu.cangku.dao.UserBeanDao;
import com.example.duanwu.cangku.utils.MyDbUtil;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
@SuppressLint("ValidFragment")
public class BlankFragment_fragement extends Fragment implements  IView{


    private RecyclerView rew;
    private Adapater adapater;
    private List<Beans.DataBean.DatasBean> lists;
    private int s;
    public BlankFragment_fragement(int s) {
        // Required empty public constructor
        this.s = s;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_blank_fragment_fragement, container, false);
        lists = new ArrayList<>();
        initView(v);
        return v;
    }

    private void initView(View v) {
        rew = (RecyclerView) v.findViewById(R.id.rew);
        LinearLayoutManager  linearLayoutManager=new LinearLayoutManager(getContext());
        rew.setLayoutManager(linearLayoutManager);
        adapater = new Adapater(getActivity(),lists);
        rew.setAdapter(adapater);
        IPstener pstener=new Prestrner(this);
        pstener.getImageList(s);
        adapater.setOnItemCLickListener(new Adapater.OnItemCLickListener() {
            @Override
            public void onItemClick(View v, int position) {

                String title = lists.get(position).getTitle();
                String chapterName = lists.get(position).getChapterName();
                String envelopePic = lists.get(position).getEnvelopePic();
                UserBean userBeans = new UserBean();
                userBeans.setImage(envelopePic);
                userBeans.setSet(chapterName);
                userBeans.setName(title);
                QueryBuilder<UserBean> user = MyApp.app.getDaoSession().getUserBeanDao().queryBuilder();
                QueryBuilder<UserBean> where = user.where(UserBeanDao.Properties.Name.eq(userBeans.getName()));
                List<UserBean> listi = user.list();

                if(listi.size()!=0){
                    Toast.makeText(getContext(),"数据库中已有数据",Toast.LENGTH_LONG).show();

                }else{
                    MyApp.app.getDaoSession().getUserBeanDao().insert(userBeans);
                }

            }
        });

    }

    @Override
    public void showImageList(List list) {
        lists.addAll(list);
        adapater.notifyDataSetChanged();

    }
}
