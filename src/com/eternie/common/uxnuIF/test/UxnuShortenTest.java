package com.eternie.common.uxnuIF.test;

import com.eternie.common.uxnuIF.*;

/**
 * Ux.nu 短縮API (JSON版) 動作確認用クラス
 * @author Eternie, Hirochika Yuda
 */
public class UxnuShortenTest {

	public static void main (String[] args) {
		final String targetURL = "http://www.gehirn.co.jp/";
		final String targetURL2 = "http://ux.nu/Gehirn";
		final String targetURL3 = "http://ux.nu/secure";
		UxnuShortenedSiteDetail result = UxnuInterface.shortenURLWithDetail(targetURL);
		result.dump();
		UxnuExpandedSiteDetail result2 = UxnuInterface.expandURL(targetURL2);
		UxnuExpandedSiteDetail result3 = UxnuInterface.expandURL(targetURL3);
		result2.dump();
		result3.dump();
	}
	
}
