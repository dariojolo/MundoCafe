package ar.com.dariojolo.mundocafe.ui.favorite;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import ar.com.dariojolo.mundocafe.R;

public class FavoriteFragment extends Fragment {

    private FavoriteViewModel favoriteViewModel;
    private TextView texto;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        favoriteViewModel =
                ViewModelProviders.of(this).get(FavoriteViewModel.class);
        View root = inflater.inflate(R.layout.fragment_favorite, container, false);
       /* final TextView textView = root.findViewById(R.id.text_dashboard);
        favoriteViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/
       texto = root.findViewById(R.id.text_favorite);
       texto.setText("TEXTO DE PRUEBA");
        return root;
    }
}