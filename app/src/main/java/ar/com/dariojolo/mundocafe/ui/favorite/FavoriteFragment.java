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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ar.com.dariojolo.mundocafe.R;
import ar.com.dariojolo.mundocafe.adapters.CafeteriaFavAdapter;
import ar.com.dariojolo.mundocafe.models.CafeteriaEntity;
import ar.com.dariojolo.mundocafe.ui.home.HomeViewModel;

public class FavoriteFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private RecyclerView mRecyclerView;
    private CafeteriaFavAdapter cafeteriaFavAdapter;


    private FavoriteViewModel favoriteViewModel;
    private TextView texto;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        favoriteViewModel =
                ViewModelProviders.of(this).get(FavoriteViewModel.class);
        View root = inflater.inflate(R.layout.fragment_favorite, container, false);

        mRecyclerView = root.findViewById(R.id.recyclerViewFav);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        cafeteriaFavAdapter = new CafeteriaFavAdapter(getActivity(),this.getMyList());
        mRecyclerView.setAdapter(cafeteriaFavAdapter);

        return root;
    }

    private List<CafeteriaEntity> getMyList() {
        List<CafeteriaEntity>listado = new ArrayList<>();

        CafeteriaEntity cafe = new CafeteriaEntity("Cuervo cafe", "Una direccion 777", "Palermo", "https://www.sctech.edu/wp-content/plugins/ajax-search-pro/img/default.jpg", 3.4f, true);
        CafeteriaEntity cafe2 = new CafeteriaEntity("Cuervo cafe 2", "Otra direccion 777", "Palermo", "https://www.sctech.edu/wp-content/plugins/ajax-search-pro/img/default.jpg", 4.6f, true);
        listado.add(cafe);
        listado.add(cafe2);

        return listado;

    }
}