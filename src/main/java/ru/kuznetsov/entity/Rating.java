package ru.kuznetsov.entity;

public enum Rating {

    G("G"),
    PG("PG"),
    PG13("PG-13"),
    R("R"),
    NC17("NC-17");

   private final String v;

    Rating(String v) {
        this.v = v;
    }

    public String getV() {
        return v;
    }
}
