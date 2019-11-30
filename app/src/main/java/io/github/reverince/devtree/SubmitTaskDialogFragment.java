package io.github.reverince.devtree;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
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
        builder.setView(inflater.inflate(R.layout.dialog_submit_task, null));
        builder.setTitle("타이틀")
                .setMessage("메시지")
                .setPositiveButton("제출", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
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
