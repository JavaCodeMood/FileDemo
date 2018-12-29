package com.lhf.file1;

import java.io.File;

public class FileMain {

	public static void main(String[] args) throws Exception {

		  //分割文件
        //FileSliptUtil.splitFileDemo(new File("F://log//nohup.out"), 2);
        
        //合并文件
        FileSliptUtil.joinFileDemo(new String[]{"F://log//nohup_data1.out", "F://log//nohup_data2.out"});

	}

}
