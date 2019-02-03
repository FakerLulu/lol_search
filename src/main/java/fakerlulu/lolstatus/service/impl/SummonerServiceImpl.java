package fakerlulu.lolstatus.service.impl;

import java.util.Map;

import org.springframework.stereotype.Service;

import fakerlulu.lolstatus.service.ApiConnectService;
import fakerlulu.lolstatus.service.SummonerService;

@Service
public class SummonerServiceImpl implements SummonerService {

	@Override
	public Map<String, Object> getSummoner(String sname) {
		ApiConnectService apiConnecter = new ApiConnectServiceImpl();
		String option = "";
		String apiAddress = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/";
		return apiConnecter.GetApiResponse(sname, apiAddress, option);
	}

}
