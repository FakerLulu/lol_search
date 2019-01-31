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
		return apiConnecter.GetApiResponse(accountId, apiAddress, option);
	}
}
