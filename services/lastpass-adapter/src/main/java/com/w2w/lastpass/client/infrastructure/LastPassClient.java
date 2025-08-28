package com.w2w.lastpass.client.infrastructure;

import java.io.IOException;

public interface LastPassClient {

    String listAllItems() throws IOException;

}
