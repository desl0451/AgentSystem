<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html lang="cn">
<head>
<meta charset="utf-8">
<title>代理商管理系统</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="/css/public.css" rel="stylesheet" />
<link href="/css/main.css" rel="stylesheet" />
<link rel="stylesheet" id='skin' type="text/css" href="/js/alertframe/skin/simple_gray/ymPrompt.css" />
<link id='theme' rel='stylesheet' href='/js/humane/themes/original.css' />
<!-- jQuery -->
<script type="text/javascript" src="/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="/js/alertframe/ymPrompt.js"></script>
<script type="text/javascript" src="/js/humane/humane.js"></script>
<script type="text/javascript" src="/js/public.js"></script>
<script type="text/javascript" src="/js/main.js" charset="UTF-8"></script>
</head>
<body>
	<div class="head">
		<ul>
			<li><h2>
					<!--  <img src="/imgs/logo.png" width="130px"/> -->
				</h2></li>
			<li class="headfunc">
				<ul>
					<li>欢迎您：${Constants.SESSION_USER }
						<a class="modifypwd" id="modifypwdbtna"> 修改密码 </a> 
						<a href="/exit.action">退出</a>
					</li>
				</ul>
			</li>
		</ul>
	</div>
	<!-- 主菜单 -->
	<div id="menu">
		<ul>
			<li>系统配置管理</li>
		</ul>
	</div>
	<!-- 子菜单 -->
	<div class="subbox">
		<ul>
			<li>
				财务管理
				服务类型
				服务年限
				APP地址
				客户类型
				证件类型
				优惠类型			
			</li>
		</ul>
	</div>
	<div id="modifydiv" class="modifydiv">
			<div class='modifTop'></div>
			<div class="modifyPasswordContent">
			<ul>
			<li>请输入原密码：<input type="password" id="oldpwdtext"/> <span id="oldpwdtip">您本次登录时的密码</span></li>
			<li>请输入新密码：<input type="password" id="newpwd"/> <span id="newpwdtip">新密码不少于6个字符</span></li>
			<li>请确认新密码：<input type="password" id="newpwd2"/> <span id="newpwdtip1">新密码不少于6个字符</span></li>
			<li class="btnli">
			<input id="modifypwdbtn" type="button" value="确认修改密码"/> 
			<input id="modifypwconcledbtn" type="button" value="取消"/> 
			</li>
			</ul>
			</div>
	</div>
</body>
</html>

