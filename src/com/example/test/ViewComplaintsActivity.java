package com.example.test;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxStatus;

public class ViewComplaintsActivity extends Activity {

	private ListViewAdapter adapter;

	List<String> myStrings;
	private ListView list;

	// ArrayAdapter adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.view_complaints_layout);
		// initList();
		myStrings = new ArrayList<String>();
		
		myStrings.add("View Dept 1");
		myStrings.add("View Dept 2");
		myStrings.add("View Dept 3");

		
		adapter = new ListViewAdapter();
		list = (ListView) findViewById(R.id.myList1);
		list.setAdapter(adapter);
		
		list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int index,
					long arg3) {
				
				Toast.makeText(ViewComplaintsActivity.this, "Hello index "+index, Toast.LENGTH_SHORT).show();
			  
				startActivity(new Intent(ViewComplaintsActivity.this, ViewComplaints.class));
			}
		});

	}
	
	
	private class ListViewAdapter extends BaseAdapter {

		private LayoutInflater inflater;

		public ListViewAdapter() {

			inflater = (LayoutInflater) ViewComplaintsActivity.this
					.getSystemService(getBaseContext().LAYOUT_INFLATER_SERVICE);
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return myStrings.size();
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			Log.i("mylistCount", "" + myStrings.size());

			View vi = convertView;
			if (convertView == null) {

				vi = inflater.inflate(R.layout.cell, null);
				TextView title = (TextView) vi.findViewById(R.id.title);
				title.setText(myStrings.get(position));
				// image
			}
			return vi;
		}

	}
}

/*
 * private void initList() { String[] versions = { "Sir Administration",
 * "Water ministry", " " };// here // is // the // data
 * 
 * adapter = new ArrayAdapter<>(getApplicationContext(),
 * android.R.layout.simple_list_item_1, versions); // create the // adapter //
 * content // android.R.layout.simple_list_item_1 way of presenting the data //
 * fill the data in the array adapter (versions)
 * 
 * list = (ListView) findViewById(R.id.listView1); list.setAdapter(adapter);
 * 
 * }
 * 
 * 
 * }
 */
