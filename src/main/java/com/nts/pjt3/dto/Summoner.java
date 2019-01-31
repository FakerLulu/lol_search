package com.nts.pjt3.dto;


public class Summoner {

	
	int profileIconId;
	String name;
	String puuid;
	long summonerLevel;
	long revisionDate;
	String id;
	String accountId;
	@Override
	public String toString() {
		return "Summoner [profileIconId=" + profileIconId + ", name=" + name + ", puuid=" + puuid + ", summonerLevel="
				+ summonerLevel + ", revisionDate=" + revisionDate + ", id=" + id + ", accountId=" + accountId + "]";
	}
	public int getProfileIconId() {
		return profileIconId;
	}
	public void setProfileIconId(int profileIconId) {
		this.profileIconId = profileIconId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPuuid() {
		return puuid;
	}
	public void setPuuid(String puuid) {
		this.puuid = puuid;
	}
	public long getSummonerLevel() {
		return summonerLevel;
	}
	public void setSummonerLevel(long summonerLevel) {
		this.summonerLevel = summonerLevel;
	}
	public long getRevisionDate() {
		return revisionDate;
	}
	public void setRevisionDate(long revisionDate) {
		this.revisionDate = revisionDate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	
	
}
