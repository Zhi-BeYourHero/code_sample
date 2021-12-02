package com.zhi.reflectAnnotation;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BankService {
    public static final BankService bankService = new BankService();

    public String createUser(String name, String id, int age, String mobile) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%-10s", name).replace(" ", "_"));
        sb.append(String.format("%-18s", id).replace(" ", "_"));
        sb.append(String.format("%05d", age));
        sb.append(String.format("%-11s", mobile).replace(" ", "_"));
        return sb.toString();
    }

    public String pay(long uId, BigDecimal amount) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%020d", uId));
        sb.append(String.format("%010d", amount.setScale(2, RoundingMode.DOWN).multiply(BigDecimal.valueOf(100)).longValue()));
        return sb.toString();
    }

    public static void main(String[] args) {
        String user = BankService.bankService.createUser("小智会好起来的", "4451523199705256315", 24, "1860401111");
        System.out.println(user);
        System.out.println(BankService.bankService.pay(20175366, BigDecimal.valueOf(0.2574)));

        PayAPI payAPI = new PayAPI();
        payAPI.setAmount(BigDecimal.valueOf(0.5541));
        payAPI.setUid(1345648);
        String s = BankService.bankService.remoteCall(payAPI);
        System.out.println(s);
    }

    public String remoteCall(AbstractAPI abstractAPI) {
        BankAPI bankAPI = abstractAPI.getClass().getAnnotation(BankAPI.class);
        String url = bankAPI.url();
        StringBuilder  stringBuilder = new StringBuilder();
        stringBuilder.append(url);
        // 1、获取所有的字段，进行组装
        Arrays.asList(abstractAPI.getClass().getDeclaredFields())
                .stream()
                .filter(field -> field.isAnnotationPresent(BankAPIField.class))
                .sorted(Comparator.comparing(field -> field.getAnnotation(BankAPIField.class).order()))
                .peek(field -> field.setAccessible(true))
                .forEach(field -> {
                    BankAPIField bankAPIField = field.getAnnotation(BankAPIField.class);
                    Object value = "";
                    try {
                        value = field.get(abstractAPI);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    switch (bankAPIField.type()) {
                        case "S": {
                            stringBuilder.append(String.format("%-" + bankAPIField.length() + "s", value.toString()).replace(' ', '_'));
                            break;
                        }
                        case "N": {
                            stringBuilder.append(String.format("%" + bankAPIField.length() + "s", value.toString()).replace(' ', '0'));
                            break;
                        }
                        case "M": {
                            if (!(value instanceof BigDecimal))
                                throw new RuntimeException(String.format("%s 的 %s 必须是BigDecimal", abstractAPI, field));
                            stringBuilder.append(String.format("%0" + bankAPIField.length() + "d", ((BigDecimal) value).setScale(2, RoundingMode.DOWN).multiply(new BigDecimal("100")).longValue()));
                            break;
                        }
                        default:
                            break;
                    }
                });
        return stringBuilder.toString();
    }


}
