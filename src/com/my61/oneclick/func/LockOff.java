package com.my61.oneclick.func;

import com.my61.oneclick.main.R;

import android.app.Activity;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LockOff extends Activity{

	private DevicePolicyManager devicePolicyManager;  
    private ComponentName componentName; //声明用到的两个类的变量
  

    @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		OnClick();
    }
    
	public void OnClick() {
        
		devicePolicyManager = (DevicePolicyManager) getSystemService(Context.DEVICE_POLICY_SERVICE); 
        componentName = new ComponentName(this, LockReceiver.class); 
        
        if ( devicePolicyManager.isAdminActive(componentName) ) {//判断是否有权限(激活了设备管理器) 
        	devicePolicyManager.lockNow();// 直接锁屏 
            android.os.Process.killProcess(android.os.Process.myPid()); 
        }else{ 
            ActiveManager();//激活设备管理器获取权限 
            
        }     
    }
	
	
	// 解除绑定
    private void Bind(View v){
     
    	if(componentName != null){
    	devicePolicyManager.removeActiveAdmin(componentName);
        ActiveManager();
     }
    
    }
    
    
    @Override 
    protected void onResume() {//这个用来在或得激活后返回时锁屏
        if (devicePolicyManager.isAdminActive(componentName)) { 
        	devicePolicyManager.lockNow(); 
            android.os.Process.killProcess(android.os.Process.myPid()); 
        } 
        super.onResume(); 
    } 
	
	
    private void ActiveManager() { 
        
    	//使用隐式意图调用系统方法来激活指定的设备管理器 
        Intent intent = new Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN); 
        intent.putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN, componentName); 
        intent.putExtra(DevicePolicyManager.EXTRA_ADD_EXPLANATION, "锁定屏幕"); 
        startActivityForResult(intent, 10001);
    } 
	
}
