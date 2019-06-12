package com.example.duanwu.cangku;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

public class Adapter_Fragment extends FragmentStatePagerAdapter {

        private ArrayList<Fragment> mFragments;

        public Adapter_Fragment(FragmentManager fm, ArrayList<Fragment> mFragments) {
            super(fm);

            this.mFragments = mFragments;
        }



        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }





}
