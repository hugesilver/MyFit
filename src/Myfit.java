import java.io.IOException;
import java.util.Scanner;

public class Myfit {
    public static void main(String[] args){
        // Scanner 호출
        Scanner sc = new Scanner(System.in);

        // 체형 정보 생성
        Body 자신 = new Body("남자", 70, 100, 45, 34);
        Body 여자친구 = new Body("여자", 58, 90, 39, 28);
        MakeBody makebody;

        System.out.print("보고 싶은 체형 정보를 입력하세요(등록됨: 자신, 여자친구) >> ");
        String who = sc.nextLine();


        System.out.println();
        System.out.println("[현재 " + who + "의 기본 신체 정보를 이렇게 되어있습니다]");

        String change = "";
        String what = "";

        if(who.equals("자신")){
            System.out.println("성별: " + 자신.gender);
            System.out.println("상체 길이: " + 자신.topheight);
            System.out.println("하체 길이: " + 자신.bottomheight);
            System.out.println("어깨 너비: " + 자신.shoulderwidth);
            System.out.println("허리 둘레: " + 자신.waistline);
            System.out.println();
            System.out.print("신체 정보를 변경하시겠습니까?(원한다면: 변경) >> ");

            change = sc.nextLine();
            if(change.equals("변경")){
                System.out.print("변경할 성별(현재: " + 자신.gender + ") >> ");
                자신.gender = sc.nextLine();
                System.out.print("변경할 상체 길이(현재: " + 자신.topheight + ") >> ");
                자신.topheight = sc.nextInt();
                System.out.print("변경할 하체 길이(현재: " + 자신.bottomheight + ") >> ");
                자신.bottomheight = sc.nextInt();
                System.out.print("변경할 어깨 너비(현재: " + 자신.shoulderwidth + ") >> ");
                자신.shoulderwidth = sc.nextInt();
                System.out.print("변경할 허리 둘레(현재: " + 자신.waistline + ") >> ");
                자신.waistline = sc.nextInt();
                System.out.println();
                System.out.println("[변경된 신체 정보]");
                System.out.println("상체 길이: " + 자신.topheight);
                System.out.println("하체 길이: " + 자신.bottomheight);
                System.out.println("어깨 너비: " + 자신.shoulderwidth);
                System.out.println("허리 둘레: " + 자신.waistline);
            }
            System.out.println();
            System.out.println("착용하실 상품을 입력하세요.");
            System.out.print("(나이키001, 아디다스001) >> ");
            what = sc.next();

            try{
                MakeBody makeBody = new MakeBody(자신.gender, 자신.topheight, 자신.bottomheight, 자신.shoulderwidth, 자신.waistline, what);
            }
            catch(IOException e){
                // 이게 왜 작동하지...?
            }
        }
        else if(who.equals("여자친구")){
            System.out.println("상체 길이: " + 여자친구.topheight);
            System.out.println("하체 길이: " + 여자친구.bottomheight);
            System.out.println("어깨 너비: " + 여자친구.shoulderwidth);
            System.out.println("허리 둘레: " + 여자친구.waistline);
            System.out.println();
            System.out.print("신체 정보를 변경하시겠습니까?(원한다면: 변경) >> ");

            change = sc.nextLine();
            if(change.equals("변경")){
                System.out.print("변경할 상체 길이(현재: " + 여자친구.topheight + ") >> ");
                여자친구.topheight = sc.nextInt();
                System.out.print("변경할 하체 길이(현재: " + 여자친구.bottomheight + ") >> ");
                여자친구.bottomheight = sc.nextInt();
                System.out.print("변경할 어깨 너비(현재: " + 여자친구.shoulderwidth + ") >> ");
                여자친구.shoulderwidth = sc.nextInt();
                System.out.print("변경할 허리 둘레(현재: " + 여자친구.waistline + ") >> ");
                여자친구.waistline = sc.nextInt();
                System.out.println();
                System.out.println("[변경된 신체 정보]");
                System.out.println("상체 길이: " + 여자친구.topheight);
                System.out.println("하체 길이: " + 여자친구.bottomheight);
                System.out.println("어깨 너비: " + 여자친구.shoulderwidth);
                System.out.println("허리 둘레: " + 여자친구.waistline);
            }
            System.out.println();
            System.out.println("착용하실 상품을 입력하세요.");
            System.out.print("(나이키001, 아디다스001) >> ");
            what = sc.next();

            try{
                MakeBody makeBody = new MakeBody(여자친구.gender, 여자친구.topheight, 여자친구.bottomheight, 여자친구.shoulderwidth, 여자친구.waistline, what);
            }
            catch(IOException e){
            }
        }
        else{
            System.out.println();
            System.out.println("맞는 정보가 없습니다.");
        }
    }
}
