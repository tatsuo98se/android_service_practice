package com.tatsuo98se.servicesample.service;

import java.util.concurrent.Callable;

import com.tatsuo98se.servicesample.util.ProgressObservable;

public class Request implements Callable<ProgressObservable> {

	@Override
	public ProgressObservable call() {
		 return UploadUtils.upload(null);
	}
	
}
