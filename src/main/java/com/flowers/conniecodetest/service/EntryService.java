package com.flowers.conniecodetest.service;


import com.flowers.conniecodetest.model.Entry;

import java.util.Collection;
import java.util.List;

public interface EntryService {
    abstract void createEntry(Entry entry);
    abstract void updateEntry(int id, int userId, String title, String body);
    abstract Collection<Entry> getEntry();
    abstract Entry findById(int id);
}
