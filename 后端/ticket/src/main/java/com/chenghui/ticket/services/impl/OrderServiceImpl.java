package com.chenghui.ticket.services.impl;

import cn.hutool.core.date.DateUtil;
import com.chenghui.ticket.mapper.BackMapper;
import com.chenghui.ticket.pojo.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.chenghui.ticket.mapper.SysUserMapper;
import com.chenghui.ticket.mapper.TicketingMapper;
import com.chenghui.ticket.services.UserService;
import com.chenghui.ticket.utlis.exception.ExceptionEnums;
import com.chenghui.ticket.utlis.exception.XxException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.chenghui.ticket.mapper.OrderMapper;
import com.chenghui.ticket.services.OrderService;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author Devil
 * @date 2020/3/14 16:49
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderMapper orderMapper;

    @Resource
    private TicketingMapper ticketingMapper;

    @Resource
    private UserService userService;

    @Resource
    private SysUserMapper sysUserMapper;

    @Resource
    private BackMapper backMapper;

    @Override
    public void addorder(Integer id) {

        Ticketing ticketing = ticketingMapper.selectByPrimaryKey(id);
        if (ticketing == null) {
            throw new XxException(ExceptionEnums.TICKET_NOT_FIND);
        }
        List<Order> orders = orderMapper.selectByTid(id);
        if (orders.size() != 0) {
            throw new XxException(ExceptionEnums.TICKE_IS_HAVE);
        }
        if (ticketing.getNumber() < 1) {
            throw new XxException(ExceptionEnums.TICKE_NOT_FIND);
        }

        SysUser userByUserName = userService.findUserByUserName(null);
        if (userByUserName == null) {
            throw new XxException(ExceptionEnums.USER_NOT_FIND);
        }

        Order order = new Order();
        order.setUid(userByUserName.getId());
        order.setTid(ticketing.getId());
        order.setPay(1);
        order.setCreatetime(DateUtil.now());
        int i = orderMapper.insertSelective(order);
        if (i != 1) {
            throw new XxException(ExceptionEnums.ADD_ERROR);
        }
    }

    @Override
    public LayUi select(String tname, String pname, Integer page, Integer limit) {
        Integer uid = null;
        Integer tid = null;
        if (pname != null && !"".equals(pname)) {
            uid = sysUserMapper.findOneByUsername(pname).getId();
        }
        if (tname != null && !"".equals(tname)) {
            tid = ticketingMapper.selectOneByTrainName(tname).getId();
        }

        PageHelper.startPage(page, limit);
        List<Order> orders = orderMapper.selectAllBySearch(uid, tid);
        if (orders == null || orders.size() == 0) {
            throw new XxException(ExceptionEnums.NOT_FIND);
        }
        for (Order order : orders) {
            String usernameByUid = userService.findUsernameByUid(order.getUid());
            Ticketing ticketing = ticketingMapper.selectByPrimaryKey(order.getTid());
            order.setTicketing(ticketing);
            order.setUname(usernameByUid);
            String s = ticketingMapper.selectTrainNameById(order.getTid());
            order.setTname(s);
        }

        PageInfo<Order> brandPageInfo = new PageInfo<>();
        LayUi<Order> layUi = new LayUi<>();
        layUi.setCount(brandPageInfo.getTotal());
        layUi.setData(orders);
        return layUi;
    }

    @Override
    public void chance(Order order) {
        int update = orderMapper.updateByPrimaryKeySelective(order);
        if (update != 1) {
            throw new XxException(ExceptionEnums.UPDATE_ERROR);
        }
    }

    @Override
    public double delect(Integer[] ids) {
        for (Integer id : ids) {
            Back back = new Back();
            Order order = orderMapper.selectByPrimaryKey(id);
            Ticketing ticketing = ticketingMapper.selectByPrimaryKey(order.getTid());
            SysUser oneById = userService.findOneById(order.getUid());
            BigDecimal bigDecimal = new BigDecimal(ticketing.getPrice() * 0.95);
            BigDecimal scale = bigDecimal.setScale(1, BigDecimal.ROUND_HALF_UP);
            orderMapper.deleteByPrimaryKey(id);
            double backMoeny = scale.doubleValue();
            back.setTrickname(ticketing.getTrainName());
            back.setBackMoney(backMoeny + "");
            back.setStartAddress(ticketing.getSAddress());
            back.setToAddress(ticketing.getEAddress());
            back.setOperTime(DateUtil.now());
            back.setUsername(oneById.getUsername());
            backMapper.insert(back);
            return backMoeny;
        }
        return 0;
    }

    @Override
    public List<Order> selectbytId(Integer tid) {
        return orderMapper.selectByTid(tid);
    }

    @Override
    public void chanceorder(Integer id, Integer toid) {
        Order order = orderMapper.selectByPrimaryKey(id);
        Ticketing ticketing = ticketingMapper.selectByPrimaryKey(order.getTid());
        Ticketing nticketing = ticketingMapper.selectByPrimaryKey(toid);

        if (!StringUtils.contains(nticketing.getSAddress(), ticketing.getSAddress())) {
            throw new XxException(ExceptionEnums.ORDER_UPDATA_ERROR);
        }
        if (!StringUtils.contains(nticketing.getEAddress(), ticketing.getEAddress())) {
            throw new XxException(ExceptionEnums.ORDER_UPDATA_ERROR);
        }
        order.setTid(nticketing.getId());
        orderMapper.updateByPrimaryKeySelective(order);

    }


}

