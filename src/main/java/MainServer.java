import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MainServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 컴퓨터 난수를 생성하는 객체 생성
		RCom r = new RCom();
		// Client 값이 들어오면 Strike ball out을 계산하는 객체 생성
		UserCheck u = new UserCheck();
		// 컴퓨터 랜덤값 3개 출력
		System.out.println(r.com[0]+","+r.com[1]+","+r.com[2]);
		try
		{
			//ServerSocket 객체 생성 port 번호는 8102
			ServerSocket s_socket = new ServerSocket(8102);
			//SeverSocket으로 Client 연결 대기 중
			Socket c_socket = s_socket.accept();
			// Client와 소켓 연결되면 실행
			// ServerThread 쓰레드 객체 생성
			ServerThread serverthread = new ServerThread();
			// ServerThread 멤벼변수인 m_Socket에 c_socket 대입
			serverthread.setSocket(c_socket);
			// ServerThread의 멤버변수인 BaseballƒNumber에 RCom에 있는 com int[] 값 대입
			serverthread.setBaseballNumber(r.com);
			// ServerThread의 멤버변수인 UserCheck 에 UserCheck 객체를 대입
			serverthread.setUserCheck(u);

			// ServerEndThread 객체를 생성
			ServerEndThread endthread = new ServerEndThread();
			// ServerEndThread 멤버변수 Socket에 c_socket 대입
			endthread.setSocket(c_socket);
			// ServerThread 시작
			serverthread.start();
			// ServerEndThread 시작
			endthread.start();
		}
		catch(IOException e)
		{
			//입출력 예외처리 발생시 실행
			e.printStackTrace();
		}
	}
}