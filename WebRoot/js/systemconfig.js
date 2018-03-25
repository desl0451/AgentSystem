$().ready(function () {
	mover(5);
	
	//显示添加面板
	$("#addsystemconfig").client(function(){
		$("#addSystemdiv").slideDown();//显示
	});
	//点击保存事件
	$("#addSystemConfigBtn").client(function(){
		//需要configType,configTypeName,isSatrt验证
		var configType=$("#addConfigType").val();
		var configTypeName=$("#addConfgName").val();
		var isStart=$("#addIsStartSelect").val();
		
		var configValue;
		//根据情况判断是否需要configValue
		if($("#addConfigValue").val()!=null){
			configValue=("#addConfigValue").val();
		}
		
		if(configType==''){
			humane.error("配置类型不能为空");
		}else if(configTypeName==''){
			humane.error("配置类型名称不能为空");
		}else{
			$.post("/addconfig.action",{
				"systemConfig.configType":configType,
				"systemConfig.configTypeName":configTypeName,
				"systemConfig.configValue":configValue,
				"systemConfig.isStart":isStart
			},function(result){
				if(result=="post"){
					humane.error("对不起,该类型名称已存在");
				}else{
					humane.success("已添加成功");
					$("#addSystemdiv").slideUp();//隐藏
					window.location.reload(true);
				}
			});
		}
	});
});