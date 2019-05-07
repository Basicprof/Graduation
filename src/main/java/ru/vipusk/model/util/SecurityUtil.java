package ru.vipusk.model.util;

import ru.vipusk.model.AbstractNameEntity;


public class SecurityUtil {

    private static int id = AbstractNameEntity.START_SEQ;

    private SecurityUtil() {
    }

    public static int authUserId() {
        return id;
    }

    public static void setAuthUserId(int id) {
        SecurityUtil.id = id;
    }

}