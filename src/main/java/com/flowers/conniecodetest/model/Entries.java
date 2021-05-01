package com.flowers.conniecodetest.model;

import java.util.ArrayList;
import java.util.List;

public class Entries {
    private List<Entry> entries;

    public Entries () {
        this.entries = new ArrayList<>();
    }


    public List<Entry> getEntries() {
        return entries;
    }

    public void setEntries(List<Entry> entries) {
        this.entries = entries;
    }
}
