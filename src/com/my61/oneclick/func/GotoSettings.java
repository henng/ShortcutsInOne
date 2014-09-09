package com.my61.oneclick.func;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;

public class GotoSettings extends Activity{

	public void GotoSettings() {
		
		Intent intent = new Intent();

		intent.setComponent(new ComponentName("com.android.settings", "com.android.settings.LaunchActivity"));

		startActivity(intent); 
	}
	
}
