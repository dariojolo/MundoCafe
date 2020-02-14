package ar.com.dariojolo.mundocafe;


import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import ar.com.dariojolo.mundocafe.models.CafeteriaEntity;


/**
 * A simple {@link Fragment} subclass.
 */
public class NuevaCafeteriaDialogFragment extends DialogFragment {
    private View view;

    private EditText tName, tAddress, tPhoto;
    private RatingBar rating;

    public NuevaCafeteriaDialogFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_nueva_cafeteria_dialog, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Nueva cafeteria")
                .setPositiveButton(R.string.fire, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Toast.makeText(getContext(), "AQUI ESTOY!", Toast.LENGTH_SHORT).show();
                        String name = tName.getText().toString();
                        String address = tAddress.getText().toString();
                        String photo = tPhoto.getText().toString();
                        float rating2 = rating.getRating();
                        NuevaCafeteriaDialogViewModel mViewModel = ViewModelProviders.of(getActivity()).get(NuevaCafeteriaDialogViewModel.class);
                        mViewModel.insertNota(new CafeteriaEntity(name,address,"",photo, rating2, false));
                        dialog.dismiss();

                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                        dialog.dismiss();
                    }
                });

        LayoutInflater inflater = getActivity().getLayoutInflater();
        view = inflater.inflate(R.layout.fragment_nueva_cafeteria_dialog, null);

        tName = view.findViewById(R.id.txtName);
        tAddress = view.findViewById(R.id.txtAddress);
        tPhoto = view.findViewById(R.id.txtUrlPic);
        rating = view.findViewById(R.id.ratingBarAdd);

        builder.setView(view);

        // Create the AlertDialog object and return it
        return builder.create();
    }
}
