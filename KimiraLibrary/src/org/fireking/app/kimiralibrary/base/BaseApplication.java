package org.fireking.app.kimiralibrary.base;

import roboguice.RoboGuice;
import android.app.Application;

/**
 * application���࣬���г�ʼ������
 * 
 * @author join
 * 
 */
public class BaseApplication extends Application {

	@Override
	public void onCreate() {
		super.onCreate();
		RoboGuice.setUseAnnotationDatabases(false);
	}

	@Override
	public void onTerminate() {
		super.onTerminate();
	}
}
