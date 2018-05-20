
package com.byteshaft.gridwithheader.library;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;

public interface StickyGridHeadersSimpleAdapter extends ListAdapter {

    long getHeaderId(int position);

    View getHeaderView(int position, View convertView, ViewGroup parent);
}
