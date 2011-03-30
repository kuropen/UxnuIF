package com.eternie.common.uxnuIF;

/**
 * ux.nu インターフェイスを使う上で発生するエラーをハンドルするための例外クラス
 * @author Hirochika Yuda, eternie@eternie-labs.net
 * @since Release 2
 */
public class UxnuProcessException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8056993230425121909L;
	
	private Integer statCode;
	
	/**
	 * デフォルトコンストラクタ
	 */
	public UxnuProcessException () {
		statCode = null;
	}
	
	/**
	 * ステータスコード異常のケース：ステータスコードを含める
	 * @param statCode
	 */
	public UxnuProcessException (int statCode) {
		super("Server returned status code " + statCode);
		this.statCode = new Integer(statCode);
	}
	
	/**
	 * 別のExceptionなどによりエラーが起きたケース：上位Exceptionを含める
	 * @param e
	 */
	public UxnuProcessException (Throwable e) {
		super(e);
		statCode = null;
	}
	
	/**
	 * サーバーの返したステータスコードを返す
	 * @return ステータスコード (そもそもサーバーに接続できていない場合はnullを返す)
	 */
	public Integer getStatCode () {
		return statCode;
	}

}
