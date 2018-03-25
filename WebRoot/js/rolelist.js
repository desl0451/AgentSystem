$().ready(function() {


	$("#addRole").click(function() {
		$("#addRoleDiv").slideDown();
		$("#modifyRoleDiv").slideUp();
	});
	$(".modifyRole").click(function() {
		$("#addRoleDiv").slideUp();
		$("#modifyRoleDiv").slideDown();

		var b = $(this);
		$("#m_roleName").val(b.attr('rolename'));
		$("#m_isStart").val(b.attr('isstart'));
	});
	$("#addRoleSubmit").click(function() {
		var a_roleName = $.trim($("#a_roleName").val());
		var a_isStart = $("#a_isStart").val();
		if(a_roleName == ''){
			alert("角色名称不能为空！");
		}
		else if(a_isStart == ''){
			alert("请选择是否启用！");
		}else{
			$.post("/editrole.action?type=add",{'role.roleName':a_roleName,'role.isStart':a_isStart},function(result){
				if("success" == result){
					alert("添加成功！");
					window.location.href="/rolelist.action";
				}else if("repeat" == result){
					alert("角色名称已存在");
				}else{
					alert("添加失败！");
				}
			},'html');
		}
	});
	mover(4);
});