package com.chenghui.ticket.controller;

import com.chenghui.ticket.pojo.Common;
import com.chenghui.ticket.pojo.LayUi;
import com.chenghui.ticket.utlis.annotation.ControllerLog;
import com.chenghui.ticket.pojo.Order;
import com.chenghui.ticket.pojo.Ticketing;
import com.chenghui.ticket.services.OrderService;
import com.chenghui.ticket.services.TicketingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author Devil
 * @date 2020/3/12 20:18
 */
@RestController
@RequestMapping("ticket")

public class ticketController {

    @Autowired
    private TicketingService ticketingService;


    @Autowired
    private OrderService orderService;
    /**
     * 新建
     *
     * @param
     */
    @PostMapping
    @ControllerLog(describe = "新建票务")
    public ResponseEntity<Common> insertUser(Ticketing ticketing) {
        ticketingService.insert(ticketing);
        Common common = new Common("新建成功");
        return ResponseEntity.ok(common);
    }


    /**
     * 查找
     *
     * @param page   页面
     * @param limit  多少行
     * @param search 搜索
     */
    @GetMapping()
    @ControllerLog(describe = "查看票务")
    public LayUi<Ticketing> selectAll(@RequestParam(name = "search", required = false) String search,
                                      @RequestParam(name = "page", required = false, defaultValue = "1") Integer page,
                                      @RequestParam(name = "limit", required = false, defaultValue = "15") Integer limit) {
        return ticketingService.findticketingServiceList(page, limit, search);
    }


    @DeleteMapping()
    @ControllerLog(describe = "删除票务")
    public ResponseEntity<Common> delectUser(@RequestParam("ids[]") Integer[] ids) {
        ticketingService.delectticket(ids);
        Common common = new Common("删除成功");
        return ResponseEntity.ok(common);
    }

    @GetMapping("{id}")
    @ControllerLog
    public ResponseEntity<Common> getOneById(@PathVariable(name = "id") Integer id) {
        Ticketing ticketing = ticketingService.findOneById(id);
        Common common = new Common(ticketing);
        return ResponseEntity.ok(common);
    }

    @GetMapping("name/{name}")
    @ControllerLog
    public ResponseEntity<Common> getOneByname(@PathVariable(name = "name") String name) {
        Ticketing ticketing = ticketingService.findOneByname(name);
        Common common = new Common(ticketing);
        return ResponseEntity.ok(common);
    }


    @PutMapping()
    @ControllerLog(describe = "更新票务信息")
    public ResponseEntity<Common> updateUser(Ticketing ticketing) {
        ticketingService.chance(ticketing);
        Common common = new Common("更新成功");
        return ResponseEntity.ok(common);
    }

    @GetMapping("echarts/{id}")
    public ResponseEntity<Common> geteecharts(@PathVariable(name = "id") Integer id) {
        Ticketing oneById = ticketingService.findOneById(id);
        List<Order> orders = orderService.selectbytId(id);
        Integer no = oneById.getNumber() - orders.size();
        Integer yes=oneById.getNumber()-no;
        Map data=new HashMap();
        data.put("name",oneById.getTrainName());
        data.put("nosale",no);
        data.put("issale",yes);
        Common common = new Common(data);
        return ResponseEntity.ok(common);
    }
    @GetMapping("find")
    public ResponseEntity<Common> find(
            @RequestParam(name = "start") String saddress,
            @RequestParam(name = "end") String eaddress
    ) {
        List<Ticketing> ticketings = ticketingService.findByEndAndStart(saddress,eaddress);
        Common common = new Common(ticketings);
        return ResponseEntity.ok(common);
    }

}
