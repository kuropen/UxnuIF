package com.eternie.common.uxnuIF;

/**
 * ux.nu から返されたJSONデータを構造化するための共通クラス
 * @author Eternie, Hirochika Yuda
 * @since 1.3
 */
public abstract class UxnuSiteDetail {

	private boolean blacklist;
	private boolean malware;
	private boolean safe;
	private String url;
	private boolean isNew;
	private int status;
	
	/**
	 * 通常のコンストラクタ。主にパースしたJSONデータから構造体を初期化する手段として、ライブラリ内部で使用する。
	 * @param bl ブラックリスト
	 * @param mw マルウェア
	 * @param sf 安全
	 * @param addr URL
	 * @param nw 新規登録
	 * @param st ステータスコード
	 */
	public UxnuSiteDetail (boolean bl, boolean mw, boolean sf, String addr, boolean nw, int st) {
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
	public abstract void dump ();
	
}
