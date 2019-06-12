package com.example.duanwu.cangku;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private Adapter_Fragment vpAdapter;
    private ArrayList<Fragment> mFragments;
    private List<Bean.DataBean> result;
    private FrameLayout fl;
    private RadioButton rb1;
    private RadioButton rb2;
    private BlankFragment blankFragment;
    private BlankFragment2 blankFragment2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();


/*        initView();
        //String  url=" https://www.wanandroid.com/project/tree/json" ;

        init();*/
    init();
    }

    private void init() {



                   RadioButton rb1 = findViewById(R.id.rb1);
                   RadioButton rb2 = findViewById(R.id.rb2);


                   blankFragment = new BlankFragment();
                   blankFragment2 = new BlankFragment2();


                   // 初始化   fragment
                   FragmentManager manager = getSupportFragmentManager();//  管理器
                   FragmentTransaction transaction = manager.beginTransaction();//  事物
                   // 初始化  fragment    add  添加    replace  替换  (  remove   add )
                   transaction.add(R.id.fl, blankFragment); //  替换   FrameLayout
                   transaction.add(R.id.fl, blankFragment2);

                   transaction.hide(blankFragment2);
                   // 提交
                   transaction.commit();




                   // replace   移除 （关闭）  （ 创建 ）  类似finishn (切换)       在切换回来   从新创建 ( 新的  )
                   //  add      类似   隐藏   显示    创建新的
                   //    提供两个 方法   show   hiede

                   rb1.setOnClickListener(new View.OnClickListener() {
                       @Override
                       public void onClick(View v) {

                           // finish();

                           // 初始化   fragment
                           FragmentManager manager = getSupportFragmentManager();//  管理器
                           FragmentTransaction transaction = manager.beginTransaction();//  事物
                           // 初始化  fragment    add  添加    replace  替换  (  remove   add )
                           //transaction.replace(R.id.fl, blankFragment); //  替换   FrameLayout
                           transaction.show(blankFragment).hide(blankFragment2);
                           // 提交
                           transaction.commit();
                       }
                   });

                   rb2.setOnClickListener(new View.OnClickListener() {
                       @Override
                       public void onClick(View v) {
                           // 初始化   fragment
                           FragmentManager manager = getSupportFragmentManager();//  管理器
                           FragmentTransaction transaction = manager.beginTransaction();//  事物
                           // 初始化  fragment    add  添加    replace  替换  (  remove   add )
                           //transaction.add(R.id.fl,blankFragment2); //  替换   FrameLayout
                           transaction.show(blankFragment2).hide(blankFragment);
                           // 提交
                           transaction.commit();
                       }
                   });
               }



    private void initView() {
        fl = (FrameLayout) findViewById(R.id.fl);
        rb1 = (RadioButton) findViewById(R.id.rb1);
        rb2 = (RadioButton) findViewById(R.id.rb2);
    }


}