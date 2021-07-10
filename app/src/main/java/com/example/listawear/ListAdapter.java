package com.example.listawear;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    final private AdapterCallback callback;
    private List<ItemsList> mItems = new ArrayList<>();

    public ListAdapter(List<ItemsList> _items, AdapterCallback _callback){
        this.mItems = _items;
        this.callback = _callback;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        LinearLayout contenedor;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            contenedor = itemView.findViewById(R.id.contenedor);
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);
        }
    } // class ViewHolder

    @NonNull
    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i){
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.main_item, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    } // ListAdapter.ViewHolder

    @Override
    public void onBindViewHolder(@NonNull ListAdapter.ViewHolder viewHolder, int i){
        ItemsList itemsList = mItems.get(i);
        viewHolder.imageView.setImageResource(itemsList.getImageItem());
        viewHolder.textView.setText(itemsList.getNameItem());
        viewHolder.contenedor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(callback != null){
                    callback.onItemClicked(v, i);
                }
            }
        });
    }

    @Override
    public int getItemCount(){
        return mItems.size();
    }

    // Interfaz para la opción de tap de cada item
    public interface AdapterCallback {
        void onItemClicked(View v, int itemPosition);
    }

}

class ItemsList {
    final private int imageItem;
    final private String nameItem;
    final private String descriptionItem;

    public ItemsList(int _imageItem, String _nameItem, String _descriptionItem){
        this.imageItem = _imageItem;
        this.nameItem = _nameItem;
        this.descriptionItem = _descriptionItem;
    }

    public int getImageItem(){ return imageItem; }

    public String getNameItem(){ return nameItem; }

    public String getDescriptionItem(){ return descriptionItem; }
}
