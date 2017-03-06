package com.aibei.lixue.designmodeexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.aibei.lixue.designmodeexample.builder.KFCWaiter;
import com.aibei.lixue.designmodeexample.builder.Meal;
import com.aibei.lixue.designmodeexample.builder.SubMealBuilderA;
import com.aibei.lixue.designmodeexample.factory.ILog;
import com.aibei.lixue.designmodeexample.factory.LogFactory;
import com.aibei.lixue.designmodeexample.singleIntance.CTO;

public class MainActivity extends AppCompatActivity {
    private TextView text_builder;
    private TextView text_single;
    private TextView text_factory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();
    }

    private void initView(){
        text_builder = (TextView) findViewById(R.id.text_builder);
        text_single = (TextView) findViewById(R.id.text_single);
        text_factory = (TextView) findViewById(R.id.text_factory);
    }

    private void initData(){
        //单例模式
        text_single.setText(CTO.getInstance().toString() + "\n" + CTO.getInstance2());

        //建造者模式

        //套餐A
        SubMealBuilderA subMealBuilderA = new SubMealBuilderA();
        //服务员
        KFCWaiter waiter = new KFCWaiter(subMealBuilderA);
        //获得套餐
        Meal mealA =  waiter.construct();
        text_builder.setText("套餐A中的\n  食物：" + mealA.getFood() +"\n  饮料：" + mealA.getDrink());

        //优化的工厂方法模式
        LogFactory factory = new LogFactory();
        ILog fileLog = factory.createFileLog();
        ILog dataBaseLog = factory.createDatabaseLog();
        text_factory.setText("fileLog:" + fileLog.writeLog() + "\n" +"dateBaseLog:" + dataBaseLog.writeLog());

    }
}
