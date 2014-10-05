package com.fan.neihan.fragments;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.fan.neihan.R;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener2;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

public class EssayListFragment extends Fragment implements OnClickListener,OnScrollListener,OnRefreshListener2{
	private Handler handler=new Handler(){
		public void handleMessage(android.os.Message msg) {
			int what=msg.what;
			if(what==1){
				//TODO 新消息提醒
				newnofity.setVisibility(View.INVISIBLE);
			}
			
		};
	};

	private View quickTools;
	private TextView newnofity;

	public EssayListFragment() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view=inflater.inflate(R.layout.fragment_essaylist, container,false);
		View title=view.findViewById(R.id.title);
		title.setOnClickListener(this);//标题 点击事件	
		///////////////////////////////////////////////////////////////////////
		PullToRefreshListView refreshListView = (PullToRefreshListView) view
				.findViewById(R.id.essaylist_listview);
		refreshListView.setOnRefreshListener(this);
		ListView listView=refreshListView.getRefreshableView();
		refreshListView.setMode(Mode.BOTH);
		head = inflater.inflate(R.layout.essay_head, listView,false); 
		View quickToolsPublish=head.findViewById(R.id.quick_tools_publish);//listview 的头上的投稿
		View quickToolsReView=head.findViewById(R.id.quick_tools_review);//listview 的头上的审核
		quickToolsPublish.setOnClickListener(this);
		quickToolsReView.setOnClickListener(this);
		listView.addHeaderView(head);
		listView.setOnScrollListener(this);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_list_item_1, new String[] { "abc",
						"dfg", "nihao", "nihao", "nihao", "nihao", "nihao",
						"nihao", "nihao", "nihao", "nihao", "nihao", "nihao",
						"nihao", "nihao", "nihao", "nihao" });
		listView.setAdapter(adapter);
		///////////////////////////////////////////////////////////////////////////////////////////
		//快速工具条菜单
		quickTools = view.findViewById(R.id.quick_tools_float);
		quickTools.setVisibility(View.INVISIBLE);
		View quickPublish=quickTools.findViewById(R.id.quick_tools_publish);//悬浮在空中的发布
		View quickReView=quickTools.findViewById(R.id.quick_tools_review);//悬浮在空中的审核
		quickPublish.setOnClickListener(this);
		quickReView.setOnClickListener(this);
		///////////////////////////////////////////////////////////////////////////////////////////////////
		//新消息的蓝色条
		newnofity = (TextView) view.findViewById(R.id.newnotify);
		newnofity.setVisibility(View.INVISIBLE);
		return view;
	}
	@Override
	public void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.title:
			newnofity.setVisibility(View.VISIBLE);
			handler.sendEmptyMessageDelayed(1, 3000);
			break;
		default:
			break;
		}
	}
	
	
	
	///////////////////////////////////////////////////////////////////////////
	//列表显示工具条
	private int lastIndex=0;

	private View head;
	@Override
	public void onScrollStateChanged(AbsListView view, int scrollState) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onScroll(AbsListView view, int firstVisibleItem,
			int visibleItemCount, int totalItemCount) {
		// TODO Auto-generated method stub
	
		int offset=lastIndex-firstVisibleItem;
		if(offset<0||firstVisibleItem==0){//向上移动  
			Log.i("----", "----shang---");
			if(quickTools!=null){
				quickTools.setVisibility(View.INVISIBLE);
			}
			
		}else if(offset>0){
			Log.i("----", "----xia---");
			quickTools.setVisibility(View.VISIBLE);
//			if(head.getVisibility()==View.VISIBLE){
//				head.setVisibility(View.VISIBLE);
//			}
		}
		lastIndex=firstVisibleItem;
	}
   /////////////////////////////////////////////////////////////////////////////////
	/**
	 * 从上向下拉动，进行新数据加载
	 */
	@Override
	public void onPullDownToRefresh(PullToRefreshBase refreshView) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * 从下向上拉动，进行新数据加载
	 */
	@Override
	public void onPullUpToRefresh(PullToRefreshBase refreshView) {
		// TODO Auto-generated method stub
		
	}
	////////////////////////////////////////////////////////////////////////////////
	
}
