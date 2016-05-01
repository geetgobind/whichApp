package com.example.whichapp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
	TextView tv;
	Button bt1,bt2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.textv);
        bt1 = (Button) findViewById(R.id.button1);
        bt2= (Button) findViewById(R.id.button2);
        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);

        
        /**ActivityManager activityManager = (ActivityManager) this.getSystemService( ACTIVITY_SERVICE );
        List<RunningAppProcessInfo> procInfos = activityManager.getRunningAppProcesses();
        for(int i = 0; i < procInfos.size(); i++)
        {
            if(procInfos.get(i).processName.equals("com.whatsapp")) 
            {
                Toast.makeText(getApplicationContext(), "Notify Message1", Toast.LENGTH_LONG).show();
            }
        }/	
       /* boolean exit = false;
        while(!exit)
        { 
             List<RunningTaskInfo> taskInfo = activityManager.getRunningTasks(1);
             ComponentName componentInfo = taskInfo.get(0).topActivity;
            if(componentInfo.getPackageName().equals("com.whatsapp"))
            {
            	  Toast.makeText(getApplicationContext(), "Notify Message2", Toast.LENGTH_LONG).show();
             exit = true;
            }
        }*/
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v.getId()==R.id.button1)
		{
			startService(bt1);
		}
		if(v.getId()==R.id.button2)
		{
			stopService(bt2);
		}
		
	}
    
	 // Method to start the service
	   public void startService(View view) {
	      startService(new Intent(getBaseContext(), MyService.class));
	   }

	   // Method to stop the service
	   public void stopService(View view) {
	      stopService(new Intent(getBaseContext(), MyService.class));
	   }
}
