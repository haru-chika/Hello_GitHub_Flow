import java.util.InputMismatchException; //クラスInputMismatchException: 不正な入力の型
import java.util.Scanner;

public class Kazuate {

    public static void main(String[] args) {

        // 1. 答えとなる2桁の正の整数を設定 (10〜99)
        int answer = 20;

        // 2. ユーザー入力の準備
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- 数当てゲーム ---");
        System.out.println("私が設定した10から99までの数字を当ててください。");
        System.out.println("チャンスは5回です。");

        // 3. ゲームループ (5回まで)
        for (int i = 1; i <= 5; i++) {
            System.out.println("\n--- " + i + "回目の挑戦 ---");
            System.out.print("予想する数を入力してください: ");

            try {
                int guess = scanner.nextInt();

                // 4. 入力された値が2桁の正の整数かチェック
                if (guess < 10 || guess > 99) {
                    System.out.println("エラー: 10から99までの2桁の正の整数を入力してください。");
                    i--; // 回数を消費しない
                    continue;
                }

                // 5. 判定
                if (guess == answer) {
                    System.out.println("当たり！おめでとうございます！");
                    break; // 当たったのでループを終了
                } else {
                    System.out.print("外れ！設定された数はもっと");
                    // 大きいか小さいかのヒント
                    if (guess < answer) {
                        System.out.print("大きいです。");
                    } else {
                        System.out.print("小さいです。");
                    }

                    // 20以上差があるかのヒント
                    if (Math.abs(guess - answer) >= 20) {
                        System.out.print(" (ヒント: 20以上離れています)");
                    }
                    System.out.println();
                }

                // 最終回で外れた場合
                if (i == 5) {
                    System.out.println("\n残念！ゲームオーバーです。");
                    System.out.println("正解は " + answer + " でした。");
                }

            } catch (InputMismatchException e) {
                System.out.println("エラー: 数字を入力してください。");
                scanner.next(); // 不正な入力をクリア
                i--; // 回数を消費しない
            }
        }
        scanner.close();
    }
}