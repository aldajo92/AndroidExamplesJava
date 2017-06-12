package com.example.aldajo92.rxhelloworld;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.text.format.DateFormat;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by aldajo92 on 6/12/17.
 */

public class StockDataAdapter extends RecyclerView.Adapter<StockDataAdapter.StockUpdateViewHolder> {

    private final List<StockUpdate> data = new ArrayList<>();

    @Override
    public StockUpdateViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new StockUpdateViewHolder(
                LayoutInflater
                        .from(parent.getContext())
                        .inflate(R.layout.stock_update_item, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(StockUpdateViewHolder holder, int position) {
        StockUpdate stockUpdate = data.get(position);
        holder.stockSymbol.setText(stockUpdate.getStockSymbol());
        holder.setStockDate(stockUpdate.getDate());
        holder.setStockPrice(stockUpdate.getPrice());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void add(StockUpdate stockUpdate) {
        this.data.add(stockUpdate);
        notifyItemInserted(data.size() - 1);
    }

    static class StockUpdateViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.stock_item_symbol)
        TextView stockSymbol;

        @BindView(R.id.stock_item_date)
        TextView stockDate;

        @BindView(R.id.stock_item_price)
        TextView stockPrice;

        private static final NumberFormat PRICE_FORMAT = new DecimalFormat("#0.00");

        StockUpdateViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setStockSymbol(String stockSymbol) {
            this.stockSymbol.setText(stockSymbol);
        }

        public void setStockDate(Date date) {
            this.stockDate.setText(DateFormat.format("yyyy-MM-dd hh:mm", date));
        }

        public void setStockPrice(BigDecimal price) {
            this.stockPrice.setText(PRICE_FORMAT.format(price.floatValue()));
        }
    }
}
