package org.jboss.errai.demo.server.index.service;

import java.util.Calendar;

import org.jboss.errai.bus.server.annotations.Service;
import org.jboss.errai.demo.client.shared.index.services.PrintService;

@Service
public class PrintServiceImpl implements PrintService {
    @Override
    public String print() {
        return "Server year: " + Calendar.getInstance().get(Calendar.YEAR);
    }
}
