package com.javaex.project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdminApp {

    public static void main(String[] args) {

        AdminDao admindao = new AdminDao();
        Scanner sc = new Scanner(System.in);

        while(true) {

            System.out.println("==========================================================================");
            System.out.println("1. 전직원 리스트 보기     2.부서명 수정    3. 부서 추가  4.  부서 삭제   5.검색  6. 이전으로");
            System.out.println("==========================================================================");

            int menuNo = sc.nextInt();
            sc.nextLine(); // 개행 문자 소비

            if (menuNo == 1) {

                List<UserVo> userList = admindao.selectEmployeesAll();

                for (UserVo user : userList) {
                    System.out.println(user.toString());
                }

            } else if (menuNo == 2) {
                System.out.println("=============================================");
                System.out.println("* 현 부서명을 입력해주세요");
                System.out.print("> 입력: ");
                String currentDept = sc.nextLine();
                System.out.println("* 바뀔 부서명을 입력해주세요");
                System.out.print("> 입력: ");
                String newDept = sc.nextLine();
                System.out.print("* 현 매니저 번호를 입력하세요 ");
                System.out.print("> 입력: ");
                int manum = sc.nextInt();
                System.out.println("* 바뀔 매니저 번호를 입력하세요 ");
                System.out.println(">입력: ");
                int nManum = sc.nextInt(); 
                sc.nextLine(); // 개행 문자 소비
                admindao.updateDepartment(currentDept, manum, newDept,nManum);

            } else if (menuNo == 3) {
                System.out.println("================================");
                System.out.println("* 추가할 부서명을 입력하세요: ");
                System.out.print("> 입력: ");
                String deNum = sc.nextLine();
                System.out.println("* 추가할 매니저 번호를 입력하세요: ");
                System.out.print("> 입력: ");
                int manage = sc.nextInt();
                sc.nextLine(); // 개행 문자 소비
                int count = admindao.insertDepartment(deNum, manage);
                System.out.println("부서가 추가되었습니다.");

            } else if (menuNo == 4) {
                System.out.println("================================");
                System.out.println("* 삭제할 부서번호를 입력하세요: ");
                System.out.print("> 입력: ");
                int deptToDelete = sc.nextInt();
                sc.nextLine(); // 개행 문자 소비
                admindao.deleteDepartment(deptToDelete);
                System.out.println("부서가 삭제되었습니다.");

            } else if (menuNo == 5) {
                System.out.println("=======================================");
                System.out.println("원하는 검색 방식을 선택해 주세요");
                System.out.println("1. 부서번호로 검색   2.직원명으로 검색   3. 이전으로");
                System.out.println("=======================================");
                int searchOption = sc.nextInt();
                sc.nextLine(); // 개행 문자 소비

                if (searchOption == 1) {
                    System.out.println("부서번호을 입력하세요: ");
                    int department = sc.nextInt();
                    List<UserVo> userList = admindao.selectdepartmentall(department);

                    for (UserVo user : userList) {
                        System.out.println(user.toString());
                    }

                } else if (searchOption == 2) {
                    System.out.println("직원명을 입력하세요: ");
                    String answer = sc.nextLine();
                    List<UserVo> useVo = admindao.selectUser(answer);
                    for (UserVo user : useVo) {
                        System.out.println(user.toString()); 
                    }

                } else if (searchOption == 3) {
                    continue; // 검색 메뉴를 벗어남
                }

            } else if (menuNo == 6) {
                System.out.println("감사합니다.");
                break; // 프로그램 종료
            }
        }
        sc.close();
    }
}
