package com.byteshaft.gridwithheader.library;

import java.util.Arrays;
import java.util.List;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.byteshaft.gridwithheader.library.StickyGridHeadersSimpleAdapter;

public class StickyGridHeadersSimpleArrayAdapter<T> extends BaseAdapter implements
        StickyGridHeadersSimpleAdapter {
    protected static final String TAG = StickyGridHeadersSimpleArrayAdapter.class.getSimpleName();

    private int mHeaderResId;

    private LayoutInflater mInflater;

    private int mItemResId;

    private List<T> mItems;

    public StickyGridHeadersSimpleArrayAdapter(Context context, List<T> items, int headerResId,
            int itemResId) {
        init(context, items, headerResId, itemResId);
    }

    public StickyGridHeadersSimpleArrayAdapter(Context context, T[] items, int headerResId,
            int itemResId) {
        init(context, Arrays.asList(items), headerResId, itemResId);
    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public long getHeaderId(int position) {
        T item = getItem(position);
        CharSequence value;
        if (item instanceof CharSequence) {
            value = (CharSequence)item;
        } else {
            value = item.toString();
        }

        return value.subSequence(0, 1).charAt(0);
    }

    @Override
    @SuppressWarnings("unchecked")
    public View getHeaderView(int position, View convertView, ViewGroup parent) {
        HeaderViewHolder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(mHeaderResId, parent, false);
            holder = new HeaderViewHolder();
            holder.textView = (TextView)convertView.findViewById(android.R.id.text1);
            convertView.setTag(holder);
        } else {
            holder = (HeaderViewHolder)convertView.getTag();
        }

        T item = getItem(position);
        CharSequence string;
        if (item instanceof CharSequence) {
            string = (CharSequence)item;
        } else {
            string = item.toString();
        }

        // set header text as first char in string
        holder.textView.setText(string.subSequence(0, 1));

        return convertView;
    }

    @Override
    public T getItem(int position) {
        return mItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    @SuppressWarnings("unchecked")
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(mItemResId, parent, false);
            holder = new ViewHolder();
            holder.textView = (TextView)convertView.findViewById(android.R.id.text1);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder)convertView.getTag();
        }

        T item = getItem(position);
        if (item instanceof CharSequence) {
            holder.textView.setText((CharSequence)item);
        } else {
            holder.textView.setText(item.toString());
        }

        return convertView;
    }

    private void init(Context context, List<T> items, int headerResId, int itemResId) {
        this.mItems = items;
        this.mHeaderResId = headerResId;
        this.mItemResId = itemResId;
        mInflater = LayoutInflater.from(context);
    }

    protected class HeaderViewHolder {
        public TextView textView;
    }

    protected class ViewHolder {
        public TextView textView;
    }
}
