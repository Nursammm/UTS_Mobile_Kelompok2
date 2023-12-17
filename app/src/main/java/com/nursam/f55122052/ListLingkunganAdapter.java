package com.nursam.f55122052;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListLingkunganAdapter extends RecyclerView.Adapter<ListLingkunganAdapter.ListViewHolder> {
    private ArrayList<Lingkungan> listLingkungan;
    private OnItemClickCallback onItemClickCallback;
    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback){
        this.onItemClickCallback = onItemClickCallback;
    }
    public ListLingkunganAdapter(ArrayList<Lingkungan> list) { this.listLingkungan = list; }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate
                (R.layout.item_design, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        Lingkungan lingkungan = listLingkungan.get(position);
        holder.imgPhoto.setImageResource(lingkungan.getPhoto());
        holder.tvName.setText(lingkungan.getName());
        holder.tvDescription.setText(lingkungan.getDescription());

        holder.itemView.setOnClickListener(v -> {
            Lingkungan selectedLingkungan = listLingkungan.get(holder.getAdapterPosition());
            Intent intent = new Intent(holder.itemView.getContext(), Ecotrack.class);
            intent.putExtra("LINGKUNGAN_PHOTO", lingkungan.getPhoto());
            intent.putExtra("LINGKUNGAN_NAME", lingkungan.getName());
            intent.putExtra("LINGKUNGAN_DESCRIPTION", lingkungan.getDescription());
            Toast.makeText(holder.itemView.getContext(), "Kamu memilih " + listLingkungan.get(holder.getAdapterPosition()).getName(), Toast.LENGTH_SHORT).show();
            holder.itemView.getContext().startActivity(intent);
        });
    }

    public interface OnItemClickCallback{
        void onItemClicked(Lingkungan data);
    }

    @Override
    public int getItemCount() {
        return listLingkungan.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvDescription;

        ListViewHolder(View itemView){
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvDescription = itemView.findViewById(R.id.tv_item_description);
        }
    }
}