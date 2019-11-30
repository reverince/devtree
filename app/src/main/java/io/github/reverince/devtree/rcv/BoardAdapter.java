package io.github.reverince.devtree.rcv;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class BoardAdapter extends BaseAdapter {
    private Context mContext;
    private String[] mStrings;

    public BoardAdapter(Context context, String[] strings) {
        mContext = context;
        mStrings = strings;
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
        TextView textView;
        if (convertView == null) {
            textView = new TextView(mContext);
        }
        else {
            textView = (TextView)convertView;
        }
        textView.setText(mStrings[position]);

        return textView;
    }
}
