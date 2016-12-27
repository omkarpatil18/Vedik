package in.myvedik.android.vedik;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * Created by admin on 20-12-2016.
 */

public class MyPagerAdapter extends FragmentStatePagerAdapter {

    private ArrayList<HashMap<String, String>> mPostData;
    private JSONArray jsonArray;
    private Context context;
    private SplashActivity splashActivity;
    private static MyPagerAdapter sPagerAdapter;

    public static MyPagerAdapter getPagerAdapter(FragmentManager fm,Context context){
        if(sPagerAdapter==null){
            sPagerAdapter= new MyPagerAdapter(fm, context);
        }
        return sPagerAdapter;
    }

    private MyPagerAdapter(FragmentManager fm, Context context) {

        super(fm);
        this.context=context;
        splashActivity= new SplashActivity();
        mPostData=splashActivity.getPostData();
        jsonArray=splashActivity.getJsonArray();
    }

    @Override
    public Fragment getItem(int i) {
        Bundle bundle = new Bundle();
        UserPostFragment fragment = new UserPostFragment();
        bundle.putSerializable("POST_CONTENT",mPostData.get(i));
        fragment.setArguments(bundle);
        return fragment;
    }



    @Override
    public int getCount() {
        return jsonArray.length();

    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "OBJECT " + (position + 1);
    }
}
