package com.aibei.lixue.recylerviewexamle.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.aibei.lixue.recylerviewexamle.R;
import com.aibei.lixue.recylerviewexamle.customView.RecyclerSwipeAdapter;
import com.aibei.lixue.recylerviewexamle.customView.SimpleSwipeListener;
import com.aibei.lixue.recylerviewexamle.customView.SwipeRevealLayout;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.List;

/**
 * 作者：lixue on 2017/2/21 18:24
 */

public class SlideInLeftAdapter extends RecyclerSwipeAdapter<SlideInLeftAdapter.SimpleViewHolder> {
    private List<String> mDatas;
    private Context context;

    @Override
    public int getSwipeLayoutResourceId(int position) {
        return R.id.swipe;
    }

    @Override
    public void closeAllExcept(SwipeRevealLayout layout) {

    }

    @Override
    public void removeShownLayouts(SwipeRevealLayout layout) {

    }

    public static class SimpleViewHolder extends RecyclerView.ViewHolder {
        SwipeRevealLayout swipeLayout;
        TextView textViewPos;
        TextView textViewData;
        Button buttonDelete;

        public SimpleViewHolder(View itemView) {
            super(itemView);
            swipeLayout = (SwipeRevealLayout) itemView.findViewById(R.id.swipe);
            textViewPos = (TextView) itemView.findViewById(R.id.position);
            textViewData = (TextView) itemView.findViewById(R.id.text_data);
            buttonDelete = (Button) itemView.findViewById(R.id.delete);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d(getClass().getSimpleName(), "onItemSelected: " + textViewData.getText().toString());
                    Toast.makeText(view.getContext(), "onItemSelected: " + textViewData.getText().toString(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }



    public SlideInLeftAdapter(Context context,List<String> datalist){
        this.context = context;
        this.mDatas = datalist;
    }

    @Override
    public SimpleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item, parent, false);
        return new SimpleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final SimpleViewHolder viewHolder, final int position) {
        String item = mDatas.get(position);
        viewHolder.swipeLayout.setShowMode(SwipeRevealLayout.ShowMode.LayDown);
        viewHolder.swipeLayout.addSwipeListener(new SimpleSwipeListener() {
            @Override
            public void onStartOpen(SwipeRevealLayout layout) {

            }

            @Override
            public void onOpen(SwipeRevealLayout layout) {
                //执行动画
                YoYo.with(Techniques.Tada).duration(500).delay(100).playOn(layout.findViewById(R.id.trash));
            }

            @Override
            public void onStartClose(SwipeRevealLayout layout) {

            }

            @Override
            public void onClose(SwipeRevealLayout layout) {

            }

            @Override
            public void onUpdate(SwipeRevealLayout layout, int leftOffset, int topOffset) {

            }

            @Override
            public void onHandRelease(SwipeRevealLayout layout, float xvel, float yvel) {

            }
        });
        viewHolder.swipeLayout.setOnDoubleClickListener(new SwipeRevealLayout.DoubleClickListener() {
            @Override
            public void onDoubleClick(SwipeRevealLayout layout, boolean surface) {
                Toast.makeText(context, "DoubleClick", Toast.LENGTH_SHORT).show();
            }

        });
        viewHolder.buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mItemManger.removeShownLayouts(viewHolder.swipeLayout);
                mDatas.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, mDatas.size());
                mItemManger.closeAllItems();
                Toast.makeText(view.getContext(), "Deleted " + viewHolder.textViewData.getText().toString() + "!", Toast.LENGTH_SHORT).show();
            }
        });
        viewHolder.textViewPos.setText((position + 1) + ".");
        viewHolder.textViewData.setText(item);
        mItemManger.bind(viewHolder.itemView, position);
    }

    @Override
    public int getItemCount() {
        return mDatas != null ? mDatas.size() : 0;
    }
}
