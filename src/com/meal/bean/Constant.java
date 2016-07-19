package com.meal.bean;

/**
 * @author xiamingxing
 *
 */
public class Constant {

    public static final String MENU_PHOTO_DEFAULT_URL = "";
    public static final String USER_PORTRAIT_DEFAULT_URL = "";
    public static final String SELLER_LOGO_DEFAULT_URL = "";

    public static final String USER_MODULE = "UserManageService";
	    public static final String USER_MODULE_LOGIN = "login";
	    public static final String USER_MODULE_LOGOUT = "logout";
	    public static final String USER_MODULE_REGISTER = "register";
	    public static final String USER_MODULE_GET_USER_INFO_BY_UID = "getUserInfoByUid";
	    public static final String USER_MODULE_GET_UID_BY_USERNAME = "getUidByUserName";
	    public static final String USER_MODULE_UPDATE_USER_INFO = "updateUserInfoByUid";

    public static final String SELLER_MODULE = "SellerManageService";
	    public static final String SELLER_MODULE_LOGIN = "login";
	    public static final String SELLER_MODULE_LOGOUT = "logout";
	    public static final String SELLER_MODULE_REGISTER = "register";
	    public static final String SELLER_MODULE_GET_SELLER_INFO = "getSellerInfo";
	    public static final String SELLER_MODULE_GET_SID_BY_SELLERNAME = "getSidBySellerName";
	    public static final String SELLER_MODULE_UPDATE_SELLER_INFO = "updateSellerInfoBySid";
	    public static final String SELLER_MODULE_OPEN_ORDER_FUNCTION = "openOrderFunctionBySid";
	    public static final String SELLER_MODULE_CLOSE_ORDER_FUNCTION = "closeOrderFunctionBySid";
	    public static final String SELLER_MODULE_GET_SELLER_LIST_BY_TYPE = "getSellerListByType";

    public static final String MENU_MODULE = "MenuManageService";
	    public static final String MENU_MODULE_ADD_MENU = "addMenu";
	    public static final String MENU_MODULE_UPDATE_MENU_BY_MID = "updateMenuByMid";
	    public static final String MENU_MODULE_DELETE_MENU_BY_MID = "deleteMenuByMid";
	    public static final String MENU_MODULE_GET_MENU_BY_MID = "getMenuByMid";
	    public static final String MENU_MODULE_GET_MENU_LIST_BY_SID = "getMenuListBySid";
	    public static final String MENU_MODULE_CLEAR_MENU_LIST_BY_SID = "clearMenuListBySid";
	    public static final String MENU_MODULE_GET_SID_BY_MID = "getSidByMid";

    public static final String ORDER_MODULE = "OrderManageService";
	    public static final String ORDER_MODULE_ADD_ORDER = "addOrder";
	    public static final String ORDER_MODULE_GET_ORDER_BY_OID = "getOrderByOid";
	    public static final String ORDER_MODULE_GET_ORDER_BY_DATE = "getOrderByDate";
	    public static final String ORDER_MODULE_GET_MENU_RANKING_BY_DATE = "getMenuRankingByDate";
	    public static final String ORDER_MODULE_DELETE_ORDER_BY_OID = "deleteOrderByOid";
	    public static final String ORDER_MODULE_CONFIRM_ORDER_BY_OID = "confirmOrderByOid";
	    public static final String ORDER_MODULE_REFUSE_ORDER_BY_OID = "refuseOrderByOid";
	    public static final String ORDER_MODULE_CLOSE_ORDER_BY_OID = "closeOrderByOid";
	    public static final String ORDER_MODULE_GET_ORDER_STATUS_BY_OID = "getOrderStatusByOid";
	    public static final String ORDER_MODULE_GET_USER_ORDER_BY_UID = "getUserOrderByUid";
	    public static final String ORDER_MODULE_GET_SELLER_ORDER_BY_SID = "getSellerOrderBySid";
	    public static final String ORDER_MODULE_SET_ORDER_SCORE_BY_OID = "setOrderScoreByOid";
	    public static final String ORDER_MODULE_SET_ORDER_STATUS_BY_OID = "setOrderStatusByOid";
	    public static final String ORDER_MODULE_UPDATE_ORDER_BY_OID = "updateOrderByOid";
	    
	public static final String GROUPON_MODULE = "GrouponManageService";
		public static final String GROUPON_MODULE_CREATE_GROUPON = "createGroupon";
		public static final String GROUPON_MODULE_CANCEL_GROUPON_BY_GID = "cancelGrouponByGid";
		public static final String GROUPON_MODULE_SET_GROUPON_STATUS_BY_GID = "setGrouponStatusByGid";
		public static final String GROUPON_MODULE_COMPLETE_GROUPON_BY_GID = "completeGrouponByGid";
		public static final String GROUPON_MODULE_JOIN_GROUPON_BY_GID = "joinGrouponByGid";
		public static final String GROUPON_MODULE_GET_GROUPON_DETAIL_BY_GID = "getGrouponDetailByGid";
		public static final String GROUPON_MODULE_GET_GROUPON_LIST_FOR_JOIN = "getGrouponListForJoin";
		public static final String GROUPON_MODULE_GET_GROUPON_LIST_BY_SID = "getGrouponListBySid";
		public static final String GROUPON_MODULE_GET_GROUPON_LIST_BY_UID = "getGrouponListByUid";

    public static final String MESSAGE_MODULE = "MsgManageService";
	    public static final String MESSAGE_MODULE_SEND_MESSAGE = "sendMessage";
	    public static final String MESSAGE_MODULE_GET_MESSAGE_LIST = "getMessageList";
	    public static final String MESSAGE_MODULE_GET_MESSAGE_DETAIL_BY_MEID = "getMessageDetailByMeid";

	

}
