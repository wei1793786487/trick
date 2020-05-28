package com.chenghui.ticket.services.impl;

import com.chenghui.ticket.pojo.Back;
import com.chenghui.ticket.pojo.LayUi;
import com.chenghui.ticket.pojo.Order;
import com.chenghui.ticket.utlis.exception.ExceptionEnums;
import com.chenghui.ticket.utlis.exception.XxException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.chenghui.ticket.mapper.BackMapper;
import com.chenghui.ticket.services.BackService;

import java.util.List;

/**
 * @author Devil
 * @date 2020/5/28 11:16
 */
@Service
public class BackServiceImpl implements BackService {

    @Resource
    private BackMapper backMapper;

    @Override
    public LayUi select(String serch, Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<Back> backs = backMapper.selectBySearch(serch);
        if (backs.size() == 0) {
            throw new XxException(ExceptionEnums.NOT_FIND);
        }
        PageInfo<Back> brandPageInfo = new PageInfo<>();
        LayUi<Back> layUi = new LayUi<>();
        layUi.setCount(brandPageInfo.getTotal());
        layUi.setData(backs);
        return layUi;
    }

    @Override
    public void delect(Integer[] ids) {
        for (Integer id : ids) {
            backMapper.deleteByPrimaryKey(id);
        }
    }
}


