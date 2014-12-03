<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
<title>图片上传</title> 
 <#assign contextPath="${request.getContextPath()}"> 
<script type="text/javascript" src="../js/jquery-1.7.2.min.js"></script> 
<script type="text/javascript" src="../common/ajaxfileupload.js"></script>
<link href="../common/uploadswf/default.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../common/uploadswf/swfupload.js"></script>
<script type="text/javascript" src="../common/uploadswf/swfupload.queue.js"></script>
<script type="text/javascript" src="../common/uploadswf/fileprogress.js"></script>
<script type="text/javascript" src="../common/uploadswf/handlers.js"></script> 

<script type="text/javascript">

	var swfupload;
	$(function() {
			swfupload = new SWFUpload({
				// Backend Settings
				upload_url: "${contextPath}/common/imageupload.do?type=ckeditImg",
				file_post_name: "file",
				post_params: {},
				// File Upload Settings
				file_size_limit : "5MB",	// 5MB
				file_types : "*.jpg;*.gif;*.png;*.bmp",
				file_types_description : "All Files",
				file_upload_limit : "200",
				file_queue_limit : "200",

				// Event Handler Settings (all my handlers are in the Handler.js file)
				file_dialog_start_handler : fileDialogStart,
			 	//file_queued_handler : fileQueued,
				file_queue_error_handler : fileQueueError,
				file_dialog_complete_handler : fileDialogComplete,
				//上传进度条
				// upload_start_handler : uploadStart,
				// upload_progress_handler : uploadProgress,
				upload_error_handler : uploadError,
				upload_success_handler : myUploadSuccess,
				upload_complete_handler : uploadComplete,

				// Button Settings
				button_image_url : "../common/uploadswf/XPButtonUploadText_61x22.png",
				button_placeholder_id : "spanButtonPlaceholder1",
				button_width: 61,
				button_height: 22,
				button_text:"选择图片",
				button_text_left_padding:5,
				
				// Flash Settings
				flash_url : "../common/uploadswf/swfupload.swf",

				custom_settings : {
					progressTarget : "fsUploadProgress1",
					cancelButtonId : "btnCancel1"
				},
				// Debug Settings
				debug: false
			});
		

		function myUploadSuccess(file, serverData) {
			try {
				var jsonData = eval("("+serverData+")");
				//删除按钮
				var progress = new FileProgress(file, this.customSettings.progressTarget);
			    progress.setComplete();
				if(jsonData.fileName!="undefined"&&jsonData.fileName!=""){
					var url = "${imagePath}"+jsonData.fileName;
					window.returnValue = url; //返回父页面
					window.close();
				}
				 progress.toggleCancel(true,this);
			} catch (ex) {
				this.debug(ex);
			}
		}
		
	});  
</script>

</head> 
<body> 
    <form action="" enctype="multipart/form-data" method="post"
		name="myform">
		<br /> <strong>
			<P>选择要上传的图片：</P>
		</strong> 图片： <span id="spanButtonPlaceholder1"></span> 
						<input id="btnCancel1" type="button" value="取消上传" onclick="cancelQueue(upload1);" disabled="disabled" style="margin-left: 2px; height: 22px; font-size: 8pt;" />
		<BR><br />
		 <div class="fieldset flash" id="fsUploadProgress1"></div>
				<!-- <INPUT type="button" value="提交" id="submit">&nbsp;&nbsp;<INPUT
					type="reset" value="取消"> -->
	</form>
</body>  
</html>  