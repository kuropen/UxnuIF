package com.eternie.common.uxnuIF;

public class UxnuExpandedSiteDetail extends UxnuSiteDetail {

	private boolean whitelist;
	private String origaddr;
	
	public UxnuExpandedSiteDetail(boolean bl, boolean mw, boolean sf,
			String addr, boolean nw, int st, boolean wl, String oa) {
		super(bl, mw, sf, addr, nw, st);
		if (oa == null) {
			oa = addr;
		}
		origaddr = oa;
		whitelist = wl;
	}

	public boolean isWhiteListed() {
		return whitelist;
	}
	
	public String getOriginalURL () {
		return origaddr;
	}
	
	@Override
	public void dump() {
		System.out.println("---------------------------");
		System.out.println("Blacklist:" + this.isBlackListed());
		System.out.println("Malware:" + this.isMalware());
		System.out.println("Safe:" + this.isSafe());
		System.out.println("URL:" + this.getUrl());
		System.out.println("New:" + this.isNew());
		System.out.println("Status:" + this.getStatus());
		System.out.println("Whitelist:" + this.isWhiteListed());
		System.out.println("Original URL:" + this.getOriginalURL());
	}

}
