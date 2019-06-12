package com.example.duanwu.cangku;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.example.duanwu.cangku.dao.DaoMaster;
import com.example.duanwu.cangku.dao.DaoSession;


public class MyApp  extends Application {
    private static final   String  DB_NAME="data1.db";
    public  static  MyApp  app;
    private SQLiteDatabase db;
    private MyDaoMaster   helper;
    private DaoSession daoSession;
    private DaoMaster daoMaster;

    @Override
    public void onCreate() {
        super.onCreate();
        app=this;
        initDao();
    }

    private void initDao() {
        helper=new MyDaoMaster(this,DB_NAME);
        db=helper.getWritableDatabase();
        daoMaster=new DaoMaster(db);
        daoSession=daoMaster.newSession();

    }

    public DaoSession getDaoSession() {
        return daoSession;

    }
}
