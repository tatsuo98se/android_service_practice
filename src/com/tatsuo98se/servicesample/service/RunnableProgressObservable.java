package com.tatsuo98se.servicesample.service;

import com.tatsuo98se.servicesample.util.ProgressObservable;

public class RunnableProgressObservable extends ProgressObservable {

	private Runnable mExecutor;
	
	public RunnableProgressObservable(Runnable executor){
		mExecutor = executor;
	}
	
	@Override
	protected void execute() throws Exception {
		mExecutor.run();
	}

}
