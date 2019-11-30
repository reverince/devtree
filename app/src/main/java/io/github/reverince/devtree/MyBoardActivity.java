package io.github.reverince.devtree;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

public class MyBoardActivity extends AppCompatActivity {
    final String[] titles = { "과제 01", "과제 02", "과제 03" };
    final String[] contents = { "01 ", "02 ", "03 " };

    GridView boardGrid;
    TextView taskTitleText, taskContentText;

    int currentTaskIdx = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_board);

        boardGrid = findViewById(R.id.grid_board);
        boardGrid.setAdapter(new BoardAdapter(this));
        boardGrid.setOnItemClickListener(onCellClickListener);

        taskTitleText = findViewById(R.id.text_task_title);
        taskContentText = findViewById(R.id.text_task_content);
    }

    private AdapterView.OnItemClickListener onCellClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            currentTaskIdx = position;
            Toast.makeText(MyBoardActivity.this, ""+position, Toast.LENGTH_SHORT).show();
            try {
                taskTitleText.setText(titles[position]);
                taskContentText.setText(contents[position]);
            }
            catch (ArrayIndexOutOfBoundsException e) {
                Log.e(this.toString(), "ArrayIndexOutOfBoundsException");
            }
        }
    };

}
