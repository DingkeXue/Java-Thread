package com.sxt.thread;

import java.io.IOException;
import java.net.MalformedURLException;

/**
 * 多线程同时下载图片
 * @author Administrator
 *
 */
public class TestThread02 extends Thread {
	private String url;
	private String name;
	
	public TestThread02(String url, String name) {
		super();
		this.url = url;
		this.name = name;
	}

	@Override
	public void run() {
		DownloadPicture dPicture = new DownloadPicture();
		try {
			dPicture.download(url, name);
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
		TestThread02 d1 = new TestThread02("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1582709482827&di=05e11d0f6ed43970005f76a91b7c389c&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2F2019-01-08%2F5c348d22906bf.jpg", "1.jpg");
		TestThread02 d2 = new TestThread02("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1582709573582&di=06816dcd289878e93004850ac124ab07&imgtype=0&src=http%3A%2F%2Fvp1.mbsimg.com%2FProductImg%2F99%2F1402%2Fhuge%2F998016555-M1AR-04-H.jpg", "2.jpg");
		TestThread02 d3 = new TestThread02("https://image.baidu.com/search/detail?ct=503316480&z=undefined&tn=baiduimagedetail&ipn=d&word=%E7%BE%8E%E5%A5%B3&step_word=&ie=utf-8&in=&cl=2&lm=-1&st=undefined&hd=undefined&latest=undefined&copyright=undefined&cs=1297818057,752979029&os=2264837631,80079777&simid=3361426693,139770020&pn=19&rn=1&di=166980&ln=3240&fr=&fmq=1582699205861_R&fm=&ic=undefined&s=undefined&se=&sme=&tab=0&width=undefined&height=undefined&face=undefined&is=0,0&istype=0&ist=&jit=&bdtype=0&spn=0&pi=0&gsm=0&hs=2&objurl=http%3A%2F%2Fs9.sinaimg.cn%2Fmw690%2F006ffqTggy6WOiTjZDq98%26690&rpstart=0&rpnum=0&adpicid=0&force=undefined", "3.jpg");
		
		d1.start();
		d2.start();
		d3.start();
	}
}
