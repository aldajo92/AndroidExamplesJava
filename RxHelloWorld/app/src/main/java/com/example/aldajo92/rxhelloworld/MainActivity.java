package com.example.aldajo92.rxhelloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

public class MainActivity extends AppCompatActivity {

    private final String TAG = getClass().getName();

    @BindView(R.id.hello_world_salute)
    TextView textView;

    @BindView(R.id.stock_updates_recycler_view)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        StockDataAdapter stockDataAdapter = new StockDataAdapter();

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(stockDataAdapter);

        Observable.just("Hi... welcome to this app")
                .subscribe(s -> textView.setText(s));

        Observable.just(
                new StockUpdate("Google", 12.43, new Date()),
                new StockUpdate("Amazon", 14.43, new Date()),
                new StockUpdate("Apple", 18.43, new Date())
        ).subscribe(stockDataAdapter::add);

        Observable.just("1")
                .map(s -> s + "mapped")
                .flatMap(s -> Observable.just("flat-" + s))
                .doOnNext(s -> Log.d(TAG, "on next: " + s))
                .subscribe(s -> Log.d(TAG, "Hello: " + s), throwable -> Log.d(TAG, "Error!"));


    }
}
