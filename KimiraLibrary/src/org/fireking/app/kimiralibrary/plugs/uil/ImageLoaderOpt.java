package org.fireking.app.kimiralibrary.plugs.uil;

import java.io.File;

import android.content.Context;

import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiscCache;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.nostra13.universalimageloader.utils.StorageUtils;

/**
 * @ClassName ImageLoader
 * @Description ImageLoader��������
 * @Version 1.0
 * @Author ���� (514260663@qq.com)
 * @Creation 2014-12-4 ����9:38:09
 * @Mender ���� (514260663@qq.com)
 * @Modification 2014-12-4 ����9:38:09
 * 
 */
public class ImageLoaderOpt {

	/**
	 * @Name getConfig
	 * @Description ����Ĭ�ϵ������ļ�
	 * @param context
	 * @return
	 * @return ImageLoaderConfiguration
	 * @Author ���� (514260663@qq.com)
	 * @Date 2014-12-4 ����9:38:25
	 * 
	 */
	public ImageLoaderConfiguration getConfig(Context context, int empty_resId,
			int fail_resId, int loading_res_Id) {
		File cacheDir = StorageUtils.getCacheDirectory(context);
		ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
				context)
				.memoryCacheExtraOptions(480, 800)
				.threadPoolSize(3)
				.threadPriority(Thread.NORM_PRIORITY - 2)
				.tasksProcessingOrder(QueueProcessingType.FIFO)
				.denyCacheImageMultipleSizesInMemory()
				.memoryCache(new LruMemoryCache(2 * 1024 * 1024))
				.memoryCacheSize(2 * 1024 * 1024)
				.memoryCacheSizePercentage(13)
				.diskCache(new UnlimitedDiscCache(cacheDir))
				.diskCacheSize(50 * 1024 * 1024)
				.diskCacheFileCount(100)
				.diskCacheFileNameGenerator(new Md5FileNameGenerator())
				.imageDownloader(
						new BaseImageDownloader(context, 5 * 1000, 30 * 1000))
				// ���ӳ�ʱ5�룬��ȡ��ʱ30��
				.defaultDisplayImageOptions(
						getDefaultOptions(empty_resId, fail_resId,
								loading_res_Id)).writeDebugLogs().build();
		return config;
	}

	/**
	 * @Name getOptions
	 * @Description ����Ĭ�ϵ� ͼƬ��������
	 * @return
	 * @Author ���� (514260663@qq.com)
	 * @Date 2014-12-4 ����9:39:31
	 */
	public DisplayImageOptions getDefaultOptions(int empty_resId,
			int fail_resId, int loading_res_Id) {
		DisplayImageOptions options = new DisplayImageOptions.Builder()
				.showImageForEmptyUri(empty_resId) // ����ͼƬUriΪ�ջ��Ǵ����ʱ����ʾ��ͼƬ
				.showImageOnFail(fail_resId) // ����ͼƬ���ػ��������з���������ʾ��ͼƬ
				.cacheInMemory(true) // �������ص�ͼƬ�Ƿ񻺴����ڴ���
				.cacheOnDisk(true)// ����Ӳ�̻���
				.showImageOnLoading(loading_res_Id)// ��ͼƬ���ص�ʱ����ʾ��ͼƬ
				.build();
		return options;
	}

}
