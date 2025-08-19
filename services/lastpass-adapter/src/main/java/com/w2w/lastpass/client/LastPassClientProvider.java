package com.w2w.lastpass.client;

import com.w2w.lastpass.client.infrastructure.ClientProvider;
import com.w2w.lastpass.client.infrastructure.LastPassCli;

public class LastPassClientProvider implements ClientProvider {

    @Override
    public LastPassCli createClient() {
        return new LastPassClient();
    }
}
