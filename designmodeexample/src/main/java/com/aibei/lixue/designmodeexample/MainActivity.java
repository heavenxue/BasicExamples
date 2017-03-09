package com.aibei.lixue.designmodeexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.aibei.lixue.designmodeexample.builder.KFCWaiter;
import com.aibei.lixue.designmodeexample.builder.Meal;
import com.aibei.lixue.designmodeexample.builder.SubMealBuilderA;
import com.aibei.lixue.designmodeexample.factory.ILog;
import com.aibei.lixue.designmodeexample.factory.ILog2;
import com.aibei.lixue.designmodeexample.factory.Log2Factory;
import com.aibei.lixue.designmodeexample.factory.LogFactory;
import com.aibei.lixue.designmodeexample.proxy.Proxy;
import com.aibei.lixue.designmodeexample.singleIntance.CTO;
import com.aibei.lixue.designmodeexample.strategy.AddStrategy;
import com.aibei.lixue.designmodeexample.strategy.Calcu;
import com.aibei.lixue.designmodeexample.strategy.DivideStrategy;
import com.aibei.lixue.designmodeexample.strategy.MultiStrategy;
import com.aibei.lixue.designmodeexample.strategy.SubStractStrategy;
import com.aibei.lixue.designmodeexample.template.AbstractComputer;
import com.aibei.lixue.designmodeexample.template.CoderComputer;
import com.aibei.lixue.designmodeexample.template.MilitaryComputer;

import static com.aibei.lixue.designmodeexample.strategy.Calcu.calc;

public class MainActivity extends AppCompatActivity {
    private TextView text_builder;
    private TextView text_single;
    private TextView text_factory;
    private TextView text_strategy;
    private TextView text_proxy;

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
        text_strategy = (TextView) findViewById(R.id.text_strategy);
        text_proxy = (TextView) findViewById(R.id.text_proxy);
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
        ILog2 dataBaseLog = factory.createDatabaseLog();
        String logStr = "fileLog:" + fileLog.writeLog() + "\n";
        dataBaseLog.outLog();
        text_factory.setText(logStr);

        //抽象工厂模式
        Log2Factory log2Factory = new Log2Factory();
        ILog file2Log = log2Factory.createFileLog();
        ILog2 database2Log = log2Factory.createDatabaseLog();
        text_factory.setText(logStr + "\n"  +"fileLog:" + fileLog.writeLog() + "\n");
        database2Log.outLog();


        //模板模式，具体见log吧
        AbstractComputer comp = new CoderComputer();
        comp.startUp();

        comp = new MilitaryComputer();
        comp.startUp();

        //策略模式
        String addstr = String.valueOf(Calcu.calc(new AddStrategy(),10,21.3));
        String substr = String.valueOf(calc(new SubStractStrategy(),10,2.3));
        String multistr = String.valueOf(calc(new MultiStrategy(),3,52));
        String dividestr = String.valueOf(calc(new DivideStrategy(),124,3));
        text_strategy.setText("加法 10 + 21.3 = " + addstr + "\n" +
                "减法 10 - 2.3 = " + substr +"\n" +
                "乘法 3 * 52 = " + multistr + "\n" +
                "除法 124 / 3 = "+ dividestr);

        //代理模式
        String theRequest = new Proxy().request();
        text_proxy.setText(theRequest);
    }
}
