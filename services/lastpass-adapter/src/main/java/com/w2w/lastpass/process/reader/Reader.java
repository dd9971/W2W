package com.w2w.lastpass.process.reader;

import com.w2w.lastpass.synchronization.DetailedItem;
import com.w2w.lastpass.synchronization.InventoryItem;
import java.util.List;

public interface Reader {

    List<DetailedItem> parseSingleOutput(String outputString);

    List<InventoryItem> itemList(String allItemsString);
}
