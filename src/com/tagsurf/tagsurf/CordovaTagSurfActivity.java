package com.tagsurf.tagsurf;
import java.util.concurrent.ExecutorService;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import org.apache.cordova.Config;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.api.CordovaInterface;
import org.apache.cordova.api.CordovaPlugin;

public class CordovaTagSurfActivity extends Activity implements CordovaInterface
{
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        CordovaWebView cwv = (CordovaWebView) findViewById(R.id.cordovaWV);
        Config.init(this);
        cwv.loadUrl(Config.getStartUrl());
    }
	@Override
	public Activity getActivity() {
		// TODO Auto-generated method stub
		return this;
	}
	@Override
	public ExecutorService getThreadPool() {
		return null;
	}
	@Override
	public Object onMessage(String arg0, Object arg1) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setActivityResultCallback(CordovaPlugin arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void startActivityForResult(CordovaPlugin arg0, Intent arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}
}
