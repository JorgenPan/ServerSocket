package ServerSocket;
 
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
 
/**
 * socket �߳���
 * 
 */
public class SocketThread extends Thread {
	private ServerSocket serverSocket = null;
 
	public SocketThread() {
		try {
			if (null == serverSocket) {
				//�󶨺ͼ����˿�
				this.serverSocket = new ServerSocket(7000);
				System.out.println("ServerSocket==>��������[�˿�=7000]");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
 
	}

	//�߳�����
	public void run() {
		while (!this.isInterrupted()) {
			try {
				Socket socket = serverSocket.accept();
 
				if (socket != null && !socket.isClosed()) {
					//����socket�������ݲ����ͷ��ر���
					new receiveAndSend(socket).start();
				}
				socket.setSoTimeout(30000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	//�ر�SocketServer
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