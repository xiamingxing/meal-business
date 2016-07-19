package com.meal.action;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONException;
import org.json.JSONObject;

import com.meal.bean.Constant;
import com.meal.bean.Global;
import com.meal.bean.Groupon;
import com.meal.bean.Order;
import com.meal.bean.Seller;

/**
 * @author xiamingxing
 * 
 */
public class GrouponManageAction extends BaseAction {

	private static GrouponManageAction instance = null;

	private final String STATUS_CANCEL_GROUPON = "cancel";
	private final String STATUS_COMPLETE_GROUPON = "complete";
	private final String STATUS_NEW_GROUPON = "new";

	private String GROUPON_MODULE;

	private String GROUPON_MODULE_CREATE_GROUPON;
	private String GROUPON_MODULE_SET_GROUPON_STATUS_BY_GID;
	private String GROUPON_MODULE_CANCEL_GROUPON_BY_GID;
	private String GROUPON_MODULE_COMPLETE_GROUPON_BY_GID;
	private String GROUPON_MODULE_JOIN_GROUPON_BY_GID;

	private String GROUPON_MODULE_GET_GROUPON_DETAIL_BY_GID;
	private String GROUPON_MODULE_GET_GROUPON_LIST_FOR_JOIN;
	private String GROUPON_MODULE_GET_GROUPON_LIST_BY_SID;
	private String GROUPON_MODULE_GET_GROUPON_LIST_BY_UID;

	private GrouponManageAction() {

		this.GROUPON_MODULE = Constant.GROUPON_MODULE;

		this.GROUPON_MODULE_CANCEL_GROUPON_BY_GID = Constant.GROUPON_MODULE_CANCEL_GROUPON_BY_GID;
		this.GROUPON_MODULE_SET_GROUPON_STATUS_BY_GID = Constant.GROUPON_MODULE_SET_GROUPON_STATUS_BY_GID;
		this.GROUPON_MODULE_COMPLETE_GROUPON_BY_GID = Constant.GROUPON_MODULE_COMPLETE_GROUPON_BY_GID;
		this.GROUPON_MODULE_CREATE_GROUPON = Constant.GROUPON_MODULE_CREATE_GROUPON;
		this.GROUPON_MODULE_JOIN_GROUPON_BY_GID = Constant.GROUPON_MODULE_JOIN_GROUPON_BY_GID;

		this.GROUPON_MODULE_GET_GROUPON_DETAIL_BY_GID = Constant.GROUPON_MODULE_GET_GROUPON_DETAIL_BY_GID;
		this.GROUPON_MODULE_GET_GROUPON_LIST_BY_SID = Constant.GROUPON_MODULE_GET_GROUPON_LIST_BY_SID;
		this.GROUPON_MODULE_GET_GROUPON_LIST_BY_UID = Constant.GROUPON_MODULE_GET_GROUPON_LIST_BY_UID;
		this.GROUPON_MODULE_GET_GROUPON_LIST_FOR_JOIN = Constant.GROUPON_MODULE_GET_GROUPON_LIST_FOR_JOIN;

	}

	/**
	 * @return
	 */
	public static GrouponManageAction getInstance() {

		if (null == instance) {

			instance = new GrouponManageAction();

		}

		return instance;

	}

	/**
	 * @param groupon
	 * @return
	 */
	public Long createGroupon(Groupon groupon) {

		Long gid = null;

		if (null != groupon && null != Global.user) {

			groupon.setUid(Global.user.getUid());
			groupon.setStatus(STATUS_NEW_GROUPON);

			JSONObject jsonObject = (JSONObject) send(GROUPON_MODULE,
					GROUPON_MODULE_CREATE_GROUPON, groupon, null, null);

			if (null != jsonObject) {

				try {
					gid = jsonObject.getLong("gid");

				} catch (JSONException e) {
					// TODO Auto-generated catch block

					e.printStackTrace();

				}

			}

		}

		return gid;

	}

	/**
	 * @param gid
	 * @param status
	 * @return
	 */
	public boolean setGrouponStatus(final Long gid, final String status) {

		boolean result = false;

		if (null != gid && null != status) {

			result = load(GROUPON_MODULE,
					GROUPON_MODULE_SET_GROUPON_STATUS_BY_GID,
					new HashMap<String, String>() {
						{
							put("gid", String.valueOf(gid));
							put("status", status);
						}
					});

		}

		return result;

	}

	/**
	 * @param gid
	 * @return
	 */
	public boolean cancelGroupon(final Long gid) {

		boolean result = false;

		if (null != gid) {

			result = setGrouponStatus(gid, STATUS_CANCEL_GROUPON);

		}

		return result;

	}

	/**
	 * @param gid
	 * @return
	 */
	public boolean completeGroupon(final Long gid) {

		boolean result = false;

		if (null != gid) {

			result = setGrouponStatus(gid, STATUS_COMPLETE_GROUPON);

		}

		return result;

	}

	/**
	 * @param gid
	 * @param oid
	 * @return
	 */
	public boolean joinGroupon(final Long gid, final Long oid) {

		boolean result = false;

		if (null != gid && null != oid) {

			result = load(GROUPON_MODULE, GROUPON_MODULE_JOIN_GROUPON_BY_GID,
					new HashMap<String, String>() {
						{
							put("gid", String.valueOf(gid));
							put("oid", String.valueOf(oid));
						}
					});

		}

		return result;

	}

	/**
	 * @param gid
	 * @return
	 */
	public Groupon getGrouponDetail(final Long gid) {

		Groupon groupon = null;

		if (null != gid) {

			groupon = (Groupon) load(GROUPON_MODULE,
					GROUPON_MODULE_GET_GROUPON_DETAIL_BY_GID, Groupon.class,
					new HashMap<String, String>() {
						{
							put("gid", String.valueOf(gid));
						}
					});

		}

		return groupon;

	}

	/**
	 * @param sid
	 * @return
	 */
	public ArrayList<Object> getSellerGrouponList(final String sid) {

		ArrayList<Object> sellerGroupList = null;

		if (null != sid) {
			JSONObject jsonObject = (JSONObject) load(GROUPON_MODULE,
					GROUPON_MODULE_GET_GROUPON_LIST_BY_SID, null,
					new HashMap<String, String>() {
						{
							put("sid", sid);// TODO

						}
					});

			sellerGroupList = _parserJavaBeanList(jsonObject, Groupon.class,
					"GroupList");
		}

		return sellerGroupList;

	}

	/**
	 * @param uid
	 * @return
	 */
	public ArrayList<Object> getUserGrouponList(final String uid) {

		ArrayList<Object> userGrouponList = null;

		if (null != uid) {
			JSONObject jsonObject = (JSONObject) load(GROUPON_MODULE,
					GROUPON_MODULE_GET_GROUPON_LIST_BY_UID, null,
					new HashMap<String, String>() {
						{
							put("uid", uid);// TODO

						}
					});

			userGrouponList = _parserJavaBeanList(jsonObject, Groupon.class,
					"GroupList");
		}

		return userGrouponList;

	}

	/**
	 * @return
	 */
	public ArrayList<Object> getGrouponListForJoin() {

		ArrayList<Object> grouponList = null;

		JSONObject jsonObject = (JSONObject) load(GROUPON_MODULE,
				GROUPON_MODULE_GET_GROUPON_LIST_FOR_JOIN, null, null);

		grouponList = _parserJavaBeanList(jsonObject, Groupon.class,
				"GroupList");

		return grouponList;

	}
}
