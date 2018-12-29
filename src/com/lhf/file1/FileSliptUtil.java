package com.lhf.file1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileSliptUtil {

	/**
	 * 
	 * @Description 文件分割
	 * @param src 分割文件路径
	 * @param m   大小
	 * @throws IOException
	 */
	public static void splitFileDemo(File src, int m) throws IOException {
		if (src.isFile()) {
			// 获取文件的总长度
			long l = src.length();
			// 获取文件名
			String fileName = src.getName().substring(0, src.getName().indexOf("."));
			// 获取文件后缀
			String endName = src.getName().substring(src.getName().lastIndexOf("."));
			System.out.println(endName);
			InputStream in = null;
			try {
				in = new FileInputStream(src);
				for (int i = 1; i <= m; i++) {
					StringBuffer sb = new StringBuffer();
					sb.append(src.getParent());
					sb.append("\\");
					sb.append(fileName);
					sb.append("_data");
					sb.append(i);
					sb.append(endName);
					System.out.println(sb.toString());

					File file2 = new File(sb.toString());
					// 创建写文件的输出流
					OutputStream out = new FileOutputStream(file2);
					int len = -1;
					byte[] bytes = new byte[10 * 1024 * 1024];
					while ((len = in.read(bytes)) != -1) {
						out.write(bytes, 0, len);
						if (file2.length() > (l / m)) {
							break;
						}
					}
					out.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (in != null)
					in.close();
			}
			System.out.println("--- 文件分割完成 ---");
		}
	}

	
	/**
	 * 
	 * @Description 文件合并的方法 改进后的方法
	 * @param src 合并文件路径
	 */
	public static void joinFileDemo(String[] src) {
		// 获取合并文件
		File newFile = new File(src[0].toString());
		// 获取文件名 后缀
		String fileName = newFile.getName().substring(0, newFile.getName().indexOf("_"));
		String endName = newFile.getName().substring(newFile.getName().lastIndexOf("."));
		// 得到新的文件名
		StringBuffer sb = new StringBuffer();
		sb.append(newFile.getParent());
		sb.append("\\");
		sb.append(fileName);
		sb.append(endName);
		newFile = new File(sb.toString());
		for (int i = 0; i < src.length; i++) {
			File file = new File(src[i]);
			try {
				// 读取小文件的输入流
				InputStream in = new FileInputStream(file);
				OutputStream out = new FileOutputStream(newFile, true);
				int len = -1;
				byte[] bytes = new byte[10 * 1024 * 1024];
				while ((len = in.read(bytes)) != -1) {
					out.write(bytes, 0, len);
				}
				out.close();
				in.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("文件合并完成！");
	}

}
