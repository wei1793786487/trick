 function request(options) {
     return new Promise((resolve, reject) => {
         $.ajax({
             method: options.method || 'get',
             url: options.url,
             data: options.data || {},
             dataType: "json",
             crossDomain: true, //设置跨域为true
             async:options.async||true, 
             xhrFields: {
                 withCredentials: true //默认情况下，标准的跨域请求是不会发送cookie的
             },
             success: function (res) {
                 resolve(res)
             },
               fail: function (err) {
                 layer.msg('请求失败，网络异常', {
                     time: 1000,
                 });
                 reject(err)
             }
         })
     })
 }