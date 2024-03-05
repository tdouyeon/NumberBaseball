//서버
public class RCom
{
   // 정수 배열 멤버변수 선언
   int com[];
   //Rcom 생성자(Rcom 객체가 만들어질 때 실행)
   public RCom() {
      // TODO Auto-generated constructor stub
      // com 멤버변수에 정수형 배열 3 생성 후에 대입
      com = new int[3];

      // 랜덤 값 3개 생성해서 com 멤버 변수에 넣어줌
      for(int i=0;i<com.length;i++){
         com[i] =(int)(Math.random()*9+1);
         if(i>0){
            for(int j=0;j<com.length;j++){
               if(i>j){
                 if(com[i]==com[j]) {
                    i--;
                    break;
                 }
               }
            }
         }
      }
   }
   //멤버변수 com을 리턴하는 메소드
   public int[] getCom()
   {
      return com;
   }
}


