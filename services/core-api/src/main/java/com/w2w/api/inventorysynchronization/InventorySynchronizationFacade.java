package com.w2w.api.inventorysynchronization;

import com.w2w.api.core.WalletType;
import com.w2w.api.inventorysynchronization.model.InventoryItem;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InventorySynchronizationFacade {

    public List<InventoryItem> startTask(WalletType walletType) {
        return List.of(new InventoryItem());
    }
}
