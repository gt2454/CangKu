package com.example.duanwu.cangku;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.duanwu.cangku.dao.DaoMaster;


public class MyDaoMaster  extends DaoMaster.OpenHelper {
    public MyDaoMaster(Context context, String name) {
        super(context, name);
    }

    public MyDaoMaster(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory);
    }
}
