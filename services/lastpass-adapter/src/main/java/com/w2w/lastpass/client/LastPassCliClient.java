package com.w2w.lastpass.client;

import com.w2w.lastpass.client.infrastructure.LastPassClient;
import com.w2w.lastpass.process.runner.Runner;
import org.springframework.stereotype.Component;
import java.io.IOException;

@Component
public class LastPassCliClient implements LastPassClient {

    private final Runner runner;

    public LastPassCliClient(Runner runner) {
        this.runner = runner;
    }

    public String listAllItems() {
        try {
            return runner.execute(CliCommand.LIST_ALL_ITEMS.getCommand());
        } catch (IOException e) {
            throw new LastPassClientException("", e);
        }
    }
}
