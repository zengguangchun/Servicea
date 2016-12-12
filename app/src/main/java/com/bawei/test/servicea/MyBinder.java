package com.bawei.test.servicea;

import android.content.Context;
import android.os.Binder;
import android.widget.Toast;

/**
 * autour: 曾光春
 * date: $date$ $time$
 * update: $date$
 */
public class MyBinder extends Binder implements ServerConnect {
    private Context context;

    public MyBinder(Context context) {
        this.context = context;
    }



    @Override
    public void getOneNet() {
        Toast.makeText(context,"MyBinder---startDownload数据", Toast.LENGTH_LONG).show();
    }
}
