package org.errai.mvp.client.shared.about.services;

import org.jboss.errai.bus.server.annotations.Remote;

@Remote
public interface PrintService {
    String print();
}
