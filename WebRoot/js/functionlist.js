$().ready(function() {
	$("#ckall").change(function() {
		var checkList = ""; //保存全选的结果
		var cblist = $(".cb");
		for (var i = 0; i < cblist.length; i++) {
			cblist[i].checked = $(this).attr("checked") == 'checked' ? "checked" : '';
		}
	});
	$("#saverolefunc").click(function() {
		
	});
});