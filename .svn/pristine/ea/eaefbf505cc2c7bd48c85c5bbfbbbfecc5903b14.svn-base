package com.meal.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.support.v4.util.LruCache;
import android.util.Log;

import com.meal.bean.Global;

public class FileCacheUtil {

	private File mCacheDir = null;
	
	private static final String DefaultCacheDir = "";

	private static final int MAX_CACHE_SIZE = 20 * 1024 * 1024; // 20M

	private static BitmapFactory.Options sBitmapOptions;

	private LruCache<String, Long> sFileCache = null;

	private static FileCacheUtil instance = null;

	static {

		sBitmapOptions = new BitmapFactory.Options();
		sBitmapOptions.inPurgeable = true; // bitmap can be purged to disk

	}

	private FileCacheUtil() {

		sFileCache = new LruCache<String, Long>(MAX_CACHE_SIZE) {

			@Override
			public int sizeOf(String key, Long value) {

				return value.intValue();

			}

			@Override
			protected void entryRemoved(boolean evicted, String key,
					Long oldValue, Long newValue) {

				File file = getFile(key);

				if (file != null) {

					file.delete();

				}

			}

		};

	}

	public static FileCacheUtil getInstance(Context context) {

		if (null == instance) {

			instance = new FileCacheUtil();

		}

		instance.setmCacheDir(context.getCacheDir());

		return instance;

	}
	
	public static FileCacheUtil getInstance() {

		if (null == instance) {

			instance = new FileCacheUtil();

		}
		
		instance.setmCacheDir(new File(DefaultCacheDir));

		return instance;

	}

	private File getFile(String fileName) {

		File file = new File(getmCacheDir(), fileName);

		if (!file.exists() || !file.isFile()) {

			try {

				throw new FileNotFoundException("文件不存在或有同名文件夹");

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block

				e.printStackTrace();

			}

		}

		return file;

	}

	// 获取bitmap
	public Bitmap getBitmap(String key) {

		File bitmapFile = getFile(key);

		Bitmap bitmap = null;

		if (bitmapFile != null) {

			try {

				bitmap = BitmapFactory.decodeStream(new FileInputStream(
						bitmapFile), null, sBitmapOptions);

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block

				e.printStackTrace();

			}

			if (bitmap != null) {

				// 重新将其缓存至硬引用中
				Global.multiCache.putBitmap(key, bitmap);

			}

		}
		return bitmap;

	}

	// 缓存bitmap到外部存储
	public boolean putBitmap(String key, Bitmap bitmap) {

		boolean result = false;

		File file = getFile(key);

		if (file != null) {

			Log.v("tag", "文件已经存在");

			result = true;

		} else {

			FileOutputStream fos = getOutputStream(key);

			boolean saved = bitmap.compress(CompressFormat.JPEG, 100, fos);

			try {

				fos.flush();
				fos.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block

				e.printStackTrace();

			}

			if (saved) {

				synchronized (sFileCache) {

					sFileCache.put(key, getFile(key).length());

				}

				result = true;

			}

		}

		return result;

	}

	// 根据key获取OutputStream
	private FileOutputStream getOutputStream(String key) {

		FileOutputStream fos = null;

		if (null != getmCacheDir()) {

			try {
				
				fos = new FileOutputStream(getmCacheDir().getAbsolutePath()
						+ File.separator + key);
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				
				e.printStackTrace();
				
			}

		}

		return fos;

	}

	public File getmCacheDir() {
		return mCacheDir;
	}

	public void setmCacheDir(File mCacheDir) {
		this.mCacheDir = mCacheDir;
	}

}
