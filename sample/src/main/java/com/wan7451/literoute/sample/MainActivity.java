package com.wan7451.literoute.sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.wan7451.literoute.IntentWrapper;
import com.wan7451.literoute.Interceptor;
import com.wan7451.literoute.LiteRouter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //创建LiteRouter
        LiteRouter liteRouter = LiteRouter.createRouter();
        //创建接口实现类对象
        IntentService intentService = liteRouter.create(IntentService.class, this);
        //调用方法，进行跳转
        intentService.startMain2Activity("android", 2016);


        IntentWrapper intentWrapper = intentService.startMain2ActivityRaw("android", 2016);
// intent
        Intent intent = intentWrapper.getIntent();
// add your flags
        intentWrapper.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
// start
        intentWrapper.start();
    }
}
