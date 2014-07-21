package com.tatsuo98se.servicesample.service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.tatsuo98se.servicesample.util.ProgressObservable;


public class Uploader {
	
	private ExecutorService mExecutorService;
	
	public Uploader(int workerCount){
		mExecutorService = Executors.newFixedThreadPool(workerCount);
	}
	
	public Future<ProgressObservable> putRequest(Request request){
		return mExecutorService.submit(request);
	}
	
}
