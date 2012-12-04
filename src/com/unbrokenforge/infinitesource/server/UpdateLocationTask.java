package com.unbrokenforge.infinitesource.server;

import android.location.Location;
import android.os.AsyncTask;

public class UpdateLocationTask extends AsyncTask<Location, Void, Void> {

	@Override
	protected Void doInBackground(Location... params) {
		if(params[0] == null)
		{
			return null;
		}
		//TODO: go to server and get back location JSON feed
		return null;
	}

}
