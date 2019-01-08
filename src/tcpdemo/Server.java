package tcpdemo;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 1、 创建服务器，指定端口 ServerSocket(int port) 2、接收客户端连接 阻塞式 3、发送数据+接收数据
 * 
 * @author Administrator
 *
 */

public class Server {
	public static void main(String[] args) {
		while (true) {
			try {
				// 1、 创建服务器，指定端口 ServerSocket(int port)
				ServerSocket server = new ServerSocket(8888);
				// 2、接收客户端连接 阻塞式
				Socket client = server.accept();

				// 输入流,写出数据
				DataInputStream dis = new DataInputStream(client.getInputStream());
				DataOutputStream dos = new DataOutputStream(client.getOutputStream());

				while (true) {
					String msg = dis.readUTF();
					System.out.println(msg);

					// 输出流

					dos.writeUTF("服务器---》" + msg);
					dos.flush();
				}
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
	}

}
