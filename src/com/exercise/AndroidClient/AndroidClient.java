package com.exercise.AndroidClient;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AndroidClient extends Activity {
	
	EditText name,rollno,sub1,sub2,sub3;
	TextView textIn;
	static float percent;
	static String stud;
	static int mrk1,mrk2,mrk3,credits;
	static String roll;
	public static String gradeA,gradeB,gradeC;
	String ip=Login.ip_addr;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        
        name = (EditText)findViewById(R.id.name);
        rollno=(EditText)findViewById(R.id.rollno);
        sub1=(EditText)findViewById(R.id.sub1);
        sub2=(EditText)findViewById(R.id.sub2);
        sub3=(EditText)findViewById(R.id.sub3);
        
        Button send = (Button)findViewById(R.id.send);
        
        send.setOnClickListener(buttonSendOnClickListener);
        send.setBackgroundColor(Color.DKGRAY);
    }
    
    Button.OnClickListener buttonSendOnClickListener = new Button.OnClickListener()
    {

    	
		@Override
		public void onClick(View arg0) 
		{
			 Toast.makeText(AndroidClient.this, "Marks sent to server(check servr machine)",Toast.LENGTH_LONG).show();

			// TODO Auto-generated method stub
			Socket socket = null;
			DataOutputStream dataOutputStream = null;
			DataInputStream dataInputStream = null;
			
			try {
				socket = new Socket(ip, 8888);
				dataOutputStream = new DataOutputStream(socket.getOutputStream());
				
				dataInputStream = new DataInputStream(socket.getInputStream());
				
				dataOutputStream.writeUTF(name.getText().toString());
				
				dataOutputStream.writeUTF(rollno.getText().toString());
				dataOutputStream.writeUTF(sub1.getText().toString());
				dataOutputStream.writeUTF(sub2.getText().toString());
				dataOutputStream.writeUTF(sub3.getText().toString());
				
				name.setText("");
				rollno.setText("");
				sub1.setText("");
				sub2.setText("");
				sub3.setText("");
				
				 percent = Float.parseFloat(dataInputStream.readUTF());
				 stud = dataInputStream.readUTF();
				 mrk1=Integer.parseInt(dataInputStream.readUTF());
				 mrk2=Integer.parseInt(dataInputStream.readUTF());
				 mrk3=Integer.parseInt(dataInputStream.readUTF());
				 roll=dataInputStream.readUTF();
				 gradeA = dataInputStream.readUTF();
				 gradeB = dataInputStream.readUTF();
				 gradeC = dataInputStream.readUTF();
				 credits=Integer.parseInt(dataInputStream.readUTF());
				
		           
				 Intent i =new Intent(getApplicationContext(),Marksheet.class );
		           startActivity(i);
				
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally{
				if (socket != null){
					try {
						socket.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				if (dataOutputStream != null){
					try {
						dataOutputStream.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				if (dataInputStream != null){
					try {
						dataInputStream.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}};
}