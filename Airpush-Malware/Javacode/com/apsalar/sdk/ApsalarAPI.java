package com.apsalar.sdk;

/* compiled from: ApEvent */
interface ApsalarAPI {

    /* compiled from: ApEvent */
    public static class Status {
        static final int INVALID = -1;
        static final int POSTPONE = 0;
        static final int SUCCESS = 1;
    }

    /* compiled from: ApEvent */
    public static class Type {
        static final int END_SESSION = 4;
        static final int EVENT = 3;
        static final int HEARTBEAT = 2;
        static final int NONE = 0;
        static final int REGISTER = 5;
        static final int RETRY = -1;
        static final int SESSION = 1;
        static final int TRIGGER = 6;
    }

    int REST();
}
