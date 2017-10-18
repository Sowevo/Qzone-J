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

		// ����Ŀ·�����ҵ�����ͼƬ��Chrome��չ
		String extensionsPath = System.getProperty("user.dir") + "\\lib\\Block-image_v1.0.crx";

		ChromeOptions options = new ChromeOptions();
		//options.addExtensions(new File(extensionsPath));
		// ������������Ϊ FirefoxDriver ����
		WebDriver driver = new ChromeDriver(options);
		String qq = "317153281";
		// String qq = "954246770";
		// ��������ڱ��
		//driver.manage().window().fullscreen();
		getOneUser(driver,"1829442");

	}

	/**
	 * ��ȡһ���û�������
	 * 
	 * @param driver
	 * @param qq
	 * @throws Exception
	 */
	public static void getOneUser(WebDriver driver, String qq) throws Exception {

		driver.get("http://user.qzone.qq.com/" + qq + "/311");

		// �ж��Ƿ���Ҫ��¼
		Boolean needLogin = true;
		try {
			Thread.sleep(1000);
			driver.findElement(By.id("login_div"));
			needLogin = true;
		} catch (Exception e) {
			needLogin = false;
		}
		System.out.println("�Ƿ���Ҫ��¼:" + needLogin);

		// ��¼
		if (needLogin) {
			System.out.println("��ʼ��½");
			driver.switchTo().frame("login_frame");
			driver.findElement(By.id("switcher_plogin")).click();
			driver.findElement(By.id("u")).clear(); // ѡ���û�����
			driver.findElement(By.id("u")).sendKeys("23642660");
			driver.findElement(By.id("p")).clear();
			driver.findElement(By.id("p")).sendKeys("��������");
			driver.findElement(By.id("login_button")).click();
			Thread.sleep(1000);
		}
		// �ж��Ƿ��з���Ȩ��
		Boolean isPrivate = true;
		try {
			driver.findElement(By.id("QM_OwnerInfo_Icon"));
			isPrivate = false;
		} catch (Exception e) {
			isPrivate = true;
		}
		System.out.println(isPrivate);

		// ��ʼץȡ��һҳ
		if (!isPrivate) {
			driver.switchTo().frame("app_canvas_frame");
			//Thread.sleep(20000);
			getOnePage(driver);
			driver.switchTo().defaultContent();
		}
	}

	/**
	 * ��ȡһҳ����Ϣ 20170919 dongjunqi
	 * 
	 * @param driver
	 * @throws Exception
	 */
	public static void getOnePage(WebDriver driver) throws Exception {
		System.out.println("��ʼץȡ");
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
		// �ж���û����һҳ
		Boolean hasNextPage = true;
		try {
			driver.findElement(By.linkText("��һҳ"));
			hasNextPage = true;
		} catch (Exception e) {
			hasNextPage = false;
		}
		// ���˵��˰�ť����ץ
		if (hasNextPage) {
			System.out.println("����һҳ");
			try {
				driver.findElement(By.linkText("��һҳ")).click();
			} catch (RuntimeException e) {
				driver.manage().window().fullscreen();
				Thread.sleep(20000);
				driver.findElement(By.linkText("��һҳ")).click();
			}
			System.out.println("ǰ����һҳ");
			Thread.sleep(500);
			getOnePage(driver);
		} else {
			System.out.println("û����һҳ,����");
		}
	}

	/**
	 * ���ݱ��浽���ݿ�
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
