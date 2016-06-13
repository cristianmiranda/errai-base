package org.errai.mvp.client.local.common.mvp;

import java.lang.annotation.Annotation;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.errai.mvp.client.local.common.mvp.places.EntryPlace;
import org.errai.mvp.client.local.common.mvp.places.PlaceManager;
import org.errai.mvp.client.local.common.mvp.places.PlaceRequest;
import org.errai.mvp.client.shared.common.mvp.Presenter;
import org.jboss.errai.ioc.client.api.EntryPoint;
import org.jboss.errai.ioc.client.container.IOCBeanDef;
import org.jboss.errai.ioc.client.container.SyncBeanManager;
import org.jboss.errai.ui.nav.client.local.DefaultPage;
import org.jboss.errai.ui.nav.client.local.Page;

import com.google.gwt.user.client.ui.Composite;

@EntryPoint
@Page(role = DefaultPage.class)
public class Root extends Composite {
    @Inject
    private PlaceManager placeManager;
    @Inject
    private SyncBeanManager beanManager;

    @PostConstruct
    public void init() {
        EntryPlace annotation = new EntryPlace() {
            @Override
            public Class<? extends Annotation> annotationType() {
                return EntryPlace.class;
            }
        };
        IOCBeanDef<? extends Presenter> bean = beanManager.lookupBean(Presenter.class, annotation);
        Presenter presenter = bean.getInstance();
        placeManager.reveal(new PlaceRequest.Builder().to(presenter.getPlace()).build());
    }
}
