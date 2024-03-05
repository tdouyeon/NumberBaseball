// Client가 입력한 값을 가지고 Strike, ball 계산
public class UserCheck
{
	// 정수 변수 strike 선언
	int strike;
	// 정수 변수 ball 선언
	int ball;
	// 정수 변수 out 선언
	int out;
	// 매개변수로 컴퓨터 값, 유저 입력 값 받아서 계산하는 메소드
	public void check(int[] com, int[] user) {
		//UserCheck 생성자로 인자로 정수형 배열 두개를 받는다.
		// TODO Auto-generated constructor stub
		//매개변수 strike 0으로 초기화
		strike = 0;
		// 매개변수 ball 0으로 초기화
		ball = 0;
		// 매개변수 out 0으로 초기화
		out = 0;

		//값 비교를 위해 for문 중첩으로 com의 배열 길이만큼 돌림
		for(int i = 0; i<3 ; i++)
		{
			for(int j = 0; j<3 ; j++)
			{
				// com의 i인덱스 값과 user의 j인덱스 값이 같으면 아래 명령어 실행
				if(com[i] == user[j])
				{
					//정수 값 i와 j가 같으면 아래 명령어 실행
					if(i==j)
						// 매개변수 strike를 1증가
						strike++;
					// 위에 조건이 아니면 실행
					else
						// 매개변수 ball을 1증가
						ball++;
				}
			}
		}
		// 만약 strike가 0이고 ball이 0이면 실행
		if(strike == 0 && ball== 0)
			//매개변수 out에 1 대입
			out = 1;
	}
	// 결과 값을 리턴하는 메소드
	public String getValue()
	{
		return strike+""+ball+""+out;
	}
}


