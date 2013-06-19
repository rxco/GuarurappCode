package com.leyendalabs.guarurapp.listeners;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class DrawerItemClickListener implements ListView.OnItemClickListener {

	Context cntIn;
	public DrawerItemClickListener(Context context) {
		cntIn = context;
	}
	
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        selectItem(position);
    }
    
    private void selectItem(int position) {
    	

    	//switch para detectar click en algun menú
    	switch(position){
    		case 0:    			
    			Toast.makeText(cntIn, "id: "+ position, Toast.LENGTH_SHORT).show();
			
    		break;
    		case 1:    			
    			Toast.makeText(cntIn, "id: "+ position, Toast.LENGTH_SHORT).show();
    			
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
    	
    	
    }
    

}
