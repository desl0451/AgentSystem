package org.agent.service.logs;

import java.util.List;

import org.agent.dao.logs.LogsMapper;
import org.agent.pojo.Logs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("logsService")
public class LogsServiceImpl implements LogsService {

	@Autowired
	private LogsMapper logsMapper;

	public LogsMapper getLogsMapper() {
		return logsMapper;
	}

	public void setLogsMapper(LogsMapper logsMapper) {
		this.logsMapper = logsMapper;
	}

	@Override
	public List<Logs> getList(Logs logs) {
		// TODO Auto-generated method stub
		return logsMapper.getList(logs);
	}

	@Override
	public int addLogs(Logs logs) {
		// TODO Auto-generated method stub
		return logsMapper.addLogs(logs);
	}

	@Override
	public int count(Logs logs) {
		// TODO Auto-generated method stub
		return logsMapper.count(logs);
	}

}
