const url = "http://api.wukaka.com/"


//登录
function login(data) {
    console.log(data)
    return request({
        url: url + "login",
        method: 'post',
        data: data
    })
}

//查看是否过期
function life() {
    return request({
        url: url + "isLife",
    })
}


//获取用户上次登录信息
function get_user_info(username) {
    return request({
        url: url + "user/" + username + ""
    })
}

//查看用户是不存在
function check_user(username){
    return request({
        url: url + "user/isHave",
        data: {username},
    })
}
 
//添加用户
function add_user(data){
    return request({
        url: url + "user",
        method:"post",
        data: data,
    })
}

//添加用户
function add_user_r(data){
    return request({
        url: url + "user/adduser",
        method:"post",
        data: data,
    })
}
//退出登录
function logout(){
    return request({
        url: url + "logout",
    })
}

//改变用户状态
function chance_user(data){
    return request({
        url: url + "user",
        method:"put",
        data: data,
    })
} 
//修改密码
function chance_psd(new_psd,old_psd){
    return request({
        url: url + "user/password",
        method:"put",
        data: {
            new_password: new_psd,
            old_password: old_psd 
        }
    })
}
//删除日志
function delete_log(ids){
    return request({
        url: url + "log",
        method:"delete",
        data:  {
            ids
        },
    }) 
}

//删除日志
function delete_user(ids){
    return request({
        url: url + "user",
        method:"delete",
        data:  {
            ids
        },
    }) 
}

//添加用户
function add_ticket(data){
    return request({
        url: url + "ticket",
        method:"post",
        data: data,
    })
}


//删除日志
function delete_ticket(ids){
    return request({
        url: url + "ticket",
        method:"delete",
        data:  {
            ids
        },
    }) 
}



function findTrickById(id){
    return request({
        url: url + "ticket/"+id,
    }) 
}

function findTrickByname(name){
    return request({
        url: url + "ticket/name/"+name,
    }) 
}

function chance_order(id,toid){
    return request({
        url: url + "order/chance",
        method:"put",
        data: {
            id,
            toid
        }
    })
} 


//改变用户状态
function chance_ticket(data){
    return request({
        url: url + "ticket",
        method:"put",
        data: data,
    })
} 


//改变用户状态
function add_message(data,message){
    return request({
        url: url + "message",
        method:"post",
        data: {
            name:data.name,
            type:data.type,
            message:message
        }
    })
} 

function findmessageById(id){
    return request({
        url: url + "message/"+id,
    }) 
}

//改变用户状态
function chance_message(data,message){
    return request({
        url: url + "message",
        method:"put",
        data: {
            id:data.id,
            name:data.name,
            type:data.type,
            addName:data.addName,
            message:message
        }
    })
} 


function delete_message(ids){
    return request({
        url: url + "message",
        method:"delete",
        data:  {
            ids
        },
    }) 
}

function delete_back(ids){
    return request({
        url: url + "back",
        method:"delete",
        data:  {
            ids
        },
    }) 
}


function delete_order(ids){
    return request({
        url: url + "order",
        method:"delete",
        data:  {
            ids
        },
    }) 
}


function add_order(tid){
    return request({
        url: url + "order",
        method:"post",
        data:  {
           tid
        },
    }) 
}


function findecharts(id){
    return request({
        url: url + "ticket/echarts/"+id,
    }) 
}


function initmessage(type){
    return request({
        url: url + "message/allmessage?type="+type,
    }) 
}


function addmessage(message){
    return request({
        url: url + "message",
        method:"post",
        data: {
            message,
            type:0
        }
    })
}

function getticket(start,end){
    return request({
        url: url + "ticket/find",
        method:"get",
        data: {
            start,
            end
        }
    })
}

function getnew(limit){
    return request({
        url: url + "message/new",
        method:"get",
        data: {
            limit
        }
    })
}


function getorder(data){
    return request({
        url: url + "order",
      
    }) 
}

//删除日志
function delete_order(ids){
    return request({
        url: url + "order",
        method:"delete",
        data:  {
            ids
        },
    }) 
}