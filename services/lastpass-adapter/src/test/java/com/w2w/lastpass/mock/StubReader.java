package com.w2w.lastpass.mock;

import com.w2w.lastpass.process.reader.Reader;
import com.w2w.lastpass.synchronization.DetailedItem;
import com.w2w.lastpass.synchronization.InventoryItem;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class StubReader implements Reader {

    private DetailedItem detailedItem;
    private List<InventoryItem> inventoryItems = new ArrayList<>();
    private String singleItemString;
    private String allItemsString;

    @Override
    public DetailedItem parseSingleOutput(String singleItemString) {
        this.singleItemString = singleItemString;
        return detailedItem;
    }

    @Override
    public List<InventoryItem> itemList(String allItemsString) {
        this.allItemsString = allItemsString;
        return inventoryItems;
    }

    public void addInventoryItem(InventoryItem item) {
        inventoryItems.add(item);
    }
}
