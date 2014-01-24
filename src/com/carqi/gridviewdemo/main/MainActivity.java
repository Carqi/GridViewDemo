package com.carqi.gridviewdemo.main;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

import com.carqi.gridviewdemo.adapter.GridViewAdapter;
import com.carqi.gridviewdemo.entity.ItemEntity;
import com.carqi.gridviewpractice.R;

public class MainActivity extends Activity {
	private GridView gridview;
	private GridViewAdapter adapter;
	private List<ItemEntity> itemList = new ArrayList<ItemEntity>();
	private Context context;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		init();
		setInitData();
		
	}


	private void init() {
		context = this;
		gridview = (GridView) findViewById(R.id.gridview);

	}
	

	private void setInitData() {
		for (int i = 0; i < 10; i++) {
			ItemEntity entity = new ItemEntity();
			entity.setText("NO." + String.valueOf(i));
			itemList.add(entity);
		}

		adapter = new GridViewAdapter(context, itemList);
		// Ìí¼Ó²¢ÇÒÏÔÊ¾
		gridview.setAdapter(adapter);
		gridview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				setTitle(itemList.get(position).getText());
				
			}
		});
		
	}

}
