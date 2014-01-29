package com.example.opengles;

import javax.microedition.khronos.opengles.GL10;

import android.opengl.EGLConfig;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView.Renderer;
import android.opengl.Matrix;

public class MyGLRenderer implements Renderer {

    private Triangle mTriangle;
	
	private static float[] mmMatrix = new float[16];
	private static float[] mpMatrix = new float[16];
	private static float[] mvMatrix = new float[16];
	
	private static float[] mMVPMatrix = new float[16];
	
	
    public void onDrawFrame(GL10 unused) {
        // Redraw background color
        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT);
        
        // Set the camera position (View matrix)
        Matrix.setLookAtM(mvMatrix, 0, 0, 0, -6, 0f, 0f, 0f, 0f, 1.0f, 0.0f);

        //Rotate the object
        Matrix.setRotateM(mmMatrix, 0, 20.0f, .0f, 1.0f, .0f);
        
        // Calculate the projection and view transformation
        Matrix.multiplyMM(mMVPMatrix, 0, mpMatrix, 0, mvMatrix, 0);

        Matrix.multiplyMM(mMVPMatrix, 0, mMVPMatrix, 0, mmMatrix, 0);
        
        // Draw shape
        mTriangle.draw(mMVPMatrix);
    }

    public void onSurfaceChanged(GL10 unused, int width, int height) {
        GLES20.glViewport(0, 0, width, height);
        
        Matrix.perspectiveM(mpMatrix, 0, 45.0f, (float)width/(float)height, 1.0f, 10.0f);
    }

	public static int loadShader(int type, String shaderCode){

	    // create a vertex shader type (GLES20.GL_VERTEX_SHADER)
	    // or a fragment shader type (GLES20.GL_FRAGMENT_SHADER)
	    int shader = GLES20.glCreateShader(type);

	    // add the source code to the shader and compile it
	    GLES20.glShaderSource(shader, shaderCode);
	    GLES20.glCompileShader(shader);

	    return shader;
	}

	@Override
	public void onSurfaceCreated(GL10 gl, javax.microedition.khronos.egl.EGLConfig config) {
        // Set the background frame color
        GLES20.glClearColor(1.0f, 0.0f, 0.0f, 1.0f);
        // initialize a triangle
	    mTriangle = new Triangle();
	}
}
