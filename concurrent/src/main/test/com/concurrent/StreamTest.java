package com.concurrent;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PushbackInputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Scanner;
import java.util.Set;

import org.junit.Test;

public class StreamTest {
	
	static String filePath = "D:"+File.separatorChar+"1.dat";
	
	@Test
	public void testPushBackInputStream() throws IOException{
		PushbackInputStream pis = new PushbackInputStream(new DataInputStream(new BufferedInputStream(new FileInputStream(new File(filePath)))));
		System.out.println(pis.available());
		
		//预读下一个字节  
		System.out.println(pis.read());
	}
	
	@Test
	public void testScannerNextint(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("----开始数据吧----");
		System.out.println(scanner.nextInt());
	}
	
	@Test
	public void charSetTest(){
		String str = "字符集测试";
		
		Charset cset = Charset.forName("UTF-8");
		
		Set<String> aliases = cset.aliases();//别名
		System.out.println("aliases : "+aliases);
		str.getBytes();
		
		ByteBuffer bytebuf = cset.encode(str);
		byte[] bytes = bytebuf.array();
		
	}
}
