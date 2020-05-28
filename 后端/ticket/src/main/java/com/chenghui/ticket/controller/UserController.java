package com.chenghui.ticket.controller;



import com.chenghui.ticket.pojo.Common;
import com.chenghui.ticket.pojo.LayUi;
import com.chenghui.ticket.utlis.CookieUtils;
import com.chenghui.ticket.utlis.annotation.ControllerLog;
import com.chenghui.ticket.utlis.exception.ExceptionEnums;
import com.chenghui.ticket.pojo.SysUser;
import com.chenghui.ticket.services.UserService;
import com.chenghui.ticket.utlis.exception.XxException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Collection;


@RestController()
@RequestMapping("user")
@Slf4j

public class UserController {

    @Autowired
    private UserService userService;



    /**
     * 获取用户上次的参数
     * @param username  用户名
     * @param request request队形
     *
     */
    @GetMapping("{username}")
    public ResponseEntity<Common> getUserByUsername(@PathVariable(value = "username",required = false) String username, HttpServletRequest request) {
        HttpSession session = request.getSession();
        String lasttime = (String) session.getAttribute("lasttime");
        String lastaddress = (String) session.getAttribute("address");
        SysUser user = userService.findUserByUserName(username);

        if (lastaddress != null && lasttime != null) {
            log.debug("设置上次登录的时间与地点");
            user.setAddress(lastaddress);
            user.setLasttime(lasttime);
        }
        Common common = new Common(user);
        return ResponseEntity.ok(common);
    }

    /**
     * 修改密码
     * @param oldPassword 老密码
     * @param newPassword 新密码
     * @param request  ？？
     * @param response ？？
     *
     */
    @PutMapping("password")
    @ControllerLog(describe = "修改密码")

    public ResponseEntity<Common> updatePassword(
            @RequestParam("old_password") String oldPassword,
            @RequestParam("new_password") String newPassword,
            HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User userDetails = (User) auth.getPrincipal();
        userService.updateUserPasswordByUserName(oldPassword, newPassword, userDetails.getUsername());
        //清除用户信息
        new SecurityContextLogoutHandler().logout(request, response, auth);

        CookieUtils.deleteCookie(request,response,"username");
        CookieUtils.deleteCookie(request,response,"remember");
        Common common = new Common("更新成功");
        return ResponseEntity.ok(common);
    }

    /**
     * 更新用户信息
     * @param sysUser  用户对象
     *
     */
    @PutMapping()
    @ControllerLog(describe = "更新用户信息")
    public ResponseEntity<Common> updateUser(SysUser sysUser) {
         boolean isSuper=false;
         //todo 超管可以设置自己的账号不可用，这样就全部都不可用了，哈哈哈哈，系统崩溃bug
        //判断更新用户是不是当前存在的用户，防止恶意请求
        User userDetails = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Collection<GrantedAuthority> authorities = userDetails.getAuthorities();
        for (GrantedAuthority authority : authorities) {
            if (StringUtils.contains(authority.getAuthority(),"ADMIN")){
                isSuper=true;
            }
        }

        if (!isSuper&&!userDetails.getUsername().equals(sysUser.getUsername())){
            throw new XxException(ExceptionEnums.INSUFFICIENT_AUTHORITY);
        }

        userService.updateUser(sysUser);
        Common common = new Common("更新成功");
        return ResponseEntity.ok(common);
    }


    /**
     * 查看用户是不是存在
     * @param username  用户名
     *
     */
    @GetMapping("isHave")
    @ControllerLog(describe = "查看用户是否存在")

    public ResponseEntity<Common> updateUser(@RequestParam("username") String username) {
        try {
            userService.findUserByUserName(username);
            throw new XxException(ExceptionEnums.USER_ISHAVE);
        } catch (XxException e) {
           //如果抛异常了就是没有用户
            if (e.getExceptionEnums()==ExceptionEnums.USER_NOT_FIND){
                Common common = new Common("用户不存在");
                return ResponseEntity.ok(common);
            }else {
                throw e;
            }

        }
    }


    /**
     * 新建用户
     * @param sysUser 用户对象
     */
    @PostMapping
    @ControllerLog(describe = "新建用户")

    public ResponseEntity<Common> insertUser(@Valid SysUser sysUser)  {
        userService.insertUser(sysUser);
        Common common = new Common("新建成功");
        return ResponseEntity.ok(common);

    }

    /**
     * 新建用户
     * @param sysUser 用户对象
     */
    //无权限的添加用户
    @PostMapping("adduser")
    public ResponseEntity<Common> adduser(@Valid SysUser sysUser)  {
        userService.insertUser(sysUser);
        Common common = new Common("新建成功");
        return ResponseEntity.ok(common);

    }


    /**
     * 查找所有用户
     * @param page  页面
     * @param limit 多少行
     * @param search 搜索
     *
     */
    @GetMapping()
    @ControllerLog(describe = "查看所有用户")
    public LayUi<SysUser> selectAll(
            @RequestParam(name = "search", required = false) String search,
            @RequestParam(name = "page", required = false, defaultValue = "1") Integer page,
            @RequestParam(name = "limit", required = false, defaultValue = "15") Integer limit
    ) {
      return userService.findUserList(page,limit,search);
    }


    @DeleteMapping
    @ControllerLog(describe = "删除用户")
    public ResponseEntity<Common> delectUser(@RequestParam("ids[]") Integer[] ids){
        userService.delectUser(ids);
        Common common = new Common("删除成功");
        return ResponseEntity.ok(common);
    }



}
