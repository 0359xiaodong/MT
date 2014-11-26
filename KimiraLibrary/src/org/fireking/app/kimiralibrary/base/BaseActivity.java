package org.fireking.app.kimiralibrary.base;

import java.util.List;

import com.google.inject.Inject;

import roboguice.activity.RoboActionBarActivity;
import roboguice.context.event.OnCreateEvent;
import roboguice.event.Observes;
import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;

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

	/**
	 * ��ȡfragment���������
	 * 
	 * @return
	 */
	protected FragmentTransaction getFragmentTransaction() {
		return getSupportFragmentManager().beginTransaction();
	}

	/**
	 * ��ʾactivity�е�ĳ��fragment
	 */
	protected void showFragment(int index) {
		FragmentTransaction ftx = getFragmentTransaction();
		List<Fragment> fragments = getSupportFragmentManager().getFragments();
		Fragment f = fragments.get(index);
		ftx.show(f).commit();
	}

	/**
	 * ����activity�е�����fragment
	 */
	protected void hideFragment() {
		FragmentTransaction ftx = getFragmentTransaction();
		List<Fragment> fragments = getSupportFragmentManager().getFragments();
		for (Fragment f : fragments) {
			ftx.hide(f);
		}
		ftx.commit();
	}

	/**
	 * ���fragmnet��activity��ȥ
	 */
	protected void attachFragments(int resId, Fragment[] fragments) {
		FragmentTransaction ftx = getFragmentTransaction();
		for (Fragment f : fragments) {
			ftx.add(resId, f);
		}
		ftx.commit();
	}
}
