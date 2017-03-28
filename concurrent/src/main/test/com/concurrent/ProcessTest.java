package com.concurrent;

import java.util.Scanner;

import org.junit.Test;

public class ProcessTest {
	public static void main(String[] args) throws Exception {
		//创建进程调用cmd  打印返回信息
		ProcessBuilder builder = new ProcessBuilder("cmd ","/c ","ipconfig/all");
		System.out.println(builder.directory());
		System.out.println(builder.environment());
		Process process = builder.start();
		printProcessInputStream(process);
	}
	
	@Test
	public void runTimeProcessTest() throws Exception{
		String cmd = "cmd "+"/c "+"ipconfig/all";
		Process pro = Runtime.getRuntime().exec(cmd);
		printProcessInputStream(pro);
	}
	
	static void printProcessInputStream(Process process){
		Scanner scanner = new Scanner(process.getInputStream(),"gbk");
		System.out.println("----------------------------");
		while(scanner.hasNextLine()){
	         System.out.println(scanner.nextLine());
	    }
	    scanner.close();
	}
}
