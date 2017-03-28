package com.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import org.junit.Test;

public class ChannelTest {
	static FileChannel inChannel ;
	static {
		 try {
			 FileInputStream fis = new FileInputStream(BufferTeset.file);
			 inChannel = fis.getChannel();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void fileChannelTest() throws Exception{
		File file = new File("D:\\channelTest.txt");
		FileOutputStream fos = new FileOutputStream(file);
		
		FileChannel channel = fos.getChannel();
		ByteBuffer buf = ByteBuffer.allocate(1024);
		String str = "通道测试";
		buf.put(str.getBytes());
		
		buf.flip();//必须调用此方法  否则无法写入内容
		
		channel.write(buf);
		channel.close();
		fos.close();
	}
	
	/**
	 * channel 分散读取  ,只有在buf1 填充完成后 才会向buf2填充数据
	 * @throws IOException 
	 */
	@Test
	public void channelScatter() throws IOException{
		ByteBuffer buf1 = ByteBuffer.allocate(256);
		ByteBuffer buf2 = ByteBuffer.allocate(256);
		ByteBuffer [] bufs = new ByteBuffer[]{buf1,buf2};
		
		inChannel.read(bufs);
		System.out.println(new String(buf1.array()));
		System.out.println(new String(buf2.array()));
	}
}
