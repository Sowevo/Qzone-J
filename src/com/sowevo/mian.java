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
//		getOneUser(driver,"1829442");
//		getOneUser(driver,"6223526");
//		getOneUser(driver,"8941661");
//		getOneUser(driver,"11179518");
//		getOneUser(driver,"23642660");
//		getOneUser(driver,"32584702");
//		getOneUser(driver,"42832660");
//		getOneUser(driver,"46895873");
//		getOneUser(driver,"56268888");
//		getOneUser(driver,"61536096");
//		getOneUser(driver,"81049954");
//		getOneUser(driver,"83041958");
//		getOneUser(driver,"89771478");
//		getOneUser(driver,"94664786");
//		getOneUser(driver,"95172040");
//		getOneUser(driver,"115421068");
//		getOneUser(driver,"120182336");
//		getOneUser(driver,"120914219");
//		getOneUser(driver,"124972659");
//		getOneUser(driver,"137002698");
//		getOneUser(driver,"178546804");
//		getOneUser(driver,"179467742");
//		getOneUser(driver,"196916712");
//		getOneUser(driver,"237707054");
//		getOneUser(driver,"240234384");
//		getOneUser(driver,"253458346");
//		getOneUser(driver,"254722399");
//		getOneUser(driver,"260948253");
//		getOneUser(driver,"261391861");
//		getOneUser(driver,"277076437");
//		getOneUser(driver,"279148750");
//		getOneUser(driver,"284536569");
//		getOneUser(driver,"291154697");
//		getOneUser(driver,"295931437");
//		getOneUser(driver,"296529433");
//		getOneUser(driver,"296910598");
//		getOneUser(driver,"307023222");
//		getOneUser(driver,"307754120");
//		getOneUser(driver,"309276520");
//		getOneUser(driver,"310462498");
//		getOneUser(driver,"313137548");
//		getOneUser(driver,"317153281");
//		getOneUser(driver,"319933299");
//		getOneUser(driver,"327140083");
//		getOneUser(driver,"329165102");
//		getOneUser(driver,"332424309");
//		getOneUser(driver,"343446148");
//		getOneUser(driver,"351596723");
//		getOneUser(driver,"357763044");
//		getOneUser(driver,"362604841");
//		getOneUser(driver,"373502724");
//		getOneUser(driver,"373852540");
//		getOneUser(driver,"374206305");
//		getOneUser(driver,"375838935");
//		getOneUser(driver,"378462699");
//		getOneUser(driver,"380709638");
//		getOneUser(driver,"380863794");
//		getOneUser(driver,"381248261");
//		getOneUser(driver,"383391486");
//		getOneUser(driver,"395598154");
//		getOneUser(driver,"404395631");
//		getOneUser(driver,"408286517");
//		getOneUser(driver,"409601345");
//		getOneUser(driver,"413178138");
//		getOneUser(driver,"415259676");
//		getOneUser(driver,"420380090");
//		getOneUser(driver,"442139461");
//		getOneUser(driver,"442499486");
//		getOneUser(driver,"446173023");
//		getOneUser(driver,"447009489");
//		getOneUser(driver,"448321039");
//		getOneUser(driver,"448774964");
//		getOneUser(driver,"450069478");
//		getOneUser(driver,"450770258");
//		getOneUser(driver,"465711761");
//		getOneUser(driver,"471033351");
//		getOneUser(driver,"472360224");
//		getOneUser(driver,"475278105");
//		getOneUser(driver,"477739112");
//		getOneUser(driver,"492129558");
//		getOneUser(driver,"496971849");
//		getOneUser(driver,"502030758");
//		getOneUser(driver,"502622755");
//		getOneUser(driver,"514084564");
//		getOneUser(driver,"514959183");
//		getOneUser(driver,"517472492");
//		getOneUser(driver,"519547983");
//		getOneUser(driver,"519875660");
//		getOneUser(driver,"525172313");
//		getOneUser(driver,"525988946");
//		getOneUser(driver,"526828473");
//		getOneUser(driver,"529314160");
//		getOneUser(driver,"534172455");
//		getOneUser(driver,"544823204");
//		getOneUser(driver,"550272165");
//		getOneUser(driver,"564767363");
//		getOneUser(driver,"569457519");
//		getOneUser(driver,"570635656");
//		getOneUser(driver,"574797339");
//		getOneUser(driver,"578005970");
//		getOneUser(driver,"591412064");
//		getOneUser(driver,"594811552");
//		getOneUser(driver,"597802570");
//		getOneUser(driver,"601285913");
//		getOneUser(driver,"601474281");
//		getOneUser(driver,"602740663");
//		getOneUser(driver,"603721103");
//		getOneUser(driver,"609770864");
//		getOneUser(driver,"616706091");
//		getOneUser(driver,"623849446");
//		getOneUser(driver,"635339925");
//		getOneUser(driver,"645896460");
//		getOneUser(driver,"649124702");
//		getOneUser(driver,"651495445");
//		getOneUser(driver,"651764330");
//		getOneUser(driver,"674347128");
//		getOneUser(driver,"675478802");
//		getOneUser(driver,"695075944");
//		getOneUser(driver,"695725051");
//		getOneUser(driver,"709609976");
//		getOneUser(driver,"710199703");
//		getOneUser(driver,"710794839");
//		getOneUser(driver,"718840833");
//		getOneUser(driver,"719030991");
//		getOneUser(driver,"719482077");
//		getOneUser(driver,"724378871");
//		getOneUser(driver,"724967243");
//		getOneUser(driver,"742690400");
//		getOneUser(driver,"742755299");
//		getOneUser(driver,"749852919");
//		getOneUser(driver,"750282520");
//		getOneUser(driver,"754501965");
//		getOneUser(driver,"757127828");
//		getOneUser(driver,"757171839");
//		getOneUser(driver,"759581732");
//		getOneUser(driver,"761686459");
//		getOneUser(driver,"772990689");
//		getOneUser(driver,"785324983");
//		getOneUser(driver,"794435141");
//		getOneUser(driver,"794513111");
//		getOneUser(driver,"798850659");
//		getOneUser(driver,"800008725");
//		getOneUser(driver,"800010000");
//		getOneUser(driver,"800010010");
//		getOneUser(driver,"809449751");
//		getOneUser(driver,"809489415");
//		getOneUser(driver,"810716599");
//		getOneUser(driver,"812343972");
//		getOneUser(driver,"821210393");
//		getOneUser(driver,"849301677");
//		getOneUser(driver,"851106118");
//		getOneUser(driver,"854495176");
//		getOneUser(driver,"859745184");
//		getOneUser(driver,"864045600");
//		getOneUser(driver,"865411604");
//		getOneUser(driver,"874933093");
//		getOneUser(driver,"879115105");
//		getOneUser(driver,"892372923");
//		getOneUser(driver,"893062601");
//		getOneUser(driver,"895242391");
//		getOneUser(driver,"895283784");
//		getOneUser(driver,"896153219");
//		getOneUser(driver,"897195000");
//		getOneUser(driver,"904252258");
//		getOneUser(driver,"906030216");
//		getOneUser(driver,"906619642");
//		getOneUser(driver,"921064632");
//		getOneUser(driver,"924562307");
//		getOneUser(driver,"926048094");
//		getOneUser(driver,"928408553");
//		getOneUser(driver,"928530415");
//		getOneUser(driver,"931862674");
//		getOneUser(driver,"938075540");
//		getOneUser(driver,"943822332");
//		getOneUser(driver,"953539103");
//		getOneUser(driver,"954124090");
//		getOneUser(driver,"954246770");
//		getOneUser(driver,"956994986");
//		getOneUser(driver,"957755237");
//		getOneUser(driver,"957838959");
//		getOneUser(driver,"963099583");
//		getOneUser(driver,"964121516");
//		getOneUser(driver,"965178177");
//		getOneUser(driver,"969651649");
//		getOneUser(driver,"977572807");
//		getOneUser(driver,"982156220");
//		getOneUser(driver,"992172351");
//		getOneUser(driver,"1002031952");
//		getOneUser(driver,"1003923615");
//		getOneUser(driver,"1006268981");
//		getOneUser(driver,"1014893208");
//		getOneUser(driver,"1021090327");
//		getOneUser(driver,"1024032961");
//		getOneUser(driver,"1031002149");
//		getOneUser(driver,"1031503859");
//		getOneUser(driver,"1035844473");
//		getOneUser(driver,"1041638892");
//		getOneUser(driver,"1042241920");
//		getOneUser(driver,"1047858929");
//		getOneUser(driver,"1050561507");
//		getOneUser(driver,"1050678171");
//		getOneUser(driver,"1057728246");
//		getOneUser(driver,"1058524320");
//		getOneUser(driver,"1070478761");
//		getOneUser(driver,"1090430113");
//		getOneUser(driver,"1121287318");
//		getOneUser(driver,"1135429210");
//		getOneUser(driver,"1141689229");
//		getOneUser(driver,"1150786480");
//		getOneUser(driver,"1151404431");
//		getOneUser(driver,"1152804851");
		getOneUser(driver,"1157954903");
		getOneUser(driver,"1160925030");
		getOneUser(driver,"1191167782");
		getOneUser(driver,"1192212462");
		getOneUser(driver,"1196855814");
		getOneUser(driver,"1206513060");
		getOneUser(driver,"1247756698");
		getOneUser(driver,"1261651212");
		getOneUser(driver,"1261961462");
		getOneUser(driver,"1276957012");
		getOneUser(driver,"1297681131");
		getOneUser(driver,"1316643567");
		getOneUser(driver,"1316746304");
		getOneUser(driver,"1328729757");
		getOneUser(driver,"1335778249");
		getOneUser(driver,"1362540974");
		getOneUser(driver,"1367916573");
		getOneUser(driver,"1397471668");
		getOneUser(driver,"1429549295");
		getOneUser(driver,"1433498999");
		getOneUser(driver,"1434396223");
		getOneUser(driver,"1439888088");
		getOneUser(driver,"1462216609");
		getOneUser(driver,"1463955487");
		getOneUser(driver,"1486738809");
		getOneUser(driver,"1541859081");
		getOneUser(driver,"1554928012");
		getOneUser(driver,"1603422950");
		getOneUser(driver,"1607530887");
		getOneUser(driver,"1663855032");
		getOneUser(driver,"1677295525");
		getOneUser(driver,"1697864007");
		getOneUser(driver,"1832152746");
		getOneUser(driver,"1832469096");
		getOneUser(driver,"1907085838");
		getOneUser(driver,"1955624997");
		getOneUser(driver,"1968196302");
		getOneUser(driver,"1977797951");
		getOneUser(driver,"2080457459");
		getOneUser(driver,"2208869933");
		getOneUser(driver,"2213277943");
		getOneUser(driver,"2226784909");
		getOneUser(driver,"2239686809");
		getOneUser(driver,"2248848074");
		getOneUser(driver,"2284033916");
		getOneUser(driver,"2358716309");
		getOneUser(driver,"2426600523");
		getOneUser(driver,"2462863567");
		getOneUser(driver,"2470026158");
		getOneUser(driver,"2538781301");
		getOneUser(driver,"2585659088");
		getOneUser(driver,"2629881085");
		getOneUser(driver,"2636299511");
		getOneUser(driver,"2829126686");
		getOneUser(driver,"2851271123");
		getOneUser(driver,"2881696871");
		getOneUser(driver,"2881711850");
		getOneUser(driver,"2991854595");
		getOneUser(driver,"3040548114");
		getOneUser(driver,"3392366230");
		getOneUser(driver,"3467763504");
		getOneUser(driver,"760580435");
		getOneUser(driver,"2759703198");
		getOneUser(driver,"123888867");
		getOneUser(driver,"469553823");
		getOneUser(driver,"838164379");
		getOneUser(driver,"905387003");
		getOneUser(driver,"1316299045");
		getOneUser(driver,"2361503083");

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
			driver.findElement(By.id("p")).sendKeys("zxcvbn");
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
