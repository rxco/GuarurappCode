package com.leyendalabs.guarurapp.listeners;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.leyendalabs.guarurapp.R;
import com.leyendalabs.guarurapp.fragments.Fragment_Mapa;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

public class DrawerItemClickListener implements OnItemClickListener {

	SherlockFragmentActivity cntIn;
	public DrawerItemClickListener(SherlockFragmentActivity context) {
		cntIn = context;
	}
	
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        selectItem(position);
    }
    
   public void selectItem(int position) {
	   FragmentManager manager = cntIn.getSupportFragmentManager();
	   FragmentTransaction transaction = manager.beginTransaction(); 
	   
	   Fragment_Mapa fragment_Mapa = null; 
	   
    	//switch para detectar click en algun menú
    	switch(position){
    		case 0:    	
    			
    			Toast.makeText(cntIn, "id: "+ position, Toast.LENGTH_SHORT).show();
    			fragment_Mapa = new Fragment_Mapa();	
    			transaction.replace(R.id.content_frame, fragment_Mapa); 
    		break;
    		case 1:    			
    			Toast.makeText(cntIn, "id: "+ position, Toast.LENGTH_SHORT).show();
    			transaction.remove(fragment_Mapa);
    		break;
    		
    		case 2:
    			Toast.makeText(cntIn, "id: "+ position, Toast.LENGTH_SHORT).show();
    		break;
    		
    		case 3:    			
    			Toast.makeText(cntIn, "id: "+ position, Toast.LENGTH_SHORT).show();
    		break;
    			 
    			
    		case 4:
    			Toast.makeText(cntIn, "id: "+ position, Toast.LENGTH_SHORT).show();
    		break;
    		
    		case 5:    			
    			Toast.makeText(cntIn, "id: "+ position, Toast.LENGTH_SHORT).show();
    		break;
    		
    	}
    	transaction.commit(); 
    	
    }
    

}
