package com.meal.action;

import android.graphics.Bitmap;

import com.meal.bean.Constant;
import com.meal.bean.Global;
import com.meal.bean.Seller;
import com.meal.util.HttpUtil;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author
 * 
 */
public class SellerManageAction extends BaseAction {

	private String SELLER_MODULE;
	
	private String SELLER_MODULE_LOGIN;
	private String SELLER_MODULE_LOGOUT;
	private String SELLER_MODULE_REGISTER;
	
	private String SELLER_MODULE_GET_SELLER_INFO;
	private String SELLER_MODULE_GET_SID_BY_SELLERNAME;
	private String SELLER_MODULE_GET_SELLER_LIST_BY_TYPE;
	
	private String SELLER_MODULE_UPDATE_SELLER_INFO;
	private String SELLER_MODULE_OPEN_ORDER_FUNCTION;
	private String SELLER_MODULE_CLOSE_ORDER_FUNCTION;
	

	public SellerManageAction() {

		this.SELLER_MODULE = Constant.SELLER_MODULE;
		
		this.SELLER_MODULE_LOGIN = Constant.SELLER_MODULE_LOGIN;
		this.SELLER_MODULE_LOGOUT = Constant.SELLER_MODULE_LOGOUT;
		this.SELLER_MODULE_REGISTER = Constant.SELLER_MODULE_REGISTER;
		
		this.SELLER_MODULE_GET_SELLER_INFO = Constant.SELLER_MODULE_GET_SELLER_INFO;
		this.SELLER_MODULE_GET_SID_BY_SELLERNAME = Constant.SELLER_MODULE_GET_SID_BY_SELLERNAME;
		this.SELLER_MODULE_GET_SELLER_LIST_BY_TYPE = Constant.SELLER_MODULE_GET_SELLER_LIST_BY_TYPE;
		
		this.SELLER_MODULE_UPDATE_SELLER_INFO = Constant.SELLER_MODULE_UPDATE_SELLER_INFO;
		this.SELLER_MODULE_OPEN_ORDER_FUNCTION = Constant.SELLER_MODULE_OPEN_ORDER_FUNCTION;
		this.SELLER_MODULE_CLOSE_ORDER_FUNCTION = Constant.SELLER_MODULE_CLOSE_ORDER_FUNCTION;
		

	}

	/**
	 * @param sellerName
	 * @param passWord
	 * @return
	 */
	public Seller login(final String sellerName, final String passWord) {

		Seller seller = null;

		if (null != sellerName && null != passWord) {

			seller = (Seller) load(SELLER_MODULE, SELLER_MODULE_LOGIN,
					Seller.class, new HashMap<String, String>() {
						{

							put("sellerName", sellerName);
							put("passWord", passWord);

						}
					});

			Global.seller = seller;

		}

		return seller;

	}

	/**
	 * @return
	 */
	public Seller freeLogin() {

		Seller seller = null;

		if (null != Global.seller) {

			seller = login(Global.seller.getName(), Global.seller.getPassWord());
			Global.seller = seller;

		}

		return seller;

	}

	/**
     *
     */
	public void logout() {

		final String sid = String.valueOf(Global.seller.getSid());

		load(SELLER_MODULE, SELLER_MODULE_LOGOUT, null,
				new HashMap<String, String>() {
					{

						put("sid", sid);

					}
				});
		Global.seller = null;

	}

	/**
	 * @param user
	 * @return
	 */
	public boolean register(Seller seller) {

		boolean result = false;

		if (null != seller) {

			JSONObject jsonData = (JSONObject) send(SELLER_MODULE,
					SELLER_MODULE_REGISTER, seller, null, null);

			if (null != jsonData) {

				try {

					Long sid = jsonData.getLong("sid");

					if (null != sid && null != Global.seller) {

						seller.setSid(sid);
						Global.seller = seller;

						result = true;

					}

				} catch (JSONException e) {
					// TODO Auto-generated catch block

					e.printStackTrace();

				}

			}

		}

		return result;

	}

	/**
	 * @param sid
	 * @return
	 */
	public Seller getSellerInfo(final Long sid) {

		Seller seller = null;

		if (null != sid) {

			seller = (Seller) load(SELLER_MODULE,
					SELLER_MODULE_GET_SELLER_INFO, Seller.class,
					new HashMap<String, String>() {
						{
							put("sid", String.valueOf(sid));
						}
					});

		}

		return seller;

	}

	/**
	 * @param uid
	 * @return
	 */
	public Seller getSellerInfoBySellerName(String sellerName) {

		final Long sid = getSidBySellerName(sellerName);
		Seller seller = null;

		if (null != sid) {

			seller = (Seller) load(SELLER_MODULE,
					SELLER_MODULE_GET_SELLER_INFO, Seller.class,
					new HashMap<String, String>() {
						{
							put("sid", String.valueOf(sid));
						}
					});

		}

		return seller;

	}

	/**
	 * @param sellerName
	 * @return
	 */
	public Long getSidBySellerName(final String sellerName) {

		Long sid = null;

		if (null != sellerName) {

			JSONObject jsonData = (JSONObject) load(SELLER_MODULE,
					SELLER_MODULE_GET_SID_BY_SELLERNAME, null,
					new HashMap<String, String>() {
						{
							put("sellerName", sellerName);
						}
					});
			if (null != jsonData) {

				try {

					sid = jsonData.getLong("sid");

				} catch (JSONException e) {
					// TODO Auto-generated catch block

					e.printStackTrace();

				}

			}

		}

		return sid;

	}

	/**
	 * @param user
	 * @return
	 */
	public boolean updateSellerInfo(Seller seller) {

		boolean result = false;

		if (null != seller && null != Global.seller) {

			seller.setSid(Global.seller.getSid());
			JSONObject jsonData = (JSONObject) send(SELLER_MODULE,
					SELLER_MODULE_UPDATE_SELLER_INFO, seller, null, null);

			if (null != jsonData) {

				Seller updatedSeller = getSellerInfo(Global.seller.getSid());

				if (null != updatedSeller) {

					Global.seller = updatedSeller;

					result = true;

				}

			}

		}

		return result;

	}

	/**
	 * @param URL
	 * @return
	 */
	public Bitmap getLogo(String URL) {

		Bitmap bmp = null;

		if (null != URL) {

			bmp = loadImage(URL);

		}

		return bmp;

	}

	/**
	 * @param path
	 * @param fileName
	 * @param sid
	 * @return
	 */
	public String uploadLogos(String path, String fileName) {

		File file = new File(path + fileName);

		if (null != file && null != Global.seller) {

			HttpUtil.Upload(SELLER_MODULE, "sid=" + Global.seller.getSid(), file);

		}

		return null;

	}

	/**
	 * @param sid
	 * @return
	 */
	public boolean openOrderFuntion(final Long sid) {

		boolean result = false;

		if (null != sid) {

			result = load(SELLER_MODULE, SELLER_MODULE_OPEN_ORDER_FUNCTION,
					new HashMap<String, Long>() {
						{
							put("sid", sid);
						}
					});

		}

		return result;
	}

	/**
	 * @param sid
	 * @return
	 */
	public boolean closeOrderFuntion(final Long sid) {

		boolean result = false;

		if (null != sid) {

			result = load(SELLER_MODULE, SELLER_MODULE_CLOSE_ORDER_FUNCTION,
					new HashMap<String, Long>() {
						{
							put("sid", sid);
						}
					});

		}

		return result;
	}
	/**
	 * @param type
	 * @return
	 */
	public ArrayList<Object> getSellerList(final String type) {

		ArrayList<Object> sellerList = null;

		if (null != type) {
			JSONObject jsonObject = (JSONObject) load(SELLER_MODULE,
					SELLER_MODULE_GET_SELLER_LIST_BY_TYPE, null,
					new HashMap<String, String>() {
						{
							put("type", type);// TODO

						}
					});

			sellerList = _parserJavaBeanList(jsonObject, Seller.class,
					"SellerList");
		}

		return sellerList;

	}

}