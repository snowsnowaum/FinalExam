package com.example.finalexam;

import androidx.appcompat.app.AppCompatActivity;



    public class store extends AppCompatActivity {
        public static final String TABLE_NAME = "userTable";

        public static final String COLUMN_USER = "Username";
        public static final String COLUMN_NAME = "FullName";
        public static final String COLUMN_PASS = "Pass";

        private String user;
        private String name;
        private String pass;


        // Create table SQL query
        public static final String CREATE_TABLE =
                "CREATE TABLE " + TABLE_NAME + "("
                        + COLUMN_USER + " TEXT PRIMARY KEY "
                        + COLUMN_NAME + " TEXT,"
                        + COLUMN_PASS + " TEXT"
                        + ")";

        public store() {
        }

        public store(String user, String name, String pass) {
            this.user = user;
            this.name = name;
            this.pass = pass;
        }

        public String getUser() {
            return user;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPass() {
            return pass;
        }

        public void setUser(String user) {
            this.user = user;
        }

        public void setPass(String pass) {
            this.pass = pass;
        }

}
