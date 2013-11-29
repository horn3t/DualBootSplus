package com.h0rn3t.dualbootsplus.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;

import com.h0rn3t.dualbootsplus.util.Constants;

/**
 * Created by h0rn3t on 09.10.2013.
 */
public class BootService extends Service implements Constants {
    public static boolean servicesStarted = false;
    Context context;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        context=this;
        if (intent == null) {
            stopSelf();
        }
        new BootWorker(this).execute();
        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    class BootWorker extends AsyncTask<Void, Void, Void> {
        Context c;
        public BootWorker(Context c) {
            this.c = c;
        }

        @Override
        protected Void doInBackground(Void... args) {
            return null;
        }
        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            servicesStarted = true;
            stopSelf();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
