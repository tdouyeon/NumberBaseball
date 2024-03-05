import java.io.*;
import java.net.*;

public class ServerEndThread extends Thread {
	//Socket 멤버변수
	private Socket m_Socket;
	public void run() {
		// 부모 thread 에 run 메소드 호출
		super.run();
		try {
			// BufferedReader 객체 생성해서 키보드 입력 받음 ( Scanner 보다 안정성이 뛰어남)
			BufferedReader tmpbuf = new BufferedReader(
					new InputStreamReader(System.in));

			while(true)
			{
				// 키보드 입력 받은 값을 sendString에 대입
				String sendString = tmpbuf.readLine();
				// 콘솔창에 출력
				System.out.println("나 :"+sendString);
				// 키보드 입력값이 quit이면 실행
				if(sendString.equals("quit"))
				{
					// 프로그램 종료 출력
					System.out.println("프로그램을 종료합니다.");
					//while문 나감
					break;	

				}
			}
			// 소켓을 닫는다.
			m_Socket.close();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		// 프로그램 종료
		System.exit(0);
	}
	// 외부로부터 소켓을 받아서 멤버변수 m_socket에 대입하기 위한 메소드
	public void setSocket(Socket _socket)
	{
		m_Socket = _socket;
	}
}