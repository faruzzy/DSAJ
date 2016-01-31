package com.faruzzy.dsaj.chpt3;

/**
 * Created by faruzzy on 1/26/16.
 */
public class DNodeString {
    private DNodeString prev, next;
    private String value;

    public DNodeString(String v, DNodeString p, DNodeString n) {
        value = v;
        prev = p;
        next = n;
    }

    public DNodeString(String v) {
        this(v, null, null);
    }

    public void setValue(String v) { value = v; }

    public String getValue() { return value; }

    public void setPrev(DNodeString n) { prev = n; }

    public DNodeString getPrev() { return prev; }

    public void setNext(DNodeString n) { next = n; }

    public DNodeString getNext() { return next; }
}
