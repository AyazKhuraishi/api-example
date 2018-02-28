package com.github.rodolfoba.apiexample.client;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import com.github.rodolfoba.apiexample.BookmarkApi;
import com.github.rodolfoba.apiexample.BookmarkInfo;

@WebServlet("/create")
public class CreateBookmarkServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target("http://localhost:8080/backend/api");
        
        BookmarkApi proxy = target.proxy(BookmarkApi.class);
        BookmarkInfo bookmarkInfo = new BookmarkInfo("Bookmark", "http://www.bookmark.com");
        Response response = proxy.create(bookmarkInfo);
        
        PrintWriter writer = resp.getWriter();
        writer.print("Status code: " + response.getStatus());
    }

}
