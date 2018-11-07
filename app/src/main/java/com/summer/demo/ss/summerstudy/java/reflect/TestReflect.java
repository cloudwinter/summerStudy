package com.summer.demo.ss.summerstudy.java.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Created by xiayundong on 2018/9/4.
 */

public class TestReflect {


    public static void main(String[] args) {
        try {
            // 第一种方式
            Class class1 = Class.forName("com.summer.demo.ss.summerstudy.java.reflect.Preson");
            System.out.println("class1:" + class1);

            // 第二种方式
            Preson preson = new Preson();
            Class class2 = preson.getClass();
            System.out.println("class2:" + class2);

            // 第三种方式
            Class class3 = Preson.class;
            System.out.println("class3:" + class3);

            // 通过class实例化对象,默认无参实例化对象
            try {
                // 无参实例化
//                Preson preson1 = (Preson) class3.newInstance();
                Preson preson1 = null;

                // 有参实例化
                try {
                    Constructor constructor = class2.getConstructor(String.class);
                    try {
                        preson1 = (Preson) constructor.newInstance("李四");
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }

//                preson1.setName("张三");
                preson1.age = 30;
                preson1.sex = "男";
                preson1.setAddr("江苏省南京市");
                System.out.println("preson name:" + preson1.name);

                System.out.println("------------------------field start------------------------");
                // ⭐️⭐⭐⭐ 只能获取public属性，包括父类的public
                Field[] fields = class3.getFields();

                // ⭐️⭐⭐⭐可以获取当前类的public,private,protect ,但是不能获取父类的属性
                //Field[] fields = class3.getDeclaredFields();

                for (Field field : fields
                        ) {
                    // 设置为true表示可以获取私有属性的数据值
                    field.setAccessible(true);
                    System.out.println("Field 属性name:" + field.getName() + " 属性类型type:" + field.getGenericType() + " 属性的值value：" + field.get(preson1));
                }
                System.out.println("------------------------field end------------------------");

                System.out.println("------------------------method start------------------------");
                // ⭐️⭐⭐⭐只能获取public方法，包括父类的public
//                Method[] methods = class1.getMethods();
                // ⭐️⭐⭐⭐可以获取当前类的public,private,protect ,但是不能获取父类的方法
                Method[] methods = class1.getDeclaredMethods();
                for (Method method : methods
                        ) {
                    System.out.println("方法名称：" + method.getName() + " 方法的修饰符：" + Modifier.toString(method.getModifiers()) + " 返回值类型：" + method.getReturnType());
//                    Class[] classes = method.getParameterTypes();
//                    for (Class classParam : classes
//                            ) {
//                        System.out.println("方法参数" + classParam);
//                    }
                }

                System.out.println("---------------------method end---------------------------");
                try {
                    Method methodGetName = class1.getMethod("getName", new Class[0]);
                    Method methodGetData = class2.getMethod("getData", String.class, String.class, int.class);

                    try {
                        String result = (String) methodGetName.invoke(preson1);
                        System.out.println("返回结果是：" + result);


                        String resultData = (String) methodGetData.invoke(preson1, "夏天", "江苏南京市雨花台区", 29);
                        System.out.println("返回的结果：" + resultData);
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }


            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
