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
 * activity�Ļ���<br />
 * ���activity�Ĺ��ܵĳ�ʼ������
 * 
 * @author join
 * 
 */
public abstract class BaseActivity extends RoboActionBarActivity {

	/**
	 * ·����<br />
	 * ��ͨ��ת����
	 * 
	 * @param aty
	 *            Ԫactivity
	 * @param clazz
	 *            Ŀ�����
	 */
	protected void router(Activity aty, Class<? extends Activity> clazz) {
		Intent intent = new Intent(aty, clazz);
		startActivity(intent);
	}

	/**
	 * ·����<br />
	 * ������ͨ��ת����
	 * 
	 * @param aty
	 *            Ԫactivity
	 * @param clazz
	 *            Ŀ�����
	 * @param requestCode
	 *            ������
	 */
	protected void router(Activity aty, Class<? extends Activity> clazz,
			int requestCode) {
		Intent intent = new Intent(aty, clazz);
		startActivityForResult(intent, requestCode);
	}

	/**
	 * ��oncreate֮��ִ��
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
	 * ��ʾfragment
	 * 
	 * @param fragment
	 */
	protected void showFragment(Fragment fragment) {
		FragmentTransaction tx = getTransaction();
		tx.show(fragment);
		tx.commit();
	}

	/**
	 * ��ȡfragmenttransaction
	 * 
	 * @return
	 */
	protected FragmentTransaction getTransaction() {
		return getManager().beginTransaction();
	}

	/**
	 * ��ȡfragmentmanager
	 * 
	 * @return
	 */
	protected FragmentManager getManager() {
		return getSupportFragmentManager();
	}

}
