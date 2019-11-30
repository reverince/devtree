package io.github.reverince.devtree.rcv;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.MessageFormat;
import java.util.List;

import io.github.reverince.devtree.R;
import io.github.reverince.devtree.data.Board;

public class BoardAdapter extends RecyclerView.Adapter<BoardAdapter.BoardViewHolder> {
    private Context context;
    private List<Board> boards;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        public void onItemClick(BoardViewHolder holder, View view, int position);
    }

    public BoardAdapter(Context context, List<Board> boards) {
        this.context = context;
        this.boards = boards;
    }

    public class BoardViewHolder extends RecyclerView.ViewHolder {
        TextView themeName;
        TextView beginningDate;
        TextView achievedTopic;
        TextView remainingTopic;
        OnItemClickListener listener;

        public BoardViewHolder(@NonNull View itemView) {
            super(itemView);
            themeName = itemView.findViewById(R.id.textThemeName);
            beginningDate = itemView.findViewById(R.id.textBeginningDate);
            achievedTopic = itemView.findViewById(R.id.textNumberOfAchievedTopic);
            remainingTopic = itemView.findViewById(R.id.textNumberOfRemainingTopic);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if (listener != null)
                        listener.onItemClick(BoardViewHolder.this, view, position);
                }
            });
        }

        public void setOnItemClickListener(OnItemClickListener listener) {
            this.listener = listener;
        }
    }

    @NonNull
    @Override
    public BoardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = layoutInflater.inflate(R.layout.board, parent, false);
        return new BoardViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull BoardViewHolder holder, int i) {
        holder.themeName.setText(boards.get(i).getThemeName());
        holder.beginningDate.setText(boards.get(i).getBeginningDate());
        holder.achievedTopic.setText(MessageFormat.format("{0}개", boards.get(i).getAchievedTopic()));
        holder.remainingTopic.setText(MessageFormat.format("{0}개", boards.get(i).getRemainingTopic()));
        holder.setOnItemClickListener(listener);
    }


    @Override
    public int getItemCount() {
        return boards.size();
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}
