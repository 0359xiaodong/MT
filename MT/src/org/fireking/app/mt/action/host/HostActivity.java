package org.fireking.app.mt.action.host;

import org.fireking.app.kimiralibrary.base.BaseActivity;
import org.fireking.app.mt.R;
import org.fireking.app.mt.action.host.fragment.BusFragment;
import org.fireking.app.mt.action.host.fragment.GroupFragment;
import org.fireking.app.mt.action.host.fragment.MoreFragment;
import org.fireking.app.mt.action.host.fragment.OwnerFragment;

import roboguice.context.event.OnCreateEvent;
import roboguice.event.Observes;
import roboguice.inject.ContentView;
import roboguice.inject.InjectView;
import android.support.v4.app.Fragment;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

/**
 * �����activity����<br />
 * �ṩ�ײ��л���ť
 * 
 * @author join
 * 
 */
@ContentView(R.layout.activity_host)
public class HostActivity extends BaseActivity {

	@InjectView(R.id.host_radiogroup)
	RadioGroup hostRadioGroup;// �ײ���ť��
	private Fragment[] fragments = new Fragment[] { new GroupFragment(),
			new BusFragment(), new OwnerFragment(), new MoreFragment() };

	@Override
	protected void doSomethingsOnCreate(@Observes OnCreateEvent onCreate) {
		// ������е�fragment��activity��
		attachFragments(R.id.content, fragments);
		// ����radiobutton�ı仯����ʵ��fragment�Ķ�̬�л�
		hostRadioGroup.setOnCheckedChangeListener(onCheckedChangeListener);
	}

	/**
	 * �л�fragment<br />
	 * 
	 */
	OnCheckedChangeListener onCheckedChangeListener = new OnCheckedChangeListener() {

		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId) {
			int count = group.getChildCount();
			hideFragment();
			for (int i = 0; i < count; i++) {
				RadioButton button = (RadioButton) group.getChildAt(i);
				if (button.isChecked()) {
					showFragment(i);
				}
			}
		}
	};

}
