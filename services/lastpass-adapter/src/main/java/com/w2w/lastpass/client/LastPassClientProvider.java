package com.w2w.lastpass.client;

import com.w2w.lastpass.client.infrastructure.ClientProvider;
import com.w2w.lastpass.client.infrastructure.LastPassClient;

public class LastPassClientProvider implements ClientProvider {

    @Override
    public LastPassClient createClient() {
        return new LastPassCliClient();
    }
}
