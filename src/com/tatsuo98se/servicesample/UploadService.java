package com.tatsuo98se.servicesample;

import java.util.concurrent.Future;

import com.tatsuo98se.servicesample.service.Request;
import com.tatsuo98se.servicesample.service.Uploader;
import com.tatsuo98se.servicesample.util.ProgressObservable;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class UploadService extends Service {
	
	private final int WORKER_COUNT = 1;
	
	private Uploader mUploader = new Uploader(WORKER_COUNT);
	
	public class UploadServiceBinder extends Binder{
		public UploadService getService(){
			return UploadService.this;
		}
	}
	
	private final IBinder mBinder = new UploadServiceBinder();

	@Override
	public void onCreate() {
		Log.d("UploadService", "onCreate");
		super.onCreate();
	}
	
	@Override
	public IBinder onBind(Intent arg0) {
		Log.d("UploadService", "onBind");
		return mBinder;
	}
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Log.d("UploadService", "onStart");
		return super.onStartCommand(intent, flags, startId);
	}
	
	@Override
	public void onDestroy() {
		Log.d("UploadService", "onDestroy");
		super.onDestroy();
	}
	
	public Future<ProgressObservable> putRequest(Request request){
		return mUploader.putRequest(request);
	}

}
