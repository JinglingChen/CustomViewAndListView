package com.jing.ListView;
import com.jing.Chat.*;
import java.util.ArrayList;
import java.util.List;

import android.view.View;
import android.app.Activity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
//import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListViewTest extends Activity{
	/*private String[] data={"apple","banana","orange","watermelon","pear",
			"grape","pineapple","strawberry","cherry","mango"};
	*/
	private List<Fruit> fruitlist=new ArrayList<Fruit>();
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listview);
		/* ArrayAdapter<String> adapter= new ArrayAdapter<String>(ListViewTest.this,
				android.R.layout.simple_list_item_1,data);
				*/
		initFruit();//初始化水果数据
		FruitAdapter adapter=new FruitAdapter(ListViewTest.this,R.layout.fruit_item,fruitlist);
		ListView listview=(ListView)findViewById(R.id.list_view);
		listview.setAdapter(adapter);
		listview.setOnItemClickListener(new OnItemClickListener(){
			@Override
			public void onItemClick(AdapterView<?> parent,View view,int position,long id){
				Fruit fruit =fruitlist.get(position);
				Toast.makeText(ListViewTest.this, fruit.getName(), Toast.LENGTH_SHORT).show();		
			}
		});
		
	}
	private void initFruit(){
		Fruit apple = new Fruit("Apple",R.drawable.love_heart);
		fruitlist.add(apple);
		Fruit banana = new Fruit("Banana",R.drawable.love_heart);
		fruitlist.add(banana);
		Fruit orange = new Fruit("Orange",R.drawable.love_heart);
		fruitlist.add(orange);
		Fruit watermelon = new Fruit("Watermelon",R.drawable.love_heart);
		fruitlist.add(watermelon);
		Fruit pear = new Fruit("Pear",R.drawable.love_heart);
		fruitlist.add(pear);
		Fruit grape = new Fruit("Grape",R.drawable.love_heart);
		fruitlist.add(grape);
		Fruit pineapple = new Fruit("Pineapple",R.drawable.love_heart);
		fruitlist.add(pineapple);
		Fruit strawberry = new Fruit("Strawberry",R.drawable.love_heart);
		fruitlist.add(strawberry);
		Fruit cherry = new Fruit("Cherry",R.drawable.love_heart);
		fruitlist.add(cherry);
		Fruit mango = new Fruit("Mango",R.drawable.love_heart);
		fruitlist.add(mango);
	}

}
