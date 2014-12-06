package org.fireking.app.kimiralibrary.plugs.baidu_location;

import android.app.Service;
import android.content.Context;
import android.os.Vibrator;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.location.LocationClientOption.LocationMode;

/**
 * @ClassName BaiduLocation
 * @Description �ٶȶ�λ������
 * @Version 1.0
 * @Author ���� (514260663@qq.com)
 * @Creation 2014-12-4 ����9:50:36
 * @Mender ���� (514260663@qq.com)
 * @Modification 2014-12-4 ����9:50:36
 * 
 */
public class BaiduLocation {

	// �ٶȶ�λ
	public LocationClient mLocationClient;
	public MyLocationListener mMyLocationListener;
	public Vibrator mVibrator;
	private BDLocation mDBLocation = null;
	OnLocationListener mOnLocationListener;
	Context context;

	public BaiduLocation(Context context) {
		this.context = context;
	}

	/**
	 * @ClassName MyLocationListener
	 * @Description �ٶȶ�λ�ص�
	 * @Version 1.0
	 * @Author ���� (514260663@qq.com)
	 * @Creation 2014-12-5 ����3:40:07
	 * @Mender ���� (514260663@qq.com)
	 * @Modification 2014-12-5 ����3:40:07
	 * 
	 */
	public class MyLocationListener implements BDLocationListener {

		@Override
		public void onReceiveLocation(BDLocation location) {
			mOnLocationListener.getLocation(location);
			setDBLocation(location);
		}
	}

	/**
	 * @Name setDBLocation
	 * @Description ���ö�λ����������Ϣ
	 * @param location
	 * @return void
	 * @Author ���� (514260663@qq.com)
	 * @Date 2014-12-5 ����3:40:28
	 * 
	 */
	public void setDBLocation(BDLocation location) {
		this.mDBLocation = location;
	}

	/**
	 * @Name getDBLocation
	 * @Description ��ȡ��λ����Ϣ
	 * @return
	 * @return BDLocation
	 * @Author ���� (514260663@qq.com)
	 * @Date 2014-12-5 ����3:40:57
	 * 
	 */
	private BDLocation getDBLocation() {
		return mDBLocation;
	}

	/**
	 * @Name setOnLocationListener
	 * @Description ���ö�λ����
	 * @param onLocationListener
	 * @return void
	 * @Author ���� (514260663@qq.com)
	 * @Date 2014-12-5 ����3:41:25
	 * 
	 */
	public void setOnLocationListener(OnLocationListener onLocationListener) {
		this.mOnLocationListener = onLocationListener;
	}

	/**
	 * @Name initBaiduLocation
	 * @Description ��ʼ����λ����
	 * @return void
	 * @Author ���� (514260663@qq.com)
	 * @Date 2014-12-5 ����3:41:44
	 * 
	 */
	public void initBaiduLocation() {
		mLocationClient = new LocationClient(context);
		mMyLocationListener = new MyLocationListener();
		mLocationClient.registerLocationListener(mMyLocationListener);
		mVibrator = (Vibrator) context
				.getSystemService(Service.VIBRATOR_SERVICE);
		LocationClientOption option = new LocationClientOption();
		option.setLocationMode(LocationMode.Hight_Accuracy);// ���ö�λģʽ
		option.setCoorType("bd09ll");// ���صĶ�λ����ǰٶȾ�γ�ȣ�Ĭ��ֵgcj02
		int span = 1000;
		option.setScanSpan(span);// ���÷���λ����ļ��ʱ��Ϊ5000ms
		option.setIsNeedAddress(true);
		mLocationClient.setLocOption(option);
	}
}
