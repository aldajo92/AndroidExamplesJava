package com.example.root.recyclerviewglide;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Based on: http://www.androidhive.info/2016/01/android-working-with-recycler-view/
 */


public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final int TYPE_HEADER = 1;
    public static final int TYPE_ITEM = 2;

    private List<GenericItem> itemModels;

    public CustomAdapter() {
        this.itemModels = new ArrayList<>();
    }

    public void addItem(GenericItem item) {
        itemModels.add(item);
    }

    public void addArrayItems(List<GenericItem> items) {
        itemModels.addAll(items);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        switch (viewType) {
            case TYPE_HEADER:
                return new ViewHolderHeader(layoutInflater.inflate(R.layout.view_header, parent, false));
            default:
                return new ViewHolderItem(layoutInflater.inflate(R.layout.view_item, parent, false));

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
        return itemModels.size();
    }

    private static class ViewHolderHeader extends RecyclerView.ViewHolder {
        ViewHolderHeader(View itemView) {
            super(itemView);
        }
    }

    private static class ViewHolderItem extends RecyclerView.ViewHolder {
        ViewHolderItem(View itemView) {
            super(itemView);
        }
    }

}
