package com.sxt.thread;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;

public class DownloadPicture {
	public void download(String url, String name) throws MalformedURLException, IOException {
		FileUtils.copyURLToFile(new URL(url), new File(name));
	}
}
