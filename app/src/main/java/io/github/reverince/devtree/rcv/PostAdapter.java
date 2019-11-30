package io.github.reverince.devtree.rcv;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import io.github.reverince.devtree.R;
import io.github.reverince.devtree.data.Post;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {
    private Context context;
    private OnItemClickListener listener;
    private List<Post> posts;

    public interface OnItemClickListener {
        public void onItemClick(PostViewHolder holder, View view, int position);
    }

    public PostAdapter(Context context, List<Post> posts) {
        this.context = context;
        this.posts = posts;
    }

    public class PostViewHolder extends RecyclerView.ViewHolder {
        ImageView imagePost;
        TextView textSummary;
        OnItemClickListener listener;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            imagePost = itemView.findViewById(R.id.imagePost);
            textSummary = itemView.findViewById(R.id.textSummary);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if (listener != null)
                        listener.onItemClick(PostViewHolder.this, view, position);
                }
            });
        }

        public void setOnItemClickListener(OnItemClickListener listener) {
            this.listener = listener;
        }
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = layoutInflater.inflate(R.layout.post, parent, false);
        return new PostViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int i) {
//        holder.imagePost.setImageDrawable(null);
        holder.textSummary.setText(posts.get(i).getSummary());
        holder.setOnItemClickListener(listener);
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

}
