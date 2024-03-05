import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.*;

// 클라이언트 GUI 만드는 클래스
public class MyPanel extends JPanel{

   //정수형 strike 변수를 0으로 초기화
   int strike = 0;
   //정수형 ball 변수를 0으로 초기화
   int ball = 0;
   //정수형 out 변수를 false로 초기화
   int out = 0;

   // 배경 이미지를 담기 위한 ImageIcon 객체 변수 선언
   ImageIcon background;


   //Server로 부터 받은 데이터를 멤버변수에 세팅하기 위한 메소드
   void setData(int strike, int ball, int out)
   {
      this.strike = strike;
      this.ball = ball;
      this.out = out;
   }
  
   // 화면 구현
   @Override
   //JComponent를 오버라이딩해서 새로운 컴포넌트 설계
   // Graphics 매개변수로 설정하여 화면이 그려져야 하는 상황에 호출되는 메소드
   public void paintComponent(Graphics g){
      // ImageIcon 객체 생성해서 이미지를 변수 background에 대입
      background = new ImageIcon("/Users/isuyeon/IdeaProjects/portfolio/img/baseball.png");
      //이미지를 그래픽에 추가
      g.drawImage(background.getImage(),0,0,null);


      //폰트 세팅
      g.setFont(new Font("맑음고딕",Font.BOLD,20));
      // 그래픽 색 white 설정
      g.setColor(Color.white);
      // 사각형 그리기
      g.drawRect(25,130,150,125);
      // 사각형 채우기 -> 위에 설정한 white 색으로 칠해짐
      g.fillRect(25,130,150,125);

      //strike의 값이 3이면 실행
      if(strike == 3)
      {
         //색 검정으로 설정
         g.setColor(Color.BLACK);
         // 폰트 세팅
         g.setFont(new Font("배달의민족 한나는 열한살",Font.BOLD,50));
         // 문자를 설정한 위치에 그림
         g.drawString("홈런", 170, 180);
      }
     //strike의 값이 3이 아닐 경우 실행
      else
      {
         // strike 값이 0일 경우 실행
         if(strike == 0)
         {
            //색 블루로 설정
            g.setColor(Color.blue);
            // 문자를 해당 위치에 그림
            g.drawString("S", 30, 162);
            // 안이 비어있는 원을 위에 지정한 색으로 해당 위치에 그림
            g.drawOval(50,140,30,30);
            // 안이 비어있는 원을 위에 지정한 색으로 해당 위치에 그림
            g.drawOval(90,140,30,30);
         }

         //strike가 1이면 실행
         else if(strike == 1)
         {
            //색 블루로 설정
            g.setColor(Color.blue);
            // 문자를 해당 위치에 그림
            g.drawString("S", 30, 162);
            // 위에 지정한 색으로 채워진 원을 해당 위치에 그림
            g.fillOval(50,140,30,30);
            // 안이 비어있는 원을 위에 지정한 색으로 해당 위치에 그림
            g.drawOval(90,140,30,30);
         }
         //위의 두조건이 모두 아니면(strike ==2) 아래 명령어 실행
         else
         {
            //색 블루로 설정
            g.setColor(Color.blue);
            // 문자를 해당 위치에 그림
            g.drawString("S", 30, 162);
            // 위에 지정한 색으로 채워진 원을 해당 위치에 그림
            g.fillOval(50,140,30,30);
            // 위에 지정한 색으로 채워진 원을 해당 위치에 그림
            g.fillOval(90,140,30,30);
         }

         // ball이 0일 경우 실행
         if(ball == 0)
         {
            // 색 오렌지로 지정
            g.setColor(Color.ORANGE);
            // 문자를 해당 위치에 그림
            g.drawString("B", 30, 202);
            //위에 지정한 색으로 채워진 원을 해당 위치에 그림
            g.drawOval(50,180,30,30);
            //위에 지정한 색으로 채워진 원을 해당 위치에 그림
            g.drawOval(90,180,30,30);
            //위에 지정한 색으로 채워진 원을 해당 위치에 그림
            g.drawOval(130,180,30,30);
         }
         // ball 이 1일 경우 실행
         else if(ball == 1)
         {
            // 색 오렌지로 지정
            g.setColor(Color.ORANGE);
            // 문자를 해당 위치에 그림
            g.drawString("B", 30, 202);
            //위에 지정한 색으로 채워진 원을 해당 위치에 그림
            g.fillOval(50,180,30,30);
            // 안이 비어있는 원을 위에 지정한 색으로 해당 위치에 그림
            g.drawOval(90,180,30,30);
            // 안이 비어있는 원을 위에 지정한 색으로 해당 위치에 그림
            g.drawOval(130,180,30,30);
         }
         //ball이 2면 실행
         else if(ball == 2)
         {
            // 색 오렌지로 지정
            g.setColor(Color.ORANGE);
            // 문자를 해당 위치에 그림
            g.drawString("B", 30, 202);
            //위에 지정한 색으로 채워진 원을 해당 위치에 그림
            g.fillOval(50,180,30,30);
            //위에 지정한 색으로 채워진 원을 해당 위치에 그림
            g.fillOval(90,180,30,30);
            // 안이 비어있는 원을 위에 지정한 색으로 해당 위치에 그림
            g.drawOval(130,180,30,30);
         }
         //ball이 3이면 실행
         else
         {
            // 색 오렌지로 지정
            g.setColor(Color.ORANGE);
            // 문자를 해당 위치에 그림
            g.drawString("B", 30, 202);
            //위에 지정한 색으로 채워진 원을 해당 위치에 그림
            g.fillOval(50,180,30,30);
            //위에 지정한 색으로 채워진 원을 해당 위치에 그림
            g.fillOval(90,180,30,30);
            //위에 지정한 색으로 채워진 원을 해당 위치에 그림
            g.fillOval(130,180,30,30);
         }
         //out이 0이면 실행
         if(out == 0)
         {
            // 색 레드로 지정
            g.setColor(Color.red);
            // 문자를 해당 위치에 그림
            g.drawString("O", 30, 242);
            // 안이 비어있는 원을 위에 지정한 색으로 해당 위치에 그림
            g.drawOval(50,220,30,30);
         }
         //out이 0이 아니면 실행(out==1)
         else
         {
            // 색 레드로 지정
            g.setColor(Color.red);
            // 문자를 해당 위치에 그림
            g.drawString("O", 30, 242);
            //위에 지정한 색으로 채워진 원을 해당 위치에 그림
            g.fillOval(50,220,30,30);
         }
      }
   }
}


