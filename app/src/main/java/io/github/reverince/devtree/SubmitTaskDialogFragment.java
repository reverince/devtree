package io.github.reverince.devtree;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class SubmitTaskDialogFragment extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.dialog_submit_task, null);
        builder.setView(dialogView);
        builder.setTitle("과제 제출하기")
                .setMessage("과제 내용이 담긴 링크와 함께 간략한 설명을 작성해 주세요.")
                .setPositiveButton("제출", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        EditText linkEdit = dialogView.findViewById(R.id.edit_link);
                        EditText descriptionEdit = dialogView.findViewById(R.id.edit_description);
                        String link = linkEdit.getText().toString();
                        String description = descriptionEdit.getText().toString();
                        //TODO: 제출
                    }
                })
                .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                        Toast.makeText(getContext(), "제출을 취소했습니다", Toast.LENGTH_SHORT).show();
                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();
    }
}
