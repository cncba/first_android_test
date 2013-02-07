package com.gaitianxia.cache_bad_egg;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.view.Menu;
import android.widget.TextView;

/*
 * 启动界面 splash
 * 用于显示启动时第一屏的欢迎界面
 * TODO: 修改合适的图片 
 */
public class SplashActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
        PackageManager pm = getPackageManager();
        try {
               PackageInfo pi = pm.getPackageInfo("com.gaitianxia.cache_bad_egg", 0);
               TextView versionNumber = (TextView) findViewById(R.id.versionNumber);
               versionNumber.setText("Version " + pi.versionName);
           } catch (NameNotFoundException e) {
               e.printStackTrace();
           }
       
       new Handler().postDelayed(new Runnable(){

           @Override
           public void run() {
               Intent intent = new Intent(SplashActivity.this,MainActivity.class);
               startActivity(intent);
               SplashActivity.this.finish();
           }
                       
       }, 2500);

	}

}
