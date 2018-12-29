package com.lhf.file2;

import java.io.File;
import java.io.IOException;

public class FileMain {

	public static void main(String[] args) throws IOException {
		SplitTextFile splitTextFile = new SplitTextFile();
		String srcPath = "F:/log/nohup.out";
		long size = 30 * 1024 * 1024;   //指定分割的文件大小
		File file = new File(srcPath);
		long fileLength = splitTextFile.getFileLength(file);
		System.out.println("文件大小：" + fileLength);
		int partitionFileNum = splitTextFile.getSplitFileNum(fileLength, srcPath, size);
		System.out.println("个数" + partitionFileNum);
		// 文件分割
		//splitTextFile.splitFile(new File(srcPath), partitionFileNum, size);

		String[] files = { "F:/log/nohup_0.out", "F:/log/nohup_1.out", "F:/log/nohup_2.out","F:/log/nohup_3.out"};
		String newFile = "F:/log1/nohup.out";
		splitTextFile.mergeFile(files, newFile);

	}

}
