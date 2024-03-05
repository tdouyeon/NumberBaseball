import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
// 부모인 Thread 상속 받음
public class ServerThread extends Thread{
	// Socket 멤버 변수 선언
	private Socket m_Socket;
	// int[] 멤버 변수 선언
	private int[] com;
	// UserCheck 멤버 변수 선언
	private UserCheck u;

	//Thread strat() 시 실행되는 메소드
	public void run() {

		try {
			// Socket을 통해 받아온 Client 데이터를 빠르고 멀티 쓰레드 환경에서 안전한
			// BufferReader를 통해 받아옴
			BufferedReader tmpbuf = new BufferedReader(new InputStreamReader(m_Socket.getInputStream()));
			// Socekt.getOutputStream 으로 받아온 데이터를 PrintWriter의 매개변수로 받음
			PrintWriter sendWriter = new PrintWriter(m_Socket.getOutputStream());

			// 문자열 변수 생성
			String receiveString;
			while(true) 
			{
				// Client가 보낸 데이터를 BufferReader에 readLine으로 읽으면
				// Client가 보낸 데이터 문자열을 한줄로 리턴해서 그 결과를 receiveString에 대입
				receiveString = tmpbuf.readLine();

				//receiveString이 null이면 실행
				if(receiveString == null)
				{
					//while문 탈출
					break;
				}
				// 위 조건이 아니면 실행
				else 
				{
					// 받은 데이터 출력
					System.out.println(receiveString);
					// 받은 문자열에 ' '을 빼서 int [] 에 대입(강제 형변환)
					int[] user = {receiveString.charAt(0)-'0', receiveString.charAt(1)-'0',
							receiveString.charAt(2)-'0'};

					// Client가 보낸 숫자와 컴퓨터가 랜덤으로 만든 숫자를 매개변수로 넣어서 Strike, ball 계산하는 메소드 호출
					u.check(user, com);
					//u.getValue() 메소드를 호출해서 해당 리턴값을 PrintWriter의 println메소드에 담아 Clinet에 보낼 준비
					// u.getValue() 리턴 값 strike+""+ball+""+out
					sendWriter.println(u.getValue());
					// Client에 데이터를 전송
					sendWriter.flush();
					
				} 
			}  
		}catch(IOException e) 
		{
			//입출력 예외처리 발생시 실행
			e.printStackTrace();
		}
		// 프로그램 종료
		System.exit(0);
	}
	// 외부에서 호출 시 Socket을 받아서맴버 변수 Socket에 대입
	public void setSocket(Socket _socket) 
	{
		m_Socket = _socket; 
	}

	// 외부에서 호출시 int[]을 받아서 내 멤버 변수 int[]에 대입
	public void setBaseballNumber(int[] _com)
	{
		this.com = _com;
	}
	// 외부에서 호출시 UserCheck를 받아서 내 멤버 변수 UserCheck에 대입
	public void setUserCheck(UserCheck _u)
	{
		this.u = _u;
	}
}
