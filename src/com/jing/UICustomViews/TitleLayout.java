package com.jing.UICustomViews;
import com.jing.Chat.*;
import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class TitleLayout extends LinearLayout{
	public TitleLayout(Context context,AttributeSet attrs){
		super(context,attrs);
		LayoutInflater.from(context).inflate(R.layout.title,this);
		Button backbutton =(Button) findViewById(R.id.back_button);
		Button titleedit =(Button) findViewById(R.id.edit1);
		backbutton.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v){
				((Activity) getContext()).finish();
			}
			}
		);
		titleedit.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v){
				Toast.makeText(getContext(), "You clicked Edit button!", Toast.LENGTH_SHORT).show();
			}
		}
	);

}
}
