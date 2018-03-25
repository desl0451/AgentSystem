$().ready(function() {
	//显示添加
	$("#addRole").click(function() {
		$("#modifyRoleDiv").slideUp(500);
		$("#addRoleDiv").slideDown(500);
	});
	//关闭添加
	$("#addCancel").click(function() {
		$("#addRoleDiv").slideUp(500);
	});

	//显示修改
	$(".modifyRole").click(function() {
		$("#addRoleDiv").slideUp();
		$("#modifyRoleDiv").slideDown();

		var b = $(this);
		$("#m_roleName").val(b.attr('rolename'));
		$("#m_isStart").val(b.attr('isstart'));
		$("#m_roleId").val(b.attr('roleid'));
	});

	//关闭修改
	$("#modifyCancel").click(function() {
		$("#modifyRoleDiv").slideUp(500);
	});



	$("#addRoleSubmit").click(function() {
		var a_roleName = $.trim($("#a_roleName").val());
		var a_isStart = $("#a_isStart").val();
		if (a_roleName == '') {
			humane.error("角色名称不能为空！");
		} else if (a_isStart == '') {
			humane.error("请选择是否启用！");
		} else {
			$.post("/editrole.action?type=add", {
				'role.roleName' : a_roleName,
				'role.isStart' : a_isStart
			}, function(result) {
				if ("success" == result) {
					humane.success("添加成功！");
					window.location.href = "/rolelist.action";
				} else if ("repeat" == result) {
					humane.error("角色名称已存在");
				} else {
					humane.error("添加失败！");
				}
			}, 'html');
		}
	});
	$("#modifyRoleSubmit").click(function() {
		var m_roleId = $("#m_roleId").val();
		var m_roleName = $.trim($("#m_roleName").val());
		var m_isStart = $("#m_isStart").val();
		if (m_roleName == '') {
			humane.error("角色名称不能为空！");
		} else if (m_isStart == '') {
			humane.error("请选择是否启用！");
		} else {
			$.post("/editrole.action?type=modify", {
				'role.id' : m_roleId,
				'role.roleName' : m_roleName,
				'role.isStart' : m_isStart
			}, function(result) {
				if ("success" == result) {
					humane.success("修改成功！");
					window.location.href = "/rolelist.action";
				} else if ("repeat" == result) {
					humane.error("角色名称已存在");
				} else {
					humane.error("修改失败！");
				}
			}, 'html');
		}
	});

	//显示删除
	$(".deleteRole").click(function() {
		var b = $(this);
		var b_roleId = b.attr('roleid');
		if (confirm('您确定要删除吗?')) {
			$.post("/deleterole.action", {
				'role.id' : b_roleId
			}, function(result) {
				if ("success" == result) {
					humane.success("删除成功！");
					window.location.href = "/rolelist.action";
				} else {
					humane.error("删除失败！");
				}
			}, 'html');
		}
	});
});