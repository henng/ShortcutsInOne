package com.my61.oneclick.func;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.provider.Settings.SettingNotFoundException;

public class RotateSwitch {

	
	//得到屏幕旋转的状态  
    private int getRotationStatus(Context context)  
    {  
        int status = 0;  
        try  
        {  
            status = android.provider.Settings.System.getInt(context.getContentResolver(),  
                    android.provider.Settings.System.ACCELEROMETER_ROTATION);  
        }  
        catch (SettingNotFoundException e)  
        {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
        return status;  
    }  
    
  
    private void setRotationStatus(ContentResolver resolver, int status)  
    {  
        //得到uri  
        Uri uri = android.provider.Settings.System.getUriFor("accelerometer_rotation");  
        //沟通设置status的值改变屏幕旋转设置  
        android.provider.Settings.System.putInt(resolver, "accelerometer_rotation", status);  
        //通知改变  
        resolver.notifyChange(uri, null);  
    }  
  
 
    public void onClick(Context context)  
    {  
        // TODO Auto-generated method stub  
  
        if (getRotationStatus(context) == 1)  
        {  
           
            setRotationStatus(context.getContentResolver(), 0);  
        }  
        else  
        {  
            setRotationStatus(context.getContentResolver(), 1);  
        }  
    }
	
}
