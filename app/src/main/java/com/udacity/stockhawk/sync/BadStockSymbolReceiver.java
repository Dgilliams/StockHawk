package com.udacity.stockhawk.sync;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.udacity.stockhawk.data.PrefUtils;

/**
 * Created by Damo on 3/20/2017.
 */

public class BadStockSymbolReceiver extends BroadcastReceiver {
    public static final String SYMBOL_KEY = "symbol_key";

    public BadStockSymbolReceiver() {}

    @Override
    public void onReceive(Context context, Intent intent) {

        String symbol = intent.getStringExtra(SYMBOL_KEY);
        String message;
        String reason = " : an invalid symbol was removed from your saved stocks list.";

        if (symbol != null) {
            PrefUtils.removeStock(context, symbol);
            message =  symbol + reason;
        } else {
            message = reason;
        }

        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }
}
