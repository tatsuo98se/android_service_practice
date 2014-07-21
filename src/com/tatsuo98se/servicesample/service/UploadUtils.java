package com.tatsuo98se.servicesample.service;

import java.io.InputStream;

import com.tatsuo98se.servicesample.util.ProgressObservable;

public class UploadUtils {
	
	static public ProgressObservable upload(InputStream stream){
		final ProgressObservable uploader = new ProgressObservable() {
			
			@Override
			protected void execute() throws Exception {
				for(int i=0; i<10; i++){
					try {
						callOnProgress(0, 10, i, null);
						Thread.sleep(100);
					} catch (InterruptedException e) {
						throw new RuntimeException(e);
					}
				}
			}
		};
		uploader.run(null);
		return uploader;
	}

}
