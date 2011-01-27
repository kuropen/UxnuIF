package com.eternie.common.uxnuIF;

/**
 * ux.nu で短縮したサイトの詳細データ。
 * @author Eternie, Hirochika Yuda
 * @see UxnuInterface#shortenURLWithDetail(String)
 */
public class UxnuShortenedSiteDetail extends UxnuSiteDetail {
	
	/**
	 * 通常のコンストラクタ。主にパースしたJSONデータから構造体を初期化する手段として、ライブラリ内部で使用する。
	 * @param bl ブラックリスト
	 * @param mw マルウェア
	 * @param sf 安全
	 * @param addr URL
	 * @param nw 新規登録
	 * @param st ステータスコード
	 */
	public UxnuShortenedSiteDetail(boolean bl, boolean mw, boolean sf,
			String addr, boolean nw, int st) {
		super(bl, mw, sf, addr, nw, st);
	}

	/**
	 * オブジェクト内容のダンプを行う。主にデバッグ用。
	 * @param obj 対象オブジェクト
	 */
	@Override
	public void dump () {
		System.out.println("---------------------------");
		System.out.println("Blacklist:" + this.isBlackListed());
		System.out.println("Malware:" + this.isMalware());
		System.out.println("Safe:" + this.isSafe());
		System.out.println("URL:" + this.getUrl());
		System.out.println("New:" + this.isNew());
		System.out.println("Status:" + this.getStatus());
	}
	
}
