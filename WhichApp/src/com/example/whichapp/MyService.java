package com.example.whichapp;

import java.util.List;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends Service {
	private static BroadcastReceiver mMessageReceiver ;
	private static ActivityManager activityManager;
	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		  activityManager = (ActivityManager) this.getSystemService( ACTIVITY_SERVICE );
	      Myreciever Receiver = new Myreciever();
	      IntentFilter filter = new IntentFilter();
	      filter.setPriority(IntentFilter.SYSTEM_HIGH_PRIORITY);
	      filter.addAction("android.intent.action.TIME_TICK");
	      this.registerReceiver(Receiver, filter);
	}
	
	@Override
	   public int onStartCommand(Intent intent, int flags, int startId) {
	      // Let it continue running until it is stopped.
		 Toast.makeText(this, "Service Started", Toast.LENGTH_LONG).show();
	      return START_STICKY;
	   }
	   
	   @Override
	   public void onDestroy() {
	      super.onDestroy();
	      Toast.makeText(this, "Service Destroyed", Toast.LENGTH_LONG).show();
	   }

	   
	   class Myreciever extends BroadcastReceiver
	   {

		@Override
		public void onReceive(Context arg0, Intent arg1) {
			// TODO Auto-generated method stub
			 // Toast.makeText(getApplicationContext(), "working", Toast.LENGTH_LONG).show();
		      List<RunningTaskInfo> taskInfo = activityManager.getRunningTasks(1);
		             ComponentName componentInfo = taskInfo.get(0).topActivity;
		            if(componentInfo.getPackageName().equals("com.whatsapp"))
		            {
		            	  Toast.makeText(getApplicationContext(), "Whatsapp Chalan Kum Kerde!", Toast.LENGTH_LONG).show();
		            
		            }
		}
		   
	   }
	   
}
