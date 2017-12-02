package com.exercise.AndroidClient;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class Feedback extends Activity
{
	RatingBar rate;
	static String r;
	static String s;
	EditText rev;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.feedback);
		
		rate=(RatingBar)findViewById(R.id.rbar1);
		
		
		rev =(EditText)findViewById(R.id.review);
		
		 
		Button send=(Button)findViewById(R.id.feed);
		send.setOnClickListener(buttonSendOnClickListener);
		send.setBackgroundColor(Color.YELLOW);
	
	}

	Button.OnClickListener buttonSendOnClickListener = new Button.OnClickListener()
	{

		@Override
		public void onClick(View arg0) 
		{
			 s=rev.getText().toString();
			 
			Toast.makeText(Feedback.this, "Thank you for your feedback ",Toast.LENGTH_LONG).show();
			 Intent x =new Intent(getApplicationContext(),Fresult.class );
	         startActivity(x);
		}
	};
		
}
