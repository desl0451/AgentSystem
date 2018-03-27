package org.agent.dao.function;

import java.util.List;

import org.agent.pojo.Function;

public interface FunctionMapper {
	// ���ȫ������
	public List<Function> getFunctionList();

	public Function getFunctionById(Function function);

	// ��ѯһ������
	public List<Function> getMenuFunctionList();

	//����ID��ѯ�����б�
	public List<Function> getFunctionByParentId(int parentId);
}
