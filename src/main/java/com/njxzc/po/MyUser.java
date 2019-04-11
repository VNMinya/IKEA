package com.njxzc.po;
/**
 *springtest数据库中user表的持久化类
 */
public class MyUser {
	private Integer uid;//主键
	private String uname;
	private String usex;
	private Integer userage;
	private String password;
	/**
	 *  @BareFieldName : uid
	 *  @return  the uid
	 */
	public Integer getUid() {
		return uid;
	}
	/**
	*  @BareFieldName : uid
	*
	*  @return  the uid
	*
	*  @param uid the uid to set
	*
	*/
	
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	/**
	 *  @BareFieldName : uname
	 *  @return  the uname
	 */
	
	public String getUname() {
		return uname;
	}
	/**
	*  @BareFieldName : uname
	*
	*  @return  the uname
	*
	*  @param uname the uname to set
	*
	*/
	
	public void setUname(String uname) {
		this.uname = uname;
	}
	/**
	 *  @BareFieldName : usex
	 *  @return  the usex
	 */
	
	public String getUsex() {
		return usex;
	}
	/**
	*  @BareFieldName : usex
	*
	*  @return  the usex
	*
	*  @param usex the usex to set
	*
	*/
	
	public void setUsex(String usex) {
		this.usex = usex;
	}
	/**
	 *  @BareFieldName : userage
	 *  @return  the userage
	 */
	
	public Integer getUserage() {
		return userage;
	}
	/**
	*  @BareFieldName : userage
	*
	*  @return  the userage
	*
	*  @param userage the userage to set
	*
	*/
	
	public void setUserage(Integer userage) {
		this.userage = userage;
	}
	/**
	 *  @BareFieldName : password
	 *  @return  the password
	 */
	
	public String getPassword() {
		return password;
	}
	/**
	*  @BareFieldName : password
	*
	*  @return  the password
	*
	*  @param password the password to set
	*
	*/
	
	public void setPassword(String password) {
		this.password = password;
	}
	/** 
	* @Title: toString
	* @Description: 
	* @return 
	* @see java.lang.Object#toString() 
	*/
	@Override
	public String toString() {
		return "MyUser [uid=" + uid + ", uname=" + uname + ", usex=" + usex + ", userage=" + userage + ", password="
				+ password + ", getUid()=" + getUid() + ", getUname()=" + getUname() + ", getUsex()=" + getUsex()
				+ ", getUserage()=" + getUserage() + ", getPassword()=" + getPassword() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	

}
