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
	 * @Description �ļ��ָ�
	 * @param src �ָ��ļ�·��
	 * @param m   ��С
	 * @throws IOException
	 */
	public static void splitFileDemo(File src, int m) throws IOException {
		if (src.isFile()) {
			// ��ȡ�ļ����ܳ���
			long l = src.length();
			// ��ȡ�ļ���
			String fileName = src.getName().substring(0, src.getName().indexOf("."));
			// ��ȡ�ļ���׺
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
					// ����д�ļ��������
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
			System.out.println("--- �ļ��ָ���� ---");
		}
	}

	
	/**
	 * 
	 * @Description �ļ��ϲ��ķ��� �Ľ���ķ���
	 * @param src �ϲ��ļ�·��
	 */
	public static void joinFileDemo(String[] src) {
		// ��ȡ�ϲ��ļ�
		File newFile = new File(src[0].toString());
		// ��ȡ�ļ��� ��׺
		String fileName = newFile.getName().substring(0, newFile.getName().indexOf("_"));
		String endName = newFile.getName().substring(newFile.getName().lastIndexOf("."));
		// �õ��µ��ļ���
		StringBuffer sb = new StringBuffer();
		sb.append(newFile.getParent());
		sb.append("\\");
		sb.append(fileName);
		sb.append(endName);
		newFile = new File(sb.toString());
		for (int i = 0; i < src.length; i++) {
			File file = new File(src[i]);
			try {
				// ��ȡС�ļ���������
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
		System.out.println("�ļ��ϲ���ɣ�");
	}

}
