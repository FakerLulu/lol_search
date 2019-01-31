package fakerlulu.lolstatus.service;

import java.util.Map;

public interface MatchService {

	Map<String, Object> getAllMatchInfo(String accountId, int endIndex);

}
