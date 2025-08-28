package com.w2w.lastpass.mock;

import com.w2w.lastpass.client.infrastructure.LastPassClient;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class StubLastPassClient implements LastPassClient {

    private String listAllString;

    @Override
    public String listAllItems() {
        return listAllString;
    }
}
