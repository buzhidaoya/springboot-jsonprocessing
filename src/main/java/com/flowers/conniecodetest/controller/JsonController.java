package com.flowers.conniecodetest.controller;

import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.flowers.conniecodetest.model.Entries;
import com.flowers.conniecodetest.model.Entry;
import com.flowers.conniecodetest.service.EntryService;
import com.flowers.conniecodetest.service.EntryServiceImpl;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.util.*;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;


@RestController
public class JsonController {

    @Autowired
    ObjectMapper mapper;

    EntryService entryService = new EntryServiceImpl();

    @RequestMapping("/newentry")
    public Entry newEntry() {
        // TO DO: Use hashmap to store and represent.
        return new Entry(1000, 200, "Title", "What's in the body? Product review?");
    }

    @RequestMapping(value = "/", method = GET, produces = "application/json")
    public Collection<Entry> jsonToObject() {
        try {
            mapper = new ObjectMapper();
            File file = new File("/Users/xiaochengjiang/Documents/自学/springboot-jsonprocessing/src/main/java/com/flowers/conniecodetest/entriesJSON.json");
            Entry[] entry = mapper.readValue(file, Entry[].class);
            for (Entry e : entry) {
                entryService.createEntry(e);
            }
            return entryService.getEntry();
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "countuser", method = GET, produces = "application/json")
    public ResponseEntity<Integer> countuser() {
            int count = 0;
            Set<Integer> uniqueUserId = new HashSet<>();
            for (Entry entry : entryService.getEntry()) {
                if (uniqueUserId.add(entry.getUserId())) {
                    count++;
                }
            }
            return new ResponseEntity<>(count, HttpStatus.OK);
    }

    @RequestMapping(value = "update/{id}", produces = "application/json")
    public Entry update(@PathVariable int id) {
        Entry entryWithId = entryService.findById(id);
        if (id == 4) {
            entryService.updateEntry(id, entryWithId.getUserId(), "1800Flowers", "1800Flowers");
        }
        return entryWithId;
    }
}
