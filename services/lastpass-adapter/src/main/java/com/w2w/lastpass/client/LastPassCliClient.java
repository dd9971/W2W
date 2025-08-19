package com.w2w.lastpass.client;

import com.w2w.lastpass.client.infrastructure.LastPassClient;
import org.springframework.context.annotation.Primary;
import org.springframework.web.context.annotation.ApplicationScope;

@ApplicationScope
@Primary
public class LastPassCliClient implements LastPassClient {
}
