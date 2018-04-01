package com.challenge.back.util;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class ConversionUtils {
    /**
     * Transforma o objeto recebido como parâmetro em String contendo todos os seus atributos e valores
     *
     * @param object objeto a ser transformado
     * @return string contendo nome da classe, atributos e valores do objeto
     */
    public static String genericToString(Object object) {
        if (object == null) {
            return "null";
        }
        StringJoiner sb = new StringJoiner(System.getProperty("line.separator"));
        sb.add(String.format("%s {", object.getClass().getSimpleName()));
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            String fieldName = field.getName();
            Object fieldValue = getFieldValue(object, field);
            sb.add(String.format("%s = %s", fieldName, fieldValue.toString()));
        }
        return sb.toString();
    }

    /**
     * Transforma o objeto recebido como parâmetro em Map contendo todos os seus atributos e valores
     *
     * @param object objeto a ser transformado
     * @return map contendo nomes de atributos e respectivos valores
     */
    public static Map<String, String> genericToMap(Object object) {
        if (object == null) {
            return new HashMap<>();
        }

        Map<String, String> map = new HashMap<>();
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            String fieldName = field.getName();
            Object fieldValue;
            fieldValue = getFieldValue(object, field);
            map.put(fieldName, fieldValue.toString());
        }
        return map;
    }

    /**
     * Auxilia na extração do valor de um field passado como parametro
     *
     * @param object instância do objeto que possui o field
     * @param field  campo presente no objeto
     * @return valor do campo presente no objeto
     */
    private static Object getFieldValue(Object object, Field field) {
        Object fieldValue;
        try {
            fieldValue = field.get(object);
            if (fieldValue == null) {
                fieldValue = "null";
            }
        } catch (IllegalAccessException e) {
            fieldValue = "<ERROR>";
        }
        return fieldValue;
    }
}
