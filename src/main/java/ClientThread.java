import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.*;

public class ClientThread extends JFrame implements ActionListener, Runnable{
	// Server와 연결된 소켓 연결을 위한 멤버 변수 선언
	private Socket m_Socket;
	// 화면 구현을 위한 멤버 변수 선언
	MyPanel p;
	// 텍스트 입력 필드 생성을 위한 멤버 변수 선언
	JTextField jt;
	// 버튼 생성을 위한 멤버 변수 선언
	JButton jb;

	//ClientThread 생성자
	public ClientThread(){
		//Container에 content 영역 가져오는 메소드 호출하여 대입
		Container c = getContentPane();
		// MyPanel() 객체 생성해서 변수 p에 대입
		p = new MyPanel();
		// 텍스트 입력 필드 가로 길이 15로 설정해서 변수 jt에 대입
		jt = new JTextField(15);
		//MyPanel 객체에 텍스트 입력 필드 추가
		p.add(jt);
		// 입력이라고 적힌 버튼 생성해서 변수 jb에 대입
		jb = new JButton("입력");
		// jb 버튼이 눌리면 actionPerformed() 메소드 실행할 수 있도록 jb 매개변수로 대입
		jb.addActionListener(this);
		//JButton의 setFont 함수 호출해서 Font 객체 생성자로 폰트 설정
		jb.setFont(new Font("맑음고딕",Font.BOLD,18));
		// MyPanel에 jb 버튼 추가
		p.add(jb);
		// Container에 MyPanel 추가
		c.add(p);
		//화면 사이즈 x : 437 y: 296 설정
		setSize(437,296);
		// 사용자가 창 크기 변경하지 못하도록 세팅
		setResizable(false);
		// 화면이 보이게 설정
		setVisible(true);
		//창 종료 시 프로세스까지 종료되게 설정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	// Server에게 결과 값을 받아서 화면 다시 그리는 메소드
	public void run() {

		try {

			// Socket을 통해 받아온 Server 데이터를 빠르고 멀티 쓰레드 환경에서 안전한
			// BufferReader를 통해 받아옴
			BufferedReader tmpbuf = new BufferedReader(
					new InputStreamReader(m_Socket.getInputStream())); 

			// 받은 데이터를 담기위한 문자열 생성
			String receiveString;
			// 무한 반복
			while(true) 
			{
				//서버에서 받은 결과 값 String receiveString 변수에 대입
				receiveString = tmpbuf.readLine();

				// receiveString이 null 이면 실행
				if(receiveString == null)
				{
					// while문 탈출
					break;
				}
				//receiveString이 null이 아니면 실행
				else
				{
					// 서버에서 받은 결과값 데이터 출력
					System.out.println(receiveString);
					// MyPanel에 결과값 데이터를 숫자로 강제 형변환해서 넣어줌
					p.setData(receiveString.charAt(0)-'0', receiveString.charAt(1)-'0',
							receiveString.charAt(2)-'0');
					// 결과 값에 따른 화면 재생성
					p.repaint();
				} 
			}  
		}catch(IOException e) 
		{  
			e.printStackTrace();
		}
		System.exit(0);
	}
	// 외부로부터 소켓을 받아서 멤버변수 m_socket에 대입하기 위한 메소드
	public void setSocket(Socket _socket)
	{
		m_Socket = _socket;
	}

	// jb 버튼이 클릭되면 호출되는 서버에 데이터 전송하는 기능을 가진 메소드
	public void actionPerformed(ActionEvent e) {
		//PrintWriter 객체 선언
		PrintWriter sendWriter = null;
		try {
			// Socket.getOutputStream을 매개변수로 받아 서버에 데이터를 보내기 위한 PrintWriter 객체 생성
			sendWriter = new PrintWriter(m_Socket.getOutputStream());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			//입출력 예외처리 발생시 실행
			e1.printStackTrace();
		}
		//텍스트 입력 필드에 있는 문자열 가져와서 해당 문자열을 println으로 보낼 준비
		sendWriter.println(jt.getText());
		// 버퍼를 강제로 비워 서버로 데이터 보냄
		sendWriter.flush();
	}
}
