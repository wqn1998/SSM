package com.pojo;

import java.io.Serializable;
import java.util.Date;

import com.util.Page;

public class Yuyue  extends Page  implements Serializable {
    private Integer yid;

    /**
     * 预约人id
     */
    private Integer uid;
    private Myuser myuser;

    private String tel;

    private Integer fid;
    private Fangyuan fangyuan;

    private String ymessage;

    private Date createtime;

    private String receive;

    private Date receivetime;

    /**
     * 同意 不同意
     */
    private String status;

    private static final long serialVersionUID = 1L;

    
    
    public Myuser getMyuser() {
		return myuser;
	}

	public void setMyuser(Myuser myuser) {
		this.myuser = myuser;
	}

	public Fangyuan getFangyuan() {
		return fangyuan;
	}

	public void setFangyuan(Fangyuan fangyuan) {
		this.fangyuan = fangyuan;
	}

	public Integer getYid() {
        return yid;
    }

    public void setYid(Integer yid) {
        this.yid = yid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public String getYmessage() {
        return ymessage;
    }

    public void setYmessage(String ymessage) {
        this.ymessage = ymessage == null ? null : ymessage.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getReceive() {
        return receive;
    }

    public void setReceive(String receive) {
        this.receive = receive == null ? null : receive.trim();
    }

    public Date getReceivetime() {
        return receivetime;
    }

    public void setReceivetime(Date receivetime) {
        this.receivetime = receivetime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", yid=").append(yid);
        sb.append(", uid=").append(uid);
        sb.append(", tel=").append(tel);
        sb.append(", fid=").append(fid);
        sb.append(", ymessage=").append(ymessage);
        sb.append(", createtime=").append(createtime);
        sb.append(", receive=").append(receive);
        sb.append(", receivetime=").append(receivetime);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}