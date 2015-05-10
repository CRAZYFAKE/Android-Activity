package com.example.skipactivitydemo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.widget.TextView;

/**
 * @2014-12-11
 * @desperation:
 * 
 */
@SuppressWarnings("deprecation")
public class SecondActivity extends Activity {

	private TextView textView;
	private String getedString;
	private String getWay;
	private MyApp myApp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.second);
		myApp = (MyApp) this.getApplication();
		textView = (TextView) findViewById(R.id.textView1);
		getWay = getIntent().getStringExtra("way");
		if (getWay.equals(FirstActivity.FROM_INTENT)
				|| getWay.equals(FirstActivity.FROM_STATIC)) {
			getedString = getIntent().getStringExtra("extra");
			textView.setText(getedString);
		} else if (getWay.equals(FirstActivity.FROM_CILPBORD)) {
			ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
			getedString = clipboard.getText().toString();
			textView.setText(getedString);
		} else if (getWay.equals(FirstActivity.FROM_APPLICATION)) {
			textView.setText(myApp.getSkipString());
		}

	}
}
