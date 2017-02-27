package com.aibei.lixue.recylerviewexamle;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.aibei.lixue.recylerviewexamle.adapter.HeaderBootAdapter;
import com.aibei.lixue.recylerviewexamle.adapter.MixRecyclerAdapter;
import com.aibei.lixue.recylerviewexamle.adapter.MultiSeletedAdapter;
import com.aibei.lixue.recylerviewexamle.adapter.RecyclerAdapter;
import com.aibei.lixue.recylerviewexamle.adapter.SlideInLeftAdapter;
import com.aibei.lixue.recylerviewexamle.animator.SlideInLeftAnimator;
import com.aibei.lixue.recylerviewexamle.divider.DividerItemDecoration;
import com.yanzhenjie.recyclerview.swipe.Closeable;
import com.yanzhenjie.recyclerview.swipe.OnSwipeMenuItemClickListener;
import com.yanzhenjie.recyclerview.swipe.SwipeMenu;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuCreator;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuItem;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private SwipeMenuRecyclerView recyclerView;
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
        recyclerView = (SwipeMenuRecyclerView) findViewById(R.id.recyclerView);
        //设置菜单创建器。
        recyclerView.setSwipeMenuCreator(swipeMenuCreator);
        // 设置菜单Item点击监听。
        recyclerView.setSwipeMenuItemClickListener(new OnSwipeMenuItemClickListener() {
            @Override
            public void onItemClick(Closeable closeable, int adapterPosition, int menuPosition, int direction) {
                Toast.makeText(getBaseContext(),adapterPosition+"",Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * 菜单创建器。在Item要创建菜单的时候调用。
     */
    private SwipeMenuCreator swipeMenuCreator = new SwipeMenuCreator() {
        @Override
        public void onCreateMenu(SwipeMenu swipeLeftMenu, SwipeMenu swipeRightMenu, int viewType) {

//            SwipeMenuItem addItem = new SwipeMenuItem(getBaseContext())
//                    .setBackgroundDrawable(R.drawable.trash)// 点击的背景。
//                    .setImage(R.drawable.trash) // 图标。
//                    .setWidth(size) // 宽度。
//                    .setHeight(size); // 高度。
//            swipeLeftMenu.addMenuItem(addItem); // 添加一个按钮到左侧菜单。

            SwipeMenuItem deleteItem = new SwipeMenuItem(getBaseContext())
                    .setImage(R.drawable.trash) // 图标。
                    .setText("删除") // 文字。
                    .setTextColor(Color.WHITE) // 文字颜色。
                    .setTextSize(16) // 文字大小。
                    .setWidth(70)
                    .setHeight(70);
            swipeRightMenu.addMenuItem(deleteItem);// 添加一个按钮到右侧侧菜单。.

            // 上面的菜单哪边不要菜单就不要添加。
        }
    };

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
            case 4:
                recyclerView.setAdapter(new SlideInLeftAdapter(this,stringList));
                break;
        }
        recyclerView.setItemAnimator(new SlideInLeftAnimator());
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
