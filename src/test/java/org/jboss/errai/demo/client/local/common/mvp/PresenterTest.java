package org.jboss.errai.demo.client.local.common.mvp;

import org.jboss.errai.common.client.api.Caller;
import org.jboss.errai.common.client.api.ErrorCallback;
import org.jboss.errai.common.client.api.RemoteCallback;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author Cristian Miranda
 * @since 6/6/15 - 16:50
 */
public abstract class PresenterTest {
    protected <T> void givenSuccess(final Class<T> service, final Caller<T> serviceDelegate) {
        when(serviceDelegate.call()).thenAnswer(new Answer<Object>() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                return mock(service);
            }
        });
    }

    protected <T> void givenSuccess(final Class<T> service, final Caller<T> serviceDelegate, final Object response) {
        when(serviceDelegate.call(any(RemoteCallback.class))).thenAnswer(new Answer<Object>() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                ((RemoteCallback) invocation.getArguments()[0]).callback(response);
                return mock(service);
            }
        });
    }

    protected <T> void givenFailure(final Class<T> service, final Caller<T> serviceDelegate, final Object object,
                                    final Throwable throwable) {
        when(serviceDelegate.call(any(RemoteCallback.class), any(ErrorCallback.class)))
                .thenAnswer(new Answer<Object>() {
                    @Override
                    public Object answer(InvocationOnMock invocation) throws Throwable {
                        ((ErrorCallback) invocation.getArguments()[1]).error(object, throwable);
                        return mock(service);
                    }
                });
    }
}
