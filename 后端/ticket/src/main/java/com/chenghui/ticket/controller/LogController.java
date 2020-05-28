package com.chenghui.ticket.controller;

import com.chenghui.ticket.pojo.Common;
import com.chenghui.ticket.pojo.LayUi;
import com.chenghui.ticket.utlis.annotation.ControllerLog;
import com.chenghui.ticket.services.impl.UserLogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("log")
public class LogController {
    @Autowired
    private UserLogServiceImpl userLogService;


    /**
     * 查询日志
     * @param serch 搜索内容
     * @param page 当前页面
     * @param limit 每页的大小
     */
    @GetMapping()
    public LayUi selectByAddId(
            @RequestParam(name = "serch", required = false) String serch,
            @RequestParam(name = "page", required = false, defaultValue = "1") Integer page,
            @RequestParam(name = "limit", required = false, defaultValue = "15") Integer limit
    ) {
        return userLogService.selectLog(serch, page, limit);
    }


    @DeleteMapping()
    @ControllerLog(describe = "删除所选日志")
    public ResponseEntity<Common> delete(@RequestParam("ids[]") Integer[] ids) {
        userLogService.deleteLog(ids);
        Common common = new Common("删除成功");
        return ResponseEntity.ok(common);
    }


    /**
     * 超管查询日志
     * @param serch 搜索内容
     * @param page 当前页面
     * @param limit 每页的大小
     */
    @GetMapping("all")
    @ControllerLog(describe = "超管查询日志")
    public LayUi selectByAll(
            @RequestParam(name = "serch", required = false) String serch,
            @RequestParam(name = "page", required = false, defaultValue = "1") Integer page,
            @RequestParam(name = "limit", required = false, defaultValue = "15") Integer limit
    ) {
        return userLogService.selectAllLog(serch, page, limit);
    }



}
