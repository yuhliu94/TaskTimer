package com.kevyliu.tasktimer;

import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

import static com.kevyliu.tasktimer.AppProvider.CONTENT_AUTHORITY;
import static com.kevyliu.tasktimer.AppProvider.CONTENT_AUTHORITY_URI;

public class TasksContract {
    static final String TABLE_NAME = "Tasks";

    // Tasks fields
    public static class Columns {
        public static final String _ID = BaseColumns._ID;
        public static final String TASKS_NAME = "Name";
        public static final String TASKS_DESCRIPTION = "Description";
        public static final String TASKS_SORTORDER = "SortOrder";

        private Columns() {
            // private constructor to prevent instantiation
        }
    }

    /**
     * The URI to access the Tasks table
     */
    public static final Uri CONTENT_URI = Uri.withAppendedPath(CONTENT_AUTHORITY_URI, TABLE_NAME);
    // CONTENT_URI = content://com.kevyliu.tasktimer.provider/Tasks/

    static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd." + CONTENT_AUTHORITY + "." + TABLE_NAME;
    // CONTENT_TYPE = vnd.android.cursor.dir/vnd.com.kevyliu.tasktimer.provider.Tasks
    static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd." + CONTENT_AUTHORITY + "." + TABLE_NAME;
    // CONTENT_ITEM_TYPE = vnd.android.cursor.item/vnd.com.kevyliu.tasktimer.provider.Tasks

    static Uri buildTaskUri(long taskId) {
        return ContentUris.withAppendedId(CONTENT_URI, taskId);
        // return content://com.kevyliu.tasktimer.provider/Tasks/{taskId}
    }

    static long getTaskId(Uri uri) {
        return ContentUris.parseId(uri);
        // return {taskId}
    }
}
