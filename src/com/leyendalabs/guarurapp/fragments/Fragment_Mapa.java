package com.leyendalabs.guarurapp.fragments;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.LocationSource;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.leyendalabs.guarurapp.R;
public class Fragment_Mapa extends SherlockFragment implements LocationListener, LocationSource{
	
	private ViewGroup viewGroup; 
	
	private GoogleMap mMap;     
	private OnLocationChangedListener mListener;
	private LocationManager locationManager;
	private SherlockFragmentActivity context; 
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		viewGroup= (ViewGroup)inflater.inflate(R.layout.mapa, container, false); 		
	
		Button boton_auxilio = (Button)viewGroup.findViewById(R.id.auxilio); 
		boton_auxilio.setOnLongClickListener(listener_auxilio); 
		
		context = getSherlockActivity(); 
		
		return viewGroup;
	}
	
	private OnLongClickListener listener_auxilio = new OnLongClickListener() {
		
		@Override
		public boolean onLongClick(View v) {
			// TODO Auto-generated method stub
			
			Toast.makeText(context, "Auxilio estoy en peligro", Toast.LENGTH_LONG).show(); 
			return false;
		}
	}; 
	
	
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		
		getSherlockActivity();
		locationManager = (LocationManager)context.getSystemService(Context.LOCATION_SERVICE);
		
        if(locationManager != null)
        {
            boolean gpsIsEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
//            boolean networkIsEnabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
            
            if(gpsIsEnabled)
            {
                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5L, 10F, this);
            }
//            else if(networkIsEnabled)
//            {
//                locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 5L, 10F, this);
//            }
            else
            {
               Toast.makeText(context, "No hay conexión Gps", Toast.LENGTH_SHORT).show();
               context.finish(); 
            }
            

        }
        else
        {
            //Show some generic error dialog because something must have gone wrong with location manager.
        	 Toast.makeText(context, "No hay conexión Gps", Toast.LENGTH_SHORT).show();
        	 context.finish();
        }
        setUpMapIfNeeded();
		
	}
	
	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	     setUpMapIfNeeded();
         
	        if(locationManager != null)
	        {
	            mMap.setMyLocationEnabled(true);
	        }
	}
	
	@Override
	public void onPause() {
		// TODO Auto-generated method stub
        if(locationManager != null)
        {
            locationManager.removeUpdates(this);
        }
         
        super.onPause();
	}
	
	
	
    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) 
        {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) context.getSupportFragmentManager().findFragmentById(R.id.mapa)).getMap();
            // Check if we were successful in obtaining the map.
            
            if (mMap != null) 
            {
                setUpMap();
            }
 
            //This is how you register the LocationSource
            mMap.setLocationSource(this);
        }
    }
    private void setUpMap() 
    {
        mMap.setMyLocationEnabled(true);
    }
    
    
    
	@Override
	public void activate(OnLocationChangedListener listener) {
		// TODO Auto-generated method stub
		
		mListener = listener;
	}

	@Override
	public void deactivate() {
		// TODO Auto-generated method stub
		
		 mListener = null;
		
	}

	@Override
	public void onLocationChanged(Location location) {
		// TODO Auto-generated method stub
		
	      if(mListener != null )
	      {
	        	Toast.makeText(context, "Posicion", Toast.LENGTH_SHORT).show(); 
	            mListener.onLocationChanged(location);
	 
	            mMap.animateCamera(CameraUpdateFactory.newLatLng(new LatLng(location.getLatitude(), location.getLongitude())));
	      }
		
	}

	@Override
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub
		//Toast.makeText(this, "provider disabled", Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub
		//Toast.makeText(this, "provider enabled", Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub
		//Toast.makeText(this, "status changed", Toast.LENGTH_SHORT).show();
	}
}
