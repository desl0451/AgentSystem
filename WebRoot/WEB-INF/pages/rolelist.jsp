<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="/WEB-INF/pages/inc/head.jsp" />
<div class="mbxnav">
	<!-- 导航 -->
	<a href="javascript:void();">系统管理</a> \ <a href="/rolelist.action">角色管理</a>
</div>
<div class="container">
	<!-- 添加面板 -->
	<div id="addRoleDiv" class="addRoleDivClass addback">
		<form>
			<ul>
				<li class="lititle"><b>添加角色信息</b></li>
				<li>角色名称：<input id="a_roleName" type="text" name="role.roleName" /> <span>*</span>
				</li>
				<li>是否启用： <select id="a_isStart" name="role.isStart">
							<option value="1" selected="selected">启用</option>
							<option value="0">不启用</option>
						  </select> <span>*</span> 
				    <input id="addRoleSubmit" type="button" value="保存" />
					<input id="addCancel" type="reset" value="取消" />
				</li>
			</ul>
		</form>
	</div>
	<!-- 修改面板 -->
	<div id="modifyRoleDiv" class="addRoleDivClass modifyback">
		<ul>
			<li class="lititle"><br>修改角色信息</li>
			<input id="m_roleId" type="hidden" name="role.id" />
			<li>角色名称：  <input type="text" id="m_roleName" name="role.roleName" /></li>
			<li>是否启用: <select id="m_isStart" name="role.isStart">
							<option value="1" selected="selected">启用</option>
							<option value="0">停用</option>
					   </select> 
				<input id="modifyRoleSubmit" type="button" value="保存"> 
				<input id="modifyCancel" type="reset" value="取消">
			</li>
		</ul>
	</div>
	<div class="addRoleDiv">
		<input id="addRole" type="button" value="新增" />
	</div>
	<!-- 角色列表 -->
	<table>
		<thead>
			<tr>
				<th>角色名称</th>
				<th>创建时间</th>
				<th>是否启用</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="roleList" status="st">
				<tr>
					<td><s:property value="roleName" /></td>
					<td><s:date name="creationTime" format="yyyy-MM-dd HH:mm:ss" /></td>
					<td><s:if test="isStart==1">启用</s:if> <s:else>停用</s:else></td>
					<td><span class="modifyRole" 
							roleid="<s:property value="id"/>"	
							rolename="<s:property value="roleName"/>" 
							isstart="<s:property value="isstart"/>"
							svalue="<s:property value="configValue"/>">
							修改
						</span> 
						<span class="deleteRole" roleid="<s:property value="id"/>"	rolename="<s:property value="roleName"/>">删除</span>
					</td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
</div>

<jsp:include page="/WEB-INF/pages/inc/foot.jsp" />
<link rel="stylesheet" type="text/css" href="/css/rolelist.css">
<script type="text/javascript" src="/js/rolelist.js"></script>
</body>
</html>
<s:debug></s:debug>