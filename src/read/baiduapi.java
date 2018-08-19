package read;

import java.io.IOException;
import java.util.HashMap;

import org.json.JSONObject;

import com.baidu.aip.ocr.AipOcr;
import com.baidu.aip.util.Util;

public class baiduapi {
	
    //����APPID/AK/SK
    public static final String APP_ID = "11634325";
    public static final String API_KEY = "oOsxvYn9KSh6c4Abn958LjfH";
    public static final String SECRET_KEY = "hAsEuUbxnGshEiC6fqIbE7bEmqIx78U3";
	public static void main(String[] args) {
	    // ��ʼ��һ��AipOcr
        AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);

        // ��ѡ�������������Ӳ���
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

/*        // ��ѡ�����ô����������ַ, http��socket��ѡһ�����߾�������
        client.setHttpProxy("proxy_host", proxy_port);  // ����http����
        client.setSocketProxy("proxy_host", proxy_port);  // ����socket����
*/
        // ��ѡ������log4j��־�����ʽ���������ã���ʹ��Ĭ������
        // Ҳ����ֱ��ͨ��jvm�����������ô˻�������
        System.setProperty("aip.log4j.conf", "path/to/your/log4j.properties");

        // ���ýӿ�
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
		// �����Ǵ�url
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
