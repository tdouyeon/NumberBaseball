import java.io.IOException;
import java.net.Socket;

public class MainClient{
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			// Socket 객체를 생성하는 ip와 포트번호를 대입
			Socket c_socket = new Socket("172.20.10.5", 8102);
			// ClientThread 객체를 생성, 생성될 때 GUI 그려짐(생성자)
			ClientThread clientThread = new ClientThread();
			// c_socket을 ClientThread 안에 있는 m_socket 멤버 변수에 넣어줌
			clientThread.setSocket(c_socket);
			//runalbe을 상속 받은 ClientThread를 매개변수로 하여 쓰레드 생성
			Thread t = new Thread(clientThread);
			// 쓰레드 시작
			t.start();
		} 
		catch(IOException e) 
		{
			//입출력 예외처리 발생시 실행
			e.printStackTrace();
		}
	}
}