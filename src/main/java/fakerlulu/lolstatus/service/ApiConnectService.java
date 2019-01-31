package fakerlulu.lolstatus.service;

import java.util.Map;

public interface ApiConnectService {
	public Map<String, Object> GetApiResponse(String sname, String apiAddress, String option);
}
