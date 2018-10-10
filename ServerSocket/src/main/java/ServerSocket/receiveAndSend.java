package ServerSocket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
 
/**
 * 多线程处理socket接收的数据
 * 
 */
public class receiveAndSend extends Thread {
	private Socket socket;
 
	public receiveAndSend(Socket socket) {
		this.socket = socket;
	}
 
	/**
	 * 读取客户端发送的信息  1、字节数组接收 2.字符数组接收
	 */
	public void run() {
		try {
			System.out.println("scoket创建成功");
			InputStream in = socket.getInputStream();
			OutputStream out = socket.getOutputStream();
 
			//字节数组接收
			
			
			//字符数组接收
			
			
			System.out.println("客户端请求报文：");
 
			socket.close();
			System.out.println("socket关闭");
 
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}