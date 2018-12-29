package com.lhf.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileUtils {
	
private  static int length=1024;//���������ļ��ڶ�ȡʱһ�ζ�ȡ�ļ��Ĵ�С��
	
	/*
	 * �ļ����и�
	 * String path   �и��ļ���·��
	 * size �������� ���ļ��Ĵ�С
	 * */
	public static void  filesplit(String path,int size)throws Exception
	{
		if(path==null)
			throw new Exception("Դ�ļ�����Ϊ��...");
		
		File file=new File(path);
		if(!file.exists())
			throw new Exception("Դ�ļ�������...");
		
		long num=file.length()%size==0?file.length()/size:file.length()/size+1;
		String list[]=new String[(int)num];//���ڴ�ŷָ��Ľ��
		
		FileInputStream reader=new FileInputStream(file);
		long beginIndex=0,endIndex=0;
		int readcount=0;byte buffer[]=new byte[length];
		for(int i=0;i<num;i++)
		{
			String absPath = file.getAbsolutePath();
			System.out.println(absPath);
			
			String[] pathArr = absPath.split("\\.");
			System.out.println("length= " + pathArr.length + "\n" + pathArr[0]);
	
			// ��ȡ�ļ���
			String fileName = file.getName().substring(0, file.getName().indexOf("."));
			// ��ȡ�ļ���׺
			String endName = file.getName().substring(file.getName().lastIndexOf("."));
			//list[i]=fileName + "_data" + i + endName;
			//list[i]=file.getAbsolutePath() + i + endName;
			list[i] = pathArr[0] + "-" + i + endName;
			
			System.out.println(list[i]);
			FileOutputStream writer=new FileOutputStream(list[i]);
			endIndex=(endIndex+size)>file.length()?file.length():endIndex+size;
			for(;beginIndex<endIndex;)
			{
				if(endIndex-beginIndex>=length) {
				 readcount=reader.read(buffer);
				 beginIndex+=readcount;
				 writer.write(buffer);
				}else {
					//����ľͲ���ֱ�Ӷ�ȡ1024���ֽ���,��Ҫһ��һ���ֽڵĶ�ȡ��
					for(;beginIndex<endIndex;beginIndex++)
					{
						writer.write(reader.read());
					}
					continue;
				}
			}
			writer.close();
			
		}
	}
	
	/**
	 * �ļ��ϲ�
	 * @param path
	 * @param newString
	 * @throws Exception
	 */
	public static void union(String path,String newString)throws Exception
	{
		File file=new File(path);
		File list[]=file.listFiles();
		File newFile=new File(newString);
		byte buffer[]=new byte[1024];
		int readcount;
		if(!newFile.getParentFile().exists())
			throw new Exception("��ϲ����ļ��еĲ�����...");
		FileOutputStream writer=new FileOutputStream(newString);
		
		for(File f:list)
		{
			FileInputStream reader=new FileInputStream(f);
			while((readcount=reader.read(buffer))!=-1)
			{
				writer.write(buffer);
			}
			reader.close();
		}
		writer.close();
	}

}
