package me.ggyu.game;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        HashMap<String, Integer> oreMap = new HashMap<>();
        oreMap.put("조약돌", 0);
        oreMap.put("석탄", 0);
        oreMap.put("철", 0);
        oreMap.put("금", 0);
        oreMap.put("에메랄드", 0);
        oreMap.put("다이아몬드", 0);

        while (true) {
            System.out.println("************************");
            System.out.println("1.블록 파괴");
            System.out.println("2.블록을 파괴한 횟수 조회");
            System.out.println("3.획득한 아이템과 갯수 조회");
            System.out.println("4.게임 종료");
            System.out.println("************************");
            System.out.println("숫자를 입력해주세요.");
            int num = in.nextInt();
            System.out.println(num);

            if (num==1){ //임의의 블록 1개 파괴
                // 랜덤 객체 생성
                Random rand = new Random();

                // 1부터 100까지 랜덤한 숫자 생성
                int randnum = rand.nextInt(100) + 1;

                // 선택된 광물 변수 초기화
                String selectedOre = "";

                // 랜덤 숫자에 따라 선택된 광물 결정
                if (randnum >= 1 && randnum <= 50) {
                    selectedOre = "조약돌";
                } else if (randnum >= 51 && randnum <= 70) {
                    selectedOre = "석탄";
                } else if (randnum >= 71 && randnum <= 85) {
                    selectedOre = "철";
                } else if (randnum >= 86 && randnum <= 95) {
                    selectedOre = "금";
                } else if (randnum >= 96 && randnum <= 99) {
                    selectedOre = "에메랄드";
                } else if (randnum == 100) {
                    selectedOre = "다이아몬드";
                }

                oreMap.put(selectedOre, oreMap.get(selectedOre) + 1);

                System.out.println("획득한 광물: " + selectedOre);
                /*
                System.out.println("입력된 숫자: " + num);
                System.out.println("랜덤 숫자: " + randnum);
                System.out.println("선택된 광물: " + selectedOre);*/
            }
            else if (num==2){ //블록 파괴한 횟수 조회
                int total = 0;
                // HashMap에 있는 모든 값을 더하여 총 광물 캔 횟수 계산
                for (int value : oreMap.values()) {
                    total += value;
                }
                System.out.println("총 광물 캔 횟수: " + total + "회");
            }
            else if (num==3) { //획득한 아이템과 횟수 조회
                System.out.println("*획득한 아이템 개수*");
                for (Map.Entry<String, Integer> entry : oreMap.entrySet()) {
                    System.out.println(entry.getKey() + ": " + entry.getValue() + "회");
                }
            }
            else if (num==4) { //게임 종료, 최종스코어 출력
                int total = 0;
                for (int value : oreMap.values()) {
                    total += value;
                }
                System.out.println("총 블록 파괴 횟수: " + total + "회");

                // 획득한 아이템 개수 및 각 아이템 출력
                System.out.println("*획득한 아이템 개수*");
                for (Map.Entry<String, Integer> entry : oreMap.entrySet()) {
                    if (entry.getValue() > 0) {
                        System.out.println(entry.getKey() + ": " + entry.getValue());
                    }
                }
                break;
            }
        }
        System.out.println("게임 종료");
    }
}
