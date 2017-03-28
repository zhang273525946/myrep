package com.nio;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Set;

import javax.print.attribute.standard.Severity;

import org.junit.Test;

public class SelectorSocketServer {
	@SuppressWarnings("static-access")
	public static void main(String[] args) throws IOException, InterruptedException {
		ServerSocketChannel socketchannel = ServerSocketChannel.open();
		SocketAddress addr = new InetSocketAddress("127.0.0.1", 8765);
		socketchannel.socket().bind(addr);
		socketchannel.configureBlocking(false);
		while(true){
			SocketChannel channel = socketchannel.accept();
			Thread.sleep(1000);
			if(channel==null){
				System.out.println("null serverSocketChannel!");
				continue;
			}
			ByteBuffer buf = ByteBuffer.allocate(1024);
			buf.wrap("你来啦".getBytes());
			channel.write(buf);
			channel.close();
		}
		
		
	}
	
	@Test
	public void selectorTest() throws IOException{
		Selector selector = Selector.open();
		Set<SelectionKey> keys = selector.selectedKeys();
		for (SelectionKey key : keys) {
			System.out.println(key);
		}
	}
	
	@Test
	public void serverSocketTest() throws IOException{
		ServerSocket server = new ServerSocket(8765);
		Socket socket = server.accept();
		System.out.println(socket);
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		writer.write("你来啦");
		writer.close();
	}
}
