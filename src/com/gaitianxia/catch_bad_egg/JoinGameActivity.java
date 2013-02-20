package com.gaitianxia.catch_bad_egg;

import com.gaitianxia.catch_bad_egg.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class JoinGameActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_join_game);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_join_game, menu);
		return true;
	}

}
