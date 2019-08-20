/**
 * Created By: XI
 * Created On: 2019-8-5 14:06:03
 *
 * Amendment History:
 * 
 * Amended By       Amended On      Amendment Description
 * ------------     -----------     ---------------------------------------------
 *
 **/
package com.qnym.business;


public class WechartFriend extends Model{

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;
	
	/**
	  *	
	  */
	private Long id;

	/**
	  *	
	  */
	private Integer rowIndex;

	/**
	  *	个人号微信ID
	  */
	private String robotWxid;

	/**
	  *	好友微信号
	  */
	private String userName;

	/**
	  *	好友微信ID
	  */
	private String fansWxid;

	/**
	  *	昵称
	  */
	private String nickName;

	/**
	  *	base64昵称
	  */
	private String base64NickName;

	/**
	  *	备注名
	  */
	private String wxAlias;

	/**
	  *	性别 :0未定义 1男 2女
	  */
	private Integer sex;

	/**
	  *	好友头像
	  */
	private String headImages;

	/**
	  *	省份
	  */
	private String proinvice;

	/**
	  *	市区
	  */
	private String city;

	/**
	  *	个性签名
	  */
	private String pslSignature;

	/**
	  *	好友标签(后台标签，非微信标签)，多个以,隔开
	  */
	private String tags;

	/**
	  *	是否为养号机器人 1为机器人 0 不是机器人
	  */
	private Integer nisRobot;

	/**
	  *	添加好友时间（账号离线期间的添加时间无法统计，都归为账号上线时间）
	  */
	private String dtCreateDate;

	/**
	  *	
	  */
	private String createTime;

	/**
	  *	药网用户id
	  */
	private String yywUserId;

	/**
	  *	药网标签
	  */
	private String yywTag;

	/**
	  *	 1 未同步 2 已同步
	  */
	private Integer syncStatus;

	/**
	  *	
	  */
	private String syncTime;

	/**
	  *	1 正常 2 被删除
	  */
	private Integer status;
	/**
	 * 任务执行次数
	 */
	private Integer times;
	/**
	 * 描述
	 */
	private String remark;

	/**
	  *	
	  */
	public Long getId()
	{
		return id;
	}
	
	/**
	  *	
	  */
	public void setId(Long id)
	{
		this.id = id;
	}
	
	/**
	  *	
	  */
	public Integer getRowIndex()
	{
		return rowIndex;
	}
	
	/**
	  *	
	  */
	public void setRowIndex(Integer rowIndex)
	{
		this.rowIndex = rowIndex;
	}
	
	/**
	  *	个人号微信ID
	  */
	public String getRobotWxid()
	{
		return robotWxid;
	}
	
	/**
	  *	个人号微信ID
	  */
	public void setRobotWxid(String robotWxid)
	{
		this.robotWxid = robotWxid;
	}
	
	/**
	  *	好友微信号
	  */
	public String getUserName()
	{
		return userName;
	}
	
	/**
	  *	好友微信号
	  */
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	
	/**
	  *	好友微信ID
	  */
	public String getFansWxid()
	{
		return fansWxid;
	}
	
	/**
	  *	好友微信ID
	  */
	public void setFansWxid(String fansWxid)
	{
		this.fansWxid = fansWxid;
	}
	
	/**
	  *	昵称
	  */
	public String getNickName()
	{
		return nickName;
	}
	
	/**
	  *	昵称
	  */
	public void setNickName(String nickName)
	{
		this.nickName = nickName;
	}
	
	/**
	  *	base64昵称
	  */
	public String getBase64NickName()
	{
		return base64NickName;
	}
	
	/**
	  *	base64昵称
	  */
	public void setBase64NickName(String base64NickName)
	{
		this.base64NickName = base64NickName;
	}
	
	/**
	  *	备注名
	  */
	public String getWxAlias()
	{
		return wxAlias;
	}
	
	/**
	  *	备注名
	  */
	public void setWxAlias(String wxAlias)
	{
		this.wxAlias = wxAlias;
	}
	
	/**
	  *	性别 :0未定义 1男 2女
	  */
	public Integer getSex()
	{
		return sex;
	}
	
	/**
	  *	性别 :0未定义 1男 2女
	  */
	public void setSex(Integer sex)
	{
		this.sex = sex;
	}
	
	/**
	  *	好友头像
	  */
	public String getHeadImages()
	{
		return headImages;
	}
	
	/**
	  *	好友头像
	  */
	public void setHeadImages(String headImages)
	{
		this.headImages = headImages;
	}
	
	/**
	  *	省份
	  */
	public String getProinvice()
	{
		return proinvice;
	}
	
	/**
	  *	省份
	  */
	public void setProinvice(String proinvice)
	{
		this.proinvice = proinvice;
	}
	
	/**
	  *	市区
	  */
	public String getCity()
	{
		return city;
	}
	
	/**
	  *	市区
	  */
	public void setCity(String city)
	{
		this.city = city;
	}
	
	/**
	  *	个性签名
	  */
	public String getPslSignature()
	{
		return pslSignature;
	}
	
	/**
	  *	个性签名
	  */
	public void setPslSignature(String pslSignature)
	{
		this.pslSignature = pslSignature;
	}
	
	/**
	  *	好友标签(后台标签，非微信标签)，多个以,隔开
	  */
	public String getTags()
	{
		return tags;
	}
	
	/**
	  *	好友标签(后台标签，非微信标签)，多个以,隔开
	  */
	public void setTags(String tags)
	{
		this.tags = tags;
	}
	
	/**
	  *	是否为养号机器人 1为机器人 0 不是机器人
	  */
	public Integer getNisRobot()
	{
		return nisRobot;
	}
	
	/**
	  *	是否为养号机器人 1为机器人 0 不是机器人
	  */
	public void setNisRobot(Integer nisRobot)
	{
		this.nisRobot = nisRobot;
	}
	
	/**
	  *	添加好友时间（账号离线期间的添加时间无法统计，都归为账号上线时间）
	  */
	public String getDtCreateDate()
	{
		return dtCreateDate;
	}
	
	/**
	  *	添加好友时间（账号离线期间的添加时间无法统计，都归为账号上线时间）
	  */
	public void setDtCreateDate(String dtCreateDate)
	{
		this.dtCreateDate = dtCreateDate;
	}
	
	/**
	  *	
	  */
	public String getCreateTime()
	{
		return createTime;
	}
	
	/**
	  *	
	  */
	public void setCreateTime(String createTime)
	{
		this.createTime = createTime;
	}
	
	/**
	  *	药网用户id
	  */
	public String getYywUserId()
	{
		return yywUserId;
	}
	
	/**
	  *	药网用户id
	  */
	public void setYywUserId(String yywUserId)
	{
		this.yywUserId = yywUserId;
	}
	
	/**
	  *	药网标签
	  */
	public String getYywTag()
	{
		return yywTag;
	}
	
	/**
	  *	药网标签
	  */
	public void setYywTag(String yywTag)
	{
		this.yywTag = yywTag;
	}
	
	/**
	  *	 1 未同步 2 已同步
	  */
	public Integer getSyncStatus()
	{
		return syncStatus;
	}
	
	/**
	  *	 1 未同步 2 已同步成功 3 已同步用户id不存在
	  */
	public void setSyncStatus(Integer syncStatus)
	{
		this.syncStatus = syncStatus;
	}
	
	/**
	  *	
	  */
	public String getSyncTime()
	{
		return syncTime;
	}
	
	/**
	  *	
	  */
	public void setSyncTime(String syncTime)
	{
		this.syncTime = syncTime;
	}
	
	/**
	  *	1 正常 2 被删除
	  */
	public Integer getStatus()
	{
		return status;
	}
	
	/**
	  *	1 正常 2 被删除
	  */
	public void setStatus(Integer status)
	{
		this.status = status;
	}

	public Integer getTimes() {
		return times;
	}

	public void setTimes(Integer times) {
		this.times = times;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "WechartFriend{" +
				"id=" + id +
				", rowIndex=" + rowIndex +
				", robotWxid='" + robotWxid + '\'' +
				", userName='" + userName + '\'' +
				", fansWxid='" + fansWxid + '\'' +
				", nickName='" + nickName + '\'' +
				", base64NickName='" + base64NickName + '\'' +
				", wxAlias='" + wxAlias + '\'' +
				", sex=" + sex +
				", headImages='" + headImages + '\'' +
				", proinvice='" + proinvice + '\'' +
				", city='" + city + '\'' +
				", pslSignature='" + pslSignature + '\'' +
				", tags='" + tags + '\'' +
				", nisRobot=" + nisRobot +
				", dtCreateDate='" + dtCreateDate + '\'' +
				", createTime='" + createTime + '\'' +
				", yywUserId='" + yywUserId + '\'' +
				", yywTag='" + yywTag + '\'' +
				", syncStatus=" + syncStatus +
				", syncTime='" + syncTime + '\'' +
				", status=" + status +
				", times=" + times +
				", remark='" + remark + '\'' +
				'}';
	}
}

