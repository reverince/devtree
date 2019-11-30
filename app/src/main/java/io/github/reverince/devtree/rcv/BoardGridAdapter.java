package io.github.reverince.devtree.rcv;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import io.github.reverince.devtree.R;

public class BoardGridAdapter extends BaseAdapter {
    Context mContext;
    final String[] mStrings;
    final boolean[] mCleared;

    public BoardGridAdapter(Context context, String[] strings, boolean[] cleared) {
        mContext = context;
        mStrings = strings;
        mCleared = cleared;
    }

    @Override
    public int getCount() {
        return mStrings.length;
    }
    @Override
    public Object getItem(int position) {
        return null;
    }
    @Override
    public long getItemId(int position) {
        return 0;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View grid;
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {
            grid = inflater.inflate(R.layout.grid_board, null);
            TextView textView = grid.findViewById(R.id.text_task);
            textView.setText(mStrings[position]);
            LinearLayout linearLayout = grid.findViewById(R.id.linear_cell);
            if (mCleared[position]) {
                linearLayout.setBackgroundColor(ContextCompat.getColor(mContext, R.color.colorPrimary));
            } else {
                linearLayout.setBackgroundColor(ContextCompat.getColor(mContext, R.color.background));
            }
        } else {
            grid = convertView;
        }

        return grid;
    }

}
