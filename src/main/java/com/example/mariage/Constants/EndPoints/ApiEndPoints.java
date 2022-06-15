package com.example.mariage.Constants.EndPoints;

public class ApiEndPoints {

    public static final String MAIN = "/api";

    public static class Guest {
        public static final String MAIN = "/guest";
        public static final String BY_ID = MAIN + "/{id}";
    }

    public static class Presence {
        public static final String MAIN = "/presence";
        public static final String BY_ID = MAIN + "/{id}";
        public static final String BY_GUEST_ID = MAIN + "/{guestd}";
    }
}
