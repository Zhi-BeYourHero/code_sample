package com.zhi.memorandum;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.YearMonth;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Double v = BigDecimal.valueOf(10000)
                .divide(BigDecimal.valueOf(10000), 4, RoundingMode.HALF_UP).doubleValue();
        System.out.println(new DecimalFormat("#.0000").format(v));
//        YearMonth lastMonth = YearMonth.now().minusMonths(2);
//        System.out.println(lastMonth);
//        InputText inputText = new InputText();
//        SnapShotHolder snapShotHolder = new SnapShotHolder();
//        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNext()) {
//            String input = scanner.next();
//            if (input.equals(":list")) {
//                System.out.println(inputText.getText());
//            }else if (input.equals(":undo")) {
//                SnapShot snapShot = snapShotHolder.pop();
//                inputText.restoreSnapShot(snapShot);
//            } else {
//                snapShotHolder.push(inputText.createSnapShot());
//                inputText.append(input);
//            }
//        }
    }
}
