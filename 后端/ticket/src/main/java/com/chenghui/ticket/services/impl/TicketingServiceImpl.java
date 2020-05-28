package com.chenghui.ticket.services.impl;

import cn.hutool.core.date.DateUtil;
import com.chenghui.ticket.pojo.LayUi;
import com.chenghui.ticket.utlis.exception.ExceptionEnums;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.chenghui.ticket.pojo.Order;
import com.chenghui.ticket.pojo.Ticketing;
import com.chenghui.ticket.services.OrderService;
import com.chenghui.ticket.utlis.exception.XxException;
import com.chenghui.ticket.services.TicketingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.chenghui.ticket.mapper.TicketingMapper;

import java.util.List;

/**
*@author Devil
*@date  2020/3/12 17:39
*/
@Service
@Slf4j
public class TicketingServiceImpl implements TicketingService {

    @Resource
    private TicketingMapper ticketingMapper;

    @Autowired
    private OrderService orderService;

    @Override
    public LayUi<Ticketing> findticketingServiceList(Integer page, Integer limit, String search) {
        PageHelper.startPage(page,limit);
        List<Ticketing> ticketings= ticketingMapper.selectAllBySearch(search);
        if (ticketings == null || ticketings.size() == 0) {
            log.error("车辆信息未找到");
            throw new XxException(ExceptionEnums.TICKET_NOT_FIND);
        }
        PageInfo<Ticketing> brandPageInfo = new PageInfo<>(ticketings);
        LayUi<Ticketing> layUi = new LayUi<>();
        layUi.setCount(brandPageInfo.getTotal());
        layUi.setData(ticketings);
        return layUi;
    }

    @Override
    public void delectticket(Integer[] ids) {
        for (Integer id : ids) {
            log.info("删除id为" + id + "的");
             ticketingMapper.deleteByPrimaryKey(id);
        }

    }

    @Override
    public void insert(Ticketing ticketing) {
        String now = DateUtil.now();
        ticketing.setCreateTime(now);
        int insert = ticketingMapper.insert(ticketing);
        if (insert!=1){
            throw new XxException(ExceptionEnums.INSERT_ERROR);
        }
    }

    @Override
    public void chance(Ticketing ticketing) {
        int update = ticketingMapper.updateByPrimaryKeySelective(ticketing);
        if (update!=1){
            throw new XxException(ExceptionEnums.UPDATE_ERROR);
        }
    }

    @Override
    public Ticketing findOneById(Integer id) {
        Ticketing ticketing = ticketingMapper.selectByPrimaryKey(id);
        if (ticketing==null){
            throw new XxException(ExceptionEnums.NOT_FIND);
        }
        //获取剩余的车票
        List<Order> orders = orderService.selectbytId(ticketing.getId());
        ticketing.setNumber(ticketing.getNumber()-orders.size());
        return ticketing;
    }

    @Override
    public List<Ticketing> findByEndAndStart(String saddress, String eaddress) {

        List<Ticketing> ticketings = ticketingMapper.selectAllByse(saddress, eaddress);
        //减去卖出去的票
        for (Ticketing ticketing : ticketings) {
            List<Order> orders = orderService.selectbytId(ticketing.getId());
            ticketing.setNumber(ticketing.getNumber()-orders.size());
        }
        return ticketings;
    }

    @Override
    public Ticketing findOneByname(String name) {
        Ticketing oneByTrainName = ticketingMapper.findOneByTrainName(name);
        if (oneByTrainName==null){
            throw new XxException(ExceptionEnums.NOT_FIND);
        }
        return oneByTrainName;
    }

}
