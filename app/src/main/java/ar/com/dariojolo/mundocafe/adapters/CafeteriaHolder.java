package ar.com.dariojolo.mundocafe.adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import ar.com.dariojolo.mundocafe.R;
import ar.com.dariojolo.mundocafe.listeners.ItemClickListener;

public class CafeteriaHolder  extends RecyclerView.ViewHolder implements View.OnClickListener{
    ImageView mImageCafeteria;
    TextView mName, mAddress;
    ItemClickListener itemClickListener;
    RatingBar ratingCafeteria;

    CafeteriaHolder(@NonNull View itemView) {
        super(itemView);
        this.mName = itemView.findViewById(R.id.name);
        this.mAddress = itemView.findViewById(R.id.address);
        this.mImageCafeteria = itemView.findViewById(R.id.imageCafeteria);
        this.ratingCafeteria = itemView.findViewById(R.id.ratingBar);
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        this.itemClickListener.onItemClickListener(v, getLayoutPosition());
    }
    public void setItemClickListener(ItemClickListener item){
        this.itemClickListener = item;
    }
}

