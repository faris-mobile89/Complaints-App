package com.example.test;

import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;
import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

import com.example.test.lib.Complaints;
import com.example.test.lib.Deptartment;
import com.example.test.lib.JSONParser;

public class ViewComplaints extends Activity {
	private JSONParser jParser = new JSONParser();
	private List<Complaints> listComplaints = new ArrayList<Complaints>();
	private JSONArray JsonArray;
	private ListViewAdapter adapter;
	
@Override
protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	
	setContentView(R.layout.view_complaints_layout);
	
	new loadData().execute();
}

	
	private class loadData extends AsyncTask<Void, Void, Void> {

		@Override
		protected Void doInBackground(Void... parms) {
           //1. build params
			
			List<NameValuePair> params = new ArrayList<NameValuePair>();
			params.add(new BasicNameValuePair("tag", "getComplaints"));
			
			//2. set URL 
			String URL = "http://10.0.2.2/ATIT/complaints/api.php";
			 //3 execute request
			JSONObject json = jParser.makeHttpRequest(URL, "GET", params);
			
			try {
				
				if (json != null) {
					
					int error = json.getInt("error");

					if (error == 0) {

						JsonArray = json.getJSONArray("comps");

						for (int i = 0; i < JsonArray.length(); i++) {
							
							JSONObject c = JsonArray.getJSONObject(i);
							
							Complaints comp = new Complaints();
							comp.setId(c.getInt("id"));
							comp.setText(c.getString("text"));
							comp.setDate(c.getString("created_at"));
							comp.setPhone(c.getString("phone"));
							comp.setImgUrl(c.getString("image"));
							//push item to array list
							listComplaints.add(comp);
					}
			     }
			}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			
			//Log.i("NSDATA", listDept.toString());
			
			ListView myList = (ListView)findViewById(R.id.myList1);
		    adapter =  new ListViewAdapter();
			myList.setAdapter(adapter);

			myList.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> arg0, View arg1, int position,
						long arg3) {
					
					
			      Intent i = new Intent(ViewComplaints.this,ViewComplaintsDetails.class);
					
			       i.putExtra("text", listComplaints.get(position).getText());
			       i.putExtra("created_at",listComplaints.get(position).getDate());
			       i.putExtra("phone", listComplaints.get(position).getPhone());
			        i.putExtra("image", listComplaints.get(position).getImgUrl());
					
				  startActivity(i);
				}
			});
		}
	}
		
	private class ListViewAdapter extends BaseAdapter {

		private LayoutInflater inflater;

		public ListViewAdapter() {

			inflater = (LayoutInflater) ViewComplaints.this
					.getSystemService(getBaseContext().LAYOUT_INFLATER_SERVICE);
		}

		@Override
		public int getCount() {
			return listComplaints.size();
		}

		@Override
		public Object getItem(int position) {
			return position;
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			Log.i("mylistCount", "" + listComplaints.size());

			View vi = convertView;
			if (convertView == null) {
				vi = inflater.inflate(R.layout.cell_complaints, null);
				TextView title = (TextView) vi.findViewById(R.id.title);
				title.setText(listComplaints.get(position).getText());
			}
			return vi;
		}

	}
}
