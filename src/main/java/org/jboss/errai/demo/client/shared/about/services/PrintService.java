package org.jboss.errai.demo.client.shared.about.services;

import org.jboss.errai.bus.server.annotations.Remote;

@Remote
public interface PrintService {
    String print();
}
