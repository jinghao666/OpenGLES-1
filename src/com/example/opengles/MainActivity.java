package com.example.opengles;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;


public class MainActivity extends Activity {

	private MyGLSurfaceView mGLView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		mGLView = new MyGLSurfaceView(this);
		setContentView(mGLView);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		return true;
	}

	@Override
	public void onPause() {
		if(mGLView != null){
			mGLView.onPause();
		}
		super.onPause();
	}
	
	@Override
	public void onResume() {
		if(mGLView != null){
			mGLView.onResume();
		}
		super.onResume();
	}
	
}
