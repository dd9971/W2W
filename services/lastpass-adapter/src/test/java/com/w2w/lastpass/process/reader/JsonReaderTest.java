package com.w2w.lastpass.process.reader;

import com.w2w.lastpass.synchronization.InventoryItem;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class JsonReaderTest {

    private Reader reader;

    @BeforeEach
    void setUp() {
        reader = new JsonReader();
    }

    @Test
    @DisplayName("Should map JSON data to a inventory detailed items")
    void test01() {
        //given
        var userName = "user_test_name";
        var name = "test_name";
        var password = "tEsT_pAssw0rd!";
        var jsonData = """
                [
                  {
                    "id": "6967969624364529912",
                    "name": "%s",
                    "fullname": "10.30.1.722",
                    "username": "%s",
                    "password": "%s",
                    "last_modified_gmt": "1727345831",
                    "last_touch": "1727347672",
                    "group": "",
                    "url": "https://10.30.1.722/ui/",
                    "note": ""
                  }
                ]
                """
                .formatted(name, userName, password);
        //when
        var result = reader.parseSingleOutput(jsonData);
        //then
        assertThat(result).isNotEmpty();
        assertThat(result.getFirst().getUsername()).isEqualTo(userName);
        assertThat(result.getFirst().getName()).isEqualTo(name);
        assertThat(result.getFirst().getPassword()).isEqualTo(password);
    }

    @Test
    @DisplayName("Should map JSON data to a inventory items list")
    void test02() {
        //given
        var record1 = InventoryItem.builder()
                .id("6967969624364529912")
                .name("Bank account")
                .directoryName("Emails")
                .build();
        var jsonData = """
                %s
                    2024-08-13 06:31 %s [id: %s] [username: %s]
                    2025-01-24 11:34 Google Cloud [id: 2437705590293748911] [username: test001@gmail.com]
                    2025-06-20 07:30 AWS EC2 [id: 7117123742006759517] [username: test_email@gmail.com]
                COMPANY
                    2024-08-13 06:31 10.30.1.118 [id: 3169206450851580384] [username: admin]
                    2024-08-13 06:31 JENKINS [id: 3284369722142577393] [username: root]
                    2024-08-13 06:31 JIRA [id: 3128993832990916726] [username:test_jira@gmail.com]
                """.formatted(record1.getDirectoryName(), record1.getName(), record1.getId(), record1.getUserName());

        //when
        var result = reader.itemList(jsonData);

        //then
        assertThat(result).isNotEmpty();
        assertThat(result.getFirst().getName()).isEqualTo(record1.getName());
        assertThat(result.getFirst().getId()).isEqualTo(record1.getId());
        assertThat(result.getFirst().getDirectoryName()).isEqualTo(record1.getDirectoryName());
        assertThat(result.getFirst().getUserName()).isEqualTo("null");
        assertThat(result.get(4).getDirectoryName()).isEqualTo("COMPANY");

    }
}