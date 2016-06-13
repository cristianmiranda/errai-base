package org.errai.mvp.server.about.service;

import java.util.Calendar;

import org.errai.mvp.client.shared.about.services.PrintService;
import org.jboss.errai.bus.server.annotations.Service;

@Service
public class PrintServiceImpl implements PrintService {
    @Override
    public String print() {
        return "Server year: " + Calendar.getInstance().get(Calendar.YEAR);
    }
}
