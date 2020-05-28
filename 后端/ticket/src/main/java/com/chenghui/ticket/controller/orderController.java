package com.chenghui.ticket.controller;

import com.chenghui.ticket.pojo.Common;
import com.chenghui.ticket.pojo.LayUi;
import com.chenghui.ticket.utlis.annotation.ControllerLog;
import com.chenghui.ticket.pojo.Order;
import com.chenghui.ticket.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Devil
 * @date 2020/3/14 16:49
 */
@RestController
@RequestMapping("order")
public class orderController {

    @Autowired
    private OrderService orderService;

    @GetMapping()
    @ControllerLog(describe = "查看订单详情")
    public LayUi select(
            @RequestParam(name = "tname", required = false) String tname,
            @RequestParam(name = "pname", required = false) String pname,
            @RequestParam(name = "page", required = false, defaultValue = "1") Integer page,
            @RequestParam(name = "limit", required = false, defaultValue = "15") Integer limit
    ) {
        return orderService.select(tname,pname, page, limit);
    }

    @PostMapping()
    @ControllerLog(describe = "添加订单消息")
    public ResponseEntity<Common> addorder(
            @RequestParam(name = "tid")Integer id
    ){
        orderService.addorder(id);
        Common common = new Common("新建成功");
        return ResponseEntity.ok(common);
    }


    @PutMapping()
    @ControllerLog(describe = "更新订单信息")
    public ResponseEntity<Common> updateUser(Order order) {
        orderService.chance(order);
        Common common = new Common("更新成功");
        return ResponseEntity.ok(common);
    }


    @DeleteMapping()
    @ControllerLog(describe = "删除订单信息")
    public ResponseEntity<Common> delectUser(@RequestParam("ids[]") Integer[] ids){
        double delect = orderService.delect(ids);
        Common common = new Common(delect);
        return ResponseEntity.ok(common);
    }

    @PutMapping("chance")
    public ResponseEntity<Common> chanceorder(
            @RequestParam("id") Integer id,
            @RequestParam("toid") Integer toid ){
        orderService.chanceorder(id, toid);
        Common common = new Common("修改成功");
        return ResponseEntity.ok(common);
    }

}
