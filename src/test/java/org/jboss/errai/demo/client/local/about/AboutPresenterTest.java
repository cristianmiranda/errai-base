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
import org.jboss.errai.demo.client.local.common.mvp.PresenterTest;
import org.jboss.errai.demo.client.shared.index.services.PrintService;
import org.junit.Before;
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

    @Before
    public void setUp() {
        presenter.setView(view);
    }

    @Test
    public void testingResponse() {
        // given
        givenSuccess(PrintService.class, printServiceDelegate, "Response");

        // when
        presenter.print();

        // then
        verify(view).show("About + Response");
        verify(view).show("About + Response");
    }
}
