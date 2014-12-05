package org.fireking.app.kimiralibrary.views;

import android.text.Editable;
import android.text.TextWatcher;

/**
 * @ClassName SimpleTextWatcher
 * @Description ��ģ�͵�textwatcher
 * @Version 1.0
 * @Author ���� (514260663@qq.com)
 * @Creation 2014-12-5 ����9:50:52
 * @Mender ���� (514260663@qq.com)
 * @Modification 2014-12-5 ����9:50:52
 * 
 */
public abstract class SimpleTextWatcher implements TextWatcher {

	@Override
	public void beforeTextChanged(CharSequence s, int start, int count,
			int after) {
	}

	@Override
	public abstract void onTextChanged(CharSequence s, int start, int before,
			int count);

	@Override
	public void afterTextChanged(Editable s) {
	}

}
