package com.eternie.common.uxnuIF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * ux.nu 操作ライブラリ
 * @author Hirochika Yuda
 * @version 1.2
 * @see <a href="http://ux.nu/developer.html">Developer - ux.nu</a>
 */
public class UxnuInterface {
	
	/**
	 * URLからテキストを読み込む
	 * @param strurl URL
	 * @return URL上にあるテキスト。エラー発生時はnull
	 * @throws IOException 通信エラーまたは入力ストリームでエラーが発生した場合にスローします
	 * @since 1.0
	 */
	private static String readFromURL(String strurl) throws IOException{
		URL url = new URL(strurl);
		URLConnection connection = url.openConnection();
		connection.setDoInput(true);
		InputStream inStream = connection.getInputStream();
		
		try {
			BufferedReader input =
					new BufferedReader(new InputStreamReader(inStream));
			
			String line = "";
			String ret = "";
			while ((line = input.readLine()) != null)
				ret += line;
			return ret;
		}finally{
			inStream.close();
		}
	}
	
	/**
	 * ux.nu APIにアクセスしてURLを短縮する
	 * @param url 短縮対象のURL
	 * @return 短縮されたURL(失敗の場合はもとの文字列)
	 * @since 1.0
	 * @deprecated {@link #shortenURLWithDetail(String)}を実行の上、戻り値を用いて{@link UxnuShortenedSiteDetail#getUrl()}を呼び出すことを推奨する。
	 */
	public static String shortenURL (String url) {
		String APIUrl = "http://ux.nu/api/short?url="+URLEncoder.encode(url)+"&format=plain";
		String ret;
		try {
			ret = readFromURL(APIUrl);
			return ret;
		} catch (IOException e) {
			ret = null;
			e.printStackTrace();
			return url;
		}
	}
	
	/**
	 * ux.nu APIにアクセスしてURLを短縮する。
	 * @param url 短縮対象のURL
	 * @return サイトデータを格納した{@link UxnuShortenedSiteDetail}のインスタンス
	 * @since 1.2
	 */
	@SuppressWarnings("deprecation")
	public static UxnuShortenedSiteDetail shortenURLWithDetail (String url) throws UxnuProcessException {
		JSONParser jp = new JSONParser();
		String APIUrl = "http://ux.nu/api/short?url="+URLEncoder.encode(url);
		String fetchResult;
		try {
			fetchResult = readFromURL(APIUrl);
			JSONObject obj = (JSONObject) jp.parse(fetchResult);
			JSONObject data = (JSONObject) obj.get("data");
			boolean bl = Boolean.parseBoolean((String)data.get("blacklist"));
			boolean mw = Boolean.parseBoolean((String)data.get("malware"));
			boolean sf = Boolean.parseBoolean((String)data.get("safe"));
			String addr = (String)data.get("url");
			boolean nw = Boolean.parseBoolean((String)obj.get("new"));
			int st = Integer.parseInt((String)obj.get("status_code"));
			UxnuShortenedSiteDetail ret = new UxnuShortenedSiteDetail(bl,mw,sf,addr,nw,st);
			return ret;
		} catch (Exception e) {
			throw new UxnuProcessException(e);
		}
	}
	
	/**
	 * ux.nu HugeURL APIにアクセスしてURLを展開する。他サービスにも適用可能。<br>
	 * ux.nu のURL展開を目的とする場合は{@link #expandURL(String)}を推奨。
	 * @param url 展開対象のURL
	 * @return 展開されたURL(失敗の場合はもとの文字列)
	 * @since 1.1
	 */
	@SuppressWarnings("deprecation")
	public static String hugeUrl (String url) {
		String APIUrl = "http://ux.nu/hugeurl?url="+URLEncoder.encode(url);
		String ret;
		try {
			ret = readFromURL(APIUrl);
			return ret;
		} catch (IOException e) {
			throw new UxnuProcessException(e);
		}
	}
	
	/**
	 * ux.nu Expand APIを用いて短縮URLを展開する。他サービスのURLも含めて展開したい場合は{@link #hugeUrl(String)}を使用する。<br>
	 * @param url 展開するURL
	 * @return サイトデータを格納した{@link UxnuExpandedSiteDetail}のインスタンス (失敗の場合は<code>null</code>)
	 */
	@SuppressWarnings("deprecation")
	public static UxnuExpandedSiteDetail expandURL (String url) {
		JSONParser jp = new JSONParser();
		String APIUrl = "http://ux.nu/api/expand?url="+URLEncoder.encode(url);
		String fetchResult;
		try {
			fetchResult = readFromURL(APIUrl);
			JSONObject obj = (JSONObject) jp.parse(fetchResult);
			JSONObject data = (JSONObject) obj.get("data");
			boolean bl = Boolean.parseBoolean((String)data.get("blacklist"));
			boolean mw = Boolean.parseBoolean((String)data.get("malware"));
			boolean sf = Boolean.parseBoolean((String)data.get("safe"));
			String addr = (String)data.get("exp");
			String origaddr = (String)data.get("origexp");
			long tmpWhiteList;
			try {
				tmpWhiteList = (Long)data.get("whitelist");
			}catch(NullPointerException e) {
				tmpWhiteList = 0;
			}
			long st = (Long)obj.get("status_code");
			//UxnuShortenedSiteDetail ret = new UxnuShortenedSiteDetail(bl,mw,sf,addr,nw,st);
			UxnuExpandedSiteDetail ret = new UxnuExpandedSiteDetail(bl,mw,sf,addr,(int)st,(tmpWhiteList == 1) ? true : false, origaddr);
			return ret;
		} catch (Exception e) {
			throw new UxnuProcessException(e);
		}
	}
}
