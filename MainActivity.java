package com.example.locationapi;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.Menu;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity  implements LocationListener {

	private TextView latituteField;
	private TextView longitudeField;
	private TextView Address1;
	private LocationManager locationManager;
	private String provider;
	double latitude,longitude;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		latituteField = (TextView) findViewById(R.id.TextView02);
		longitudeField = (TextView) findViewById(R.id.TextView04);
		Address1 = (TextView) findViewById(R.id.TextView05);

		// Get the location manager
		locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		// Define the criteria how to select the locatioin provider -> use
		// default
		Criteria criteria = new Criteria();
		//criteria.setAccuracy(Criteria.ACCURACY_FINE);  //fine accuracy selected
				
		provider = locationManager.getBestProvider(criteria, false);
		Location location = locationManager.getLastKnownLocation(provider);

		// Initialize the location fields
		if (location != null) {
			Log.e("LocationTag", "Provider " + provider + " has been selected.");
			
			latitude=location.getLatitude();
			longitude=location.getLongitude();
			int lat = (int) (location.getLatitude());
			int lng = (int) (location.getLongitude());
			latituteField.setText(String.valueOf(lat));
			longitudeField.setText(String.valueOf(lng));
		} else {
			latituteField.setText("Provider not available");
			longitudeField.setText("Provider not available");
		}
		
		
		
		//latitude=26.88723;
		//longitude=75.76123;
		StringBuilder result = new StringBuilder();
        try {
            //Geocoder geocoder = new Geocoder(this, Locale.getDefault());
        	Geocoder geocoder = new Geocoder(this, Locale.ENGLISH);
            List<Address> addresses = geocoder.getFromLocation(latitude, longitude, 1);
            if (addresses!=null) {
            	for (Address address : addresses) {
            		result.append("\n" + address.getAddressLine(0));
                  }
            	result.append("\n");
            	
            	
                Address address = addresses.get(0);
                if(addresses!=null)
            	{
               try{ result.append(address.getPremises());}catch(Exception ex1){}
               try{ result.append(address.getSubLocality());}catch(Exception ex1){}
               try{ result.append(address.getLocality()).append("\n");}catch(Exception ex1){}
               try{ result.append(address.getCountryName());}catch(Exception ex1){}
            	}
            }
            else{
            	result.append("No Address returned!");
            }
        } catch (IOException e) {
            Log.e("tag", e.getMessage());
            result.append(e.getMessage());
        }

        Address1.setText("Msg"+result.toString());
        
	}
	
	/* Request updates at startup */
	@Override
	protected void onResume() {
		super.onResume();
		locationManager.requestLocationUpdates(provider, 400, 1, this);
	}

	/* Remove the locationlistener updates when Activity is paused */
	@Override
	protected void onPause() {
		super.onPause();
		locationManager.removeUpdates(this);
	}

	@Override
	public void onLocationChanged(Location location) {
		int lat = (int) (location.getLatitude());
		int lng = (int) (location.getLongitude());
		latituteField.setText(String.valueOf(lat));
		longitudeField.setText(String.valueOf(lng));
	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onProviderEnabled(String provider) {
		Toast.makeText(this, "Enabled new provider " + provider,
				Toast.LENGTH_SHORT).show();

	}

	@Override
	public void onProviderDisabled(String provider) {
		Toast.makeText(this, "Disabled provider " + provider,
				Toast.LENGTH_SHORT).show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
