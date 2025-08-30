package com.w2w.api.controller;

import com.w2w.api.core.WalletType;
import com.w2w.api.inventorysynchronization.InventorySynchronizationFacade;
import com.w2w.api.inventorysynchronization.model.InventoryItem;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TaskController {

    InventorySynchronizationFacade inventorySynchronizationFacade;

    @GetMapping("/start-inventory-synchronization")
    public List<InventoryItem> startInventorySynchronization(@RequestParam WalletType walletType) {
        return inventorySynchronizationFacade.startTask(walletType);
    }
}
