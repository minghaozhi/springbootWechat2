package com.sheshu.wechat;

import com.sheshu.wechat.bean.AccessToken;
import com.sheshu.wechat.menu.Menu;
import com.sheshu.wechat.service.MenuService;
import com.sheshu.wechat.service.WeChatService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SheshuWechatApplicationTests {

	@Autowired
	private WeChatService weChatService;

	@Autowired
	private MenuService menuService;

	@Test
	public void getAccessToken() throws IOException {
		AccessToken accessToken = weChatService.getAccessToken();
		System.out.print(accessToken.getAccess_token());
	}

	@Test
	public void createMenu() throws IOException {
		Integer errcode = menuService.createMenu();
		if(errcode==0){
			System.out.println("菜单创建成功");
		}else{
			System.out.println("菜单创建失败");
		}
	}

	@Test
	public void queryMenu() throws IOException {
		String result = menuService.queryMenu();
		System.out.println(result);
	}

	@Test
	public void deleteMenu() throws IOException {
		Integer errcode = this.menuService.deleteMenu();
		System.out.println(errcode);
	}
}
