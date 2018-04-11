<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html lang="cn">
<head>
<meta charset="utf-8">
<title>代理商管理系统</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="/css/public.css" rel="stylesheet" />
<link href="/css/main.css" rel="stylesheet" />
<link rel="stylesheet" id='skin' type="text/css"
	href="/js/alertframe/skin/simple_gray/ymPrompt.css" />
<link id='theme' rel='stylesheet' href='/js/humane/themes/original.css' />
<!-- jQuery -->
<script type="text/javascript" src="/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="/js/alertframe/ymPrompt.js"></script>
<script type="text/javascript" src="/js/humane/humane.js"></script>
<script type="text/javascript" src="/js/public.js"></script>
<script type="text/javascript" src="/js/main.js" charset="UTF-8"></script>

</head>
<body>
	<div class="mbxnav">
		账号:[
		<s:property value="user.userCode" />
		]LOG操作日志

	</div>
	<div class="container">
		<div class="seracheruserdiv ope">
			<ul>
				<li>
					<form action="/loglist.action" method="post">
						<input type="text" id="usercode" name="userCode" value="<s:property value='user.userCode'/>">
						<input type="text" id="userid" name="userId" value="<s:property value='user.id'/>">
						操作时间:
						<input type="text" name="logs.operateDatetime" 
						value='<s:date name="logs.operateDatetime" format="yyyy-MM-dd"/>'/>
						<input type="submit" value="查看"/>
					</form>
				</li>
			</ul>
			
			<table>
				<tr>
					<td>登录账户</td>
					<td>操作信息</td>
					<td>操作时间</td>
				</tr>
				<s:iterator value="logsList">
				<tr>
					<td><s:property value="userName"/></td>
					<td><s:property value="operateInfo"/></td>
					<td><s:date name="operateDatetime" format="yyyy-MM-dd"/></td>
				</tr>
				</s:iterator>
			</table>
		</div>
	</div>
	<link rel="stylesheet" href="/css/loglist.css" />
</body>
</html>
<s:debug/>