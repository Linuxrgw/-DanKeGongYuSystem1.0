package com.icss.dkgy.entity;

public class OwnerEntity {
	private int ownerid;  //�û�id
	private String ownername;  //�û�����
	private String ownerpwd;  //�û�����
	private String ownerphone; //�û��绰
	private String ownersex;		//�Ա�
	private String status;  //�˻�״̬ 0-����  1-���
	private String address;
	private String imgpath; //����
	
	/**
	 * 
	 */
	public OwnerEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param ownerid
	 * @param ownername
	 * @param ownerpwd
	 * @param ownerphone
	 * @param ownersex
	 * @param status
	 * @param address
	 * @param imgpath
	 */
	public OwnerEntity(int ownerid, String ownername, String ownerpwd, String ownerphone, String ownersex,
			String status, String address, String imgpath) {
		super();
		this.ownerid = ownerid;
		this.ownername = ownername;
		this.ownerpwd = ownerpwd;
		this.ownerphone = ownerphone;
		this.ownersex = ownersex;
		this.status = status;
		this.address = address;
		this.imgpath = imgpath;
	}
	public int getOwnerid() {
		return ownerid;
	}
	public void setOwnerid(int ownerid) {
		this.ownerid = ownerid;
	}
	public String getOwnername() {
		return ownername;
	}
	public void setOwnername(String ownername) {
		this.ownername = ownername;
	}
	public String getOwnerpwd() {
		return ownerpwd;
	}
	public void setOwnerpwd(String ownerpwd) {
		this.ownerpwd = ownerpwd;
	}

	public String getOwnerphone() {
		return ownerphone;
	}
	public void setOwnerphone(String ownerphone) {
		this.ownerphone = ownerphone;
	}
	public String getOwnersex() {
		return ownersex;
	}
	public void setOwnersex(String ownersex) {
		this.ownersex = ownersex;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getImgpath() {
		return imgpath;
	}
	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}
	@Override
	public String toString() {
		return "OwnerEntity [ownerid=" + ownerid + ", ownername=" + ownername + ", ownerpwd=" + ownerpwd
				+ ", ownerphone=" + ownerphone + ", ownersex=" + ownersex + ", status=" + status + ", address="
				+ address + ", imgpath=" + imgpath + "]";
	}

	
	
	

}
