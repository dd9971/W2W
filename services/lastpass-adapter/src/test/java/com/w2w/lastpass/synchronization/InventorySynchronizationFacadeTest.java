package com.w2w.lastpass.synchronization;

import com.w2w.lastpass.mock.StubLastPassClient;
import com.w2w.lastpass.mock.StubReader;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InventorySynchronizationFacadeTest {

    private InventorySynchronizationFacade inventorySynchronizationFacade;
    private StubLastPassClient lastPassClient;
    private StubReader reader;

    @BeforeEach
    void setUp() {
        lastPassClient = new StubLastPassClient();
        reader = new StubReader();
        inventorySynchronizationFacade = new InventorySynchronizationFacade(
                lastPassClient,
                reader
        );
    }

    @Test
    @DisplayName("Should synchronize inventory successfully")
    void test01() {
        //given
        var item1 = InventoryItem.builder()
                .build();
        reader.addInventoryItem(item1);
        //when
        var result = inventorySynchronizationFacade.synchronizeInventory();
        //then
        assertThat(result).isNotEmpty();
    }

    @Test
    @DisplayName("Should last pass client output be correct")
    void test02() {
        //given
        var clieentOutput = "item1\nitem2\nitem3";
        lastPassClient.setListAllString(clieentOutput);
        var item1 = InventoryItem.builder()
                .build();
        reader.addInventoryItem(item1);
        //when
        inventorySynchronizationFacade.synchronizeInventory();
        //then
        assertThat(reader.getAllItemsString()).isEqualTo(clieentOutput);
    }
}