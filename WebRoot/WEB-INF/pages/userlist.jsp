<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="/WEB-INF/pages/inc/head.jsp" />
<div class="mbxnav">
	<!-- 导航 -->
	<a href="javascript:void();">系统管理</a> \ <a href="/userlist.action">用户管理</a>
</div>
<div class="container">
	
	<!-- 添加面板 -->
	<div id="addUserDiv" class="addUserDivClass addback">
		<form>
			<ul>
				<li class="lititle"><b>添加代理商用户信息</b></li>
				<li>登录账号 ：<input id="a_userCode" type="text" name="user.userCode" value="<s:property value="user.userCode"/>"/> <span>*</span></li>
				<li>用户名称 ：<input id="a_userName" type="text" name="user.userName" /> <span>*</span></li>
				<li>登录密码 ： <input id="a_userPassword" type="password" name="user.userPassword" value="123456"/><span>*默认初始密码123456</span> 
				<li>角色名称 ：<s:select id="a_roleId"  list="roleList" name="user.roleId" headerKey="" headerValue="--请选择--" listKey="id" listValue="roleName"></s:select>

				</li>
				<li>是否启用 ：<select id="a_isStart" name="user.isStart">
							<option value="1" selected="selected">启用</option>
							<option value="0">停用</option>
						   </select> 
				    <input id="addUserSubmit" type="button" value="保存" />
					<input id="addCancel" type="reset" value="取消" />
				</li>
			</ul>
		</form>
	</div>
	<!-- 修改面板 -->
	<div id="modifyUserDiv" class="addUserDivClass modifyback">
		<ul>
			<li class="lititle"><b>修改代理商用户信息</b></li>
				<li>登录账号 ：<input id="m_userCode" type="text" name="user.userCode" /> <span>*</span></li>
				<li>用户名称 ：<input id="m_userName" type="text" name="user.userName" /> <span>*</span></li>
				<li>登录密码 ： <input id="m_userPassword" type="password" name="user.userPassword" value="123456"/><span>*默认初始密码123456</span> 
				<li>角色名称 ：<s:select id="m_roleId"  list="roleList" name="user.roleId" headerKey="" headerValue="--请选择--" listKey="id" listValue="roleName"></s:select>

				</li>
				<li>是否启用 ：<select id="m_isStart" name="user.isStart">
							<option value="1" selected="selected">启用</option>
							<option value="0">停用</option>
						   </select> 
				    <input id="modifyUserSubmit" type="button" value="保存" />
					<input id="modifyCancel" type="reset" value="取消" />
				</li>
		</ul>
	</div>
	
	<div class="addUserDiv">
		<input id="addUser" type="button" value="新增" />
	</div>
	<!-- 用户搜索 -->
	<div>
		<form action="/userlist.action" method="post">
			用户名称：<input id="a_roleName" type="text" name="user.userName" value='<s:property value="user.userName"/>'/>
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
					<td><span class="modifyUser"
							usercode="<s:property value="userCode"/>"	
							username="<s:property value="userName"/>"
							userpassword="<s:property value="userPassword"/>"
							roleid="<s:property value="roleId"/>" 
							isstart="<s:property value="isStart"/>"
							svalue="<s:property value="configValue"/>">
						修改</span> 
						<span class="deleteRole" id="<s:property value="id"/>" rolename="<s:property value="roleName"/>">删除</span>
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