package fakerlulu.lolstatus.service.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import fakerlulu.lolstatus.service.ApiConnectService;

public class ApiConnectServiceImpl implements ApiConnectService {
	public Map<String, Object> GetApiResponse(String information, String apiAddress, String option) {
		try {
			StringBuffer res = new StringBuffer();
			String apiKey = "RGAPI-b7451a8c-4b28-4138-9255-70015e67f0b8";// api 키";
			String text = URLEncoder.encode(information, "UTF-8");
			String apiURL = apiAddress + text + "?api_key=" + apiKey + option;
			System.out.println(apiURL);
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("api_key", apiKey);
			int responseCode = con.getResponseCode();
			BufferedReader br;
			if (responseCode == 200) { // 정상 호출
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else { // 에러 발생
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}

			String inputLine;

			while ((inputLine = br.readLine()) != null) {
				res.append(inputLine);
			}

			JSONObject jsonObj = new JSONObject(new String(res.toString().getBytes(), "utf-8"));

			br.close();
			return ConvertJSONToMap(jsonObj);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	private Map<String, Object> ConvertJSONToMap(JSONObject jsonObj) {
		Map<String, Object> map = new HashMap<String, Object>();
		Iterator<String> keysItr = jsonObj.keys();
		while (keysItr.hasNext()) {
			String key = keysItr.next();
			Object value = jsonObj.get(key);
			if (value instanceof JSONObject) {
				map.put(key, ConvertJSONToMap((JSONObject) value));
				continue;
			}
			if (value instanceof JSONArray) {
				JSONArray jsonArr = (JSONArray) value;

				map.put(key, ConvertJSONArrayToMap(jsonArr, key));

				continue;
			}
			map.put(key, value);
		}
		return map;
	}

	private Map<String, Object> ConvertJSONArrayToMap(JSONArray jsonArr, String key) {
		Map<String, Object> map = new HashMap<String, Object>();
		int num = 1;
		for (int i = 0; i < jsonArr.length(); i++) {
			map.put("" + num++, ConvertJSONToMap((JSONObject) jsonArr.get(i)));
		}
		return map;
	}

}
