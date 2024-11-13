/*
    - 수정 조건 : 가변 길이 대신 ArrayList 컬렉션 프레임으로 수정
    - ArrayList
        .add() : 리스트 내 지정한 객체 저장
        .get() : 리스트 내 지정한 인덱스에 객체 반환
        .size() : 리스트 내 저장한 총 객체 수 반환
        .remove() : 리스트 내 지정한 객체 삭제
*/

package day22;

import java.util.ArrayList;
import java.util.Scanner;

public class BoardService5 {
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
