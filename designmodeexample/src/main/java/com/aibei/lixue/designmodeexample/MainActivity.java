package com.aibei.lixue.designmodeexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.aibei.lixue.designmodeexample.builder.KFCWaiter;
import com.aibei.lixue.designmodeexample.builder.SubMealBuilderA;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //套餐A
        SubMealBuilderA subMealBuilderA = new SubMealBuilderA();
        //服务员
        KFCWaiter waiter = new KFCWaiter(subMealBuilderA);
        //获得套餐
        waiter.construct();
    }
}
