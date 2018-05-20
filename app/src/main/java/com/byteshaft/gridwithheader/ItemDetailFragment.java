
package com.byteshaft.gridwithheader;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.byteshaft.gridwithheader.R;

public class ItemDetailFragment extends Fragment {

    public static final String ARG_ITEM_ID = "item_id";
    private int mItem;

    public ItemDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            mItem = getArguments().getInt(ARG_ITEM_ID);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_item_detail, container, false);

        ((TextView) rootView.findViewById(R.id.item_detail)).setText(getResources().getStringArray(R.array.countries)[mItem]);
        return rootView;
    }
}
