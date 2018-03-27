package org.agent.service.function;

import java.util.List;

import org.agent.pojo.Function;

public interface FunctionService {
	// ���ȫ������
	public List<Function> getFunctionList();

	public Function getFunctionById(Function function);

	// ��ѯһ������
	public List<Function> getMenuFunctionList();

	//����ID��ѯ�����б�
	public List<Function> getFunctionByParentId(int parentId);

}
