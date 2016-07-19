package com.meal.bean;

import java.util.ArrayList;

import com.meal.util.SysUtil;

/**
 * @author xiamingxing
 * 
 */
public class Groupon {

	private Long gid;// 团购ID

	private Long sid;// 团购商家ID

	private Long uid;// 发起团购者ID

	private String time;// 团购发起时间

	private String limiteTime;// 团购等待时限

	private double minCost; // 团购最低限额

	private String status;// 团购订单状态

	private ArrayList<Long> orderList;// 订单列表

	private Groupon() {

	}

	public Groupon(Long sid, String limiteTime, double minCost, Long oid) {

		this.gid = -1l;

		this.sid = sid;

		this.uid = null != Global.user ? Global.user.getUid() : -1l;

		this.time = SysUtil.getTime();

		this.limiteTime = limiteTime;

		this.minCost = minCost;

		this.orderList = new ArrayList<Long>();

		if (null != oid) {

			orderList.add(oid);

		}

	}

	public Long getGid() {
		return gid;
	}

	public void setGid(Long gid) {
		this.gid = gid;
	}

	public Long getSid() {
		return sid;
	}

	public void setSid(Long sid) {
		this.sid = sid;
	}

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getLimiteTime() {
		return limiteTime;
	}

	public void setLimiteTime(String limiteTime) {
		this.limiteTime = limiteTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ArrayList<Long> getOrderList() {
		return orderList;
	}

	public void setOrderList(ArrayList<Long> orderList) {
		this.orderList = orderList;
	}

	public double getMinCost() {
		return minCost;
	}

	public void setMinCost(double minCost) {
		this.minCost = minCost;
	}

	public void joinGroupon(Long order) {
		this.orderList.add(order);
	}

}
