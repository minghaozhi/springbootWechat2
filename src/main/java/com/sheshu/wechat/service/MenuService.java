package com.sheshu.wechat.service;

import com.sheshu.wechat.menu.Menu;

import java.io.IOException;

/**
 */
public interface MenuService {

    /**
     * 获取菜单
     * @return
     */
    Menu getMenu();

    /**
     * 创建菜单
     * @return
     * @throws IOException
     */
    Integer createMenu() throws IOException;

    /**
     * 查询菜单的json串
     * @return
     * @throws IOException
     */
    String queryMenu() throws IOException;

    Integer deleteMenu() throws IOException;
}
