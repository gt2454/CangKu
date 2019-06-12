package com.example.duanwu.cangku;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class Adapaters extends RecyclerView.Adapter {
    Context context;
    List<UserBean> list = new ArrayList<>();
    private OnItemCLickListener mListener;
    public Adapaters(Context context, List<UserBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.item, null, false);
        MyHolder  myHolder=new MyHolder(v);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder,final int i) {
        MyHolder  myHolders= (MyHolder) viewHolder;
        Glide.with(context).load(list.get(i).getImage()).into(myHolders.image);
        myHolders.textView.setText(list.get(i).getSet());
        myHolders.textView2.setText(list.get(i).getName());
        myHolders.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mListener!=null){
                    mListener.onItemClick(v,i);

                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setList(List<UserBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    class MyHolder extends RecyclerView.ViewHolder {

        private final ImageView image;
        private TextView textView2;
        private final TextView textView;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            textView = itemView.findViewById(R.id.text);
            textView2=itemView.findViewById(R.id.text2);
        }
    }

     public interface OnItemCLickListener{
             void onItemClick(View v, int position);
            // void onLongClick(View v,int  position);
         }

         public void setOnItemCLickListener(OnItemCLickListener listener){
             this.mListener = listener;
         }



}
