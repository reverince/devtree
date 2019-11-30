package io.github.reverince.devtree.rcv;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import io.github.reverince.devtree.R;

public class PostRecyclerAdapter extends RecyclerView.Adapter<PostRecyclerAdapter.RecyclerViewHolder> {
    private String[] mAuthors, mContents, mLinks;

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder {
        public TextView authorText, contentText;
        public LinearLayout linearLayout;

        public RecyclerViewHolder(View v) {
            super(v);
            authorText = v.findViewById(R.id.text_author);
            contentText = v.findViewById(R.id.text_content);
            linearLayout = v.findViewById(R.id.linear_post);
        }
    }
    public PostRecyclerAdapter(String[] author, String[] content, String[] link) {
        mAuthors = author;
        mContents = content;
        mLinks = link;
    }

    @Override
    public PostRecyclerAdapter.RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_post, parent, false);
        RecyclerViewHolder vh = new RecyclerViewHolder(v);
        return vh;
    }
    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, final int position) {
        holder.authorText.setText(mAuthors[position]);
        holder.contentText.setText(mContents[position]);
        //TODO: 외부 사이트로 링크
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(mLinks[position]));
                view.getContext().startActivity(browserIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mAuthors.length;
    }

}
