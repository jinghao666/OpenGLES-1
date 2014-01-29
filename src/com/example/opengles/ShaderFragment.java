package com.example.opengles;

import android.app.Fragment;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ShaderFragment extends Fragment {

	private MyGLSurfaceView mGLView;
	
	public ShaderFragment(){
	
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		if (container == null) {
	        return null;
	    }
		mGLView = new MyGLSurfaceView(getActivity());
	   
		return mGLView;
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
