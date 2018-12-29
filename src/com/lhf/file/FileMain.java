package com.lhf.file;

/**
 * 文件的分割与合并
 * 		1．文件的分割，原理是用输入流去读取文件，将读取规定大小的流再输出到指定的文件，直到把整个文件读取结束．
 * 		2．文件合并，文件的合并原理与分割正好想反，就是把所有的文件都读取到一个输入流中，然后再把输入流中的东西全部输出到
 * 				同一个文件输出流中，这样就可以把分割的文件合并到一个文件中去了．　并且文件的大小和原来也会一样　．　
 * 																				
 */
public class FileMain {

	public static void main(String[] args) throws Exception {

		/*long startTime = System.currentTimeMillis();
		System.out.println("开始拆分文件.....");
		FileUtils.filesplit("F:\\BaiduNetdiskDownload\\01.mp4", 12*1024*1024);
		long endTime = System.currentTimeMillis();
		System.out.println("拆分文件耗时：" + (endTime - startTime) + "毫秒");
		
		
		
		long startTime1 = System.currentTimeMillis();
		System.out.println("\n开始合并文件.....");
		FileUtils.union("F:\\BaiduNetdiskDownload\\","F:\\01.mp4");
		long endTime1 = System.currentTimeMillis();
		System.out.println("合并文件耗时：" + (endTime1 - startTime1) + "毫秒");*/
		
		FileUtils.filesplit("F:\\BaiduNetdiskDownload\\01.mp4",12*1024*1024);
		//FileUtils.union("F:\\BaiduNetdiskDownload\\","E:\\01.mp4");

	}

}
