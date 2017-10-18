package com.sowevo.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.alibaba.fastjson.JSON;
import com.sowevo.bean.ShuoShuo;
/**
 * 从数据库取出保存的信息,下载其中的图片
 * @author dqqsw
 *
 */
public class GetImg {
	public static void main(String[] args) throws Exception {
		findAll();
	}
	
	public static void findAll() throws Exception {
		QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "SELECT *  FROM shuoshuo";
		List<ShuoShuo> sss = runner.query(sql, new BeanListHandler<>(ShuoShuo.class));
		int xx = 1;
		for (ShuoShuo ss : sss) {
			System.out.println(xx);
			if (ss.getImgs().length()>2) {
				List<String> imgstr = (List<String>) JSON.parse(ss.getImgs());
				for (int i = 0; i < imgstr.size(); i++) {
					System.out.println(imgstr.get(i));
					try {
						String url = imgstr.get(i);
						if (url.contains("taobaocdn")||url.contains("alicdn")) {
							continue;
						}
						download(imgstr.get(i), i+ss.getId()+".jpg", "f://Qzone//"+ss.getUid());
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			xx++;
		}
	}
	
	/**
	 * 下载文件
	 * @param urlString 下载的链接
	 * @param filename	保存的文件名
	 * @param savePath	保存的位置
	 * @throws Exception
	 */
	public static void download(String urlString, String filename, String savePath) throws Exception {
		// 构造URL
		
		URL url = new URL(urlString);
		// 打开连接
		URLConnection con = url.openConnection();
		// 设置请求超时为5s
		con.setConnectTimeout(1000);
		con.setRequestProperty("User-agent","Mozilla/4.0");
		// 输入流
		InputStream is = con.getInputStream();

		// 1K的数据缓冲
		byte[] bs = new byte[1024];
		// 读取到的数据长度
		int len;
		// 输出的文件流
		File sf = new File(savePath);
		if (!sf.exists()) {
			sf.mkdirs();
		}
		OutputStream os = new FileOutputStream(sf.getPath() + "\\" + filename);
		// 开始读取
		while ((len = is.read(bs)) != -1) {
			os.write(bs, 0, len);
		}
		// 完毕，关闭所有链接
		os.close();
		is.close();
	}
}
