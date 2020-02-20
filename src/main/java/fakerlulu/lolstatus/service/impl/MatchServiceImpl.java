package fakerlulu.lolstatus.service.impl;

import java.util.Map;

import org.springframework.stereotype.Service;

import fakerlulu.lolstatus.service.ApiConnectService;
import fakerlulu.lolstatus.service.MatchService;

@Service
public class MatchServiceImpl implements MatchService {

	@Override
	public Map<String, Object> getAllMatchInfo(String accountId, int endIndex) {
		ApiConnectService apiConnecter = new ApiConnectServiceImpl();
		String option = "";
		if (endIndex <= 100) {
			option += "&endIndex=" + endIndex;
		}
		String apiAddress = "https://kr.api.riotgames.com/lol/match/v4/matchlists/by-account/";
		Map<String, Object> matchesObj = apiConnecter.GetApiResponse(accountId, apiAddress, option);
		Map<String, Object> match = (Map<String, Object>) matchesObj.get("matches");
		for (String id : match.keySet()) {
			String matchId = ((Map<String, Object>) match.get(id)).get("gameId").toString();
			String useChampion = ((Map<String, Object>) match.get(id)).get("champion").toString();
			match.replace(id, getMatchDetail(matchId));
			((Map<String, Object>) match.get(id)).put("champion", useChampion);
		}
		matchesObj.replace("matches", match);
		return matchesObj;
	}

	@Override
	public Map<String, Object> getMatchDetail(String matchId) {
		ApiConnectService apiConnecter = new ApiConnectServiceImpl();
		String option = "";
		String apiAddress = "https://kr.api.riotgames.com/lol/match/v4/matches/";
		return apiConnecter.GetApiResponse(matchId, apiAddress, option);
	}
}
