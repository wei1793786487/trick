package com.chenghui.ticket.controller;

import com.chenghui.ticket.pojo.Common;
import com.chenghui.ticket.pojo.LayUi;
import com.chenghui.ticket.utlis.annotation.ControllerLog;
import com.chenghui.ticket.pojo.Message;
import com.chenghui.ticket.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Devil
 * @date 2020/3/14 14:34
 */
@RestController
@RequestMapping("message")
public class messageController {

    @Autowired
    private MessageService messageService;

    @GetMapping()
    @ControllerLog(describe = "查看消息列表")
    public LayUi select(
            @RequestParam(name = "search", required = false) String search,
            @RequestParam(name = "type", required = false) Integer type,
            @RequestParam(name = "page", required = false, defaultValue = "1") Integer page,
            @RequestParam(name = "limit", required = false, defaultValue = "15") Integer limit
    ) {
        return messageService.select(search, page, limit, type);
    }

    @PutMapping()
    public ResponseEntity<Common> update(Message message) {
        messageService.chance(message);
        Common common = new Common("更新成功");
        return ResponseEntity.ok(common);
    }

    @DeleteMapping
    @ControllerLog(describe = "删除信息")
    public ResponseEntity<Common> delectmessage(@RequestParam("ids[]") Integer[] ids) {
        messageService.delectmessage(ids);
        Common common = new Common("删除成功");
        return ResponseEntity.ok(common);
    }

    @PostMapping
    public ResponseEntity<Common> insertMessage(Message message) {
        messageService.insertmessage(message);
        Common common = new Common("新建成功");
        return ResponseEntity.ok(common);
    }


    @GetMapping("{id}")
    @ControllerLog
    public ResponseEntity<Common> getOneById(@PathVariable(name = "id") Integer id) {
        Message oneById = messageService.findOneById(id);
        Common common = new Common(oneById);
        return ResponseEntity.ok(common);
    }

    //这个接口是springsecurity的允许访问的接口
    @GetMapping("allmessage")
    public LayUi getAllMessAge(
            @RequestParam(name = "type", required = false) Integer type,
            @RequestParam(name = "page", required = false, defaultValue = "1") Integer page,
            @RequestParam(name = "limit", required = false, defaultValue = "15") Integer limit
    ) {
        return messageService.select(null, page, limit, type);
    }

    @GetMapping("new")
    public ResponseEntity<Common> findNewMessage(
            @RequestParam(name = "limit", required = false, defaultValue = "5") Integer limit
            ) {
          List<Message> messages= messageService.selectnew(limit);
          return  ResponseEntity.ok(new Common(messages));
    }

}
