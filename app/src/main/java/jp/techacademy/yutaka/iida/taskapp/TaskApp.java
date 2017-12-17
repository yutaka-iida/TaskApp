package jp.techacademy.yutaka.iida.taskapp;

import android.app.Application;

import io.realm.Realm;

/**
 * Created by iiday on 2017/12/17.
 */

public class TaskApp extends Application {
    @Override
    public void onCreate(){
        super.onCreate();
        Realm.init(this);
    }
}
