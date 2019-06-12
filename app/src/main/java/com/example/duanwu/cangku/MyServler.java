package com.example.duanwu.cangku;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

public interface MyServler {
    //String  url=" https://www.wanandroid.com/project/tree/json" ;

    String   url="https://www.wanandroid.com/project/";
    @GET("tree/json")
    Observable<Bean>getImage();




    @GET("list/1/json?")
    Observable<Beans> getImages(@QueryMap Map<String,Object> map);


}
