
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
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Grades extends Activity
{
	String student=Marksheet.student2;
	String rollno =AndroidClient.roll;
	int mrk1=Marksheet.mrk1;
	int mrk2=Marksheet.mrk2;
	int mrk3=Marksheet.mrk3;
	int totalmrks;
	float Tpoint;
	int avgmrks;
	
	String grdA=AndroidClient.gradeA;
	String grdB=AndroidClient.gradeB;
	String grdC=AndroidClient.gradeC;
	
	
	int crd=AndroidClient.credits;
	int flag=0;

	TextView name,roll,sub1mrk,sub2mrk,sub3mrk,pointer,gr1,gr2,gr3,fgrd,score_grde;
	Button feedback;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.marksheet2);
        
    //    username = (EditText)findViewById(R.id.username);
    //    password =(EditText)findViewById(R.id.password);
		 Toast.makeText(Grades.this, "Cool",Toast.LENGTH_LONG).show();
		 
		 
		 name=(TextView)findViewById(R.id.textView2);
		 name.setText(student);
		 
		 roll=(TextView)findViewById(R.id.feedbk);
		 roll.setText(rollno);
		 
		 sub1mrk=(TextView)findViewById(R.id.textView8);
		 sub1mrk.setText(Integer.toString(mrk1));
		 
		 sub2mrk=(TextView)findViewById(R.id.TextView03);
		 sub2mrk.setText(Integer.toString(mrk2));
		 
		 sub3mrk=(TextView)findViewById(R.id.TextView04);
		 sub3mrk.setText(Integer.toString(mrk3));
		 
		 gr1=(TextView)findViewById(R.id.textView9);
		 gr1.setText(grdA);
		 
		 gr2=(TextView)findViewById(R.id.TextView05);
		 gr2.setText(grdB);
		 
		 gr3=(TextView)findViewById(R.id.TextView06);
		 gr3.setText(grdC);
		 
		 score_grde=(TextView)findViewById(R.id.score_grde);
		 
		 totalmrks=mrk1+mrk2+mrk3;
		 
		 Tpoint=(crd*10)/15;
		 
		 pointer=(TextView)findViewById(R.id.textView10);
		 pointer.setTextColor(Color.YELLOW);
		 pointer.setText(Float.toString(Tpoint));
		 
		 
		 avgmrks=totalmrks/3;
		 
		 fgrd=(TextView)findViewById(R.id.textView11);
		 fgrd.setTextColor(Color.YELLOW);

		 if(avgmrks>=90 && avgmrks<=100 && mrk1>40 && mrk2>40 && mrk3>40)
		    {
		       fgrd.setText("O");
		       score_grde.setText("Excellent");
		    }
		    else if(avgmrks>=80 && avgmrks<90 && mrk1>40 && mrk2>40 && mrk3>40)
		    {
		        
		    	fgrd.setText("A");
			       score_grde.setText("V Good");

		    }
		    else if(avgmrks>=70 && avgmrks<80 && mrk1>40 && mrk2>40 && mrk3>40)
		    {
		    	fgrd.setText("B");
			       score_grde.setText("Good");

		    }
		    else if(avgmrks>=60 && avgmrks<70 && mrk1>40 && mrk2>40 && mrk3>40)
		    {
		    	fgrd.setText("C");
			       score_grde.setText("Fair");

		    }
		    else if (avgmrks>=50 && avgmrks<60 && mrk1>40 && mrk2>40 && mrk3>40)
		    {
		    	fgrd.setText("D");
			       score_grde.setText("Average");

		    }
		    else if(avgmrks>=40 && avgmrks<50 && mrk1>40 && mrk2>40 && mrk3>40)
		    {
		    	fgrd.setText("E");
			       score_grde.setText("Unsatify");

		    }
		    else if(avgmrks>=40 && (mrk1<40 || mrk2<40 || mrk3<40))
		    {
		    	fgrd.setText("X");
			       score_grde.setText("Fail");
			       pointer.setText("X");

		    }
		    else if(avgmrks<40 && (mrk1<40 || mrk2<40 || mrk3<40))
		    {
		    	fgrd.setText("X");
			       score_grde.setText("Fail");
			       pointer.setText("X");

		    }
		 
		 feedback=(Button)findViewById(R.id.feedback);
		
		feedback.setOnClickListener(buttonSendOnClickListener);
		feedback.setBackgroundColor(Color.CYAN);
    }
    
    
    Button.OnClickListener buttonSendOnClickListener = new Button.OnClickListener()
    {

		@Override
		public void onClick(View arg0) 
		{
			
		           Toast.makeText(Grades.this, "Please give your feedback",Toast.LENGTH_LONG).show();
		    
		           	Intent i=new Intent(getApplicationContext(),Feedback.class);
		           	startActivity(i);
		}
    };
   
     
}