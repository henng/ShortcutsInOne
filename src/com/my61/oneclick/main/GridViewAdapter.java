package com.my61.oneclick.main;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GridViewAdapter extends BaseAdapter{
	
	private static final String TAG = "GridViewAdapter";  
    
	private String[] names = 
    {	
		"Wifi",
		"流量",
		"GPS",
		"蓝牙",
		"锁屏",
		"手电筒",
		"旋转",
		"静音",
		"振动"
	};  
    
    
    private int[] icons = 
    {
    	R.drawable.wifi,
    	R.drawable.wifi,
    	R.drawable.wifi,
    	R.drawable.wifi,
    	R.drawable.wifi,
    	R.drawable.wifi,
    	R.drawable.wifi,
    	R.drawable.wifi,
    	R.drawable.wifi
    };  
    
    private Context context;  
    LayoutInflater infalter; 
    BigFloatWindow mBigFloatWindow;
      
    public GridViewAdapter(BigFloatWindow bigFloatWindow, Context context) {  
        this.context = context;  
               
        this.mBigFloatWindow = bigFloatWindow;
        
        //方法1 通过系统的service 获取到 试图填充器   
        //infalter = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);  
        //方法2 通过layoutinflater的静态方法获取到 视图填充器  
        infalter = LayoutInflater.from(context);  
    }  
    
    
    // 返回gridview里面有多少个条目   
    public int getCount() {  
        return names.length;  
    }  
    
    
    //返回某个position对应的条目   
    public Object getItem(int position) {  
        return position;  
    }  
    
    
    //返回某个position对应的id  
    public long getItemId(int position) {  
        return position;  
    }  
    
    
    //返回某个位置对应的视图   
    public View getView(int position, View convertView, ViewGroup parent) {  
        Log.i(TAG, "GETVIEW " + position);  
        
        
        //把一个布局文件转换成视图  
        View view = infalter.inflate(R.layout.gridview_item, null);  
        ImageView iv =  (ImageView) view.findViewById(R.id.main_gv_iv);  
        TextView  tv =  (TextView)  view.findViewById(R.id.main_gv_tv);  
        
        
        //设置每一个item的名字和图标   
        iv.setImageResource(icons[position]);  
        tv.setText(names[position]);  
        
        return view;  
    }  
}
