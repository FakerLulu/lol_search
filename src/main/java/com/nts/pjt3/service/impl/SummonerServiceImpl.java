package com.nts.pjt3.service.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.nts.pjt3.dto.Summoner;
import com.nts.pjt3.service.SummonerService;

@Service
public class SummonerServiceImpl implements SummonerService {

	@Override
	public JSONObject getPromotionList(String sname) {
		Summoner summoner = new Summoner();
		String apiKey = "RGAPI-06544e87-fa23-4aad-85ab-03e3b139627b";// api 키";
		StringBuffer res = new StringBuffer();
		try {
			String decodeArea = new String(sname.getBytes("8859_1"), "UTF-8");
			String text = URLEncoder.encode(sname, "UTF-8");
			String apiURL = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/" + text + "?api_key="
					+ apiKey;
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

			System.out.println(new String(res.toString().getBytes(), "utf-8"));

			br.close();
			return jsonObj;

		} catch (Exception e) {
		}
		return null;
	}

}
