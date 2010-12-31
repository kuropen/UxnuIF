package com.eternie.common.uxnuIF;

/**
 * ux.nu で短縮したサイトの詳細データ。
 * @author Eternie, Hirochika Yuda
 * @see {@link UxnuInterface#shortenURLWithDetail(String)}
 */
public class UxnuShortenedSiteDetail {
	private boolean blacklist;
	private boolean malware;
	private boolean safe;
	private String url;
	private boolean isNew;
	private int status;
	
	/**
	 * デフォルトコンストラクタ。通常はこちらをコールすることはないが、事故防止のため設定。
	 */
	public UxnuShortenedSiteDetail () {
		blacklist = false;
		malware = false;
		safe = false;
		url = "";
		isNew = false;
		status = 0;
	}
	
	/**
	 * 通常のコンストラクタ。主にパースしたJSONデータから構造体を初期化する手段として、ライブラリ内部で使用する。
	 * @param bl ブラックリスト
	 * @param mw マルウェア
	 * @param sf 安全
	 * @param addr URL
	 * @param nw 新規登録
	 * @param st ステータスコード
	 */
	public UxnuShortenedSiteDetail (boolean bl, boolean mw, boolean sf, String addr, boolean nw, int st) {
		blacklist = bl;
		malware = mw;
		safe = sf;
		url = addr;
		isNew = nw;
		status = st;
	}
	
	/**
	 * ブラックリストに登録されているか
	 */
	public boolean isBlackListed() {
		return blacklist;
	}
	
	/**
	 * マルウェア配信リストに登録されているか
	 */
	public boolean isMalware () {
		return malware;
	}
	
	/**
	 * 安全なサイトに登録されているか
	 */
	public boolean isSafe () {
		return safe;
	}
	
	/**
	 * 短縮後のURL
	 */
	public String getUrl () {
		return url;
	}
	
	/**
	 * 新規登録か
	 */
	public boolean isNew () {
		return isNew;
	}
	
	/**
	 * HTTPステータスコード
	 */
	public int getStatus () {
		return status;
	}
	
	/**
	 * オブジェクト内容のダンプを行う。主にデバッグ用。
	 * @param obj 対象オブジェクト
	 */
	public static void dump (UxnuShortenedSiteDetail obj) {
		System.out.println("Blacklist:" + obj.isBlackListed());
		System.out.println("Malware:" + obj.isMalware());
		System.out.println("Safe:" + obj.isSafe());
		System.out.println("URL:" + obj.getUrl());
		System.out.println("New:" + obj.isNew());
		System.out.println("Status:" + obj.getStatus());
	}
	
}
