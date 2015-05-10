package com.example.skipactivitydemo;

import android.app.Application;

/**
 * @2014-12-11
 * @desperation:
 * 
 */
public class MyApp extends Application {
	private String skipString;

	public String getSkipString() {
		return skipString;
	}

	public void setSkipString(String skipString) {
		this.skipString = skipString;
	}

	@Override
	public void onCreate() {
		super.onCreate();
	}
}
