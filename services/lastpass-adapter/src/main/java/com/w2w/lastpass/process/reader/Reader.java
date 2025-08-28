package com.w2w.lastpass.process.reader;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.w2w.lastpass.synchronization.DetailedItem;
import com.w2w.lastpass.synchronization.InventoryItem;
import java.util.List;

public interface Reader {

    DetailedItem parseSingleOutput(String outputString) throws JsonProcessingException;

    List<InventoryItem> itemList(String allItemsString);
}
