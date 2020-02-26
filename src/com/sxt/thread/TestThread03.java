package com.sxt.thread;

import java.io.IOException;
import java.net.MalformedURLException;

/**
 * 使用 Runnable 实现线程
 * @author Administrator
 *
 */
public class TestThread03 implements Runnable {
	private String name;
	private String url;
	
	public TestThread03(String name, String url) {
		super();
		this.name = name;
		this.url = url;
	}

	@Override
	public void run() {
		DownloadPicture dp = new DownloadPicture();
		try {
			dp.download(url, name);
			System.out.println(name);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		String url = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1582709482827&di=05e11d0f6ed43970005f76a91b7c389c&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2F2019-01-08%2F5c348d22906bf.jpg";
		new Thread(new TestThread03("1.jpg", url)).start();
		new Thread(new TestThread03("2.jpg", url)).start();
		
	}

}
