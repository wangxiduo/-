package read;

import java.io.IOException;
import java.util.HashMap;

import org.json.JSONObject;

import com.baidu.aip.util.Util;


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
