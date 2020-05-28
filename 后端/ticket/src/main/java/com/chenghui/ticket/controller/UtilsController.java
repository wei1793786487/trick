package com.chenghui.ticket.controller;

import cn.hutool.core.util.IdUtil;
import com.chenghui.ticket.pojo.Common;
import com.chenghui.ticket.pojo.Menu;
import com.chenghui.ticket.services.UserService;
import com.chenghui.ticket.utlis.CookieUtils;
import com.chenghui.ticket.utlis.annotation.ControllerLog;
import com.chenghui.ticket.utlis.exception.ExceptionEnums;
import com.chenghui.ticket.pojo.SysUser;
import com.chenghui.ticket.services.MenuService;
import com.chenghui.ticket.utlis.exception.XxException;
import com.chenghui.ticket.utlis.getverUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;


@Slf4j
@Controller

public class UtilsController {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private MenuService menuService;

    @Autowired
    private UserService userService;


    @Autowired
    private com.chenghui.ticket.services.uploadService uploadService;


    @RequestMapping("verifyCode.jpg")
    public void verifyCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String cookie = CookieUtils.getCookieValue(request, "getverid");
        /*禁止缓存*/
        response.setDateHeader("Expires", 0);
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");
        response.setContentType("image/jpeg");
        String code = getverUtils.generateVerifyCode(4);
        log.info("验证码============>" + code);
        String uuid = IdUtil.simpleUUID();
        redisTemplate.opsForValue().set(uuid, code, 5, TimeUnit.MINUTES);
        CookieUtils.setCookie(request, response, "getverid", uuid, 60 * 5);
        //每次更改删除cookie
        if (cookie != null && StringUtils.equals(cookie, "")) {
            Boolean isDelete = redisTemplate.delete(cookie);
            String msg = isDelete ? "成功" : "失败";
            log.info("删除" + msg + cookie);
        }
        ServletOutputStream outputStream = response.getOutputStream();
        getverUtils.outputImage(110, 40, outputStream, code);
        outputStream.flush();
        outputStream.close();
    }

    /**
     * 菜单
     */
    @GetMapping("menu")
    @ResponseBody
    public ResponseEntity<Common> loadMeau() {
        User userDetails = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        SysUser user = userService.findUserByUserName(userDetails.getUsername());
        if (user == null) {
            throw new XxException(ExceptionEnums.USER_NOT_FIND);
        }
        Menu menu = menuService.findMenuByRolename(user.getRole());
        if (menu == null) {
            throw new XxException(ExceptionEnums.MENU_NOT_FIND);
        }
        Common common = new Common(menu);
        return ResponseEntity.ok(common);
    }

    /**
     * 看看是不是活着
     */
    @GetMapping("isLife")
    @ResponseBody
    @Secured("ROLE_ADMIN")
    public ResponseEntity<Map> isLife() {
        Map<String, Boolean> isLife = new HashMap<>();
        isLife.put("islife", true);
        return ResponseEntity.ok(isLife);
    }


    /**
     * 上传图片
     */
    @PostMapping("upload")
    @ControllerLog(describe = "上传富文本编辑器")
    public ResponseEntity<Common> uploadPersion(@RequestParam(value = "file") MultipartFile file) throws Exception {
        String upload = uploadService.upload(file);
        Common common = new Common(upload);
        return ResponseEntity.ok(common);
    }


}
