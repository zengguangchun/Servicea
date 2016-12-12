package com.bawei.test.servicea;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MyService extends Service implements ServiceConnection {
    public MyService() {

    }
    private static final String TAG = "MyService----------->";
    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        Log.e(TAG, "onStart");
        Toast.makeText(getApplicationContext(),"Service----------onStart",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(TAG, "onCreate");
        try {
            Thread.sleep(20000);//20秒 10秒广播
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Toast.makeText(getApplicationContext(),"Service----------onCreate",Toast.LENGTH_LONG).show();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        Toast.makeText(getApplicationContext(),"Service----------onBind",Toast.LENGTH_LONG).show();
        Log.e(TAG, "onBind");
        MyBinder myBinder = new MyBinder(getApplicationContext());
        myBinder.getOneNet();
        return  myBinder;

    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.e(TAG, "onUnbind");
        return super.onUnbind(intent);

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e(TAG, "onStartCommand");
        Toast.makeText(getApplicationContext(),"Service----------onStartCommand",Toast.LENGTH_LONG).show();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy");
        Toast.makeText(getApplicationContext(),"Service----------onDestroy",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        //ServerConnect myService = (ServerConnect) iBinder;
        Log.e(TAG, "---------------onSeviceDisconnected");
    }

    @Override
    public void onServiceDisconnected(ComponentName componentName) {
        Log.e(TAG, " --------------onServiceConnected");
    }
}
