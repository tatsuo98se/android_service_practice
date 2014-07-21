package com.tatsuo98se.servicesample;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button start_service = (Button)findViewById(R.id.btn_start_service);
		Button stop_service = (Button)findViewById(R.id.btn_stop_service);
		Button add_upload_request = (Button)findViewById(R.id.btn_add_upload_request);
		start_service.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
                startService(new Intent(MainActivity.this, UploadService.class));
			}
		});
		stop_service.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
                stopService(new Intent(MainActivity.this, UploadService.class));				
			}
		});
		add_upload_request.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
