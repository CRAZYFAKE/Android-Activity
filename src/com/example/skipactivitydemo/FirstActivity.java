package com.example.skipactivitydemo;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class FirstActivity extends Activity implements OnClickListener {

	public static String FROM_FIRST_ACTIVITY = "这是通过静态变量传值";
	public static final String FROM_INTENT = "from_intent";
	public static final String FROM_STATIC = "from_static";
	public static final String FROM_CILPBORD = "from_cilpboard";
	public static final String FROM_APPLICATION = "from_application";

	private Button intentBtn;
	private Button staticBtn;
	private Button cilpboardBtn;
	private Button applicationBtn;

	private MyApp myApp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.first);
		intentBtn = (Button) findViewById(R.id.intent_btn);
		staticBtn = (Button) findViewById(R.id.static_btn);
		cilpboardBtn = (Button) findViewById(R.id.cilpboard_btn);
		applicationBtn = (Button) findViewById(R.id.application_btn);

		intentBtn.setText("Intent传值");
		staticBtn.setText("静态变量传值");
		cilpboardBtn.setText("剪切板传值");
		applicationBtn.setText("全局对象传值");

		intentBtn.setOnClickListener(this);
		staticBtn.setOnClickListener(this);
		cilpboardBtn.setOnClickListener(this);
		applicationBtn.setOnClickListener(this);

		myApp = (MyApp) this.getApplication();
	}

	@SuppressWarnings("deprecation")
	@SuppressLint("NewApi")
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.intent_btn:
			Intent intent = new Intent();
			intent.putExtra("extra", "这是通过Intent传值");
			intent.putExtra("way", FROM_INTENT);
			intent.setClass(FirstActivity.this, SecondActivity.class);
			startActivity(intent);
			break;
		case R.id.static_btn:
			intent = new Intent();
			intent.putExtra("extra", "这是通过静态变量传值");
			intent.putExtra("way", FROM_STATIC);
			intent.setClass(FirstActivity.this, SecondActivity.class);
			startActivity(intent);
			break;
		case R.id.cilpboard_btn:
			intent = new Intent();
			ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
			clipboard.setText("这是通过剪切板传值");
			intent.putExtra("way", FROM_CILPBORD);
			intent.setClass(FirstActivity.this, SecondActivity.class);
			startActivity(intent);
			break;
		case R.id.application_btn:
			intent = new Intent();
			myApp.setSkipString("通过Appliction传值");
			intent.putExtra("way", FROM_APPLICATION);
			intent.setClass(FirstActivity.this, SecondActivity.class);
			startActivity(intent);
			break;
		default:
			break;
		}
	}
}
