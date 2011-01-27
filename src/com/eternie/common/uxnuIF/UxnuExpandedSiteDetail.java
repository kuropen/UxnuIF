package com.eternie.common.uxnuIF;

/**
 * ux.nu で展開したサイトの詳細データ。
 * @author Eternie, Hirochika Yuda
 */
public class UxnuExpandedSiteDetail extends UxnuSiteDetail {

	private boolean whitelist;
	private String origaddr;
	
	/**
	 * 通常のコンストラクタ。主にパースしたJSONデータから構造体を初期化する手段として、ライブラリ内部で使用する。
	 * @param bl ブラックリスト
	 * @param mw マルウェア
	 * @param sf 安全
	 * @param addr URL
	 * @param nw 新規登録
	 * @param st ステータスコード
	 * @param wl ホワイトリスト
	 * @param oa オリジナルURL
	 * @deprecated nwは{@link UxnuShortenedSiteDetail}特有フィールドとなったため不要
	 */
	public UxnuExpandedSiteDetail(boolean bl, boolean mw, boolean sf,
			String addr, boolean nw, int st, boolean wl, String oa) {
		super(bl, mw, sf, addr, nw, st);
		if (oa == null) {
			oa = addr;
		}
		origaddr = oa;
		whitelist = wl;
	}

	/**
	 * 通常のコンストラクタ。主にパースしたJSONデータから構造体を初期化する手段として、ライブラリ内部で使用する。
	 * @param bl ブラックリスト
	 * @param mw マルウェア
	 * @param sf 安全
	 * @param addr URL
	 * @param st ステータスコード
	 * @param wl ホワイトリスト
	 * @param oa オリジナルURL
	 */
	public UxnuExpandedSiteDetail(boolean bl, boolean mw, boolean sf,
			String addr, int st, boolean wl, String oa) {
		super(bl, mw, sf, addr, st);
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
		System.out.println("Status:" + this.getStatus());
		System.out.println("Whitelist:" + this.isWhiteListed());
		System.out.println("Original URL:" + this.getOriginalURL());
	}
	
}
