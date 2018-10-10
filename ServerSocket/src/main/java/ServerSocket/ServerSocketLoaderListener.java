package ServerSocket;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * ���������� web��Ŀһ��ʼ������
 * @author JorgenPan
 */
public class ServerSocketLoaderListener implements ServletContextListener {

	private SocketThread socketThread;
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		if (null != socketThread && !socketThread.isInterrupted()) {
			socketThread.closeSocketServer();
			socketThread.interrupt();
		}
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		if (null == socketThread) {
			// �½��߳���
			socketThread = new SocketThread();
			// �����߳�
			socketThread.start();
		}
	}

	
}
