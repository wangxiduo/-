package read;

import java.util.HashMap;

import org.json.JSONObject;

import com.baidu.aip.ocr.AipOcr;

public class sample {
	public void test(AipOcr client) {
	    // 传入可选参数调用接口
	    HashMap<String, String> options = new HashMap<String, String>();
	    options.put("language_type", "CHN_ENG");
	    options.put("detect_direction", "true");
	    options.put("detect_language", "true");
	    options.put("probability", "true");
	    
	    // 参数为本地图片路径
	    String image = "E:\\Testpics\\1538059427378.jpg";
	    JSONObject res = client.basicGeneral(image, options);
	    System.out.println(res.toString(2));
	}
	public static void main(String[] args) {
		 AipOcr client = new AipOcr("11634325","oOsxvYn9KSh6c4Abn958LjfH", "hAsEuUbxnGshEiC6fqIbE7bEmqIx78U3");
		    HashMap<String, String> options = new HashMap<String, String>();
		    options.put("language_type", "CHN_ENG");
		    options.put("detect_direction", "true");
		    options.put("detect_language", "true");
		    options.put("probability", "true");
		    
		    // 参数为本地图片路径
		    String image = "E:\\Testpics\\1538059499921.jpg";
		    JSONObject res = client.basicGeneral(image, options);
		    System.out.println(res.toString(2));
	}

}
