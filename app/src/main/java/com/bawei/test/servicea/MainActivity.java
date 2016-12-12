package com.bawei.test.servicea;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button start_but = (Button)findViewById(R.id.service_start);
        Button stop_but = (Button)findViewById(R.id.service_stop);
        start_but.setOnClickListener(this);
        stop_but.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.service_start:
                Intent intent = new Intent(this,MyService.class);
              startService(new Intent(this,MyService.class));//开启服务

                //该参数通过Intent指定要启动的Service。
               /* 该参数的类型是ServiceConnection，负责连接Intent对象指定的服务。当访问者与Service之间连
                成功时将回调ServiceConnecttion对象的onServiceConnected(ComponentName name,IBinder service)方法；当
                Service所在的宿主进程由于异常终止或由于其他原因终止，导致该Service与访问者之间断开连接时回调
                ServiceConnection对象的onServiceDisconnected(ComponentName name)方法。*/
                //该参数是一个标志位，一般设为Context.BIND_AUTO_CREATE。
               // bindService(intent, connection, BIND_AUTO_CREATE);//绑定服务
                break;
            case R.id.service_stop:
                stopService(new Intent(this,MyService.class));//停止服务

              //  unbindService(connection);//解绑服务
                break;
        }
    }
    ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.e("", "---------------onServiceConnected");
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            Log.e("", "---------------onSeviceDisconnected");
        }
    };
}
