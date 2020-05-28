package com.chenghui.ticket.controller;

import com.chenghui.ticket.pojo.Common;
import com.chenghui.ticket.pojo.LayUi;
import com.chenghui.ticket.services.BackService;
import com.chenghui.ticket.utlis.annotation.ControllerLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Devil
 * @date 2020/5/28 12:07
 */
@RestController
@RequestMapping("back")
public class backController {
    @Autowired
    private BackService backService;

    @GetMapping()
    public LayUi selectByAddId(
            @RequestParam(name = "serch", required = false) String serch,
            @RequestParam(name = "page", required = false, defaultValue = "1") Integer page,
            @RequestParam(name = "limit", required = false, defaultValue = "15") Integer limit
    ) {
        return backService.select(serch, page, limit);
    }

    @DeleteMapping()
    public ResponseEntity<Common> delete(@RequestParam("ids[]") Integer[] ids) {
        backService.delect(ids);
        Common common = new Common("删除成功");
        return ResponseEntity.ok(common);
    }

}
