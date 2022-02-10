package com.example.projectmk2;

public class User {
    private static String uid;
    private boolean loginState;

    public static String getUid() {
        return uid;
    }

    public static void setUid(String str) {
        uid = str;
    }

    public boolean isLoginState() {
        return loginState;
    }

    public void setLoginState(boolean loginState) {
        this.loginState = loginState;
    }
}
