package com.hlb;

/**
 * @author: code_hlb
 * @date :  2023/10/24 14:30
 * @desc :
 */
public class PasswdExption extends RuntimeException {
    public PasswdExption() {
        super();
    }

    public PasswdExption(String message) {
        super(message);
    }
}
