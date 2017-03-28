package com.nio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

import org.junit.Test;

public class SelectorTest {

	public static void main(String[] args) throws Exception, IOException {
		Socket socket = new Socket("127.0.0.1", 8765);
		SocketChannel channel = null;
		while(true){
			Thread.sleep(1000);
			channel = socket.getChannel();
			if(channel!=null){
				break;
			}
			System.out.println("socket null channle");
		}
		ByteBuffer buf = ByteBuffer.allocate(1024);
		channel.read(buf);
		System.out.println(buf.toString());
		
	}

	
	@Test
	public void testSocket() throws UnknownHostException, IOException{
		Socket socket = new Socket("127.0.0.1", 8765);
		System.out.println(socket.getLocalPort());
		InputStream inputStream = socket.getInputStream();
		System.out.println(inputStream.available());
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		while(reader.readLine()!=null){
			System.out.println(reader.readLine());
		}
		
	}
}
