/*
    - 추가 조건 : NewBoard 클래스 객체들을 캡슐화
        1. NewBoard는 Board와 동일한 게시물
        2. NewBoard 모든 필드는 private으로 선언
        3. 외부에서 객체 생성 시 생성자 사용
        4. getter(필드값 호출 함수), setter(필드값 대입 함수), toString(객체 정보 함수) 이용해 모든 필드 데이터 간접 접근

    public : 공개용, 모든 클래스/패키지 내에서 접근 가능
    private : 비공개용, 현재 클래스 내에서 접근 가능
        - 이유 : 객체의 자료는 중요하기 때문에 쉽게 저장/변경하면 안됨
        - 객체를 통해 필드 직접 접근을 차단하고 간접 접근을 이용한 유효성 검사를 시행
    protected : 동일한 패키지 내에서 접근 가능, 상속관계면 다른 패키지에서 접근 가능
    (default) : 동일한 패키지 내에서 접근 가능, 위에서 3가지를 작성하지 않으면 기본적으로 적용되는 제한자

*/

package day22;

import java.util.ArrayList;
import java.util.Scanner;

public class BoardService6 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); // - 입력 객체
        ArrayList<Board> BoardList = new ArrayList<>();
        // 제네릭 타입 : 리스트 객체에 저장할 여러 개 객체들의 타입

        int count = 0;
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

                Board board = new Board();
                board.content = content; board.writer = writer; board.pwd = pwd;

                BoardList.add(board);

            }else if ( choose == 2 ) { // choose 가 2면 '게시물 출력'
                for (int i = 0; i <= BoardList.size() - 1; i++) { // 0~99
                    System.out.printf("작성자 : %s, 내용 : %s \n", BoardList.get(i).writer, BoardList.get(i).content);
                }
            }
        } // while end
    }
}
