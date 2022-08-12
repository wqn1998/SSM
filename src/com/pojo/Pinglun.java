package com.pojo;

import java.io.Serializable;
import java.util.Date;

import com.util.Page;

public class Pinglun  extends Page  implements Serializable {
    private Integer pid;

    private Integer fid;
private Fangyuan fangyuan;
    private Integer uid;
    private Myuser  myuser;

    private String content;

    private Date createtime;

    private static final long serialVersionUID = 1L;

    
    
    public Fangyuan getFangyuan() {
		return fangyuan;
	}

	public void setFangyuan(Fangyuan fangyuan) {
		this.fangyuan = fangyuan;
	}

	public Myuser getMyuser() {
		return myuser;
	}

	public void setMyuser(Myuser myuser) {
		this.myuser = myuser;
	}

	public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", pid=").append(pid);
        sb.append(", fid=").append(fid);
        sb.append(", uid=").append(uid);
        sb.append(", content=").append(content);
        sb.append(", createtime=").append(createtime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}