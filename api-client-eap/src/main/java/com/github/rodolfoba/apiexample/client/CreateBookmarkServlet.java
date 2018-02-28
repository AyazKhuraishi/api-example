package com.github.rodolfoba.apiexample.client;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.ProxyFactory;
import org.jboss.resteasy.client.exception.ResteasyClientException;

import com.github.rodolfoba.apiexample.BookmarkApi;
import com.github.rodolfoba.apiexample.BookmarkInfo;

@WebServlet("/create")
public class CreateBookmarkServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BookmarkApi proxy = ProxyFactory.create(BookmarkApi.class, "http://localhost:8081/backend/api");
        PrintWriter writer = resp.getWriter();
        try {
            Response response = proxy.create(new BookmarkInfo("Bookmark", "http://www.bookmark.com"));
            writer.print("Status code: " + response.getStatus());
        } catch (ResteasyClientException e) {
            writer.println("ResteasyClientException: " + e.getMessage());
            writer.println("Cause: " + e.getCause());
            e.printStackTrace(writer);
        }
    }

}
