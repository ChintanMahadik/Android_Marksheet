package com.exercise.AndroidClient;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Date;

import android.R.color;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Marksheet extends Activity
{
	
	
float result= AndroidClient.percent;
static String student =AndroidClient.stud;
static String student2=student;
static int mrk1=AndroidClient.mrk1;
static int mrk2=AndroidClient.mrk2;
static int mrk3=AndroidClient.mrk3;

Button marksheet;

TextView mrks,sign,desp,date;
//Date d;

public void onCreate(Bundle savedInstanceState)
{
    super.onCreate(savedInstanceState);
    setContentView(R.layout.marksheet);
    
    mrks = (TextView)findViewById(R.id.percent);
    sign =(TextView)findViewById(R.id.princi);
    date=(TextView)findViewById(R.id.date);
    desp=(TextView)findViewById(R.id.Desp);
    
    if(result >= 75 && result <100 && mrk1<=100 && mrk2<=100 && mrk3<=100 && mrk1>40 && mrk2>40 && mrk3>40)
    {
    
    desp.setTextColor(Color.YELLOW);
    desp.setText("CONGRATULATIONS "+student+ "\nYou are passed with \nDistinction ");
    
    mrks.setTextColor(Color.GREEN);
    mrks.setText(Float.toString(result)+"%");
    }
    else if(result >= 60 && result < 75 && mrk1<=100 && mrk2<=100 && mrk3<=100 && mrk1>40 && mrk2>40 && mrk3>40)
    {
    	 desp.setTextColor(Color.YELLOW);
    	 desp.setText("CONGRATULATIONS "+student+ "\nYou are passed with \nFirst Class ");
    	    
    	 mrks.setTextColor(Color.GREEN);
    	 mrks.setText(Float.toString(result)+"%");
    }
    else if(result >=40 && result <60 && mrk1<=100 && mrk2<=100 && mrk3<=100 && mrk1>40 && mrk2>40 && mrk3>40)
    {
    
    	desp.setTextColor(Color.YELLOW);
   	    desp.setText("CONGRATULATIONS "+student+ "\nYou are passed with  \nSecond Class ");
   	    
   	    mrks.setTextColor(Color.MAGENTA);
   	    mrks.setText(Float.toString(result)+"%");	
    }
    else if(result < 40 && mrk1<=100 && mrk2<=100 && mrk3<=100)
    {
    	desp.setTextColor(Color.YELLOW);
   	    desp.setText(" \n"+student+ "\nYou are Failed ");
   	    
   	    mrks.setTextColor(Color.RED);
   	    mrks.setText("F");
    }
    else if(result > 40 && mrk1<=100 && mrk2<=100 && mrk3<=100 && (mrk1<40 || mrk2<40 || mrk3<40))
    {
    	desp.setTextColor(Color.YELLOW);
   	    desp.setText(" \n"+student+ "\nYou are Failed ");
   	    
   	    mrks.setTextColor(Color.RED);
   	    mrks.setText("F");
    }
    else if ( mrk1>100 && mrk2>100 && mrk3>100)
    {
    	desp.setTextColor(Color.YELLOW);
   	    desp.setText("Hey... "+student+ "\nYou please verify your marks\nIncorrect marks ");
   	    
   	    mrks.setTextColor(Color.RED);
   	    mrks.setText("Invalid score");
    }
    sign.setTextColor(Color.BLACK);
    sign.setText("Dr.Unnikrishnan");
    
    date.setTextColor(Color.BLACK);
    date.setText("22/3/15");

    
    marksheet=(Button)findViewById(R.id.marks);
    marksheet.setOnClickListener(buttonSendOnClickListener);
    marksheet.setBackgroundColor(Color.BLUE);
   
}

Button.OnClickListener buttonSendOnClickListener = new Button.OnClickListener()
{

	@Override
	public void onClick(View arg0) 
	{
		 Toast.makeText(Marksheet.this, "Cool",Toast.LENGTH_LONG).show();
		 Intent x =new Intent(getApplicationContext(),Grades.class );
         startActivity(x);
	}
};	



}
