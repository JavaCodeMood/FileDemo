package com.lhf.file2;

import java.io.File;
import java.io.IOException;

public abstract class SplitFile {
	/**
	 * 设置单个文件的大小
	 * 根据自己需求设置大小，字节进率为1024，本例中设置的最大分割文件大小是2Gb。
	 */
	public static long MAX_BYTE = 1024 * 1024 * 1024 * 2L;  //2G
	
	/**
	 * 获取可以分割的文件数
	 * @param fileByte 文件大小
	 * @param fileParh 文件路径
	 * @param size  要分割的文件大小
	 * @return
	 */
	//public abstract int getSplitFileNum(long fileByte,String fileParh);
	public abstract int getSplitFileNum(long fileByte,String fileParh, long size);
	/**
	 * 获取文件长度
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public abstract long getFileLength(File file) ;
	/**
	 * 分割文件
	 * @param srcFile
	 * @param splitFileNum
	 * @return
	 * @throws IOException
	 */
	//public abstract String[] splitFile (File srcFile,int splitFileNum) throws IOException;
	public abstract String[] splitFile (File srcFile,int splitFileNum, long size) throws IOException;
	/**
	 * 合并文件
	 * @param files
	 * @param newFile
	 * @throws IOException
	 */
	public abstract void mergeFile(String[] files,String newFile) throws IOException;


}
