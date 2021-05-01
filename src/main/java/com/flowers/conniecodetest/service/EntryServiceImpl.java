package com.flowers.conniecodetest.service;

import com.flowers.conniecodetest.model.Entry;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EntryServiceImpl implements EntryService {
    protected static Map<Integer, Entry> entryMap;

    public EntryServiceImpl() {
        entryMap = new HashMap<>();
    }

    @Override
    public void createEntry(Entry entry) {
        if (entryMap.containsKey(entry.getId())) return;
        entryMap.put(entry.getId(), entry);
    }

    @Override
    public void updateEntry(int id, int userId, String title, String body) {
        if (!entryMap.containsKey(id)) return;
        Entry oldEntry = entryMap.get(id);
        if (oldEntry.getUserId() != userId) {
            oldEntry.setUserId(userId);
        }
        if (oldEntry.getTitle() != title) {
            oldEntry.setTitle(title);
        }
        if (oldEntry.getBody() != body) {
            oldEntry.setBody(body);
        }
        entryMap.put(id, oldEntry);
    }

    @Override
    public Collection<Entry> getEntry() {
        return entryMap.values();
    }

    @Override
    public Entry findById(int id) {
        if (!entryMap.containsKey(id)) return null;
        return entryMap.get(id);
    }
}
