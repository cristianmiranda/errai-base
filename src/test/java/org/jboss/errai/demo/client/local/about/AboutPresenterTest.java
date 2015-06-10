/*
 * Copyright (c) 2014 by Lille Group, Inc., All rights reserved.
 * This source code, and resulting software, is the confidential and proprietary information
 * ("Proprietary Information") and is the intellectual property ("Intellectual Property")
 * of Lille Group, Inc. ("The Company"). You shall not disclose such Proprietary Information and
 * shall use it only in accordance with the terms and conditions of any and all license
 * agreements you have entered into with The Company.
 */

package org.jboss.errai.demo.client.local.about;

import org.jboss.errai.common.client.api.Caller;
import org.jboss.errai.demo.client.local.common.Place;
import org.jboss.errai.demo.client.local.common.mvp.PresenterTest;
import org.jboss.errai.demo.client.local.common.mvp.places.PlaceManager;
import org.jboss.errai.demo.client.local.common.mvp.places.PlaceRequest;
import org.jboss.errai.demo.client.shared.about.services.PrintService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class AboutPresenterTest extends PresenterTest {
    @InjectMocks
    private AboutPresenter presenter;

    @Mock
    private AboutPresenter.MyView view;
    @Mock
    private Caller<PrintService> printServiceDelegate;
    @Mock
    private PlaceManager placeManager;

    @Test
    public void testingResponse() {
        // given
        String response = "Response from Server";
        givenSuccess(PrintService.class, printServiceDelegate, response);

        // when
        presenter.print();

        // then
        PlaceRequest placeRequest = new PlaceRequest.Builder().to(Place.INDEX).with("Response", response).build();
        verify(placeManager).reveal(placeRequest);
        // verify(view).show("About + Response");
        // verify(view).show("About + Response");
    }
}
