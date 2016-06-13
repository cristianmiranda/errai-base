package org.errai.mvp.server.about.service;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.errai.mvp.client.shared.about.model.UserComplaint;
import org.errai.mvp.client.shared.about.services.UserComplaintService;
import org.errai.mvp.server.about.dao.UserComplaintDao;

/**
 * A stateless EJB implementing the REST endpoint to create, update and delete {@link UserComplaint}
 * objects.
 */
@Stateless
public class UserComplaintServiceImpl implements UserComplaintService {

    @Inject
    private Event<UserComplaint> created;

    @Inject
    private UserComplaintDao complaintDao;

    @Override
    public Response create(UserComplaint entity) {
        complaintDao.create(entity);
        created.fire(entity);
        return Response.created(UriBuilder.fromResource(UserComplaintService.class)
                .path(String.valueOf(entity.getId())).build()).build();
    }

    @Override
    public Response update(Long id, UserComplaint entity) {
        complaintDao.update(id, entity);
        return Response.noContent().build();
    }

    @Override
    public Response delete(Long id) {
        complaintDao.delete(id);
        return Response.noContent().build();
    }
}
