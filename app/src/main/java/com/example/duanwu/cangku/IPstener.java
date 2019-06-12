package com.example.duanwu.cangku;

import java.util.List;

public interface IPstener {
     void getImageList(int s);
         interface   ICallback{
             void  success(List<Beans.DataBean.DatasBean> list);
             void onFail(String   string);
         }
}
