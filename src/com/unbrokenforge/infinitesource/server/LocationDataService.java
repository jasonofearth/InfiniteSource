package com.unbrokenforge.infinitesource.server;

import com.unbrokenforge.infinitesource.util.Constants;

import android.app.Service;
import android.content.Intent;
import android.location.Location;
import android.os.IBinder;

public class LocationDataService extends Service {

	@Override
	public IBinder onBind(Intent arg0) {
		// don't allow binding. This isn't for rpc
		return null;
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Location loc = (Location)intent.getParcelableExtra(Constants.EXTRA_LOCATION);
		
		return START_STICKY;
	}

	
}
