package fakerlulu.lolstatus.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fakerlulu.lolstatus.service.MatchService;
import fakerlulu.lolstatus.service.SummonerService;

@RestController
@RequestMapping(path = "/api")
public class LolStatusRestController {// api이름자체가 컨트롤러에서 별로
	@Autowired
	private SummonerService summonerInfo;
	@Autowired
	private MatchService matchInfoSearcher;

	@GetMapping(path = "/summoner/{summonerName}")
	public Map<String, Object> getSummoner(@PathVariable(name = "summonerName") String sname) {
		// Summoner smInfo = summonerInfo.getPromotionList(sname);
		Map<String, Object> summonerObj = summonerInfo.getPromotionList(sname);

		summonerObj.replace("name", sname);

		return summonerObj;
	}

	@GetMapping(path = "/match/{accountId}")
	public Map<String, Object> getAllMatches(@PathVariable(name = "accountId") String accountId) {
		Map<String, Object> matchesObj = matchInfoSearcher.getAllMatchInfo(accountId, 2);
		System.out.println(matchesObj.toString());
		return matchesObj;
	}
	// http://ddragon.leagueoflegends.com/cdn/6.24.1/data/en_US/champion.json 챔피언
	// 데이터
}
