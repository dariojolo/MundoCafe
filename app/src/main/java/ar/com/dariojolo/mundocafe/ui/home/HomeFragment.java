package ar.com.dariojolo.mundocafe.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ar.com.dariojolo.mundocafe.R;
import ar.com.dariojolo.mundocafe.adapters.CafeteriaAdapter;
import ar.com.dariojolo.mundocafe.models.CafeteriaEntity;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private RecyclerView mRecyclerView;
    private CafeteriaAdapter cafeteriaAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        /*final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/

        mRecyclerView = root.findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

//        cafeteriaAdapter = new CafeteriaAdapter(getActivity(),this.getMyList());
        cafeteriaAdapter = new CafeteriaAdapter(getActivity(),this.getMyList());
        mRecyclerView.setAdapter(cafeteriaAdapter);

        return root;
    }

    private List<CafeteriaEntity> getMyList() {
        List<CafeteriaEntity>listado = new ArrayList<>();

        CafeteriaEntity cafe = new CafeteriaEntity(1L,"Cuervo cafe", "Una direccion 777", "Palermo", R.drawable.cuervo, 3.4f, true);
        CafeteriaEntity cafe2 = new CafeteriaEntity(2L,"Cuervo cafe 2", "Otra direccion 777", "Palermo", R.drawable.cuervo, 4.6f, true);
        listado.add(cafe);
        listado.add(cafe2);

        return listado;

    }
}