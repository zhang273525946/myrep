package com.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

import org.junit.Test;

public class BufferTeset {
	static File file = new File("src/main/test/com/nio/ChannelTest.java");
	public static void main(String[] args) throws Exception {
		String str = "buffer 测试使用";
//		ByteArrayInputStream bis = new ByteArrayInputStream(str.getBytes()); 
		
		FileInputStream fis = new FileInputStream(file);
		FileChannel channel = fis.getChannel();
		
		ByteBuffer buf = ByteBuffer.allocate(256);
		int r = channel.read(buf);//写入数据
		while(r!=-1){
			buf.flip();//切换 buf的读写模式  
			/**使用此方法打印时   byte 数组的声明要放在while 循环里面 如果放在外面的话  同样会出现  最后一次读取的字节长度不足 无法全部覆盖掉数组中的数据 
			 * 出现循环打印的现象**/
//			byte [] b = new byte[1024];
//			buf.get(b,0,buf.limit());
//			String x = new String(b);
//			System.out.println(x);
			/** 使用此方法时  会出现错误   重复输出信息    似乎是因为   最后一次的读取时 读取的字节长度不足 没有把缓冲区中的数据都给覆盖掉   导致打印多余的信息
			 * 但是  如果是因为这样的话   使用clear清楚缓冲区  为什么会停止打印信息  二 使用compact 却不会停止**/
//			System.out.println(new String(buf.array()));
//			while(buf.hasRemaining()){
//				System.out.println(Charset.defaultCharset().decode(buf));
//			}
//			buf.compact();
			buf.clear();
			r = channel.read(buf);
		}
		channel.close();
		fis.close();
	}
	
	
	
	/**
	 * @throws IOException
	 * 测试  byte数组不够大时  是否会存在 main 方法中的情况 
	 */
	@Test
	public void testArrayByteReflush() throws IOException{
		FileInputStream fis = new FileInputStream(file);
		byte [] buf = new byte[526];
		StringBuilder sb = new StringBuilder();
		while((fis.read(buf))!=-1){
			String str = new String (buf);
//			System.out.println(str);
			sb.append(str);
		}
		System.out.println(sb.toString());
	}
}
