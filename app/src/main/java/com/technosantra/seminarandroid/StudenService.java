package com.technosantra.seminarandroid;

import android.app.Service;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;

/**
 * Created by M. Nashrulloh on 05/04/19.
 * at PT. Ansvia
 * contact us blankcd3@gmail.com or mohammad.nashrulloh@ansvia.com
 */
public class StudenService extends Service {

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);

        /**
         * Jalankan Service kamu disini
         * misal: fetch data dari API
         * misal: Tampilkan Notifkasi dll
         */

        return START_STICKY;
    }
}
