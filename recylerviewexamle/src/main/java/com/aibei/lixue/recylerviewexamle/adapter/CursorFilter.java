package com.aibei.lixue.recylerviewexamle.adapter;

import android.database.Cursor;
import android.widget.Filter;

/**
 * 数据库Cursor筛选
 *
 * 作者：lixue on 2017/2/14 15:26
 */

public class CursorFilter extends Filter {

    private CursorFilterClient mClient;

    public interface CursorFilterClient{
        CharSequence convertToString(Cursor cursor);//站换成字符串
        Cursor runQueryOnBackgroundThread(CharSequence constraint); //在后台线程中运行查询
        Cursor getCursor();//得到Cursor
        void changeCursor(Cursor cursor);//改变Cursor
    }

    public CursorFilter(CursorFilterClient client){
        this.mClient = client;
    }

    @Override
    public CharSequence convertResultToString(Object resultValue) {
        return mClient.convertToString((Cursor) resultValue);
    }

    @Override
    protected FilterResults performFiltering(CharSequence charSequence) {
        Cursor cursor = mClient.runQueryOnBackgroundThread(charSequence);
        FilterResults results = new FilterResults();
        if (cursor != null){
            results.count = cursor.getCount();
            results.values = cursor;
        }else {
            results.count = 0;
            results.values = null;
        }
        return results;
    }

    @Override
    protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
        Cursor oldCursor = mClient.getCursor();
        if (filterResults.values != null && filterResults.values != oldCursor){
            mClient.changeCursor((Cursor) filterResults.values);
        }
    }
}
