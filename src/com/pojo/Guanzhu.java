package com.pojo;

import java.io.Serializable;

import com.util.Page;

public class Guanzhu   extends Page  implements Serializable {
    private Integer gid;

    private Integer uid;
    private Myuser  myuser;

    private Integer fid;
    private Fangyuan fangyuan;

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

	public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", gid=").append(gid);
        sb.append(", uid=").append(uid);
        sb.append(", fid=").append(fid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}