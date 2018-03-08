package au.com.nextdot.searchoptionsmanager;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

/**
 * Created by sakib on 2/26/2018.
 */

public class SharedPreferenceManager {
    private static SharedPreferenceManager mInstance;
    private static SharedPreferences mSharedPref;

    public SharedPreferenceManager(Context context){

        if(mSharedPref == null)
            mSharedPref = context.getSharedPreferences(context.getPackageName(), Activity.MODE_PRIVATE);
    }
    public static SharedPreferenceManager getInstance(Context context)
    {
        if(mInstance == null){
            mInstance = new SharedPreferenceManager(context);
        }
        return mInstance;
    }

    //get methods

    public String getGroup1(String group1,String key1)
    {
       // Log.d("getg1",mSharedPref.getString(key1,group1));
        return mSharedPref.getString(key1,group1);
    }
    public String getGroup2(String group2,String key2)
    {
       // Log.d("getg1",mSharedPref.getString(key2,group2));
        return mSharedPref.getString(key2,group2);
    }
    public String getGroup3(String group3,String key3)
    {
       // Log.d("getg1",mSharedPref.getString(key3,group3));
        return mSharedPref.getString(key3,group3);
    }


    //set methods
    public void setGroups(String key1,String key2,String key3,String group1,String group2,String group3)
    {
        SharedPreferences.Editor editor=mSharedPref.edit();
        editor.putString(key1,group1);
        editor.putString(key2,group2);
        editor.putString(key3,group3);
        //Log.d("setg1",mSharedPref.getString(key1,group1));
        editor.commit();
    }

}
