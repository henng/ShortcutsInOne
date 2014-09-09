package com.my61.oneclick.func;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import android.content.Context;
import android.net.ConnectivityManager;

public class DataSwitch {
	
	
	//获取移动数据开关状态  
    private boolean getMobileDataStatus(Context context)  
    {  
        String methodName = "getMobileDataEnabled"; 
        
	    ConnectivityManager mConnectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);  
        Class cmClass = mConnectivityManager.getClass();  
        Boolean isOpen = null;  
          
        try   
        {  
            Method method = cmClass.getMethod(methodName, null);  
  
            isOpen = (Boolean) method.invoke(mConnectivityManager, null);  
        }   
        catch (Exception e)   
        {  
            e.printStackTrace();  
        }  
        return isOpen;  
    }
	

	private void setMobileData(Context context, boolean enabled) {  
		
	    ConnectivityManager conMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);  
	    Class<?> conMgrClass = null; // ConnectivityManager类  
	    Field iConMgrField = null; // ConnectivityManager类中的字段  
	    Object iConMgr = null; // IConnectivityManager类的引用  
	    Class<?> iConMgrClass = null; // IConnectivityManager类  
	    Method setMobileDataEnabledMethod = null; // setMobileDataEnabled方法  
	    
	    try {   
	    // 取得ConnectivityManager类   
	    conMgrClass = Class.forName(conMgr.getClass().getName());   
	    // 取得ConnectivityManager类中的对象mService   
	    iConMgrField = conMgrClass.getDeclaredField("mService");   
	    // 设置mService可访问  
	    iConMgrField.setAccessible(true);   
	    // 取得mService的实例化类IConnectivityManager   
	    iConMgr = iConMgrField.get(conMgr);   
	    // 取得IConnectivityManager类   
	    iConMgrClass = Class.forName(iConMgr.getClass().getName());   
	    // 取得IConnectivityManager类中的setMobileDataEnabled(boolean)方法   
	    setMobileDataEnabledMethod = iConMgrClass.getDeclaredMethod("setMobileDataEnabled", Boolean.TYPE);   
	    // 设置setMobileDataEnabled方法可访问   
	    setMobileDataEnabledMethod.setAccessible(true);   
	    // 调用setMobileDataEnabled方法   
	    setMobileDataEnabledMethod.invoke(iConMgr, enabled);  
	    } 
	    catch (ClassNotFoundException e) {   
	        e.printStackTrace();  
	    } catch (NoSuchFieldException e) {   
	        e.printStackTrace();  
	    } catch (SecurityException e) {   
	        e.printStackTrace();  
	    } catch (NoSuchMethodException e) {   
	        e.printStackTrace();  
	    } catch (IllegalArgumentException e) {   
	        e.printStackTrace();  
	    } catch (IllegalAccessException e) {   
	        e.printStackTrace();  
	    } catch (InvocationTargetException e) {   
	        e.printStackTrace();  
	    } 
	}
	
	public void OnClick(Context context) {
		
		if (getMobileDataStatus(context)) {
			setMobileData(context, false);
		}else {
			setMobileData(context, true);
		}
	}
	
}
