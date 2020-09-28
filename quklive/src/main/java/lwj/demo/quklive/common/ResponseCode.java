package lwj.demo.quklive.common;

/**
 * 返回枚举
 *
 * @author liuweijia
 * @date 2017年10月13日 上午10:11:08
 * @since 1.0.0
 */
public enum ResponseCode {
    SUCCESS(0, "成功"),
    FAIL(1, "失败"),

    /********** 登录相关 ************/
    ERROR_PCODE(10001, "图形验证码错误"),
    ERROR_VCODE(10002, "手机验证码错误"),
    NO_ACCOUNT(10003, "无此帐号"),
    ERROR_PASSWORD(10004, "密码错误"),
    SAME_PASSWORD(10005, "密码与旧密码相同"),
    NO_PASSWORD(10006, "没有密码"),
    NO_USERTYPE(10007, "帐号存在，但不存在此平台类型用户"),
    SAME_PHOME(10008, "新老手机号相同"),
    EXIST_PHOME(10009, "手机帐号已存在"),
    SHOP_SETTLED(10010, "商户已入驻并开店"),
    SHOP_NO_SETTLED(10011, "商户未入驻"),
    SHOP_CLOSE(10012, "商户已关店"),
    ACCOUNT_CLOSE(10013, "此账号已被冻结"),
    SUB_ACCOUNT(10014, "商户已入驻并开店并且是子账号登录"),
    TOKEN_ERROR(10015, "accessToken错误或者超时"),
    UID_STOREID_ERROR(10016, "uid和storeId错误"),
    NOT_LOGIN(10017, "not login"),
    INVALID_PHONE(10018, "电话号码格式不正确"),
    /********** 用户 ************/
    ADDRESS_ZISE(10011, "用户地址限制10个"),
    SAME_NICKNAME(10012, "用户昵称重复"),

    /********** 索票相关 ************/
    NO_EXPO(10021, "无展会"),
    TICKET_EXPO(10022, "展会信息"),
    TICKET_INVITATION(10023, "邀请函信息"),
    TICKET_QRCODE(10024, "二维码信息"),

    /********** 其他 ************/
    PUSH_TIME_OVERLAP(10101, "推送时间冲突"),

    /********** 商品相关 ************/
    PRODUCT_NOT_EXISTS(20001, "商品已失效"),
    /********** 店铺相关 ************/
    STORE_NOT_EXIST(30001, "店铺信息不存在"),
    STORE_NAME_EXIST(30002, "店铺名称已存在"),
    STORE_BRANCH_NOT_EXIST(30003, "店铺分店不存在"),
    STORE_CHECK_ERROR(30004, "店铺校验失败,店铺id不匹配"),
    STORE_CITY_INDUSTRY_UPDATE(30005, "店铺审核已通过,无法修改服务范围和主营行业"),
    STORE_BRAND_NOT_EXIST(30006, "店铺品牌信息不存在"),
    STORE_CATE_NOT_EXIST(30007, "店铺分类信息不存在"),
    STORE_MISS_PARAM(30008, "缺少参数"),
    STORE_PRIVATE_KEY_LENGTH(30009, "支付宝私钥长度超过限制"),
    STORE_PUBLIC_KEY_LENGTH(30010, "支付宝公钥长度超过限制"),
    STORE_OPERATOR_NOT_EXIST(30011, "店铺子账号信息不存在"),
    STORE_ROLE_NOT_EXIST(30012, "店铺子账号角色信息不存在"),
    STORE_OPERATOR_ACOUNT_LIMIT(30013, "账号名不能是手机号"),
    STORE_ROLE_BAN(30014, "角色已被禁用"),
    STORE_ROLE_NAME_EXIST(30015, "角色名已存在"),
    STORE_OPERATOR_COUNT_LIMIT(30016, "已使用子账号数量超过5个,请先冻结再添加"),
    STORE_OPERATOR_ACCOUNT_EXIST(30017, "子账号账号名已存在"),
    STORE_OPERATOR_PWD_FORMAT(30018, "子账号密码格式有误"),
    STORE_CLOSE(30019, "店铺已关闭"),
    STORE_NOT_VERIFY_FIRST(30020, "店铺入驻未通过"),

    /***********营销活动***********/
    //领券
    MARKETING_COUPON_USER_NON_EXISTENT(40001, "用户不存在"),
    MARKETING_COUPON_NON_EXISTENT(40002, "现金券不存在"),
    MARKETING_COUPON_NOT_HAVE(40003, "现金券已经领取"),
    MARKETING_COUPON_RECEIVE_NOT_BEGIN(40004, "现金券领取时间未到"),
    MARKETING_COUPON_RECEIVE_END(40005, "现金券已过领取时间"),
    MARKETING_COUPON_NOT_RECEIVE(40006, "现金券不能领取"),
    MARKETING_COUPON_USER_HAVE(40007, "已领取过这张现金券"),
    MARKETING_COUPON_RECEIVE_ERROR(40008, "领取失败"),
    MARKETING_COUPON_RECEIVE_SYSTEM_ERROR(40009, "系统错误，领取失败"),
    MARKETING_COUPON_RECEIVE_LOCK_SYSTEM_ERROR(40010, "领取人数太多，稍后重试"),
    MARKETING_COUPON_NOT_MATCH_LEVEL(40011, "用户等级与该券适用等级不匹配"),
    MARKETING_COUPON_UNDER_SHELF(40012, "该现金券已下架"),
    MARKETING_COUPON_USER_NOT_GET(40013, "用户未领取现金券"),
    //用券
    MARKETING_USE_COUPON_NON_EXISTENT(41001, "现金券不存在，或者已使用"),
    MARKETING_USE_COUPON_NOT_USE(41002, "不能使用这张现金券"),
    MARKETING_USE_COUPON_USED(41003, "现金券已使用"),
    MARKETING_USE_COUPON_NOT_BEGIN(41004, "现金券未到使用时间"),
    MARKETING_USE_COUPON_TIMEOUT(41005, "现金券已过期"),
    MARKETING_USE_COUPON_LOCK_SYSTEM_ERROR(41006, "抵扣现金券失败"),
    //核销点券
    MARKETING_USE_VOUCHER_NON_EXISTENT(42001, "点券不存在"),
    MARKETING_USE_VOUCHER_END(42002, "超过核销次数，不能核销"),
    MARKETING_USE_VOUCHER_USER_NON_EXISTENT(42003, "用户错误，不能核销"),
    MARKETING_USE_VOUCHER_ERROR(42004, "核销失败"),
    MARKETING_USE_VOUCHER_SYSTEM_ERROR(42005, "系统错误，核销失败"),
    MARKETING_USE_VOUCHER_ORDER_ERROR(42006, "订单状态不对，核销失败"),
    MARKETING_USE_VOUCHER_ORDER_IN_AFTER(42007, "订单已售后，核销失败"),
    //扫码点券
    MARKETING_GET_VOUCHER_ERROR(43001, "核销码格式不对"),
    MARKETING_GET_VOUCHER_USER_NON_EXISTENT(43002, "用户不存在"),
    MARKETING_GET_VOUCHER_STORE_ERROR(43003, "该店铺不能核销"),
    MARKETING_GET_VOUCHER_TIMEOUT(43004, "核销码过期，请重新获取"),
    //个人钱包
    MARKETING_WALLET_USER_NON_EXISTENT(44001, "用户不存在"),
    MARKETING_WALLET_NON_EXISTENT(40002, "活动不存在"),
    MARKETING_WALLET_RECEIVE_NOT_BEGIN(40004, "活动领取时间未到"),
    MARKETING_WALLET_RECEIVE_END(40005, "活动已过领取时间"),
    MARKETING_WALLET_NOT_RECEIVE(40006, "活动不能领取"),
    MARKETING_WALLET_RECEIVE_ERROR(40008, "领取失败"),
    MARKETING_WALLET_RECEIVE_SYSTEM_ERROR(40009, "系统错误，领取失败"),
    MARKETING_WALLET_RECEIVE_LOCK_SYSTEM_ERROR(40010, "领取人数太多，稍后重试"),

    MARKETING_WALLET_USER_ASSETS_NON_EXISTENT(44011, "用户资产不存在"),
    MARKETING_WALLET_UPDATE_SYSTEM_ERROR(40012, "系统错误，抵扣失败"),
    MARKETING_WALLET_USER_SUBSIDY_EXISTENT(44013, "此订单已经抵扣购物津贴"),
    MARKETING_WALLET_USER_CASH_MONEY_EXISTENT(44014, "此订单已经抵扣余额"),
    MARKETING_WALLET_USER_CASH_MONEY_HAS_TRANSFER(44015, "转账记录已存在"),
    MARKETING_WALLET_USER_CASH_MONEY_NON(44016, "余额不足"),
    MARKETING_WALLET_USER_SUBSIDY_NON(44018, "购物津贴不足"),
    MARKETING_WALLET_USER_CASH_MONEY_TRANSFER_ERROR(44019, "转账失败"),

    MARKETING_WALLET_USER_CASH_MONEY_HAS_FUND(44020, "已有返现记录"),

    /***********中婚基金&订单返现***********/
    REFUND_ORDER_NOT_FOUND(45001, "订单不存在"),
    REFUND_ORDER_CANT_EDIT(45002, "订单不能修改"),;


    private int code;
    private String msg;

    private ResponseCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 由值获取枚举对象
     *
     * @param code
     * @return
     */
    public static ResponseCode getEnum(int code) {
        for (ResponseCode messageEnum : ResponseCode.values()) {
            if (messageEnum.getCode() == code) {
                return messageEnum;
            }
        }
        return null;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
