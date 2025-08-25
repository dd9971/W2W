package com.w2w.lastpass.process.runner;

import java.io.IOException;

public interface Runner {

    String execute(String command) throws IOException;
}
