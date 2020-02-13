package ar.com.dariojolo.mundocafe.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import ar.com.dariojolo.mundocafe.R;
import ar.com.dariojolo.mundocafe.listeners.ItemClickListener;
import ar.com.dariojolo.mundocafe.models.CafeteriaEntity;

public class CafeteriaAdapter  extends RecyclerView.Adapter<CafeteriaHolder> {
    Context context;
    List<CafeteriaEntity> listado; //Lista donde se va a guardar la info para mostrar en el RecyclerView

    public CafeteriaAdapter(Context context, List<CafeteriaEntity> listado) {
        this.context = context;
        this.listado = listado;
    }
    @NonNull
    @Override
    public CafeteriaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_cafeteria,parent, false); //Infla el elemento del recyclerview a cargar
        return new CafeteriaHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull final CafeteriaHolder holder, int position) {
        holder.mName.setText(listado.get(position).getName());
        holder.mAddress.setText(listado.get(position).getAddress());
        Picasso.get()
                .load(listado.get(position).getImage())
                .centerCrop()
                .into(holder.mImageCafeteria);

        holder.ratingCafeteria.setRating(listado.get(position).getRating());

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClickListener(View view, int position) {
                Navigation.findNavController(view).navigate(R.id.to_detail_fragment);

            }
        });
    }
    @Override
    public int getItemCount() {
        return listado.size();
    }


}
