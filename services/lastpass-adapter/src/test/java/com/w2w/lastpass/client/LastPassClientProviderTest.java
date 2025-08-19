package com.w2w.lastpass.client;

import com.w2w.lastpass.client.infrastructure.LastPassCli;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LastPassClientProviderTest {

    private LastPassClientProvider lastPassClientProvider;

    @BeforeEach
    void setup() {
        lastPassClientProvider = new LastPassClientProvider();
    }

    @Test
    @DisplayName("Should create a LastPassClient instance")
    void test01(){
        //given

        //when
        LastPassCli result = lastPassClientProvider.createClient();
        //then
        assertThat(result).isNotNull();
    }
}