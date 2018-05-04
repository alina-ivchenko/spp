package main.java;

import java.lang.reflect.Method;
import java.sql.Date;
import java.util.*;

public class ProjectFunctions {
    public static String escapeNullException(Object inputObj, String defaultNullStr) {
        if (defaultNullStr == null)
            defaultNullStr = "неизвестно";
        return inputObj != null && !inputObj.toString().equals("") ? inputObj.toString() : defaultNullStr;
    }

    public static boolean ifDbObjectContainsKey(HashMap<String, Object> dbRetObject, String key) {
        return dbRetObject.containsKey(key) && dbRetObject.get(key) != null;
    }

    //пытается заполнить объект с использованием массива, полученного из БД
    //ищет setters с использованием рефлексии
    //возвращает часть исходного массива, setter-ы для которого не были найдены

    public static HashMap<String, Object> tryFillObjectByDbArray(Object object, HashMap<String, Object> dbArray) {
        List<Method> existingSetters = getSetters(object.getClass().getMethods());
        HashMap<String, Object> avoidedElementsOfArray = new HashMap<String, Object>();

        for (Map.Entry<String, Object> item : dbArray.entrySet()) {
            String tempStr = "set".concat(item.getKey().toLowerCase(Locale.ENGLISH).replaceAll("_", ""));
            String methodName;
            Method methodToRun = null;

            for (int i = 0; i < existingSetters.size(); i++) {
                methodName = existingSetters.get(i).getName().toLowerCase();
                if (tempStr.compareTo(methodName) == 0) {
                    //TODO: починить LocalDate initialization
                    methodToRun = existingSetters.get(i);
                    break;
                }
            }
            if (methodToRun != null) {
                try {
                    String typeName = methodToRun.getGenericParameterTypes()[0].getTypeName();

                    if (typeName.equalsIgnoreCase("java.lang.String")) {
                        methodToRun.invoke(object, item.getValue().toString());
                        continue;
                    }

                    if (typeName.equalsIgnoreCase("long")) {
                        methodToRun.invoke(object, Long.parseLong(item.getValue().toString()));
                        continue;
                    }

                    if (typeName.equalsIgnoreCase("date")) {
                        methodToRun.invoke(object, Date.valueOf(item.getValue().toString()));
                        continue;
                    }

                    methodToRun.invoke(object, Date.valueOf(item.getValue().toString()));
                    continue;

                } catch (Exception e) {
                    avoidedElementsOfArray.put(item.getKey(), item.getValue());
                }
            } else
                avoidedElementsOfArray.put(item.getKey(), item.getValue());

            //TODO:  object.getClass().getMethod("set".concat(convertDbNameToSetterPostfix(item.getKey())));
        }
        return avoidedElementsOfArray;
    }

    public static boolean isEmptyOrNull(String str) {
        return str == null || str.isEmpty();
    }

    private static List<Method> getSetters(Method[] methodsToFilter) {
        List<Method> retGetters = new ArrayList<Method>();
        for (int i = 0; i < methodsToFilter.length; i++)
            if (methodsToFilter[i].getName().substring(0, 3).equals("set"))
                retGetters.add(methodsToFilter[i]);
        return retGetters;
    }
}
