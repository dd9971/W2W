package com.w2w.api.inventorysynchronization;

import com.w2w.api.core.WalletType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class InventorySynchronizationFacadeTest {

    InventorySynchronizationFacade inventorySynchronizationFacade;

    @BeforeEach
    void setUp() {
        inventorySynchronizationFacade = new InventorySynchronizationFacade();
    }

    @Test
    @DisplayName("Should return items list")
    void test01() {
        //given

        //when
        var result = inventorySynchronizationFacade.startTask(WalletType.LASTPASS);

        //then
        assertThat(result).isNotEmpty();
    }
}