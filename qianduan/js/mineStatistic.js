var wrapperVue = new Vue({
		el: "#wrapper",
		data: {
			getStatistics: "http://localhost:8080/mineStatistics/data.do",
			index: 1, // 选择哪一个标题
			items: table, // 数据

			posts: {
				dataList: [], // 查询出来的数据
				pageList: [], // 显示 分页数据
				title: []
			}


		},
		mounted: function() {
			var vm = this;
			this.getRecord(vm.index)
		},
		methods: {
			getRecord: function(index) {
				var vm = this;
				if (index != 0) {
					vm.index = index
				}
				vm.page = pageInit.init();
				// var dt = new Object();
				// dt.test = "测试股";
				// vm.posts.dataList.push(dt);
				// vm.$refs.component.handleData()
				axios.get(vm.getStatistics, {
					params: {
						"index": vm.index,
						"size": this.$refs.component.page.size,
						"preTotal": this.$refs.component.page.preTotal,
						"start": $("#datetimepickerStart").val(),
						"end": $("#datetimepickerEnd").val()
					}
				}).then(function(response) {
					handSuccess(response.data, function() {
						vm.$refs.component.firstGetData(vm.items, vm.index, response.data.data)

					})
				});
			},
			nextPage: function(page) {
				var vm = this;
				page.preTotal = vm.posts.dataList.length;
				axios.get(vm.getStatistics, {
					params: {
						"index": vm.index,
						"size": this.$refs.component.page.size,
						"preTotal": this.$refs.component.page.preTotal,
						"start": $("#datetimepickerStart").val(),
						"end": $("#datetimepickerEnd").val()
					}
				}).then(function(response) {
					handSuccess(response.data, function() {
						vm.$refs.component.nextGetData(response.data.data)
					})
				});
			},
			excelData: function() {
				var vm = this;

				
				var chedata =  {
				    index: vm.index,
				    start:  $("#datetimepickerStart").val(),
					end: $("#datetimepickerEnd").val(),
					jsonstr: JSON.stringify(vm.posts.title)
				  };
				  
				//axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';
				axios({
				  method: 'post',
				  url: 'http://localhost:8080/mineStatistics/export.do',
				  
				  // `data` 是作为请求主体被发送的数据
				    // 只适用于这些请求方法 'PUT', 'POST', 和 'PATCH'
				    // 在没有设置 `transformRequest` 时，必须是以下类型之一：
				  data: Qs.stringify(chedata),
				  
				  // `transformRequest` 允许在向服务器发送前，修改请求数据
				    // 只能用在 'PUT', 'POST' 和 'PATCH' 这几个请求方法
				    // 后面数组中的函数必须返回一个字符串，或 ArrayBuffer，或 Stream
				/*  transformRequest: [function (data, headers) {
				      // 对 data 进行任意转换处理
				     //return Qs.stringify(data);
					 return data;
				    }], */
				  
				   //
				  "Content-Type": "application/x-www-form-urlencoded;charset=utf-8",
				    // headers: {'Content-type': 'application/json;charset=UTF-8'},
				   
				    // `params` 是即将与请求一起发送的 URL 参数
				     // 必须是一个无格式对象(plain object)或 URLSearchParams 对象
				   params:{},
				   // `paramsSerializer` 是一个负责 `params` 序列化的函数
				     // (e.g. https://www.npmjs.com/package/qs, http://api.jquery.com/jquery.param/)
				   paramsSerializer: function(params) {
				        return Qs.stringify(params, {arrayFormat: 'brackets'})
				     },
					   // `responseType` 表示服务器响应的数据类型，可以是 'arraybuffer', 'blob', 'document', 'json', 'text', 'stream'
				     responseType: 'blob', // 默认的
					 
				}).then(function(response) {
					if (!data) {
						return
					}
					var fileName = window.decodeURI(response.headers['content-disposition'].split('=')[1]);
					var link = document.createElement("a");
					link.href = window.URL.createObjectURL(new Blob([response.data], {
					type: "application/ms-txt.numberformat:@"
						
						// //application/vnd.openxmlformats-officedocument.spreadsheetml.sheet这里表示xlsx类型
						//type: "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8"
					}));
					link.target = "_blank";
					link.download = fileName;
					document.body.appendChild(link);
					link.click();
					document.body.removeChild(link);
				}).catch(function(error) {
					console.log(error)
				});
;
		/* 		axios.get("http://localhost:8080/mineStatistics/export.do", {
					params: {
						"index": vm.index,
						"start": $("#datetimepickerStart").val(),
						"end": $("#datetimepickerEnd").val(),
						"jsonstr": str
					},
					responseType: 'blob', //二进制流
				}).then(function(response) {
					if (!data) {
						return
					}
					var fileName = window.decodeURI(response.headers['content-disposition'].split('=')[1]);
					var link = document.createElement("a");
					link.href = window.URL.createObjectURL(new Blob([response.data], {
						type: "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8"
					}));
					link.target = "_blank";
					link.download = fileName;
					document.body.appendChild(link);
					link.click();
					document.body.removeChild(link);
				}).catch(function(error) {
					console.log(error)
				}); */

			}

		}
	}

)
