package com.sowevo;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.alibaba.fastjson.JSON;
import com.sowevo.bean.ShuoShuo;
import com.sowevo.utils.C3P0Utils;

public class mian {
	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.bin", "C:/Program Files (x86)/Google/Chrome/Application/chromedriver.exe");

		// 从项目路径下找到禁用图片的Chrome扩展
		String extensionsPath = System.getProperty("user.dir") + "\\lib\\Block-image_v1.0.crx";

		ChromeOptions options = new ChromeOptions();
		//options.addExtensions(new File(extensionsPath));
		// 定义驱动对象为 FirefoxDriver 对象
		WebDriver driver = new ChromeDriver(options);
		String qq = "317153281";
		// String qq = "954246770";
		// 浏览器窗口变大
		//driver.manage().window().fullscreen();
		getOneUser(driver,"1829442");

	}

	/**
	 * 获取一个用户的所有
	 * 
	 * @param driver
	 * @param qq
	 * @throws Exception
	 */
	public static void getOneUser(WebDriver driver, String qq) throws Exception {

		driver.get("http://user.qzone.qq.com/" + qq + "/311");

		// 判断是否需要登录
		Boolean needLogin = true;
		try {
			Thread.sleep(1000);
			driver.findElement(By.id("login_div"));
			needLogin = true;
		} catch (Exception e) {
			needLogin = false;
		}
		System.out.println("是否需要登录:" + needLogin);

		// 登录
		if (needLogin) {
			System.out.println("开始登陆");
			driver.switchTo().frame("login_frame");
			driver.findElement(By.id("switcher_plogin")).click();
			driver.findElement(By.id("u")).clear(); // 选择用户名框
			driver.findElement(By.id("u")).sendKeys("23642660");
			driver.findElement(By.id("p")).clear();
			driver.findElement(By.id("p")).sendKeys("密码密码");
			driver.findElement(By.id("login_button")).click();
			Thread.sleep(1000);
		}
		// 判断是否有访问权限
		Boolean isPrivate = true;
		try {
			driver.findElement(By.id("QM_OwnerInfo_Icon"));
			isPrivate = false;
		} catch (Exception e) {
			isPrivate = true;
		}
		System.out.println(isPrivate);

		// 开始抓取第一页
		if (!isPrivate) {
			driver.switchTo().frame("app_canvas_frame");
			//Thread.sleep(20000);
			getOnePage(driver);
			driver.switchTo().defaultContent();
		}
	}

	/**
	 * 获取一页的信息 20170919 dongjunqi
	 * 
	 * @param driver
	 * @throws Exception
	 */
	public static void getOnePage(WebDriver driver) throws Exception {
		System.out.println("开始抓取");
		Thread.sleep(1000);
		List<WebElement> elements = driver.findElements(By.cssSelector(".feed"));
		for (WebElement webElement : elements) {
			String id = webElement.getAttribute("data-tid");
			String uid = webElement.getAttribute("data-uin");
			String forward = "";
			try {
				forward = webElement.findElement(By.cssSelector(".quote>.bd")).getText();
			} catch (RuntimeException e) {
			}
			String content = webElement.findElement(By.cssSelector(".content")).getText();
			String sendTime = webElement.findElement(By.cssSelector(".c_tx.c_tx3.goDetail")).getText();

			List<WebElement> imgs = webElement.findElements(By.cssSelector(".img-attachments-inner.clearfix>a"));
			List<String> imgList = new ArrayList<String>();
			for (WebElement img : imgs) {
				imgList.add(img.getAttribute("href"));
			}
			String imgStr = JSON.toJSONString(imgList);

			ShuoShuo shuoShuo = new ShuoShuo();
			shuoShuo.setId(id);
			shuoShuo.setUid(uid);
			shuoShuo.setForward(forward);
			shuoShuo.setContent(content);
			shuoShuo.setSendTime(sendTime);
			shuoShuo.setImgs(imgStr);
			saveShuoShuo(shuoShuo);
		}
		// 判断有没有下一页
		Boolean hasNextPage = true;
		try {
			driver.findElement(By.linkText("下一页"));
			hasNextPage = true;
		} catch (Exception e) {
			hasNextPage = false;
		}
		// 有了点了按钮继续抓
		if (hasNextPage) {
			System.out.println("有下一页");
			try {
				driver.findElement(By.linkText("下一页")).click();
			} catch (RuntimeException e) {
				driver.manage().window().fullscreen();
				Thread.sleep(20000);
				driver.findElement(By.linkText("下一页")).click();
			}
			System.out.println("前往下一页");
			Thread.sleep(500);
			getOnePage(driver);
		} else {
			System.out.println("没有下一页,结束");
		}
	}

	/**
	 * 数据保存到数据库
	 * 
	 * @param movieinfo
	 * @param fileinfo
	 * @throws Exception
	 */
	public static void saveShuoShuo(ShuoShuo shuoShuo) throws Exception {
		System.out.println(shuoShuo);
		QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
//		String sql = "REPLACE INTO shuoshuo VALUES ('" + shuoShuo.getId() + "', '" + shuoShuo.getUid() + "', '"
//				+ shuoShuo.getSendTime() + "', '" + shuoShuo.getContent().replaceAll("'", "''") + "','" + shuoShuo.getForward().replaceAll("'", "''") + "', '"
//				+ shuoShuo.getImgs().replaceAll("'", "''") + "')";
		String sql = "REPLACE INTO shuoshuo VALUES ( ? , ? , ? , ? , ? , ? )";
		runner.update(sql,shuoShuo.getId(),shuoShuo.getUid(),shuoShuo.getSendTime(),shuoShuo.getContent(),shuoShuo.getForward(),shuoShuo.getImgs());
	}
}
