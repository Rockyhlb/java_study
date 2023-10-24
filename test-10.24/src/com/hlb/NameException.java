package com.hlb;

/**
 * @author: code_hlb
 * @date :  2023/10/24 14:05
 * @desc :
 */

/* 自定义异常可以继承自 “Exception” 和 “RuntimeException”
 如果继承了“Exception”,则该自定义异常就成为了受查异常，编译无法通过
 继承了“RuntimeException”就变成了非受查异常，因此就可以通过编译运行，违规情况才会报异常
 我们的自定义异常一般都是继承自RuntimeException*/
public class NameException extends RuntimeException{

    public NameException() {
        super();
    }

    public NameException(String message) {
        super(message);
    }

    public NameException(String message, Throwable cause) {
        super(message, cause);
    }
}
