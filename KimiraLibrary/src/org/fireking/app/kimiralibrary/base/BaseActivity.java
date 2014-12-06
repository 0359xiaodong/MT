package org.fireking.app.kimiralibrary.base;

import roboguice.activity.RoboActionBarActivity;
import roboguice.context.event.OnCreateEvent;
import roboguice.event.Observes;
import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * activity的基类<br />
 * 完成activity的功能的初始化操作
 * 
 * @author join
 * 
 */
public abstract class BaseActivity extends RoboActionBarActivity {

	/**
	 * 路由器<br />
	 * 普通跳转操作
	 * 
	 * @param aty
	 *            元activity
	 * @param clazz
	 *            目标对象
	 */
	protected void router(Activity aty, Class<? extends Activity> clazz) {
		Intent intent = new Intent(aty, clazz);
		startActivity(intent);
	}

	/**
	 * 路由器<br />
	 * 进行普通跳转操作
	 * 
	 * @param aty
	 *            元activity
	 * @param clazz
	 *            目标对象
	 * @param requestCode
	 *            请求编号
	 */
	protected void router(Activity aty, Class<? extends Activity> clazz,
			int requestCode) {
		Intent intent = new Intent(aty, clazz);
		startActivityForResult(intent, requestCode);
	}

	/**
	 * 在oncreate之后执行
	 * 
	 * @param onCreate
	 */
	protected void doSomethingsOnCreate(@Observes OnCreateEvent onCreate) {
	}

	protected void addFragments(int rId, Fragment[] fragments) {
		FragmentTransaction tx = getTransaction();
		for (Fragment f : fragments) {
			tx.add(rId, f);
		}
		tx.commit();
	}

	protected void hideFragments(Fragment[] fragments) {
		FragmentTransaction tx = getTransaction();
		for (Fragment f : fragments) {
			tx.hide(f);
		}
		tx.commit();
	}

	/**
	 * 显示fragment
	 * 
	 * @param fragment
	 */
	protected void showFragment(Fragment fragment) {
		FragmentTransaction tx = getTransaction();
		tx.show(fragment);
		tx.commit();
	}

	/**
	 * 获取fragmenttransaction
	 * 
	 * @return
	 */
	protected FragmentTransaction getTransaction() {
		return getManager().beginTransaction();
	}

	/**
	 * 获取fragmentmanager
	 * 
	 * @return
	 */
	protected FragmentManager getManager() {
		return getSupportFragmentManager();
	}

}
