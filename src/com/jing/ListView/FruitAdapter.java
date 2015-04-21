package com.jing.ListView;
import com.jing.Chat.*;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class FruitAdapter extends ArrayAdapter<Fruit>{
	private int resourceId;
	public FruitAdapter(Context context,int textResourceId,List<Fruit> objects){
		super(context,textResourceId,objects);
		resourceId=textResourceId;
	}
	public View getView(int position,View convertView,ViewGroup parent){
		Fruit fruit=getItem(position);
		View view;
		ViewHolder viewHolder =new ViewHolder();
		if(convertView==null)
			{view=LayoutInflater.from(getContext()).inflate(resourceId, null);
			viewHolder.fruitImage=(ImageView) view.findViewById(R.id.fruit_image);
			viewHolder.fruitText=(TextView) view.findViewById(R.id.fruit_name);
			view.setTag(viewHolder);
			}
		else {view=convertView;
		      viewHolder = (ViewHolder) view.getTag();
			}
		viewHolder.fruitImage.setImageResource(fruit.getImageId());
		viewHolder.fruitText.setText(fruit.getName());
		return view;		
	}
	class ViewHolder{
		ImageView fruitImage;
		TextView fruitText;
	}
	
}
