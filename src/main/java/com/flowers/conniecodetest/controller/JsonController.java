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

    Entries entryList = new Entries();

    @RequestMapping("/newentry")
    public Entry newEntry() {
        // TO DO: Use hashmap to store and represent.
        return new Entry(1000, 200, "Title", "What's in the body? Product review?");
    }

    @RequestMapping(value = "/", method = GET, produces = "application/json")
    public ResponseEntity<String> jsonToObject() {
        try {
            mapper = new ObjectMapper();
            File file = new File("/Users/xiaochengjiang/Documents/自学/springboot-jsonprocessing/src/main/java/com/flowers/conniecodetest/entriesJSON.json");
            Entry[] entry = mapper.readValue(file, Entry[].class);
            entryList.setEntries(Arrays.asList(entry));
//            return entryList;
            return new ResponseEntity<>("Success!", HttpStatus.OK);
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        return null;
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "countuser", method = GET, produces = "application/json")
    public ResponseEntity<Integer> countuser() {
//        try {
            // TO DO: Use list for now. Can change to hashmap. Will do caching later.
//            mapper = new ObjectMapper();
//            JavaType type = mapper.getTypeFactory().constructParametricType(Collection.class, Entry.class);
//            Collection<Entry> list = mapper.readValue(
//                    new File("/Users/xiaochengjiang/Documents/自学/conniecodetest/src/main/java/com/flowers/conniecodetest/entriesJSON.json"),
//                    type);
            int count = 0;
            Set<Integer> uniqueUserId = new HashSet<>();
            for (Entry entry : entryList.getEntries()) {
                if (uniqueUserId.add(entry.getUserId())) {
                    count++;
                }
            }
            return new ResponseEntity<>(count, HttpStatus.OK);
//        } catch (JsonParseException e) {
//            e.printStackTrace();
//        } catch (JsonMappingException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "update/{id}", produces = "application/json")
    public Entry update(@PathVariable int id) {
        // TO DO: Currently use a list. Will try a hashmap instead when it works. Will do caching later.
//        try {
//            mapper = new ObjectMapper();
//            File file = new File("/Users/xiaochengjiang/Documents/自学/conniecodetest/src/main/java/com/flowers/conniecodetest/entriesJSON.json");
//            Entry[] entry = mapper.readValue(file, Entry[].class);
//            Entry entryWithId = entry[id - 1];
        Entry entryWithId = entryList.getEntries().get(id - 1);
        if (id == 4) {
            entryWithId.setTitle("1800Flowers");
            entryWithId.setBody("1800Flowers");
        }
        return entryWithId;
//        } catch (JsonParseException e) {
//            e.printStackTrace();
//        } catch (JsonMappingException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return new Entry();
    }
}
