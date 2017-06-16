package com.example.root.recyclerviewglide;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final int TYPE_HEADER = 1;
    public static final int TYPE_ITEM = 2;

    private List<CustomModel> itemModels;

    public CustomAdapter() {
        this.itemModels = new ArrayList<>();
    }

    public void addItem(CustomModel item){
        itemModels.add(item);
    }

    public void addArrayItems(List<CustomModel> items){
        itemModels.addAll(items);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        switch (viewType){
            case TYPE_HEADER:
                View itemView = layoutInflater.inflate(R.layout.item_header, parent, false);
                return new ViewHolderHeader(itemView);
            default:
//                return new ViewHolderItem()
                return null;

        }
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
        for (CustomModel item: itemModels) {
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
