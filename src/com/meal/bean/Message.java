package com.meal.bean;

import com.meal.util.SysUtil;

/**
 * @author xiamingxing
 *
 */
public class Message {

    private Long meid;

    private String content;

    private String time;

    private String status;

    private String sender;

    private String receiver;

    private Message() {

    }

    public Message(String content, String receiver) {

        this.meid = -1l;

        this.content = content;

        this.time = SysUtil.getTime();

        this.status = null;

        if (null != Global.user) {

            this.sender = "user_" + Global.user.getUid();

        } else if (null != Global.seller) {

            this.sender = "seller_" + Global.seller.getSid();

        } else {

            this.sender = "unKnown";

        }

        this.receiver = receiver;


    }

    public Long getMeid() {
        return meid;
    }

    public void setMeid(Long meid) {
        this.meid = meid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return this.receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }


}
