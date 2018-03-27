package org.agent.dao.function;

import java.util.List;

import org.agent.pojo.Function;

public interface FunctionMapper {
	// 获得全部内容
	public List<Function> getFunctionList();

	public Function getFunctionById(Function function);

	// 查询一级功能
	public List<Function> getMenuFunctionList();

	//按父ID查询功能列表
	public List<Function> getFunctionByParentId(int parentId);
}
