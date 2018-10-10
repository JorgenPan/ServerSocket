package ServerSocket;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 创建监听器 web项目一开始便启动
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
			// 新建线程类
			socketThread = new SocketThread();
			// 启动线程
			socketThread.start();
		}
	}

	
}
