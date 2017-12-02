
package com.exercise.AndroidClient;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import android.R.color;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends Activity
{
	
	EditText username;
	EditText password;
	EditText ip;
	static String ip_addr;
	TextView login1;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first);
        
        username = (EditText)findViewById(R.id.username);
        password =(EditText)findViewById(R.id.password);
        ip=(EditText)findViewById(R.id.ip);
        
        login1=(TextView)findViewById(R.id.lg);
        login1.setTextColor(Color.GREEN);
       
        
        Button login = (Button)findViewById(R.id.login);
       // textIn = (TextView)findViewById(R.id.textin);
        login.setOnClickListener(buttonSendOnClickListener);
        
        login.setBackgroundColor(Color.GREEN);
    }
    
    Button.OnClickListener buttonSendOnClickListener = new Button.OnClickListener()
    {

		@Override
		public void onClick(View arg0) 
		{
			
			
			if((username.getText().toString()).equals("chintan")&& password.getText().toString().equals("chintan"))
			{
				 ip_addr=ip.getText().toString();
		           Toast.makeText(Login.this, "Login Successful",Toast.LENGTH_LONG).show();
		           Intent i =new Intent(getApplicationContext(),AndroidClient.class );
		           startActivity(i);
		          }
			else
			{
		           Toast.makeText(Login.this, "Invalid Login",Toast.LENGTH_LONG).show();
		    }
		    
		}
    };

}