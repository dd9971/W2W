package com.w2w.lastpass.process.reader;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.w2w.lastpass.synchronization.DetailedItem;
import com.w2w.lastpass.synchronization.InventoryItem;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class JsonReader implements Reader {

    private final ObjectMapper objectMapper;
    private static final Pattern PATTERN = Pattern.compile("\\d{4}-\\d{2}-\\d{2}\\s+\\d{2}:\\d{2}\\s+(.*?)\\s+\\[id:\\s*(\\d+)\\]\\s+\\[username: ?(.*?)\\]");

    public JsonReader() {
        objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    @Override
    public DetailedItem parseSingleOutput(String outputString) throws JsonProcessingException {
            List<DetailedItem> items = objectMapper.readValue(outputString, new TypeReference<List<DetailedItem>>() {});
            if (items.isEmpty()) {
                throw new JsonReaderException("No DetailedItem found in the output");
            }
            if (items.size() > 1) {
                throw new JsonReaderException("Multiple DetailedItem found in the output");
            }
            return items.get(0);
    }

    @Override
    public List<InventoryItem> itemList(String allItemsString) {
        List<InventoryItem> result = new ArrayList<>();

        String currentDirectory = null;
        for (String line : allItemsString.split("\\R")) {
            line = line.trim();
            if (line.isEmpty()) continue;
            if (!line.contains("[id:")) {
                currentDirectory = line;
                continue;
            }
            Matcher matcher = PATTERN.matcher(line);
            if (matcher.find()) {
                InventoryItem item = new InventoryItem();
                item.setName(matcher.group(1).trim());
                item.setId(matcher.group(2).trim());
                item.setUserName(matcher.group(3).trim());
                item.setDirectoryName(currentDirectory);
                result.add(item);
            }
        }
        return result;
    }
}
