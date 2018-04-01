$().ready(function() {
	//显示添加
	$("#addUser").click(function() {
		$("#modifyUserDiv").slideUp(500);
		$("#addUserDiv").slideDown(500);
	});

	//隐藏添加
	$("#addCancel").click(function() {
		$("#addUserDiv").slideUp(500);
	});


	//显示修改
	$(".modifyUser").click(function() {
		$("#addUserDiv").slideUp(500);
		$("#modifyUserDiv").slideDown(500);

		var b = $(this);
		$("#m_userCode").val(b.attr('usercode'))
		$("#m_userName").val(b.attr('username'))
		$("#m_userPassword").val(b.attr('userpassword'))
		$("#m_roleId").val(b.attr('roleid'));
		$("#m_isStart").val(b.attr('isstart'));
		$("#m_id").val(b.attr('id'));
	});

	//隐藏修改
	$("#modifyCancel").click(function() {
		$("#modifyUserDiv").slideUp(500);
	});
	$("#addUserSubmit").click(function() {
		var a_userCode = $.trim($("#a_userCode").val()); //读取userCode的值
		var a_userName = $.trim($("#a_userName").val()); //读取userName的值
		var a_userPassword = $.trim($("#a_userPassword").val()); //提取密码
		var a_roleId = $("#a_roleId").val();
		var a_isStart = $("#a_isStart").val();
		if (a_userCode == '') {
			humane.error("登录账号不能为空!");
		} else if (a_userName == '') {
			humane.error("用户名称不能为空!");
		} else if (a_userPassword == '') {
			humane.error("登录密码不能为空!");
		} else if (a_roleId == '--请选择--') {
			humane.error("角色名称不能为空!");
		} else if (a_isStart == '') {
			humane.error("请选择是否启用！");
		} else {
			$.post("/edituser.action?type=add", {
				'user.userCode' : a_userCode,
				'user.userName' : a_userName,
				'user.userPassword' : a_userPassword,
				'user.roleId' : a_roleId,
				'user.isStart' : a_isStart
			}, function(result) {
				if (result == "success") {
					humane.success("添加成功！");
					window.location.href = "/userlist.action";
				} else if (result == "repeat") {
					humane.error("该用户已经存在!！");
					window.location.href = "/userlist.action";
				} else {
					humane.error("添加失败！");
				}
			}, 'html');
		}
	});
	$("#modifyUserSubmit").click(function() {
		var m_userCode = $.trim($("#m_userCode").val()); //读取userCode的值
		var m_userName = $.trim($("#m_userName").val()); //读取userName的值
		var m_userPassword = $.trim($("#m_userPassword").val()); //提取密码
		var m_roleId = $("#m_roleId").val();
		var m_isStart = $("#m_isStart").val();
		var m_id = $("#m_id").val();

		if (m_userCode == '') {
			humane.error("登录账号不能为空!");
		} else if (m_userName == '') {
			humane.error("用户名称不能为空!");
		} else if (m_userPassword == '') {
			humane.error("登录密码不能为空!");
		} else if (m_roleId == '--请选择--') {
			humane.error("角色名称不能为空!");
		} else if (m_isStart == '') {
			humane.error("请选择是否启用！");
		} else {
			$.post("/edituser.action?type=modify", {
				'user.userCode' : m_userCode,
				'user.userName' : m_userName,
				'user.userPassword' : m_userPassword,
				'user.roleId' : m_roleId,
				'user.isStart' : m_isStart,
				'user.id' : m_id
			}, function(result) {
				if (result == "success") {
					humane.success("修改成功!");
					window.location.href = "/userlist.action";
				} else {
					humane.error("修改失败!");
				}
			}, 'html');
		}
	});
	$(".deleteUser").click(function() {
		var b = $(this);
		var d_id = b.attr('id');
		var d_userCode = b.attr("usercode");
		var d_userRoleId=b.attr("roleid");
		if(d_userRoleId==1){
			humane.error("该账号角色：系统管理员!不能被删除!");
			return;
		}
		
		if (confirm("您确定要删除[" + d_userCode + "]吗？")) {
			$.post("/deleteuser.action",
				{
					'user.id' : d_id
				}, function(result) {
					if (result == "success") {
						humane.success("删除成功!");
						window.location.href = "/userlist.action";
					} else {
						humane.error("删除失败!");
					}

				}, 'html');
		}
	});
	mover(4);
});