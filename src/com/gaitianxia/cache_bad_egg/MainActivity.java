package com.gaitianxia.cache_bad_egg;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editText = (EditText) findViewById(R.id.edit_message);
    	editText.setMovementMethod(ScrollingMovementMethod.getInstance());
    	// 调用 打电话的系统程序
    	// Intent intent2 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel://10010"));
    	
    	editText.setOnKeyListener(new View.OnKeyListener() {
			@Override
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				Log.i("info", String.valueOf(keyCode));
                //监视硬键盘按键
                if(event.getAction()== KeyEvent.ACTION_DOWN && keyCode== KeyEvent.KEYCODE_ENTER){
                        //按住把EditView中的文版显示在吐司消息中
                        Toast.makeText(MainActivity.this, "test message",
                                        Toast.LENGTH_SHORT).show();
                        //返回true说明你已经处理了这个事件并且它应该就此终止，如果返回false就表示此事件还需要继续传递下去
                        return false;
                }
                return false;
			}
		});
		
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    
    
    
    
    /** Called when the user clicks the Send button */
    public void sendMessage(View view) {
    	Intent intent = new Intent(this, DisplayMessageActivity.class);
    	final EditText editText = (EditText) findViewById(R.id.edit_message);
    	String message = editText.getText().toString();
    	intent.putExtra(EXTRA_MESSAGE, message);
    	startActivity(intent);
    }

}
