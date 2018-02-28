package com.github.rodolfoba.apiexample.backend;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import com.github.rodolfoba.apiexample.Bookmark;
import com.github.rodolfoba.apiexample.BookmarkApi;
import com.github.rodolfoba.apiexample.BookmarkId;
import com.github.rodolfoba.apiexample.BookmarkInfo;
import com.github.rodolfoba.apiexample.ErrorResponseEntity;

public class BookmarkRestApi implements BookmarkApi {

    @Context
    private UriInfo uriInfo;

    @Override
    public Response create(BookmarkInfo bookmarkInfo) {
        System.out.println(bookmarkInfo);
        String id = UUID.randomUUID().toString();
        URI location = uriInfo.getRequestUriBuilder().path(id).build();
        return Response.created(location).entity(new BookmarkId(id))
                .header("x-request-id", UUID.randomUUID().toString()).build();
    }

    @Override
    public Response update(String id, BookmarkInfo bookmarkInfo) {
        if ("400".equals(id)) {
            ErrorResponseEntity entity = new ErrorResponseEntity("BAD_REQUEST", "Invalid bookmark data");
            throw new WebApplicationException(Response.status(Status.BAD_REQUEST).entity(entity).build());
        }

        if ("404".equals(id)) {
            ErrorResponseEntity entity = new ErrorResponseEntity("NOT_FOUND", "Id not found");
            throw new WebApplicationException(Response.status(Status.NOT_FOUND).entity(entity).build());
        }

        if ("500".equals(id)) {
            ErrorResponseEntity entity = new ErrorResponseEntity("INTERNAL_SERVER_ERROR",
                    "Internal server error, try again.");
            throw new WebApplicationException(Response.serverError().entity(entity).build());
        }

        return Response.ok().build();
    }

    @Override
    public Response delete(String id) {
        if ("400".equals(id)) {
            ErrorResponseEntity entity = new ErrorResponseEntity("BAD_REQUEST", "Invalid bookmark data");
            throw new WebApplicationException(Response.status(Status.BAD_REQUEST).entity(entity).build());
        }

        if ("404".equals(id)) {
            ErrorResponseEntity entity = new ErrorResponseEntity("NOT_FOUND", "Id not found");
            throw new WebApplicationException(Response.status(Status.NOT_FOUND).entity(entity).build());
        }

        if ("500".equals(id)) {
            ErrorResponseEntity entity = new ErrorResponseEntity("INTERNAL_SERVER_ERROR",
                    "Internal server error, try again.");
            throw new WebApplicationException(Response.serverError().entity(entity).build());
        }

        return Response.ok().build();
    }

    @Override
    public Response getById(String id) {
        if ("400".equals(id)) {
            ErrorResponseEntity entity = new ErrorResponseEntity("BAD_REQUEST", "Invalid bookmark data");
            throw new WebApplicationException(Response.status(Status.BAD_REQUEST).entity(entity).build());
        }

        if ("404".equals(id)) {
            ErrorResponseEntity entity = new ErrorResponseEntity("NOT_FOUND", "Id not found");
            throw new WebApplicationException(Response.status(Status.NOT_FOUND).entity(entity).build());
        }

        if ("500".equals(id)) {
            ErrorResponseEntity entity = new ErrorResponseEntity("INTERNAL_SERVER_ERROR",
                    "Internal server error, try again.");
            throw new WebApplicationException(Response.serverError().entity(entity).build());
        }

        Bookmark bookmark = new Bookmark(new BookmarkId(id), "Bookmark", "http://www.bookmark.com");
        return Response.ok(bookmark).build();
        
    }

    @Override
    public Response findByName(String name) {
        if ("BAD_REQUEST".equalsIgnoreCase(name)) {
            ErrorResponseEntity entity = new ErrorResponseEntity("BAD_REQUEST", "Invalid bookmark data");
            throw new WebApplicationException(Response.status(Status.BAD_REQUEST).entity(entity).build());
        }

        if ("NOT_FOUND".equalsIgnoreCase(name)) {
            ErrorResponseEntity entity = new ErrorResponseEntity("NOT_FOUND", "Id not found");
            throw new WebApplicationException(Response.status(Status.NOT_FOUND).entity(entity).build());
        }

        if ("INTERNAL_SERVER_ERROR".equalsIgnoreCase(name)) {
            ErrorResponseEntity entity = new ErrorResponseEntity("INTERNAL_SERVER_ERROR",
                    "Internal server error, try again.");
            throw new WebApplicationException(Response.serverError().entity(entity).build());
        }

        
        Bookmark bookmark1 = new Bookmark(new BookmarkId(UUID.randomUUID().toString()), "Bookmark One", "http://www.bookmark1.com");
        Bookmark bookmark2 = new Bookmark(new BookmarkId(UUID.randomUUID().toString()), "Bookmark Two", "http://www.bookmark2.com");
        List<Bookmark> bookmarks = new ArrayList<>();
        bookmarks.add(bookmark1);
        bookmarks.add(bookmark2);
        
        return Response.ok(bookmarks).build();
    }
}
