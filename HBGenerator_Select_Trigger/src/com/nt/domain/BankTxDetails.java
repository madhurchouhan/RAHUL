package com.nt.domain;

import java.util.Date;

public class BankTxDetails {
	//private String txid;
	private int txid;
	private String txName;
	private float txAmount;
	private Date txDate;
	public int getTxid() {
		return txid;
	}
	public void setTxid(int txid) {
		this.txid = txid;
	}
	public String getTxName() {
		return txName;
	}
	public void setTxName(String txName) {
		this.txName = txName;
	}
	public float getTxAmount() {
		return txAmount;
	}
	public void setTxAmount(float txAmount) {
		this.txAmount = txAmount;
	}
	public Date getTxDate() {
		return txDate;
	}
	public void setTxDate(Date txDate) {
		this.txDate = txDate;
	}

}
