package fakerlulu.lolstatus.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

	@GetMapping(path = "/summonerMatches/")
	public Map<String, Object> getSummonerMatches(@RequestParam(name = "summonerName") String sname,
			@RequestParam(name = "count", defaultValue = "1") int matchCount) {
		Map<String, Object> summonerObj = summonerInfo.getSummoner(sname);
		Map<String, Object> matchesObj = matchInfoSearcher.getAllMatchInfo((String) summonerObj.get("accountId"),
				matchCount);
		summonerObj.put("matches", matchesObj.get("matches"));
		return summonerObj;
	}

	@GetMapping(path = "/match/")
	public Map<String, Object> getAllMatches(@RequestParam(name = "accountId") String accountId,
			@RequestParam(name = "count") int matchCount) {
		Map<String, Object> matchesObj = matchInfoSearcher.getAllMatchInfo(accountId, matchCount);
		System.out.println(matchesObj.toString());
		return matchesObj;
	}

	@GetMapping(path = "/match_detail/{matchId}")
	public Map<String, Object> getMatchDetail(@PathVariable(name = "matchId") String matchId) {
		Map<String, Object> matchesObj = matchInfoSearcher.getMatchDetail(matchId);
		System.out.println(matchesObj.toString());
		return matchesObj;
	}
	// http://ddragon.leagueoflegends.com/cdn/6.24.1/data/en_US/champion.json 챔피언
	// 데이터
}
