/**
 * web-upload 工具类
 * 
 * 约定：
 * 上传按钮的id = 图片隐藏域id + 'BtnId'
 * 图片预览框的id = 图片隐藏域id + 'PreId'
 * 
 * @author fengshuonan
 */
(function() {
	
	var $WebUpload = function(pictureId) {
		this.pictureId = pictureId;
		this.uploadBtnId = pictureId + "BtnId";
		this.uploadPreId = pictureId + "PreId";
		this.uploadUrl = '/uploadFile';
		this.fileSizeLimit = 100 * 1024 * 1024;
		this.picWidth = 800;
		this.picHeight = 800;
        this.uploadBarId = null;
	};

	$WebUpload.prototype = {
		/**
		 * 初始化webUploader
		 */
		init : function() {
			var uploader = this.create();
			this.bindEvent(uploader);
			return uploader;
		},
		
		/**
		 * 创建webuploader对象
		 */
		create : function() {
			var webUploader = WebUploader.create({
				auto : true,
				pick : {
					id : '#' + this.uploadBtnId,
					multiple : false,// 只上传一个
				},
				accept : {
					extensions : 'properties',
                    // mimeTypes : 'application/octet-stream'
				},
				swf : BBQ.ctxPath
						+ '/static/js/plugins/webuploader/Uploader.swf',
				disableGlobalDnd : true,
				duplicate : true,
				server : this.uploadUrl,
				fileSingleSizeLimit : this.fileSizeLimit
			});
			
			return webUploader;
		},

		/**
		 * 绑定事件
		 */
		bindEvent : function(bindedObj) {
			var me =  this;
			bindedObj.on('fileQueued', function(file) {
				var $li = $('<div><p>'+file.name+'</p></div>');
				$("#" + me.uploadPreId).html($li);
			});

			// 文件上传过程中创建进度条实时显示。
			bindedObj.on('uploadProgress', function(file, percentage) {
                $("#"+me.uploadBarId).css("width",percentage * 100 + "%");
			});

			// 文件上传成功，给item添加成功class, 用样式标记上传成功。
			bindedObj.on('uploadSuccess', function(file,response) {
				if(response.code==1){
                    BBQ.success("上载成功");
                    console.log(file);
                    console.log(response);
                    var data = response.data;
                    jQuery.each(data, function(i, val) {
                    	$("#"+i).val(val);
                    });

                }else{
                    BBQ.error("上载失败");
				}

			});

			// 文件上传失败，显示上传出错。
			bindedObj.on('uploadError', function(file) {
				BBQ.error("上载失败");
			});

			// 其他错误
			bindedObj.on('error', function(type) {
				if ("Q_EXCEED_SIZE_LIMIT" == type) {
					BBQ.error("文件大小超出了限制");
				} else if ("Q_TYPE_DENIED" == type) {
					BBQ.error("文件类型不满足");
				} else if ("Q_EXCEED_NUM_LIMIT" == type) {
					BBQ.error("上传数量超过限制");
				} else if ("F_DUPLICATE" == type) {
					BBQ.error("图片选择重复");
				} else {
					BBQ.error("上传过程中出错");
				}
			});

			// 完成上传完了，成功或者失败
			bindedObj.on('uploadComplete', function(file) {
			});
		},

        /**
         * 设置图片上传的进度条的id
         */
        setUploadBarId: function (id) {
            this.uploadBarId = id;
        }
	};

	window.$WebUploadFile = $WebUpload;

}());