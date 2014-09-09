package com.my61.oneclick.func;

import android.content.Context;
import android.media.AudioManager;

public class VibrateSwitch {

	
    //获取手机当前的静音模式状态  
    private int getSilentStatus(Context context)  
    {  
    	AudioManager mAudioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
        return mAudioManager.getRingerMode();  
    }  
    
    
      
    //设置手机的静音、正常、震动模式  
    public void OnClick(Context context)  
    {
    	AudioManager mAudioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);

        switch (getSilentStatus(context))  
        {  
        case AudioManager.RINGER_MODE_SILENT:  
            mAudioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL); 
            mAudioManager.setVibrateSetting(AudioManager.VIBRATE_TYPE_RINGER,AudioManager.VIBRATE_SETTING_OFF);
            mAudioManager.setVibrateSetting(AudioManager.VIBRATE_TYPE_NOTIFICATION,AudioManager.VIBRATE_SETTING_OFF);
            break;  
        case AudioManager.RINGER_MODE_NORMAL:  
            mAudioManager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
            mAudioManager.setVibrateSetting(AudioManager.VIBRATE_TYPE_RINGER,AudioManager.VIBRATE_SETTING_ON);       
            mAudioManager.setVibrateSetting(AudioManager.VIBRATE_TYPE_NOTIFICATION,AudioManager.VIBRATE_SETTING_ON);
            break;        
        case AudioManager.RINGER_MODE_VIBRATE:  
            mAudioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL); 
            mAudioManager.setVibrateSetting(AudioManager.VIBRATE_TYPE_RINGER,AudioManager.VIBRATE_SETTING_OFF);
            mAudioManager.setVibrateSetting(AudioManager.VIBRATE_TYPE_NOTIFICATION,AudioManager.VIBRATE_SETTING_OFF);
            break;  
        }  
    }  
	
}
