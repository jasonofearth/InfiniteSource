package com.unbrokenforge.infinitesource.ui;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.unbrokenforge.infinitesource.R;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class MainUI extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		SupportMapFragment map = (SupportMapFragment)this.getSupportFragmentManager().findFragmentById(R.id.map);
		map.getMap().setMapType(GoogleMap.MAP_TYPE_TERRAIN);
		map.getMap().setMyLocationEnabled(true);
		
		if(map.getMap().getMyLocation() != null)
		{
		LatLng myLocation = new LatLng(map.getMap().getMyLocation().getLatitude(),map.getMap().getMyLocation().getLongitude());
		CameraPosition pos = new CameraPosition.Builder().target(myLocation).build();
		map.getMap().moveCamera(CameraUpdateFactory.newCameraPosition(pos));
		}
	}

	
}
