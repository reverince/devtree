package io.github.reverince.devtree;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

public class BoardAdapter extends BaseAdapter {
    private Context context;

    private String[] strings = { "aa", "bb", "cc", "dd", "ee", "ff" };

    public BoardAdapter(Context c) {
        context = c;
    }

    @Override
    public int getCount() {
        return strings.length;
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
            textView = new TextView(context);
        }
        else {
            textView = (TextView)convertView;
        }
        textView.setText(strings[position]);

        return textView;
    }
}
