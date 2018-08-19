package read;

import com.baidu.aip.ocr.AipOcr;

public class AIPOcrJava extends AipOcr {

	// …Ë÷√APPID/AK/SK
	public static final String APP_ID = "11634325";
	public static final String API_KEY = "oOsxvYn9KSh6c4Abn958LjfH";
	public static final String SECRET_KEY = "hAsEuUbxnGshEiC6fqIbE7bEmqIx78U3";

	public AIPOcrJava() {
		super(APP_ID, API_KEY, SECRET_KEY);
		this.setConnectionTimeoutInMillis(60000);
		this.setSocketTimeoutInMillis(20000);
		System.setProperty("aip.log4j.conf", "classpath/log4j.properties");
	}

	public AIPOcrJava(String aipId, String aipKey, String secretKey) {
		super(aipId, aipKey, secretKey);
		this.setConnectionTimeoutInMillis(60000);
		this.setSocketTimeoutInMillis(60000);
		System.setProperty("aip.log4j.conf", "classpath/log4j.properties");

	}
}
