package com.lhf.file;

/**
 * �ļ��ķָ���ϲ�
 * 		1���ļ��ķָԭ������������ȥ��ȡ�ļ�������ȡ�涨��С�����������ָ�����ļ���ֱ���������ļ���ȡ������
 * 		2���ļ��ϲ����ļ��ĺϲ�ԭ����ָ������뷴�����ǰ����е��ļ�����ȡ��һ���������У�Ȼ���ٰ��������еĶ���ȫ�������
 * 				ͬһ���ļ�������У������Ϳ��԰ѷָ���ļ��ϲ���һ���ļ���ȥ�ˣ��������ļ��Ĵ�С��ԭ��Ҳ��һ��������
 * 																				
 */
public class FileMain {

	public static void main(String[] args) throws Exception {

		/*long startTime = System.currentTimeMillis();
		System.out.println("��ʼ����ļ�.....");
		FileUtils.filesplit("F:\\BaiduNetdiskDownload\\01.mp4", 12*1024*1024);
		long endTime = System.currentTimeMillis();
		System.out.println("����ļ���ʱ��" + (endTime - startTime) + "����");
		
		
		
		long startTime1 = System.currentTimeMillis();
		System.out.println("\n��ʼ�ϲ��ļ�.....");
		FileUtils.union("F:\\BaiduNetdiskDownload\\","F:\\01.mp4");
		long endTime1 = System.currentTimeMillis();
		System.out.println("�ϲ��ļ���ʱ��" + (endTime1 - startTime1) + "����");*/
		
		FileUtils.filesplit("F:\\BaiduNetdiskDownload\\01.mp4",12*1024*1024);
		//FileUtils.union("F:\\BaiduNetdiskDownload\\","E:\\01.mp4");

	}

}
