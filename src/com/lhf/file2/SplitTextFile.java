package com.lhf.file2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SplitTextFile extends SplitFile{

	/**
	 * 获取文件长度
	 */
	@Override
	public long getFileLength(File file) {
		FileReader fr =  null;
		BufferedReader br = null;
		//文件大小
		long fileSize = 0;
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			String line = br.readLine();
			//按行读取文件
			while(line != null){
				//计算文件大小
				fileSize += line.length();
				line = br.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			//关闭输入流
			try {
				if(br != null){
					br.close();
				}
				if(fr != null){
					fr.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		//返回文件大小
		return fileSize;
	}
	
	/**
	 * 获取可以分割的文件数
	 */
	@Override
	public int getSplitFileNum(long fileByte,String fileParh, long size){
		fileByte = getFileLength(new File(fileParh));
		if(size < fileByte){
			if(fileByte % size == 0){
				return (int) (fileByte/size);
			}else{
				return (int) (fileByte/size) + 1;
			}
		}
		return 1;
	}
	
	/*@Override
	public int getSplitFileNum(long fileByte,String fileParh){
		fileByte = getFileLength(new File(fileParh));
		if(MAX_BYTE < fileByte){
			if(fileByte % MAX_BYTE == 0){
				return (int) (fileByte/MAX_BYTE);
			}else{
				return (int) (fileByte/MAX_BYTE) + 1;
			}
		}
		return 1;
	}*/
 
	/**
	 * 分割文件
	 */
	@Override
	//public String[] splitFile(File srcFile, int splitFileNum) throws IOException {
	public String[] splitFile(File srcFile, int splitFileNum, long size) throws IOException {
		splitFileNum = getSplitFileNum(getFileLength(srcFile), srcFile.toString(), size);
		if(splitFileNum <= 0){
			return null;
		}
		FileReader fr = null;
		BufferedReader br = null;
		long readNum = 0;
		String[] splits = new String[splitFileNum];
		try {
			fr = new FileReader(srcFile);
			br = new BufferedReader(fr);
			int i = 0;
			while(splitFileNum > i){
				//分割后的文件名
				String name = null;
				//文件后缀
				String nameLast = null;
				if(srcFile.getName().indexOf(".") != -1){
					name = srcFile.getName().substring(0, srcFile.getName().indexOf("."));
					int last = srcFile.getName().lastIndexOf(".");
//					System.out.println(i);
//					String string = str.substring(i);
					nameLast = srcFile.getName().substring(last);
					
				}else{
					name = srcFile.getName();
				}
				splits[i] = srcFile.getParent() + "/" + name + "_" + i + nameLast;
				File wfile = new File(splits[i]);
				if(!wfile.exists()){
					wfile.getParentFile().mkdirs();
					wfile.createNewFile();
				}
				FileWriter fw = new FileWriter(wfile,false);
				BufferedWriter bw = new BufferedWriter(fw);
				String line = br.readLine();
				int flush = 0;
				while(line != null){
					if(line.trim().length() == 0){
						line = br.readLine();
						continue;
					}
					readNum += line.length();
					if(i + 1 == splitFileNum){
						bw.write(line);
						bw.newLine();
					}else{
						if(readNum >= size){
							bw.write(line);
							bw.newLine();
							break;
						}else{
							bw.write(line);
							bw.newLine();
						}
					}
					line = br.readLine();
					if(flush % 100 == 0){
						bw.flush();
					}
				}
				bw.flush();
				fw.flush();
				bw.close();
				fw.close();
				readNum = 0;
				i++;
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		finally{
			try {
				if(br != null) br.close();
				if(fr != null) fr.close();
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				br = null;
				fr = null;
			}
		}
		return splits;
	}
 
	/**
	 * 合并文件
	 */
	@Override
	public void mergeFile(String[] files, String newFile) throws IOException {
		File wfile = new File(newFile);
		FileWriter writer = null;
		BufferedWriter bufferedWriter = null;
		try {
			writer = new FileWriter(wfile,false);
			bufferedWriter = new BufferedWriter(writer);
			for(int i = 0; i < files.length; i++){
				File rFile = new File(files[i]);
				FileReader reader =  new FileReader(rFile);
				BufferedReader bufferedReader = new BufferedReader(reader);
				String line = bufferedReader.readLine();
				while(line != null){
					if(line.trim().length() == 0){
						line = bufferedReader.readLine();
						continue;
					}
					bufferedWriter.write(line);
					bufferedWriter.newLine();
					line = bufferedReader.readLine();
				}
			}
			bufferedWriter.flush();
			writer.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(bufferedWriter != null)
				bufferedWriter.close();
			bufferedWriter = null;
			if(writer != null)
				writer.close();
			writer = null;
		}
	}

}
