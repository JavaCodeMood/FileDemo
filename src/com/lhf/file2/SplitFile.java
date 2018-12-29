package com.lhf.file2;

import java.io.File;
import java.io.IOException;

public abstract class SplitFile {
	/**
	 * ���õ����ļ��Ĵ�С
	 * �����Լ��������ô�С���ֽڽ���Ϊ1024�����������õ����ָ��ļ���С��2Gb��
	 */
	public static long MAX_BYTE = 1024 * 1024 * 1024 * 2L;  //2G
	
	/**
	 * ��ȡ���Էָ���ļ���
	 * @param fileByte �ļ���С
	 * @param fileParh �ļ�·��
	 * @param size  Ҫ�ָ���ļ���С
	 * @return
	 */
	//public abstract int getSplitFileNum(long fileByte,String fileParh);
	public abstract int getSplitFileNum(long fileByte,String fileParh, long size);
	/**
	 * ��ȡ�ļ�����
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public abstract long getFileLength(File file) ;
	/**
	 * �ָ��ļ�
	 * @param srcFile
	 * @param splitFileNum
	 * @return
	 * @throws IOException
	 */
	//public abstract String[] splitFile (File srcFile,int splitFileNum) throws IOException;
	public abstract String[] splitFile (File srcFile,int splitFileNum, long size) throws IOException;
	/**
	 * �ϲ��ļ�
	 * @param files
	 * @param newFile
	 * @throws IOException
	 */
	public abstract void mergeFile(String[] files,String newFile) throws IOException;


}
