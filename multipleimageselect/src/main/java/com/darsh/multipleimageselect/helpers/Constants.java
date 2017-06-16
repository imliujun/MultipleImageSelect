package com.darsh.multipleimageselect.helpers;

/**
 * 项目名称：MultipleImageSelect
 * 类描述：
 * 创建人：Darshan
 * 创建时间：5/26/2015
 * 修改人：LiuJun
 * 修改时间：6/16/2017 14:10
 * 修改备注：Add support GIF images parameters
 */
public class Constants {
    public static final int PERMISSION_REQUEST_CODE = 1000;
    public static final int PERMISSION_GRANTED = 1001;
    public static final int PERMISSION_DENIED = 1002;

    public static final int REQUEST_CODE = 2000;

    public static final int FETCH_STARTED = 2001;
    public static final int FETCH_COMPLETED = 2002;
    public static final int ERROR = 2005;

    /**
     * Request code for permission has to be < (1 << 8)
     * Otherwise throws java.lang.IllegalArgumentException: Can only use lower 8 bits for
     * requestCode
     */
    public static final int PERMISSION_REQUEST_READ_EXTERNAL_STORAGE = 23;

    public static final String INTENT_EXTRA_ALBUM = "album";
    public static final String INTENT_EXTRA_IMAGES = "images";
    public static final String INTENT_EXTRA_LIMIT = "limit";
    public static final String INTENT_EXTRA_IS_SUPPORT_GIF = "isSupportGif";
    public static final int DEFAULT_LIMIT = 10;

    //Maximum number of images that can be selected at a time
    public static int limit;
    //default Support Gif
    public static boolean isSupportGif;
}
