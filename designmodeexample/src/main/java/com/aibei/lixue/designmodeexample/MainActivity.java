package com.aibei.lixue.designmodeexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.aibei.lixue.designmodeexample.bridge.Car;
import com.aibei.lixue.designmodeexample.bridge.RainyTire;
import com.aibei.lixue.designmodeexample.bridge.RancingCar;
import com.aibei.lixue.designmodeexample.bridge.SandyTire;
import com.aibei.lixue.designmodeexample.bridge.SedanCar;
import com.aibei.lixue.designmodeexample.builder.KFCWaiter;
import com.aibei.lixue.designmodeexample.builder.Meal;
import com.aibei.lixue.designmodeexample.builder.SubMealBuilderA;
import com.aibei.lixue.designmodeexample.command.ConcreateCommand;
import com.aibei.lixue.designmodeexample.command.ConcreteCommand2;
import com.aibei.lixue.designmodeexample.command.Invoker;
import com.aibei.lixue.designmodeexample.command.People;
import com.aibei.lixue.designmodeexample.command.Receiver;
import com.aibei.lixue.designmodeexample.factory.ILog;
import com.aibei.lixue.designmodeexample.factory.ILog2;
import com.aibei.lixue.designmodeexample.factory.Log2Factory;
import com.aibei.lixue.designmodeexample.factory.LogFactory;
import com.aibei.lixue.designmodeexample.iterator.Contanier;
import com.aibei.lixue.designmodeexample.iterator.IContanier;
import com.aibei.lixue.designmodeexample.iterator.Iterator;
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

import java.util.ArrayList;
import java.util.List;

import static com.aibei.lixue.designmodeexample.strategy.Calcu.calc;

public class MainActivity extends AppCompatActivity {
    private TextView text_builder;
    private TextView text_single;
    private TextView text_factory;
    private TextView text_strategy;
    private TextView text_proxy;
    private TextView text_iterator;
    private TextView text_command;
    private TextView text_bridge;

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
        text_iterator = (TextView) findViewById(R.id.text_iterator);
        text_command = (TextView) findViewById(R.id.text_command);
        text_bridge = (TextView) findViewById(R.id.text_bridge);
    }

    private void initData(){

        //************单例模式************
        text_single.setText(CTO.getInstance().toString() + "\n" + CTO.getInstance2());

        //************建造者模式************

        //套餐A
        SubMealBuilderA subMealBuilderA = new SubMealBuilderA();
        //服务员
        KFCWaiter waiter = new KFCWaiter(subMealBuilderA);
        //获得套餐
        Meal mealA =  waiter.construct();
        text_builder.setText("套餐A中的\n  食物：" + mealA.getFood() +"\n  饮料：" + mealA.getDrink());

        //************优化的工厂方法模式************
        LogFactory factory = new LogFactory();
        ILog fileLog = factory.createFileLog();
        ILog2 dataBaseLog = factory.createDatabaseLog();
        String logStr = "fileLog:" + fileLog.writeLog() + "\n";
        dataBaseLog.outLog();
        text_factory.setText(logStr);

        //************抽象工厂模式************
        Log2Factory log2Factory = new Log2Factory();
        ILog file2Log = log2Factory.createFileLog();
        ILog2 database2Log = log2Factory.createDatabaseLog();
        text_factory.setText(logStr + "\n"  +"fileLog:" + fileLog.writeLog() + "\n");
        database2Log.outLog();


        //************模板模式，具体见log吧************
        AbstractComputer comp = new CoderComputer();
        comp.startUp();

        comp = new MilitaryComputer();
        comp.startUp();

        //************策略模式************
        String addstr = String.valueOf(Calcu.calc(new AddStrategy(),10,21.3));
        String substr = String.valueOf(calc(new SubStractStrategy(),10,2.3));
        String multistr = String.valueOf(calc(new MultiStrategy(),3,52));
        String dividestr = String.valueOf(calc(new DivideStrategy(),124,3));
        text_strategy.setText("加法 10 + 21.3 = " + addstr + "\n" +
                "减法 10 - 2.3 = " + substr +"\n" +
                "乘法 3 * 52 = " + multistr + "\n" +
                "除法 124 / 3 = "+ dividestr);

        //************代理模式************
        String theRequest = new Proxy().request();
        text_proxy.setText(theRequest);

        //************迭代模式************
        List<Object> list = new ArrayList<>();
        list.add("Android");
        list.add("PHP");
        list.add("C Language");

        IContanier container = new Contanier(list);
        container.add("HardWare");

        Iterator iterator = container.createIterator();
        String str = "";
        while (iterator.hasNext()) {
            str = str + iterator.next() + " , ";
        }
        text_iterator.setText(str);

        //************命令模式******************
        People people = new People();
        people.setAge(10);//这是人的原始年龄
        people.setName("xiao hua ");//原始名字

        Receiver receiver = new Receiver(people);
        ConcreateCommand command = new ConcreateCommand(receiver);
        Invoker invoker = new Invoker(command);
        invoker.call();
        String commandstr = people.toString();
        text_command.setText(commandstr);//看代码内部，已经把人update成18，ruby了

        //执行第二个命令
        ConcreteCommand2 command2 = new ConcreteCommand2(receiver);
        Invoker invoker2 = new Invoker(command2);
        invoker2.call();
        text_command.setText(commandstr + "\n" + people.toString());//看代码内部，已经把人update成18，ruby了

        //************桥接模式************
        //使抽象部分与实现部分分离开来
        Car car = null;
        car = new SedanCar(new SandyTire());
        String car1 = car.run();
        car = new SedanCar(new RainyTire());
        String car2 = car.run();
        car = new RancingCar(new SandyTire());
        String car3 = car.run();
        car = new RancingCar(new RainyTire());
        String car4 = car.run();
        text_bridge.setText(car1 + "\n " + car2 + "\n " + car3 + "\n " + car4);
    }
}
