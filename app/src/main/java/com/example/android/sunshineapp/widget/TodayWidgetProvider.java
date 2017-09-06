package com.example.android.sunshineapp.widget;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.android.sunshineapp.sync.SunshineSyncAdapter;

/**
 * Created by Sagar on 6/15/2017.
 */

public class TodayWidgetProvider extends AppWidgetProvider {

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        context.startService(new Intent(context, TodayWidgetIntentService.class));
        }

    @Override
    public void onAppWidgetOptionsChanged(Context context, AppWidgetManager appWidgetManager, int appWidgetId, Bundle newOptions) {
        context.startService(new Intent(context, TodayWidgetIntentService.class));
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (SunshineSyncAdapter.ACTION_DATA_UPDATED.equals(intent.getAction())){
            context.startService(new Intent(context, TodayWidgetIntentService.class));
        }
    }
}

