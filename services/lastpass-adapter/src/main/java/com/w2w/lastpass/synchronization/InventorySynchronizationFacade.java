package com.w2w.lastpass.synchronization;

import com.w2w.lastpass.client.infrastructure.LastPassClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class InventorySynchronizationFacade {

    private final LastPassClient lastPassClient;

}
