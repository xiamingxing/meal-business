package com.meal.action;

import android.graphics.Bitmap;

import com.meal.bean.Global;
import com.meal.util.HttpUtil;
import com.meal.util.JSONFactoryUtil;
import com.meal.util.ParamsFactory;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author xiamingxing
 * 
 */
public abstract class BaseAction {

	/**
	 * @param module
	 * @param action
	 * @param targetCls
	 * @param paramsMap
	 * @return
	 */
	public Object load(String module, String action, Class<?> targetCls,
			HashMap paramsMap) {

		Object result = null;

		if (null != module && null != action) {

			ParamsFactory paramsFactory = new ParamsFactory();
			String parameters = paramsFactory.parser(paramsMap);
			JSONObject jsonObject = HttpUtil.Get(module, action, parameters);

			result = (null == targetCls) ? jsonObject : JSONFactoryUtil
					.parserToJavaBeanObject(jsonObject, targetCls);

		}

		return result;

	}

	/**
	 * @param module
	 * @param action
	 * @param paramsMap
	 * @return
	 */
	public boolean load(String module, String action, HashMap paramsMap) {

		boolean result = false;

		if (null != module && null != action) {

			ParamsFactory paramsFactory = new ParamsFactory();
			String parameters = paramsFactory.parser(paramsMap);

			if (null != HttpUtil.Get(module, action, parameters)) {

				result = true;

			}

		}

		return result;

	}

	/**
	 * @param module
	 * @param action
	 * @param javaBeanObject
	 * @param targetCls
	 * @param paramsMap
	 * @return
	 */
	public Object send(String module, String action, Object javaBeanObject,
			Class<?> targetCls, HashMap paramsMap) {

		Object result = null;

		if (null != module && null != action) {

			ParamsFactory paramsFactory = new ParamsFactory();
			String parameters = paramsFactory.parser(paramsMap);
			String postData = JSONFactoryUtil
					.parserToJsonString(javaBeanObject);
			JSONObject jsonObject = HttpUtil.Post(module, action, parameters,
					postData);

			result = (null == targetCls) ? jsonObject : JSONFactoryUtil
					.parserToJavaBeanObject(jsonObject, targetCls);

		}

		return result;
	}

	/**
	 * @param module
	 * @param action
	 * @param javaBeanObject
	 * @param paramsMap
	 * @return
	 */
	public boolean send(String module, String action, Object javaBeanObject,
			HashMap paramsMap) {

		boolean result = false;

		if (null != module && null != action) {

			ParamsFactory paramsFactory = new ParamsFactory();
			String parameters = paramsFactory.parser(paramsMap);
			String postData = JSONFactoryUtil
					.parserToJsonString(javaBeanObject);

			if (null != HttpUtil.Post(module, action, parameters, postData)) {

				result = true;

			}

		}

		return result;

	}

	/**
	 * @param URL
	 * @return
	 */
	public Bitmap loadImage(String URL) {

		Bitmap bmp = null;

		if (null != URL) {

//			if (null != Global.lruCache) {
//
//				bmp = Global.lruCache.getBitmapFromMemCache(URL);
//
//				if (null == bmp) {
//
//					bmp = HttpUtil.DownLoadImage(URL);
//					Global.lruCache.addBitmapToMemoryCache(URL, bmp);
//
//				}
//
//			}

			if (null != URL) {

				if (null != Global.multiCache) {

					bmp = Global.multiCache.getBitmap(URL);

					if (null == bmp) {

						bmp = HttpUtil.DownLoadImage(URL);
						Global.multiCache.putBitmap(URL, bmp);

					}

				}

			}

		}

		return bmp;

	}

	/**
	 * @param module
	 * @param path
	 * @param fileName
	 * @param paramsMap
	 * @return
	 */
	public String upload(String module, String path, String fileName,
			HashMap paramsMap) {

		String fileURL = null;

		File file = new File(path + fileName);

		if (null != file && null != module) {

			ParamsFactory paramsFactory = new ParamsFactory();
			String parameters = paramsFactory.parser(paramsMap);
			HttpUtil.Upload(module, parameters, file);

		}

		return fileURL;

	}

	/**
	 * @param jsonObject
	 * @param javaBeanClass
	 * @param listName
	 * @return
	 */
	public ArrayList<Object> _parserJavaBeanList(JSONObject jsonObject,
			Class<?> javaBeanClass, String listName) {
		ArrayList<Object> list = null;

		if (null != jsonObject && null != javaBeanClass && null != listName) {

			try {

				JSONArray jsonArray = jsonObject.getJSONArray(listName);
				list = _parseJavaBeanList(jsonArray, javaBeanClass);

			} catch (JSONException e) {
				// TODO Auto-generated catch block

				e.printStackTrace();

			}

		}
		return list;

	}

	/**
	 * @param jsonArray
	 * @param javaBeanClass
	 * @return
	 */
	public ArrayList<Object> _parseJavaBeanList(JSONArray jsonArray,
			Class<?> javaBeanClass) {

		ArrayList<Object> list = null;

		if (null != jsonArray) {

			list = new ArrayList<Object>();

			Object item = null;

			for (int i = 0; i < jsonArray.length(); i++) {

				try {

					item = JSONFactoryUtil.parserToJavaBeanObject(
							jsonArray.get(i), javaBeanClass);

				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				list.add(item);

			}

		}

		return list;

	}
}
