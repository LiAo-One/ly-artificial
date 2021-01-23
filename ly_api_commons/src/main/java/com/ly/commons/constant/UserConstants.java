package com.ly.commons.constant;

/**
 * <p>
 * 用户常量信息
 * </p>
 *
 * @author LiAo
 * @since 2020/12/28
 */
public class UserConstants {

    /** 是否为外链（0是 1否） */
    private String isFrame;

    /** 菜单类型（目录） */
    public static final String TYPE_DIR = "M";

    /** 菜单类型（菜单） */
    public static final String TYPE_MENU = "C";

    /** 菜单类型（按钮） */
    public static final String TYPE_BUTTON = "F";

    /** 是否菜单外链（否） */
    public static final String NO_FRAME = "1";

    /** Layout组件标识 */
    public final static String LAYOUT = "Layout";

    /** 校验返回结果码 */
    public final static String UNIQUE = "0";
    public final static String NOT_UNIQUE = "1";

    /** 部门正常状态 */
    public static final String DEPT_NORMAL = "0";

    /** 部门停用状态 */
    public static final String DEPT_DISABLE = "1";
}
