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
					//����֪ͨ�б�����ݷ����˱仯����������Ϣʱ��ˢ��ListView�е���ʾ
					msgListView.setSelection(msglist.size());//��ListView��λ�����һ��
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
