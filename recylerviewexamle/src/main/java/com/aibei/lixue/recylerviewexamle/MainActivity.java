package com.aibei.lixue.recylerviewexamle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.aibei.lixue.recylerviewexamle.adapter.HeaderBootAdapter;
import com.aibei.lixue.recylerviewexamle.adapter.MixRecyclerAdapter;
import com.aibei.lixue.recylerviewexamle.adapter.MultiSeletedAdapter;
import com.aibei.lixue.recylerviewexamle.adapter.RecyclerAdapter;
import com.aibei.lixue.recylerviewexamle.divider.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<String> stringList = new ArrayList<>();

    private int adapterType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initView(){
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
    }

    private void initData(){
        adapterType = getIntent().getIntExtra("adapterType",0);
        //九宫格布局
//        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));//这里用线性宫格显示 类似于grid view
        //瀑布流布局
//        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, OrientationHelper.VERTICAL));//这里用线性宫格显示 类似于瀑布流
        //线性布局
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        String[] arrayList = getResources().getStringArray(R.array.datas);
        for(int i =0 ;i < arrayList.length; i ++){
            stringList.add(arrayList[i]);
        }
        switch (adapterType){
            case 0:
                recyclerView.setAdapter(new RecyclerAdapter(stringList));
                break;
            case 1:
                recyclerView.setAdapter(new MixRecyclerAdapter(stringList));
                break;
            case 2:
                recyclerView.setAdapter(new MultiSeletedAdapter(stringList));
                break;
            case 3:
                HeaderBootAdapter headerBootAdapter = new HeaderBootAdapter(stringList);
                headerBootAdapter.setmHeaderCount(1);
                headerBootAdapter.setmBottomCount(1);
                recyclerView.setAdapter(headerBootAdapter);
                break;
        }
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));

    }

    @Override
    protected void onDestroy() {
        if (stringList != null){
            stringList.clear();
            stringList = null;
        }
        super.onDestroy();
    }
}
