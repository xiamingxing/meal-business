package com.meal.action;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONObject;

import com.meal.bean.Constant;
import com.meal.bean.Global;
import com.meal.bean.Message;

/**
 * @author xiamingxing
 *
 */
public class MessageManageAction extends BaseAction {

	private static MessageManageAction instance = null;

	public String MESSAGE_MODULE;
	
	public String MESSAGE_MODULE_SEND_MESSAGE;
	
	public String MESSAGE_MODULE_GET_MESSAGE_LIST;
	public String MESSAGE_MODULE_GET_MESSAGE_DETAIL_BY_MEID;

	private MessageManageAction() {

		this.MESSAGE_MODULE = Constant.MESSAGE_MODULE;
		
		
		this.MESSAGE_MODULE_SEND_MESSAGE = Constant.MESSAGE_MODULE_SEND_MESSAGE;
		
		this.MESSAGE_MODULE_GET_MESSAGE_LIST = Constant.MESSAGE_MODULE_GET_MESSAGE_LIST;
		this.MESSAGE_MODULE_GET_MESSAGE_DETAIL_BY_MEID = Constant.MESSAGE_MODULE_GET_MESSAGE_DETAIL_BY_MEID;

	}

	/**
	 * @return
	 */
	public static MessageManageAction getInstance() {

		if (null == instance) {

			instance = new MessageManageAction();

		}

		return instance;

	}

	/**
	 * @param uid
	 * @return
	 */
	public ArrayList<Object> getMessageListForUser(final Long uid) {

		ArrayList<Object> messageList = null;

		if (null != uid) {
			JSONObject jsonObject = (JSONObject) load(MESSAGE_MODULE,
					MESSAGE_MODULE_GET_MESSAGE_LIST, null,
					new HashMap<String, String>() {
						{
							put("uid", String.valueOf(uid));// TODO

						}
					});

			messageList = _parserJavaBeanList(jsonObject, Message.class,
					"MessageList");
		}

		return messageList;

	}

	/**
	 * @param uid
	 * @return
	 */
	public ArrayList<Object> getMessageListForSeller(final Long sid) {

		ArrayList<Object> messageList = null;

		if (null != sid) {
			JSONObject jsonObject = (JSONObject) load(MESSAGE_MODULE,
					MESSAGE_MODULE_GET_MESSAGE_LIST, null,
					new HashMap<String, String>() {
						{
							put("sid", String.valueOf(sid));// TODO

						}
					});

			messageList = _parserJavaBeanList(jsonObject, Message.class,
					"MessageList");
		}

		return messageList;

	}

	/**
	 * @param msg
	 * @return
	 */
	public boolean sendMessage(Message msg) {

		boolean result = false;

		if (null != msg && (null != Global.user || null != Global.seller)) {

			result = send(MESSAGE_MODULE, MESSAGE_MODULE_SEND_MESSAGE, msg,
					null);

		}

		return result;

	}

	/**
	 * @param msg
	 * @return
	 */
	public boolean sendMessage(String content, String role, Long id) {

		boolean result = false;

		Message msg = new Message(content, role + "_" + id);

		if (null != Global.user || null != Global.seller) {

			result = send(MESSAGE_MODULE, MESSAGE_MODULE_SEND_MESSAGE, msg,
					null);

		}

		return result;

	}

	/**
	 * @param msg
	 * @return
	 */
	public boolean sendMessageToGroup(String content, String role,
			ArrayList<Long> idList) {

		boolean result = true;

		if (null != idList && idList.size() > 0) {

			for (int i = 0; i < idList.size(); i++) {

				if (!sendMessage(content, role, idList.get(i))) {

					result = false;

				}

			}

		}

		return result;

	}

	/**
	 * @param msg
	 * @return
	 */
	public Message getMessageDetail(final Long meid) {

		Message msg = null;

		if (null != meid) {

			msg = (Message) load(MESSAGE_MODULE,
					MESSAGE_MODULE_GET_MESSAGE_DETAIL_BY_MEID, Message.class,
					new HashMap<String, String>() {
						{
							put("meid", String.valueOf(meid));// TODO

						}
					});

		}

		return msg;

	}

}
