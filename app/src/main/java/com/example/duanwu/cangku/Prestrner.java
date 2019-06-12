package com.example.duanwu.cangku;

import java.util.List;

public class Prestrner  implements IPstener,IPstener.ICallback {
     private IModel  mdeol;
         private IView  view;
         public    Prestrner  (IView  view){
             this.view=view;
             mdeol=new Model();
         }
         @Override
         public void getImageList(int s) {
             mdeol.mGetImageList(s,this);
         }

         @Override
         public void success(List<Beans.DataBean.DatasBean> list) {
             if(this.view!=null){
                 this.view.showImageList(list);

             }

         }

         @Override
         public void onFail(String string) {

         }

}
