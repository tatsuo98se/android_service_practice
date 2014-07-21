package com.tatsuo98se.servicesample.util;

import java.util.Observable;

import android.util.Log;

public abstract class ProgressObservable extends Observable {
	
	protected abstract void execute() throws Exception;
	
	public void run(Object additionalData){
		try{
			callOnPreExeCute(additionalData);
			execute();
			callOnPostExecute(additionalData);
		}
		catch(Exception e){
			callOnError(e, additionalData);
		}
		finally{
			callOnFinally(additionalData);
		}
	}

	private synchronized void sendStatusChanged(Event event){
		setChanged();
		Log.d("sendStatusChanged", "hasChanged: " + hasChanged() + " Event: " + event);
		notifyObservers(event);
	}
	
	final protected void callOnPreExeCute(Object additionalData){
		sendStatusChanged(new Event(Event.EventId.PreExecute, additionalData));
	}
	final protected void callOnPostExecute(Object additionalData){
		sendStatusChanged(new Event(Event.EventId.PostExecute, additionalData));
	}
	final protected void callOnError(Throwable e, Object additionalData){
		sendStatusChanged(new Event.ErrorEvent(e, additionalData));
	}
	final protected void callOnProgress(int min, int max, int currentProgress, Object additionalData){
		sendStatusChanged(new Event.ProgressEvent(min, max, currentProgress, additionalData));
	}
	final protected void callOnFinally(Object additionalData) {
		sendStatusChanged(new Event(Event.EventId.Finally, additionalData));
	}

	
}
