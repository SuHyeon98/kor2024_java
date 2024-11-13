/*
      내용[String타입] 과 작성자[String타입] 과 비밀번호[int타입] 로 구성된 게시물 클래스를 설계
      - 게시물 객체 최대 100개 까지 저장하는 서비스 구축
          - 조건 : main함수 1개 와 배열은 최대1까지 사용 하여 구현
          - 구축 : 게시물 쓰기 와 게시물 출력 기능 구현

      타입 : 데이터 형태를 분류
            - 대분류 :
                - 기본 타입(byte, short, int, long, float, double, char, boolean)
                - 참조 타입( []배열, class, interface, 열거 )
      클래스 : 멤버변수(필드), 생성자, 메소드(멤버함수)로 구성된 새로운 타입 만들기
      객체 : 하나의 자료(여러개 자료들의 주소값)를 저장하는 메모리 공간 (JVM 힙영역)
      변수 : 하나의 자료(실제값, 주소값)를 저장하는 메모리 공간(JVM 스택영역)
*/

package day22;

import java.util.Scanner;

public class BoardService3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); // - 입력 객체
        Board[] boardList = new Board[100];// Board 객체 100개를 저장할 수 있는 배열 선언

        while ( true ) {
            System.out.println("1.게시물 쓰기 2. 게시물 출력 : ");
            int choose = scan.nextInt();
            if ( choose == 1 ) {
                // 사용자로 저장할 데이터 입력

                // nextLine() 사용 시 주의 : .nextLine() 앞에 다른 .next가 존재하면
                // 1. 의미 없는 .nextLine()을 작성한다
                scan.nextLine();
                System.out.println("내용 : "); String content = scan.nextLine();
                System.out.println("작성자 : "); String writer = scan.next();
                System.out.println("비밀번호 : "); int pwd = scan.nextInt();
                // .next() 문자열 입력, .nextLine() 문자열(공백/띄어쓰기 포함)

                boolean save = false; // false 해서 저장 실패 했다는 뜻
                for (int i = 0; i <= boardList.length -1; i++) {
                    if ( boardList[i] == null ) { // 만약에 i 게시물이 null 이라면
                        Board board = new Board(); // 게시물 객체 생성
                        // 생성된 게시물 객체 내 입력받은 값들을 대입
                        board.content = content; board.writer = writer; board.pwd = pwd;
                        // 배열 내 i 번째 위치에 생성한 객체를 저장/대입
                        boardList[i] = board;
                        break;
                    }
                }
            }
            if ( choose == 2 ) { // choose 가 2면 '게시물 출력'
                for (int i = 0; i <= boardList.length - 1; i++) { // 0~99
                    if ( boardList[i] != null ) { // i번째 게시물이 존재하면
                        System.out.printf("작성자 : %s, 내용 : %s \n", boardList[i].writer, boardList[i].content);
                    }
                }
            }
        } // while end
    }
}
