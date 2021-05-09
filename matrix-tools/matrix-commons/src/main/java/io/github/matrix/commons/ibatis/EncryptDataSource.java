package io.github.matrix.commons.ibatis;

import com.zaxxer.hikari.HikariDataSource;
import io.github.matrix.commons.security.AES;

/**
 * @author Bing D. Yee
 * @since 2021/05/04
 */
public class EncryptDataSource extends HikariDataSource {

    private final static String USERNAME_KEY = "mauname-encoding";
    private final static String PASSWORD_KEY = "mat-pwd-encoding";


    @Override
    public String getPassword() {
        return AES.decrypt(super.getPassword(), PASSWORD_KEY);
    }

    @Override
    public String getUsername() {
        return AES.decrypt(super.getUsername(), USERNAME_KEY);
    }

    public static void main(String[] args) {
        System.err.println(AES.encrypt("root", USERNAME_KEY));
        System.err.println(AES.encrypt("root", PASSWORD_KEY));
    }

}
