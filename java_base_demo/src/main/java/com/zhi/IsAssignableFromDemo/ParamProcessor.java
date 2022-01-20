package com.zhi.IsAssignableFromDemo;

import com.zhi.IsAssignableFromDemo.dto.Father;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: luowenzhi
 * @CreateTime: 20/1/2022
 * @desc: 参数处理器， 根据注解为值为null的字段设置默认值
 */
public class ParamProcessor {
    public static void main(String[] args) {
        Father father = new Father();
        applyDefaultValue(father);
        System.out.println(father);
    }

    public static void applyDefaultValue(Object o) {
        Class sourceClass = o.getClass();
        //获取对象所有字段 包括父类
        List<Field> fields = Arrays.asList(sourceClass.getDeclaredFields());
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                if(field.isAnnotationPresent(ParamDefaultValue.class)) {
                    Object value = field.get(o);
                    if (value != null) {
                        continue;
                    }
                    Class<?> type = field.getType();
                    if (type.isPrimitive()) {
                        continue;
                    }
                    String defVal = field.getAnnotation(ParamDefaultValue.class).value();
                    //isAssignableFrom()方法的调用者和参数都是Class对象，调用者为父类，参数为本身或者其子类。
                    //isAssignableFrom()方法是判断是否为某个类的父类，instanceof关键字是判断是否某个类的子类。
                    if (String.class.isAssignableFrom(type)) {
                        field.set(o, defVal);
                    } else if (Number.class.isAssignableFrom(type)) {
                        if(Byte.class.isAssignableFrom(type)) {
                            field.set(o, Byte.valueOf(defVal));
                        } else if (Short.class.isAssignableFrom(type)) {
                            field.set(o, Short.valueOf(defVal));
                        } else if (Integer.class.isAssignableFrom(type)) {
                            field.set(o, Integer.valueOf(defVal));
                        } else if (Long.class.isAssignableFrom(type)) {
                            field.set(o, Long.valueOf(defVal));
                        } else if (Double.class.isAssignableFrom(type)) {
                            field.set(o, Double.valueOf(defVal));
                        }
                    }
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        }
    }
}
