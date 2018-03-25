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
<!-- 					  <img src="/imgs/logo.png" width="130px"/>  -->
				</h2></li>
			<li class="headfunc">
				<ul>
					<li>欢迎您：<s:property value="currentUser.userName"/>
						<a class="modifypwd" id="modifypwdbtna"> 修改密码 </a> 
						<a href="/exit.action">退出</a>
					</li>
				</ul>
			</li>
		</ul>
	</div>
	 <!-- 主菜单 --> 
	<div id="menu" class="menu">
		<ul>
			<li class="m_line"><img src="imgs/line1.gif"/></li>
			<li id="m_1" class="m_li" onmousemove="mover('1')"><a>系统配置管理</a></li>
			
 			<li class="m_line"><img src="imgs/line1.gif"/></li> 
 			<li id="m_2" class="m_li" onmousemove="mover('2')"><a>系统管理</a></li> 
			
			
 			<li class="m_line"><img src="imgs/line1.gif"/></li> 
 			<li id="m_3" class="m_li"  onmousemove="mover('3')"><a>系统管理</a></li> 
			
			
			<li class="m_line"><img src="imgs/line1.gif"/></li>
			<li id="m_4" class="m_li" onmousemove="mover('4')"><a>系统管理</a></li>
			
			<li class="m_line"><img src="imgs/line1.gif"/></li>
			<li id="m_5" class="m_li" onmouseover="mover('5')"><a>系统配置管理</a></li>
	
		</ul>
	</div>
	 <!-- 主菜单 -->
	<div class="subbox">
		<ul class="smenu">
			<li id="s_1" class="s_li">
			
			</li>
			<li id="s_2" class="s_li">
				<a href="#">#</a>
			</li>
			<li id="s_3" class="s_li">
				<a href="#">#</a>
			</li>
			<li id="s_4" class="s_li_a">
				<a href="#">财务类型</a>
				<a href="/rolelist.action">角色管理</a>
				<a href="#">角色权限配置</a>
				<a href="#">用户管理</a>
				<a href="#">关键词审核</a>
				<a href="#">财务类型</a>
			</li>
			
			
			<li id="s_5" class="s_li">
				<a href="/caiwutype.action">财务类型</a>
				<a href="/servicetype.action">服务类型</a>
				<a href="/serviceyears.action">服务年限</a>
				<a href="/appurl.action">APP地址</a>
				<a href="/customtype.action">客户类型</a>
				<a href="/cardtype.action">证件类型</a>
				<a href="/youhuitype.action">优惠类型</a>
			</li>
		</ul>
	</div>
	<div id="modifydiv" class="modifydiv">
			<div class='modifTop'></div>
			<div class="modifyPasswordContent">
				<ul>
					<li>请输入原密码：<input type="password" id="oldpwdtext" value="123456"/> <span id="oldpwdtip">您本次登录时的密码</span></li>
					<li>请输入新密码：<input type="password" id="newpwd" value="654321"/> <span id="newpwdtip">新密码不少于6个字符</span></li>
					<li>请确认新密码：<input type="password" id="newpwd2" value="654321"/> <span id="newpwdtip1">新密码不少于6个字符</span></li>
					<li class="btnli">
						<input id="modifypwdbtn" type="button" value="确认修改密码"/> 
						<input id="modifypwconcledbtn" type="button" value="取消"/> 
					</li>
				</ul>
			</div>
	</div>
</body>
</html>

