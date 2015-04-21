package com.jing.Chat;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ListView;
import android.widget.EditText;
import android.view.View.OnClickListener;

public class MsgMain extends Activity{
	
	private ListView msgListView;
	private EditText inputText;
	private Button button;
	private MsgAdapter adapter;
	private List<Msg> msglist =new ArrayList<Msg>();
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.chat);
		initMsgs();
		adapter=new MsgAdapter(MsgMain.this,R.layout.msg_item,msglist);
		inputText=(EditText)findViewById(R.id.input_text);
		button=(Button)findViewById(R.id.send);
		msgListView=(ListView)findViewById(R.id.msg_list_view);
		msgListView.setAdapter(adapter);
		button.setOnClickListener(new OnClickListener() {
			

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String content=inputText.getText().toString();
				if(!"".equals(content)){
					Msg msg=new Msg(content,Msg.TYPE_SEND);
					msglist.add(msg);
					adapter.notifyDataSetChanged();
					//用于通知列表的数据发生了变化，当有新消息时，刷新ListView中的显示
					msgListView.setSelection(msglist.size());//将ListView定位到最后一行
	                inputText.setText("");	
				}
			}
		});
		
	}
	private void initMsgs(){
		Msg msg1=new Msg("hello,beauty!",Msg.TYPE_RECEIVED);
		msglist.add(msg1);
		Msg msg2=new Msg("hello,Who is that",Msg.TYPE_SEND);
		msglist.add(msg2);
		Msg msg3=new Msg("This is Jane,Nice Talking to you",Msg.TYPE_RECEIVED);
		msglist.add(msg3);
		
		
	}

}
