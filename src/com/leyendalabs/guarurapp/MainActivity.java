package com.leyendalabs.guarurapp;


import com.leyendalabs.guarurapp.listeners.DrawerItemClickListener;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends FragmentActivity {
	
	private ListView navList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        this.navList = (ListView)findViewById(R.id.left_drawer);
        
        final String[] names = getResources().getStringArray(R.array.nav_options);
        
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,names);
        
        navList.setAdapter(adapter);
        
        navList.setOnItemClickListener(new DrawerItemClickListener(getApplicationContext()));
      }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    

}
