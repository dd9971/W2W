package com.w2w.lastpass.synchronization;

import com.w2w.lastpass.client.infrastructure.LastPassClient;
import com.w2w.lastpass.process.reader.Reader;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.List;


@Service
@AllArgsConstructor
@Log4j2
public class InventorySynchronizationFacade {

    private final LastPassClient lastPassClient;
    private final Reader reader;

    public List<InventoryItem> synchronizeInventory() {
        String allItemsString = null;
        try {
            allItemsString = lastPassClient.listAllItems();
        } catch (IOException e) {
            throw new InventorySynchronizationException("Failed to fetch items from LastPass", e);
        }
        var allItems = reader.itemList(allItemsString);
        if (allItems.isEmpty()) {
            log.error("No items found in LastPass. Check your LastPass resources and try again.");
            return List.of();
        }
        return allItems;
    }
}
