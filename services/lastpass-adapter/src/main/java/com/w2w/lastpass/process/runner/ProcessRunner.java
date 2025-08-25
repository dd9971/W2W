package com.w2w.lastpass.process.runner;

import org.springframework.stereotype.Component;
import java.io.IOException;

@Component
public class ProcessRunner implements Runner {

    @Override
    public String execute(String command) throws IOException {
        var processBuilder = new ProcessBuilder(command);
        var started = processBuilder.start();
        var inputStream = started.getInputStream();
        return new String(inputStream.readAllBytes());
    }
}
