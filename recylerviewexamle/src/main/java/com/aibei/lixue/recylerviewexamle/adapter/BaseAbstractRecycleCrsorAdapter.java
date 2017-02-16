package com.aibei.lixue.recylerviewexamle.adapter;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.FilterQueryProvider;
import android.widget.Filterable;

/**
 * 作者：lixue on 2017/2/14 15:22
 */

public abstract class BaseAbstractRecycleCrsorAdapter<VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> implements Filterable,CursorFilter.CursorFilterClient {

    /**
     * 当用curosr绑定view的时候调用这个方法
     * @param holder
     * @param cursor
     */
    public abstract void onBindViewHolder(VH holder,Cursor cursor);
    protected boolean mDataValid;//数据是否有效
    protected Cursor mCursor;
    protected Context context;
    protected int mRowIDColumn;
    protected ChangeObserver mChangeObserver;//s数据变化观察器
    protected DataSetObserver mDataSetObserver;//数据设置观察器
    protected CursorFilter mCursorFilter;
    protected FilterQueryProvider mFilterQueryProvider;
    public static final int FLAG_REGISTER_CONTENT_OBSERVER = 0x02;

    public BaseAbstractRecycleCrsorAdapter(Context context,Cursor c){
        this(context,c,FLAG_REGISTER_CONTENT_OBSERVER);
    }
    //构造函数
    public BaseAbstractRecycleCrsorAdapter(Context context,Cursor c,int flags){
        init(context,c,flags);
    }

    private void init(Context context,Cursor c,int flags){
        boolean cursorPresent = c != null;
        this.mCursor = c;
        this.mDataValid = cursorPresent;
        this.context = context;
        this.mRowIDColumn = cursorPresent ? c.getColumnIndexOrThrow("_id") : -1;

        if ((flags & FLAG_REGISTER_CONTENT_OBSERVER) == FLAG_REGISTER_CONTENT_OBSERVER){
            mChangeObserver = new ChangeObserver();
            mDataSetObserver = new MyDataSetObserver();

        }else{
            mChangeObserver = null;
            mDataSetObserver = null;
        }

        if (cursorPresent){
            if (mChangeObserver != null) c.registerContentObserver(mChangeObserver);
            if (mDataSetObserver != null) c.registerDataSetObserver(mDataSetObserver);
        }

        setHasStableIds(true);//这个地方要注意，需要将表关联ID设置为true

    }

    public Object getItem(int postion){
        if (mDataValid && mCursor != null){
            mCursor.moveToPosition(postion);
            return mCursor;
        }else{
            return null;
        }
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        if (!mDataValid){
            throw new IllegalStateException("this should only be called when the cursor is valid");
        }
        if (!mCursor.moveToPosition(position)){
            throw new IllegalStateException("could'nt move cursor to position " + position);
        }
        onBindViewHolder(holder,mCursor);
    }

    @Override
    public int getItemCount() {
        if (mDataValid && mCursor != null){
            return mCursor.getCount();
        }else{
            return 0;
        }
    }

    @Override
    public long getItemId(int position) {
        if (mDataValid){
            if (mCursor.moveToPosition(position)){
                return mCursor.getLong(mRowIDColumn);
            }else{
                return 0;
            }
        }else{
            return 0;
        }
    }

    @Override
    public Filter getFilter() {
        if (mCursorFilter == null){
            mCursorFilter = new CursorFilter(this);
        }
        return mCursorFilter;
    }

    @Override
    public CharSequence convertToString(Cursor cursor) {
        return cursor == null ? "" : cursor.toString();
    }

    @Override
    public Cursor runQueryOnBackgroundThread(CharSequence constraint) {
        if (mFilterQueryProvider != null){
            return mFilterQueryProvider.runQuery(constraint);
        }
        return mCursor;
    }

    @Override
    public Cursor getCursor() {
        return mCursor;
    }

    @Override
    public void changeCursor(Cursor cursor) {
        Cursor old = swapCursor(cursor);
        if (old != null){
            old.close();
        }
    }

    public Cursor swapCursor(Cursor newCursor){
        if (newCursor == mCursor){
            return null;
        }
        Cursor old = mCursor;
        if (old != null){
            if (mChangeObserver != null){
                old.unregisterContentObserver(mChangeObserver);
            }
            if (mDataSetObserver != null){
                old.unregisterDataSetObserver(mDataSetObserver);
            }
        }
        mCursor = newCursor;
        if (newCursor != null){
            if (mChangeObserver != null){
                newCursor.registerContentObserver(mChangeObserver);
            }
            if (mDataSetObserver != null){
                newCursor.registerDataSetObserver(mDataSetObserver);
            }
            mRowIDColumn = newCursor.getColumnIndexOrThrow("_id");
            mDataValid = true;
            notifyDataSetChanged();
        }else{
            mRowIDColumn = -1;
            mDataValid = false;
            notifyDataSetChanged();
        }
        return old;
    }

    public FilterQueryProvider getmFilterQueryProvider() {
        return mFilterQueryProvider;
    }

    public void setmFilterQueryProvider(FilterQueryProvider mFilterQueryProvider) {
        this.mFilterQueryProvider = mFilterQueryProvider;
    }

    private class ChangeObserver extends ContentObserver{
        public ChangeObserver(){
            super(new Handler());
        }

        @Override
        public boolean deliverSelfNotifications() {
            return true;
        }

        @Override
        public void onChange(boolean selfChange) {
            onContentChanged();
        }
    }

    protected void onContentChanged(){};

    private class MyDataSetObserver extends DataSetObserver{
        @Override
        public void onChanged() {
            mDataValid = true;
            notifyDataSetChanged();;
        }

        @Override
        public void onInvalidated() {
            mDataValid = false;
            notifyDataSetChanged();;
        }
    }
}
