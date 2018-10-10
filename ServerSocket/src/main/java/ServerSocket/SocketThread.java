package ServerSocket;
 
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
 
/**
 * socket 线程类
 * 
 */
public class SocketThread extends Thread {
	private ServerSocket serverSocket = null;
 
	public SocketThread() {
		try {
			if (null == serverSocket) {
				//绑定和监听端口
				this.serverSocket = new ServerSocket(7000);
				System.out.println("ServerSocket==>服务启动[端口=7000]");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
 
	}

	//线程启动
	public void run() {
		while (!this.isInterrupted()) {
			try {
				Socket socket = serverSocket.accept();
 
				if (socket != null && !socket.isClosed()) {
					//接收socket流中数据并发送返回报文
					new receiveAndSend(socket).start();
				}
				socket.setSoTimeout(30000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	//关闭SocketServer
	public void closeSocketServer() {
		try {
			if (serverSocket != null && !serverSocket.isClosed()) {
				serverSocket.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}