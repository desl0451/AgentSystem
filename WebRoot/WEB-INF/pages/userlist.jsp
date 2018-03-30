<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="/WEB-INF/pages/inc/head.jsp" />
<div class="mbxnav">
	<!-- 导航 -->
	<a href="javascript:void();">系统管理</a> \ <a href="/userlist.action">用户管理</a>
</div>
<div class="container">
	
	<!-- 用户搜索 -->
	<div>
		<form action="/userlist.action" method="post">
			用户名称：<input id="a_roleName" type="text" name="user.userName" />
			角色：       <s:select name="user.roleId"  list="roleList" headerKey="" headerValue="--请选择--" listKey="id" listValue="roleName"></s:select>
			是否启用：<s:select name="user.isStart" list="#{'1':'启用','0':'未启用' }"></s:select>
			<input type="submit" name="" value="查询"/>
		</form>
	</div>
	<!-- 角色列表 -->
	<table>
		<thead>
			<tr>
				<th>登录账号</th>
				<th>用户名称</th>
				<th>角色</th>
				<th>创建时间</th>
				<th>是否启用</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="userList" status="st">
				<tr>
					<td><s:property value="userCode" /></td>
					<td><s:property value="userName" /></td>
					<td><s:property value="roleName" /></td>
					<td><s:date name="creationTime" format="yyyy-MM-dd HH:mm:ss" /></td>
					<td><s:if test="isStart==1">启用</s:if> <s:else>停用</s:else></td>
					<td><span class="modifyUser">修改</span> 
						<span class="deleteRole" roleid="<s:property value="id"/>" rolename="<s:property value="roleName"/>">删除</span>
					</td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
</div>

<jsp:include page="/WEB-INF/pages/inc/foot.jsp" />
<link rel="stylesheet" type="text/css" href="/css/userlist.css">
<script type="text/javascript" src="/js/userlist.js"></script>
</body>
</html>
<s:debug></s:debug>