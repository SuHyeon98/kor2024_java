/*
    BoardService1
        - 내용과 작성자로 구성된 게시물을 최대 3개까지 저장하는 서비스 구축
        - 조건 : main 함수 1개와 변수 6개와 반복문 사용
        - 구축 : 게시물 쓰기와 글출력 기능 구현
        - 이유 : 깡통인 상태에서 구현하는 방법이 필요
*/

package day21;

import java.util.Scanner;

public class BoardService1 {

    public static void main(String[] args) { // main start - 번역된 코드를 실행하는 기능(main 스레드 포함)
        Scanner scan = new Scanner(System.in); // - 입력 객체
        // - 저장소 설계, 게시물 개당 내용과 작성자(내용 2개), 게시물 3개면 내용 6개
            // 변수 - 하나의 데이터, 주소값을 저장하는 공간, 메모리
            // 타입 - 변수의 저장될 데이터, 주소의 형태, 데이터 분류, 기본 타입(7:int~double) vs 참조타입(class, interface, Array)

        String contents1 = null; String writer1 = null; // 첫 번째 게시글 내용
        String contents2 = null; String writer2 = null; // 두 번째 게시글 내용
        String contents3 = null; String writer3 = null; // 세 번째 게시글 내용

        while ( true ) { // 무한루프
            System.out.println("1.게시물 쓰기 2. 게시물 출력 선택 : ");// 출력
            int choose = scan.nextInt(); // 입력
            if ( choose == 1 ) { // choose 가 1이면 '게시물 쓰기'
                System.out.println("새로운 게시물 내용 : "); String content = scan.next();
                System.out.println("새로운 게시물 작성자 : "); String writer = scan.next();
                // 게시물 작성할 공간이 있는지 체크, 임의로 게시물이 존재하지 않는 뜻, null(객체가 없음) 또는 ""
                if ( contents1 == null ) {
                    contents1 = content; writer1 = writer; // 입력받은 값들을 첫 번째 게시물 변수에 저장
                }
                else if ( contents2 == null ) { // 두 번째 게시물의 정보가 비어 있으면
                    contents2 = content; writer2 = writer;
                }
                else if ( contents3 == null ) { // 세 번째 게시물의 정보가 비어 있으면
                    contents3 = content; writer3 = writer;
                } else { // 위의 조건에 다 맞지 않다면
                    System.out.println("게시물 쓰기 실패 : 빈 공간이 없습니다.");
                }
            }
            if ( choose == 2 ) { // choose 가 2면 '게시물 출력'
                if (contents1 != null ) { // 만약에 첫 번째 게시물이 존재하면
                    System.out.printf("작성자 : %s, 내용 : %s ", writer1, contents1);
                }
                if (contents2 != null ) { // 만약에 두 번째 게시물이 존재하면
                    System.out.printf("작성자 : %s, 내용 : %s ", writer2, contents2);
                }
                if (contents3 != null ) { // 만약에 세 번째 게시물이 존재하면
                    System.out.printf("작성자 : %s, 내용 : %s ", writer3, contents3);
                }
            }
        } // while end

    }
} // class end
