package com.example.test.util;

import android.util.Log;


import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Mani
 */

public class LogUtils {

    private static boolean SHOULD_PRINT_LOG = true;

    private static final String HANDLED = "Handled";
    private static final String UNHANDLED = "Unhandled";

    private static final ArrayList<String> ignoreTags = new ArrayList<String>() {{

    }};

    /**
     * Set whether logs can be printed
     */
    public static void setLogLevel(boolean isBuildInReleaseMode) {
        SHOULD_PRINT_LOG = !isBuildInReleaseMode;
    }

    /**
     * Method to print error log.
     *
     * @param tag     - tag
     * @param message - message
     */
    public static void errorLog(String tag, String message) {
        if (SHOULD_PRINT_LOG) {
            Log.e(tag, message);
        }
    }

    /**
     * Method to print warning log.
     *
     * @param tag     - tag
     * @param message - message
     */
    public static void warnLog(String tag, String message) {
        if (SHOULD_PRINT_LOG) {
            Log.w(tag, message);
        }
    }

    /**
     * Method to print info log.
     *
     * @param tag     - tag
     * @param message - message
     */
    public static void infoLog(String tag, String message) {
        if (SHOULD_PRINT_LOG) {
            Log.i(tag, message);
        }
    }

    /**
     * Method to print debug log.
     *
     * @param tag     - tag
     * @param message - message
     */
    public static void debugLog(String tag, String message) {
        if (SHOULD_PRINT_LOG && !ignoreTags.contains(tag)) {
            Log.d(tag, message);
        }
    }

    public static void exceptionLog(Exception exception) {
        if (SHOULD_PRINT_LOG && exception != null) {

            Log.e("AndroidRuntime", "crash occurred");

            exception.printStackTrace();
        }
    }

    /**
     * Generate a TAG for log according to APM standards
     *
     * @param className         - name of the class
     * @param methodName        - name of the method
     * @param isHandledProperly - is all the exceptions/code handled properly
     * @return - generatedString
     */
    public static String generateTagFormat(String className, String methodName, boolean isHandledProperly) {
        String generatedTag;
        generatedTag = className + " " + methodName + " " + (isHandledProperly ? HANDLED : UNHANDLED);
        return generatedTag;
    }
}
