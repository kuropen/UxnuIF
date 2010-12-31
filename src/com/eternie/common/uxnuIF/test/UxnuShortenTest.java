package com.eternie.common.uxnuIF.test;

import com.eternie.common.uxnuIF.*;

/**
 * Ux.nu 短縮API (JSON版) 動作確認用クラス
 * @author Eternie, Hirochika Yuda
 */
public class UxnuShortenTest {

	public static void main (String[] args) {
		final String targetURL = "http://www.gehirn.co.jp/";
		UxnuShortenedSiteDetail result = UxnuInterface.shortenURLWithDetail(targetURL);
		UxnuShortenedSiteDetail.dump(result);
	}
	
}
