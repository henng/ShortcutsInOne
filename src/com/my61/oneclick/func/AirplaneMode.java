package com.my61.oneclick.func;

import java.io.DataOutputStream;
import android.annotation.SuppressLint;
import android.app.Activity;  
import android.content.BroadcastReceiver;  
import android.content.ContentResolver;
import android.content.Context;  
import android.content.Intent;  
import android.content.IntentFilter;  
import android.os.Build;
import android.os.Bundle;  
import android.provider.Settings;  
import android.provider.Settings.Global;
import android.view.View;  
import android.view.View.OnClickListener;  
import android.widget.Button;  
import android.widget.Toast; 


public class AirplaneMode {
	
	
	
	/**
	 * 应用程序运行命令获取 Root权限，设备必须已破解(获得ROOT权限)
	 *
	 * @return 应用程序是/否获取Root权限
	 */
	public static boolean upgradeRootPermission(String pkgCodePath) {
		
	    Process process = null;
	    DataOutputStream os = null;
	    
	    try {
	        String cmd="chmod 777 " + pkgCodePath;
	        process = Runtime.getRuntime().exec("su"); //切换到root帐号
	        os = new DataOutputStream(process.getOutputStream());
	        os.writeBytes(cmd + "\n");
	        os.writeBytes("exit\n");
	        os.flush();
	        process.waitFor();
	    } catch (Exception e) {
	        return false;
	    } finally {
	        try {
	            if (os != null) {
	                os.close();
	            }
	            process.destroy();
	        } catch (Exception e) {
	        }
	    }
	    return true;
	    
	}
	


	/** 
	 * 判断手机是否是飞行模式 
	 * @param context 
	 * @return 
	 */  
	//获取当前的飞行模式状态  需要根据不同的Android版本进行修改
	
	@SuppressLint("NewApi")
	@SuppressWarnings("deprecation")
	public boolean getAirplaneModeStatus(Context context){  

		if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR1) //4.2以下
	     {
	         return Settings.System.getInt(context.getContentResolver(), 
	                 Settings.System.AIRPLANE_MODE_ON, 0) != 0;          
	     } 
	     else //4.2或4.2以上
	     {
	         return Settings.Global.getInt(context.getContentResolver(), 
	                 Settings.Global.AIRPLANE_MODE_ON, 0) != 0;
	     } 
		
	}  
	
	
      
    //开启或关闭飞行模式  
	@SuppressLint("NewApi")
	@SuppressWarnings("deprecation")
    private void setAirplaneMode(Context context, boolean enable)  
    {  
/*        Settings.System.putInt(context.getContentResolver(),  
                Settings.System.AIRPLANE_MODE_ON, enable ? 1 : 0); 
        //Android 4.2 以上已经失效。
*/       
    	upgradeRootPermission(context.getPackageCodePath());
		
		if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR1)
		{
			Settings.System.putInt(context.getContentResolver(),  
	                          Settings.System.AIRPLANE_MODE_ON, enable ? 1:0);  
	    }
		else //4.2或4.2以上 
	    {
			Settings.Global.putInt(context.getContentResolver(), Global.AIRPLANE_MODE_ON, enable? 1 : 0);  
	    }  
 
		
        Intent intent = new Intent(Intent.ACTION_AIRPLANE_MODE_CHANGED);  
        intent.putExtra("state", enable);  
        context.sendBroadcast(intent);  
    }
	
    
    public void onClick(Context context)  
    {  
        // TODO Auto-generated method stub  
        if (getAirplaneModeStatus(context))  
        {  
            setAirplaneMode(context, false);  
        }  
        else  
        {  
            setAirplaneMode(context, true);  
        }  
    }
	
}
