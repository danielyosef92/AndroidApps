package com.example.danielyosef.androidapps.Database;

import static java.util.Calendar.DATE;

/**
 * Created by danielyosef on 11/30/16.
 */

public class dbContract {

    public static final String DB_NAME = "MyBirthdays.db";

    public static class MyBirthdaysTable {

        public static final String TABLE_NAME = "mybirthdaystable";

        public static final String NAME = "name";
        public static final String BIRTH_DATE = "birth_date";
        public static final String NEXT_COMING_BIRTHDAY  = "next_coming_birthday";
        public static final String COMMENT = "comment";

    }
}
