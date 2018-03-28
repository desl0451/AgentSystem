$().ready(function() {
	$("#ckall").change(function() {
		var checkList = ""; //保存全选的结果
		var cblist = $(".cb");
		for (var i = 0; i < cblist.length; i++) {
			cblist[i].checked = $(this).attr("checked") == 'checked' ? "checked" : '';
		}
	});
	$("#saverolefunc").click(function() {
		var checkList = ""; //已选
		var chlist = $(".cb");
		var roleId = $("#roleid").val();
		for (var i = 0; i < chlist.length; i++) {
			if (chlist[i].checked) {
				checkList += chlist[i].value + ",";
			}
		}
		$.post("/saverolefunc.action", {'roleId':roleId,'checkList':checkList}, function(result) {
			if(result=="success")
				humane.success("保存成功!");
			else
				humane.error("保存失败!");
		});
	});
});