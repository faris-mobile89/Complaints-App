package com.example.test;

import com.example.test.lib.ImageLoader;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ViewComplaintsDetails extends Activity {
@Override
protected void onCreate(Bundle i) {
	super.onCreate(i);
	setContentView(R.layout.view_complaints_details);
	
	Bundle bundle = getIntent().getExtras();
	
	ImageView img = (ImageView)findViewById(R.id.imageView1);
	TextView date = (TextView)findViewById(R.id.date);
	TextView phone = (TextView)findViewById(R.id.phone);
	TextView text = (TextView)findViewById(R.id.description);
	
	Button mapView =(Button)findViewById(R.id.viewMap);
	
	mapView.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			
			Toast.makeText(getBaseContext(), "Map pending", Toast.LENGTH_SHORT).show();
			
		}
	});
	
	/*
	if(!admin()){
		phone.setVisibility(View.INVISIBLE);
	}
	*/
	ImageLoader imageLoader = new ImageLoader(ViewComplaintsDetails.this);
	if(bundle != null){
		
		imageLoader.DisplayImage(bundle.getString("image"), img);
		date.setText(bundle.getString("created_at"));
		phone.setText(bundle.getString("phone"));
		text.setText(bundle.getString("text"));
		
	}
	
}
}
