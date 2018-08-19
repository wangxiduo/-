package read;

import java.io.IOException;
import java.util.HashMap;

import org.json.JSONObject;

import com.baidu.aip.ocr.AipOcr;
import com.baidu.aip.util.Util;

public class baiduapi {
	
    //设置APPID/AK/SK
    public static final String APP_ID = "11634325";
    public static final String API_KEY = "oOsxvYn9KSh6c4Abn958LjfH";
    public static final String SECRET_KEY = "hAsEuUbxnGshEiC6fqIbE7bEmqIx78U3";
	public static void main(String[] args) {
	    // 初始化一个AipOcr
        AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

/*        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
        client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
        client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理
*/
        // 可选：设置log4j日志输出格式，若不设置，则使用默认配置
        // 也可以直接通过jvm启动参数设置此环境变量
        System.setProperty("aip.log4j.conf", "path/to/your/log4j.properties");

        // 调用接口
        String path = "E:\\Testpics\\1533040968127.jpg";
        JSONObject res = client.basicGeneral(path, new HashMap<String, String>());
        System.out.println(res.toString(2));
		
	}
	
	public static JSONObject enhancedGeneral(String file) {
		HashMap<String, String> options = new HashMap<>(6);

		options.put("language_type", "CHN_ENG");
		options.put("detect_direction", "true");
		options.put("detect_language", "true");
		options.put("probability", "true");
		AIPOcrJava aipOcrJava = new AIPOcrJava();
		// JSONObject jsonObject = aipOcrJava.basicAccurateGeneral(file, options);
		// 或者是传url
		byte[] bytes = new byte[0];
		try {
			bytes = Util.readFileByBytes(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		JSONObject jsonObject = aipOcrJava.enhancedGeneral(bytes, options);
		// ResultBean bean =
		// com.alibaba.fastjson.JSONObject.toJavaObject(com.alibaba.fastjson.JSONObject.parseObject(jsonObject.toString()),
		// ResultBean.class);

		return jsonObject;
	}	
}
