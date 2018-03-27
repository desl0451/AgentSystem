package org.agent.service.function;

import java.util.List;

import org.agent.dao.function.FunctionMapper;
import org.agent.pojo.Function;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("functionService")
public class FunctionServiceImpl implements FunctionService {
	@Autowired
	private FunctionMapper functionMapper;

	@Override
	public List<Function> getFunctionList() {
		// TODO Auto-generated method stub
		return functionMapper.getFunctionList();
	}

	@Override
	public Function getFunctionById(Function function) {
		// TODO Auto-generated method stub
		return functionMapper.getFunctionById(function);
	}

	@Override
	public List<Function> getMenuFunctionList() {
		// TODO Auto-generated method stub
		return functionMapper.getMenuFunctionList();
	}

	@Override
	public List<Function> getFunctionByParentId(int parentId) {
		// TODO Auto-generated method stub
		return functionMapper.getFunctionByParentId(parentId);
	}

}
