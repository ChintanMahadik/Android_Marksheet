package com.exercise.AndroidClient;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Fresult extends Activity
{

	String r=Feedback.r;
	String sr=Feedback.s;
	
	TextView rating,feedbk;
	Button new_login;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fresult);
		
	feedbk=(TextView)findViewById(R.id.feedbk);
	feedbk.setTextColor(Color.CYAN);
	feedbk.setText(sr);
		
	new_login =(Button)findViewById(R.id.newlogin);
	new_login.setOnClickListener(login);
	new_login.setBackgroundColor(Color.YELLOW);
	
	
	}
	
	Button.OnClickListener login = new Button.OnClickListener()
	{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Toast.makeText(Fresult.this, "First Run Your Server Machine  ",Toast.LENGTH_LONG).show();
			 Intent x =new Intent(getApplicationContext(),Login.class );
	         startActivity(x);
		}
		
	};
}
