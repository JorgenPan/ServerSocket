package ServerSocket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
 
/**
 * ���̴߳���socket���յ�����
 * 
 */
public class receiveAndSend extends Thread {
	private Socket socket;
 
	public receiveAndSend(Socket socket) {
		this.socket = socket;
	}
 
	/**
	 * ��ȡ�ͻ��˷��͵���Ϣ  1���ֽ�������� 2.�ַ��������
	 */
	public void run() {
		try {
			System.out.println("scoket�����ɹ�");
			InputStream in = socket.getInputStream();
			OutputStream out = socket.getOutputStream();
 
			//�ֽ��������
			
			
			//�ַ��������
			
			
			System.out.println("�ͻ��������ģ�");
 
			socket.close();
			System.out.println("socket�ر�");
 
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}