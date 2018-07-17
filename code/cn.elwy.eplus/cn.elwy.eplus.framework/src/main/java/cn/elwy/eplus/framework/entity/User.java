package cn.elwy.eplus.framework.entity;

import java.util.Date;

import cn.elwy.common.entity.CommonEntity;

public class User extends CommonEntity {

	private static final long serialVersionUID = 1L;

	private String userType; // 类型
	private String userCode; // 代码
	private String userName; // 名称
	private String roleCode; // 角色代码
	private String orgCode; // 机构代码
	private String postCode; // 岗位代码
	private String nickname; // 昵称
	private Integer editState; // 编辑状态
	private Integer lockState; // 锁定状态
	private Integer online; // 是否在线
	private String safety; // 安全码
	private Date inceptTime; // 生效时间
	private Date expiryTime; // 失效时间
	private Date loginTime; // 登录时间
	private Integer loginCount; // 登录次数
	private String clientIp; // 客户端IP
	private String password; // 密码
	private String realName; // 真实姓名
	private String sex; // 性别
	private Date birthday; // 出生日期
	private String telephone; // 电话号码
	private String mobile; // 手机号码
	private String job; // 职位
	private String postcode; // 邮编
	private String email; // 邮箱
	private String address; // 联系地址
	private String remark; // 备注

	public User() {
		super();
	}

	public User(String id) {
		super(id);
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType == null ? null : userType.trim();
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode == null ? null : userCode.trim();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName == null ? null : userName.trim();
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode == null ? null : roleCode.trim();
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode == null ? null : orgCode.trim();
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode == null ? null : postCode.trim();
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname == null ? null : nickname.trim();
	}

	public Integer getEditState() {
		return editState;
	}

	public void setEditState(Integer editState) {
		this.editState = editState;
	}

	public Integer getLockState() {
		return lockState;
	}

	public void setLockState(Integer lockState) {
		this.lockState = lockState;
	}

	public Integer getOnline() {
		return online;
	}

	public void setOnline(Integer online) {
		this.online = online;
	}

	public String getSafety() {
		return safety;
	}

	public void setSafety(String safety) {
		this.safety = safety == null ? null : safety.trim();
	}

	public Date getInceptTime() {
		return inceptTime;
	}

	public void setInceptTime(Date inceptTime) {
		this.inceptTime = inceptTime;
	}

	public Date getExpiryTime() {
		return expiryTime;
	}

	public void setExpiryTime(Date expiryTime) {
		this.expiryTime = expiryTime;
	}

	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	public Integer getLoginCount() {
		return loginCount;
	}

	public void setLoginCount(Integer loginCount) {
		this.loginCount = loginCount;
	}

	public String getClientIp() {
		return clientIp;
	}

	public void setClientIp(String clientIp) {
		this.clientIp = clientIp == null ? null : clientIp.trim();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName == null ? null : realName.trim();
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex == null ? null : sex.trim();
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone == null ? null : telephone.trim();
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile == null ? null : mobile.trim();
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job == null ? null : job.trim();
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode == null ? null : postcode.trim();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email == null ? null : email.trim();
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address == null ? null : address.trim();
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

}