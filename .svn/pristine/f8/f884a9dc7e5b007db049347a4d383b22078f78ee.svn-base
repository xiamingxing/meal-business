package com.meal.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.text.style.SuperscriptSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.meal.activity.ipml.AsynThreadImpl;
import com.meal.activity.ipml.UIThreadImpl;
import com.meal.util.HttpUtil;

public class StorelistActivity extends BaseActivity {
	
	List<Map<String, Object>> dataList;
	
	ListView storeList;
	TextView storeName;
	Button retButton;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.storelist_activity);
        initWidget();
//        initial();
//        startAsynThread("send");
        
        
        
    }
	

	private void initWidget()
	{
		storeList = (ListView)findViewById(R.id.storeList);
		storeName = (TextView)findViewById(R.id.storeName);
		retButton = (Button)findViewById(R.id.retButton);
		retButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				StorelistActivity.this.finish();
			}
		});
		fakeListItemCreate();//演示专用
	}
	private void fakeListItemCreate()
	{
		SimpleAdapter adapter = new SimpleAdapter(this,getData(),R.layout.storelistitem,
				new String[]{"img","storename"},
				new int[]{R.id.storeImage,R.id.storeName});
		storeList.setAdapter(adapter);
		storeList.setOnItemClickListener(new OnItemClickListener() {
			
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(StorelistActivity.this, GoodslistActivity.class);
//				intent.putExtra("lv_item_id", id);
				startActivity(intent);
//				startActivity(intent);
			}
		});
	}

	private List<Map<String, Object>> getData()
	{
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("img", R.drawable.qinlicheng);
		map.put("storename", "秦立成百货");
		list.add(map);

		map = new HashMap<String, Object>();
		map.put("img", R.drawable.yigou);
		map.put("storename", "易购便利店");
		list.add(map);

		map = new HashMap<String, Object>();
		map.put("img", R.drawable.lianhua);
		map.put("storename", "联华快客");
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put("img", R.drawable.jingkelong);
		map.put("storename", "京客隆");
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put("img", R.drawable.baoxingcheng);
		map.put("storename", "宝行程便利店");
		list.add(map);
		
		return list;
		
	}
}
