package com.cx.springboot02.common.utils;



public enum AuthorizeType {


    /** 有没有发现写枚举类的这一部分就像是在调用构造方法 */
    CUSTOMER("customer"),
    BUSINESS("business"),
    MANAGE("manage"),
    CUSTOMER_SERVICE("customerService"),
    //上面的逗号可去可不去, 并不会导致编译错误
    ;

    private String identity;

    public final static AuthorizeType[] authorizeTypes = {
            AuthorizeType.CUSTOMER,
            AuthorizeType.BUSINESS,
            AuthorizeType.CUSTOMER_SERVICE,
            AuthorizeType.MANAGE,
    };
    //构造函数默认并且必须是private
    AuthorizeType(String identity) {
        this.identity = identity;
    }


    public String identity() {
        return this.identity;
    }

    /**
     * 返回字符串对应的枚举类
     * @param name
     * @return
     */
    public static AuthorizeType StringToAuthorizeType(String name){
        if(name==null) return null;
        AuthorizeType authorizeType = null;
        if(name.equals(AuthorizeType.CUSTOMER.identity())){
            authorizeType = AuthorizeType.CUSTOMER;
        }else if(name.equals(AuthorizeType.MANAGE.identity())){
            authorizeType = AuthorizeType.MANAGE;
        }else if(name.equals(AuthorizeType.CUSTOMER_SERVICE.identity())){
            authorizeType = AuthorizeType.CUSTOMER_SERVICE;
        }else if(name.equals(AuthorizeType.BUSINESS.identity())){
            authorizeType = AuthorizeType.BUSINESS;
        }
        return authorizeType;
    }

}
