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
 * @Description 百度定位配置类
 * @Version 1.0
 * @Author 王刚 (514260663@qq.com)
 * @Creation 2014-12-4 上午9:50:36
 * @Mender 王刚 (514260663@qq.com)
 * @Modification 2014-12-4 上午9:50:36
 * 
 */
public class BaiduLocation {

	// 百度定位
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
	 * @Description 百度定位回调
	 * @Version 1.0
	 * @Author 王刚 (514260663@qq.com)
	 * @Creation 2014-12-5 下午3:40:07
	 * @Mender 王刚 (514260663@qq.com)
	 * @Modification 2014-12-5 下午3:40:07
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
	 * @Description 设置定位到的内容信息
	 * @param location
	 * @return void
	 * @Author 王刚 (514260663@qq.com)
	 * @Date 2014-12-5 下午3:40:28
	 * 
	 */
	public void setDBLocation(BDLocation location) {
		this.mDBLocation = location;
	}

	/**
	 * @Name getDBLocation
	 * @Description 获取定位的信息
	 * @return
	 * @return BDLocation
	 * @Author 王刚 (514260663@qq.com)
	 * @Date 2014-12-5 下午3:40:57
	 * 
	 */
	private BDLocation getDBLocation() {
		return mDBLocation;
	}

	/**
	 * @Name setOnLocationListener
	 * @Description 设置定位监听
	 * @param onLocationListener
	 * @return void
	 * @Author 王刚 (514260663@qq.com)
	 * @Date 2014-12-5 下午3:41:25
	 * 
	 */
	public void setOnLocationListener(OnLocationListener onLocationListener) {
		this.mOnLocationListener = onLocationListener;
	}

	/**
	 * @Name initBaiduLocation
	 * @Description 初始化定位监听
	 * @return void
	 * @Author 王刚 (514260663@qq.com)
	 * @Date 2014-12-5 下午3:41:44
	 * 
	 */
	public void initBaiduLocation() {
		mLocationClient = new LocationClient(context);
		mMyLocationListener = new MyLocationListener();
		mLocationClient.registerLocationListener(mMyLocationListener);
		mVibrator = (Vibrator) context
				.getSystemService(Service.VIBRATOR_SERVICE);
		LocationClientOption option = new LocationClientOption();
		option.setLocationMode(LocationMode.Hight_Accuracy);// 设置定位模式
		option.setCoorType("bd09ll");// 返回的定位结果是百度经纬度，默认值gcj02
		int span = 1000;
		option.setScanSpan(span);// 设置发起定位请求的间隔时间为5000ms
		option.setIsNeedAddress(true);
		mLocationClient.setLocOption(option);
	}
}
