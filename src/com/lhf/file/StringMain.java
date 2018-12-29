package com.lhf.file;

import java.io.File;

public class StringMain {
	
	public static void main(String[] args) {
		
		String path = "F:\\BaiduNetdiskDownload\\01.mp4";
		File file=new File(path);
		String absPath = file.getAbsolutePath();
		String[] pathArr = absPath.split("\\.");
		System.out.println("length= " + pathArr.length);
		System.out.println(pathArr[0]);
	}

}
