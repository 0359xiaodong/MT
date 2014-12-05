package org.fireking.app.kimiralibrary.base;

import java.util.ArrayList;
import java.util.List;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * @ClassName KimiraAdapter
 * @Description ʹ�õĹ���adapter
 * @Version 1.0
 * @param <T>
 * @Author ���� (514260663@qq.com)
 * @Creation 2014-12-4 ����5:14:51
 * @Mender ���� (514260663@qq.com)
 * @Modification 2014-12-4 ����5:14:51
 * 
 */
public abstract class KimiraAdapter<T> extends BaseAdapter {

	private List<T> mlist = new ArrayList<T>();

	/**
	 * @Name add
	 * @Description �������
	 * @return void
	 * @Author ���� (514260663@qq.com)
	 * @Date 2014-12-4 ����5:15:45
	 * 
	 */
	public void add(List<T> mlist) {
		this.mlist = mlist;
		notifyDataSetChanged();
	}

	/**
	 * @Name remove
	 * @Description ɾ������
	 * @return void
	 * @Author ���� (514260663@qq.com)
	 * @Date 2014-12-4 ����5:16:00
	 * 
	 */
	public void remove() {

	}

	/**
	 * @Name clear
	 * @Description ���
	 * @return void
	 * @Author ���� (514260663@qq.com)
	 * @Date 2014-12-4 ����5:16:22
	 * 
	 */
	public void clear() {

	}

	/**
	 * @Name append
	 * @Description ׷������
	 * @return void
	 * @Author ���� (514260663@qq.com)
	 * @Date 2014-12-4 ����5:16:51
	 * 
	 */
	public void append(List<T> mlist) {
		this.mlist.addAll(mlist);
		notifyDataSetChanged();
	}

	@Override
	public int getCount() {
		return mlist.size();
	}

	@Override
	public Object getItem(int position) {
		return mlist.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		return extralView(position, convertView, parent);
	}

	/**
	 * @Name extralView
	 * @Description �����߼�����
	 * @param position
	 * @param convertView
	 * @param parent
	 * @return View
	 * @Author ���� (514260663@qq.com)
	 * @Date 2014-12-4 ����5:19:21
	 * 
	 */
	public abstract View extralView(int position, View convertView,
			ViewGroup parent);
}
