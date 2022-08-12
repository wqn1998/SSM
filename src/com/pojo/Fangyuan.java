package com.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.util.Page;

public class Fangyuan  extends Page  implements Serializable {
    private Integer fid;

    private String title;

    private BigDecimal saleprice;

    private BigDecimal rentprice;

    private String huxing;

    private Double mianji;

    private String chaoxiang;

    private String louceng;

    private String zhuangxiu;

    /**
     * ���� ���� �·�
     */
    private String type;

    /**
     * ���۳� δ�۳� ί�����
     */
    private String status;

    /**
     * ������id ����˭�����ķ�Դ
     */
    private Integer faburenid;
    private Myuser faburen;

    /**
     * ί����id ���˷�Դί���˺ͷ�������һ��
     */
    private Integer weituorenid;
    private Myuser weituoren;
    private Date createtime;

    private String description;

    private Integer xujiacount;

    private String pics;

    private String area;

    
    
    public Myuser getFaburen() {
		return faburen;
	}

	public void setFaburen(Myuser faburen) {
		this.faburen = faburen;
	}

	public Myuser getWeituoren() {
		return weituoren;
	}

	public void setWeituoren(Myuser weituoren) {
		this.weituoren = weituoren;
	}

	private static final long serialVersionUID = 1L;

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public BigDecimal getSaleprice() {
        return saleprice;
    }

    public void setSaleprice(BigDecimal saleprice) {
        this.saleprice = saleprice;
    }

    public BigDecimal getRentprice() {
        return rentprice;
    }

    public void setRentprice(BigDecimal rentprice) {
        this.rentprice = rentprice;
    }

    public String getHuxing() {
        return huxing;
    }

    public void setHuxing(String huxing) {
        this.huxing = huxing == null ? null : huxing.trim();
    }

    public Double getMianji() {
        return mianji;
    }

    public void setMianji(Double mianji) {
        this.mianji = mianji;
    }

    public String getChaoxiang() {
        return chaoxiang;
    }

    public void setChaoxiang(String chaoxiang) {
        this.chaoxiang = chaoxiang == null ? null : chaoxiang.trim();
    }

    public String getLouceng() {
        return louceng;
    }

    public void setLouceng(String louceng) {
        this.louceng = louceng == null ? null : louceng.trim();
    }

    public String getZhuangxiu() {
        return zhuangxiu;
    }

    public void setZhuangxiu(String zhuangxiu) {
        this.zhuangxiu = zhuangxiu == null ? null : zhuangxiu.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Integer getFaburenid() {
        return faburenid;
    }

    public void setFaburenid(Integer faburenid) {
        this.faburenid = faburenid;
    }

    public Integer getWeituorenid() {
        return weituorenid;
    }

    public void setWeituorenid(Integer weituorenid) {
        this.weituorenid = weituorenid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getXujiacount() {
        return xujiacount;
    }

    public void setXujiacount(Integer xujiacount) {
        this.xujiacount = xujiacount;
    }

    public String getPics() {
        return pics;
    }

    public void setPics(String pics) {
        this.pics = pics == null ? null : pics.trim();
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", fid=").append(fid);
        sb.append(", title=").append(title);
        sb.append(", saleprice=").append(saleprice);
        sb.append(", rentprice=").append(rentprice);
        sb.append(", huxing=").append(huxing);
        sb.append(", mianji=").append(mianji);
        sb.append(", chaoxiang=").append(chaoxiang);
        sb.append(", louceng=").append(louceng);
        sb.append(", zhuangxiu=").append(zhuangxiu);
        sb.append(", type=").append(type);
        sb.append(", status=").append(status);
        sb.append(", faburenid=").append(faburenid);
        sb.append(", weituorenid=").append(weituorenid);
        sb.append(", createtime=").append(createtime);
        sb.append(", description=").append(description);
        sb.append(", xujiacount=").append(xujiacount);
        sb.append(", pics=").append(pics);
        sb.append(", area=").append(area);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}