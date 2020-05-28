package com.chenghui.ticket.services.impl;

import com.chenghui.ticket.utlis.exception.ExceptionEnums;
import com.chenghui.ticket.mapper.MenuMapper;
import com.chenghui.ticket.pojo.Menu;
import com.chenghui.ticket.services.MenuService;
import com.chenghui.ticket.utlis.exception.XxException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author Devil
 * @date 2020/1/5 16:28
 */
@Service
@Transactional(rollbackFor = Exception.class)
@Slf4j
public class MenuServiceImpl implements MenuService {

    @Resource
    private MenuMapper menuMapper;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public Menu findMenuByRolename(String rolename) {
        Menu menu;
        if (StringUtils.isBlank(rolename)) {
            throw new XxException(ExceptionEnums.ROLE_NOT_FIND);
        }

//        String role = redisTemplate.opsForValue().get(rolename);
//        if (role == null) {

            menu = menuMapper.findOneByRoleName(rolename);
//            String jsonrole = JSON.toJSONString(menu);
//            redisTemplate.opsForValue().set(rolename, jsonrole, 10, TimeUnit.DAYS);
//            log.info("角色菜单没有缓存");
//        } else {
//            menu = JSON.parseObject(role, Menu.class);
//            log.info("角色菜单有缓存");
//
//        }

        if (menu == null) {
            throw new XxException(ExceptionEnums.MENU_NOT_FIND);
        }
        return menu;
    }


}




