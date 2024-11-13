/*
    - 조건 : 고정길이가 아닌 가변 길이 형식으로 100개 이상
*/

package day22;

import day22.Board;

import java.util.ArrayList;
import java.util.Scanner;

public class BoardService4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); // - 입력 객체

        Board[] boardList = null;
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

                count++; // 게시물 수 1증가
                // 최초 게시물
                Board[] newBoardList = new Board[count]; // 새로운 배열 생성
                // 새로운 배열 내 마지막 인덱스에 입력받은 게시물 객체 등록

                if (count != 1) {
                    for (int i = 0; i <= boardList.length -1; i++) {
                        newBoardList[i] = boardList[i];
                    }
                }

                newBoardList[newBoardList.length -1] = board;
                boardList = newBoardList;

            }else if ( choose == 2 ) { // choose 가 2면 '게시물 출력'
                for (int i = 0; i <= boardList.length - 1; i++) { // 0~99
                    System.out.printf("작성자 : %s, 내용 : %s \n", boardList[i].writer, boardList[i].content);
                }
            }
        } // while end
    }
}
