package com.hnk.account.core.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * MyBatis工具类
 * @author 懒猴子CG
 * @date 2020/05/25 16:04
 */
public class MyBatisUtil {

    /**
     * 实体类转Example
     * @author 懒猴子CG
     * @date 2020/05/25 16:04
     */
    public static <E> E toExample(Object source, Class<E> exampleClass) {
        try {
            E example = exampleClass.newInstance();
            Method createCriteria = exampleClass.getMethod("createCriteria");
            Object criteria = createCriteria.invoke(example);
            Field[] fields = source.getClass().getDeclaredFields();
            for (Field field: fields) {
                field.setAccessible(Boolean.TRUE);
                Object value = field.get(source);
                if (value != null) {
                    String name = field.getName();
                    Method andMethod = criteria.getClass().getMethod(String.format("and%sEqualTo", name.substring(0, 1).toUpperCase() + name.substring(1)), field.getType());
                    andMethod.invoke(criteria, value);
                }
            }
            return example;
        } catch (Exception e) {
            throw new RuntimeException("Method 'toExample' of class MyBatisUtil throw an exception", e);
        }
    }
}