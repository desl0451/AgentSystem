<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="/WEB-INF/pages/inc/head.jsp" />
<div class="mbxnav">
	<!-- 导航 -->
	<a href="javascript:void();">系统管理</a> \<a href="/userlist.action">用户管理</a>
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
				<li class="lititle">
					<b>修改代理商用户信息</b>
					<input id="m_id" type="hidden" name="id" /> 
				</li>
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
							svalue="<s:property value="configValue"/>"
							id="<s:property value="id"/>">
							
						修改</span> 
						<span class="deleteUser" 
							id="<s:property value="id"/>" 
							usercode="<s:property value="userCode"/>"
							roleid="<s:property value="roleId"/>" 
							>删除</span>
						<span>预付款</span>
						<span><a href="javascript:ymPrompt.win('/loglist.action?user.userId=<s:property value="id"/>&user.userCode=<s:property value="userCode"/>&logs.operateDatetime=<s:date name="creationTime" format="yyyy-MM-dd HH:mm:ss" />',1000,500,'LOG日志',handler,null,null,true)">LOG日志</a></span>
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
<script type="text/javascript">
		function cn(){
			ymPrompt.setDefaultCfg({title:'标题', message:"内容",okTxt:' 确 定 ',cancelTxt:' 取 消 ',closeTxt:'关闭'});
		}
		function en(){
			ymPrompt.setDefaultCfg({title:'Default Title', message:"Default Message",okTxt:' OK ',cancelTxt:' Cancel ',closeTxt:'close'});
		}
		function autoClose(){
			alert('三秒钟自动关闭');
			setTimeout(function(){ymPrompt.close()},3000)
		}
		function handlerIframe(){
			alert(ymPrompt.getPage().contentWindow.document.body.outerHTML);
			ymPrompt.close();
		}
		function noTitlebar(){
			alert('提示：除了可以通过增加按钮来控制，还可以在子页面中调用该页面的ymPrompt.close方法来关闭');
		}
		var Alert=ymPrompt.alert;
		function cancelFn(){
			Alert("点击了'取消'按钮");
		}
		function okFn(){
			Alert("点击了'确定'按钮");
		}
		function closeFn(){
			Alert("点击了'关闭'按钮");
		}
		function handler(tp){
			if(tp=='ok'){
				okFn();
			}
			if(tp=='cancel'){
				cancelFn();
			}
			if(tp=='close'){
				closeFn()
			}
		}
		function testHd(tp){
			Alert('你点击的按钮的标志为：'+tp);
		}
		function handler2(tp){
			if(tp=='ok'){
				ymPrompt.confirmInfo("保存成功!是否打印税票？",null,null,"问询提示",function(tp){tp=='ok'?ticketPrevie("print"):loadImposeInfo()})
			}
			if(tp=='cancel'){
				cancelFn();
			}
			if(tp=='close'){
				closeFn()
			}
		}
		function ticketPrevie(xx){
			Alert(xx)
		}
		function loadImposeInfo(){
			Alert("exit")
		}
	</script>
<s:debug></s:debug>