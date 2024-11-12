/*
    BoardService2
        - 내용과 작성자로 구성된 게시물을 최대 100개까지 저장하는 서비스 구축
        - 조건 : main 함수 1개와 배열(최대 2개)
        - 구축 : 게시물 쓰기와 글출력 기능 구현
*/

package day21;

import java.util.Scanner;

public class BoardService2 {
    public static void main(String[] args) {
        // 배열 변수를 사용하는 이유 : 여러 개의 변수 데이터를 배열로 사용하면 관리가 편함
        // 배열이란 - 여러 개의 동일한 타입(String, int, boolean...)의 데이터들을 하나의 변수에 저장할 수 있는 타입
        // 인덱스란 - 배열 내 저장된 데이터들의 저장 순서 번호 0번부터 최대길이
            // 반복문 활용 : 시작값부터 끝값까지 반복
        String[] content = new String[100];
        String[] writer = new String[100];

        Scanner scan = new Scanner(System.in); // - 입력 객체

        while ( true ) {
            System.out.println("1.게시물 쓰기 2. 게시물 출력 선택 : ");// 출력
            int choose = scan.nextInt(); // 입력
            if ( choose == 1 ) { // choose 가 1이면 '게시물 쓰기'
                System.out.println("새로운 게시물 제목 : "); String con = scan.next();
                System.out.println("새로운 게시물 작성자 : "); String wt = scan.next();
                // 게시물이 100개면 if 100개를 사용하는가?
                // 인덱스 0부터 99까지 1씩 증가
                    // switch 변수
                boolean save = false; // false 해서 저장 실패 했다는 뜻
                for (int i = 0; i <= content.length -1; i++) {
                    if ( content[i] == null ) { // 만약에 i 게시물이 null 이라면
                        content[i] = con; writer[i] = wt; // 비어있는 게시물의 입력받은 내용을 저장
                        save = true; // 저장 성공하면 save 변수에 true 값으로 변경
                        break; // 만약에 저장을 했으면 1개 저장해야 하므로 break 해 반복문 종료
                    }
                }
                // for 종료 후 save 변수값이 true 성공, false 출력
                if ( !save ) { System.out.println("비어있는 자리가 없습니다."); }
                else { System.out.println("게시물 쓰기 성공"); }
            }
            if ( choose == 2 ) { // choose 가 2면 '게시물 출력'
                for (int i = 0; i <= content.length - 1; i++) { // 0~99
                    if ( content[i] != null ) { // i번째 게시물이 존재하면
                        System.out.printf("작성자 : %s, 내용 : %s ", writer[i], content[i]);
                    }
                }
            }
        } // while end
    }
}
