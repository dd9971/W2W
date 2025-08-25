package com.w2w.lastpass.synchronization;

import lombok.val;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InventorySynchronizationFacadeTest {

    private InventorySynchronizationFacade inventorySynchronizationFacade;

    @BeforeEach
    void setUp() {
        inventorySynchronizationFacade = new InventorySynchronizationFacade(
                null,
                null
        );
    }

    @Test
    @DisplayName("")
    void test01(){
        //given

        //when
        var result = inventorySynchronizationFacade.synchronizeInventory();
        //then
        assertThat(result).isNotNull();
    }
}