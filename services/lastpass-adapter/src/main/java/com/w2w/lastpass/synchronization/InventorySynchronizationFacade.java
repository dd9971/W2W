package com.w2w.lastpass.synchronization;

import com.w2w.lastpass.client.infrastructure.LastPassClient;
import com.w2w.lastpass.process.reader.Reader;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


@Service
@AllArgsConstructor
public class InventorySynchronizationFacade {

    private final LastPassClient lastPassClient;
    private final Reader reader;

    public List<DetailedItem> synchronizeInventory() {
        var allItemsString = lastPassClient.listAllItems();
        var allItems = reader.itemList(allItemsString);
        var result = reader.parseSingleOutput(allItemsString);
        if (result.isEmpty()) {
            throw new InventorySynchronizationException("Failed to parse inventory output. " + allItemsString);
        }
        return new ArrayList<>();
    }
}
