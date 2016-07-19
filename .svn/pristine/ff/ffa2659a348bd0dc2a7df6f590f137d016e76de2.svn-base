package com.meal.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.meal.util.DialogUtil;

public class UndergolistActivity extends BaseActivity {

	List<Map<String, Object>> dataList;
	
	ListView undergolist;
	Button snackButton;
	Button breadButton;
	Button fruitButton;
	Button drinkButton;
	Button icecreamButton;
	Button cookedfoodButton;
	Button goButton;
	Button retbutton4;
	Button myorderButton;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.undergolist_activity);
		initWidget();
		snackButton = (Button) findViewById(R.id.snackButton);
		breadButton = (Button) findViewById(R.id.breadButton);
		fruitButton = (Button) findViewById(R.id.fruitButton);
		drinkButton = (Button) findViewById(R.id.drinkButton);
		icecreamButton = (Button) findViewById(R.id.icecreamButton);
		cookedfoodButton = (Button) findViewById(R.id.cookedfoodButton);
		goButton = (Button) findViewById(R.id.gobtn);
		myorderButton = (Button)findViewById(R.id.myorder);
		
		myorderButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				DialogUtil.alert("哇哦，这玩意还没做，要把程序员累死么？下个版本再说吧", UndergolistActivity.this);
				
			}
		});

		snackButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				// intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
				intent.setClass(UndergolistActivity.this,
						StorelistActivity.class);
				startActivity(intent);
			}
		});
		// goButton.setOnClickListener(new View.OnClickListener() {
		//
		// @Override
		// public void onClick(View v) {
		// // TODO Auto-generated method stub
		// Intent intent = new Intent();
		// //intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
		// intent.setClass(UndergolistActivity.this,
		// AddGoodslistActivity.class);
		// startActivity(intent);
		// }
		// });
	}

	private void initWidget() {
		
		retbutton4 = (Button)findViewById(R.id.retbutton4);
		retbutton4.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				UndergolistActivity.this.finish();
			}
		});
		
	
		
		fakeListItemCreate();
	}

	private void fakeListItemCreate() {
		
		undergolist = (ListView) findViewById(R.id.undergolist);
		
		final MyAdapter myAdapter = new MyAdapter(this);
		
		dataList = getData();
		
		undergolist.setAdapter(myAdapter);
		
	}

	private List<Map<String, Object>> getData() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("undergoStoreName", "易购便利店");
		map.put("undergoStoreClass", "零食|熟食");
		map.put("undergoNum", "已有7人加入凑单");
		list.add(map);
		map = new HashMap<String, Object>();
		map.put("undergoStoreName", "联华快客");
		map.put("undergoStoreClass", "饮料|熟食");
		map.put("undergoNum", "已有2人加入凑单");
		list.add(map);
		map = new HashMap<String, Object>();
		map.put("undergoStoreName", "秦立成百货");
		map.put("undergoStoreClass", "零食|面包");
		map.put("undergoNum", "已有5人加入凑单");
		list.add(map);
		map = new HashMap<String, Object>();
		map.put("undergoStoreName", "京客隆");
		map.put("undergoStoreClass", "零食|水果");
		map.put("undergoNum", "已有10人加入凑单");
		list.add(map);
		return list;
	}
	
	public final class ViewHolder 
	{
		TextView undergoStoreName;
		TextView undergoStoreClass;
		TextView undergoNum;
		Button goButton;
	}	
    
	
	public class MyAdapter extends BaseAdapter
	{

		private LayoutInflater mInflater;

		public MyAdapter(Context context) 
		{
			this.mInflater = LayoutInflater.from(context);
		}

		//@Override
		public int getCount() 
		{
			// TODO Auto-generated method stub
			return dataList.size();
		}

		//@Override
		public Object getItem(int arg0) 
		{
			// TODO Auto-generated method stub
			return null;
		}

		//@Override
		public long getItemId(int arg0) 
		{
			// TODO Auto-generated method stub
			return 0;
		}

		//@Override
		public View getView(int position, View convertView, ViewGroup parent) 
		{
			
			HashMap<String, Object> viewItem = (HashMap<String, Object>) dataList.get(position); 

			ViewHolder holder = null;

			if (convertView == null) 
			{
				convertView = mInflater.inflate(R.layout.undergolistitem, null);
				holder = new ViewHolder();
				holder.undergoStoreName = (TextView) convertView.findViewById(R.id.undergoshop);
				holder.undergoStoreClass = (TextView) convertView.findViewById(R.id.undergoshopclass);
				holder.undergoNum = (TextView) convertView.findViewById(R.id.undergonum);
				holder.goButton = (Button) convertView.findViewById(R.id.gobtn);
				convertView.setTag(holder);

			} else 
			{

				holder = (ViewHolder) convertView.getTag();
			}
			
			holder.undergoStoreName.setText((String)viewItem.get("undergoStoreName"));
			holder.undergoStoreClass.setText((String)viewItem.get("undergoStoreClass"));
			holder.undergoNum.setText((String)viewItem.get("undergoNum"));
			holder.goButton.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
//					DialogUtil.alert("text", UndergolistActivity.this);
					Intent intent = new Intent();
					//intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
					intent.setClass(UndergolistActivity.this,
								AddGoodslistActivity.class);
					startActivity(intent);
				}
			});

			return convertView;
		}

	}
}