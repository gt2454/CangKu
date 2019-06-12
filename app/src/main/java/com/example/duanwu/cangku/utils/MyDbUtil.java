package com.example.duanwu.cangku.utils;

import com.example.duanwu.cangku.MyApp;
import com.example.duanwu.cangku.UserBean;
import com.example.duanwu.cangku.dao.DaoMaster;
import com.example.duanwu.cangku.dao.DaoSession;
import com.example.duanwu.cangku.dao.UserBeanDao;

import java.util.List;

public class MyDbUtil {
    private static MyDbUtil myDbUtil;
    private final UserBeanDao userBeanDao;

    private MyDbUtil(){
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(MyApp.app, "info.db");
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        userBeanDao = daoSession.getUserBeanDao();
    }
    public static MyDbUtil getMyDbUtil() {
        if(myDbUtil == null){
            synchronized (MyDbUtil.class){
                if(myDbUtil == null){
                    myDbUtil = new MyDbUtil();
                }
            }
        }
        return myDbUtil;
    }
    public boolean has(UserBean bean){
        List<UserBean> list = userBeanDao.queryBuilder().where(UserBeanDao.Properties.Image.eq(bean.getImage())).list();
        if(list!= null && list.size()>0){
            return true;
        }
        return false;
    }

    public void insert(UserBean bean){
        if(!has(bean)){
            userBeanDao.insert(bean);
        }
    }
    public void delete(UserBean bean){
        if(has(bean)){
            userBeanDao.delete(bean);
        }
    }

    public List<UserBean> query(){
        return userBeanDao.queryBuilder().list();
    }
}

