package com.example.root.recyclerviewglide;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 15/06/17.
 */

public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<CustomItemModel> itemModels;

    public CustomAdapter() {
        this.itemModels = new ArrayList<>();
    }

    public void addItem(CustomItemModel item){
        itemModels.add(item);
    }

    public void addArrayItems(List<CustomItemModel> items){
        itemModels.addAll(items);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        int totalSize = 0;
        for (CustomItemModel item: itemModels) {
            totalSize += item.getItems().size();
        }
        return totalSize;
    }

    static class ViewHolderHeader extends RecyclerView.ViewHolder {

        public ViewHolderHeader(View itemView) {
            super(itemView);
        }
    }

    static class ViewHolderItem extends RecyclerView.ViewHolder {

        public ViewHolderItem(View itemView) {
            super(itemView);
        }
    }

}
