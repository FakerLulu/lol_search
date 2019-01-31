package com.nts.pjt3.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nts.pjt3.service.SummonerService;

@RestController
@RequestMapping(path = "/api")
public class ReservationRestController {// api이름자체가 컨트롤러에서 별로
	@Autowired
	private SummonerService summonerInfo;

	@GetMapping(path = "/summoner/{summoner_name}")
	public Map<String, Object> getPromotion(@PathVariable(name = "summoner_name") String sname) {
		// Summoner smInfo = summonerInfo.getPromotionList(sname);
		JSONObject summonerObj = summonerInfo.getPromotionList(sname);
		Map<String, Object> map = new HashMap<String, Object>();

		Iterator<String> keysItr = summonerObj.keys();
		while (keysItr.hasNext()) {
			String key = keysItr.next();
			Object value = summonerObj.get(key);
			if (key.equals("name")) {
				map.put(key, sname);
			}
			map.put(key, value);
		}
		return map;
	}
	// http://ddragon.leagueoflegends.com/cdn/6.24.1/data/en_US/champion.json 챔피언
	// 데이터
}
