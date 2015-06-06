package org.jboss.errai.demo.client.shared.index.services;

import org.jboss.errai.bus.server.annotations.Remote;

@Remote
public interface PrintService {
    String print();
}
