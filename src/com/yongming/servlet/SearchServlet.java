package com.yongming.servlet;

import com.yongming.model.poetoryModel;
import com.yongming.service.PoetService;
import com.yongming.service.PoetiesService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiangyongming on 4/5/16.
 */
public class SearchServlet extends HttpServlet {

    private PoetiesService poetiesService = new PoetiesService();

    /**
     * Define session
     */
    private HttpSession session;

    public SearchServlet() {
    }

    /**
     * override doPost
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String content = request.getParameter("content");
        String method = request.getParameter("method");

        session = request.getSession();

        /**
         * 根据选择的查询的方法:
         * 1)query by title return content
         * 2)query by author return title list
         * 3)query by content return all information list
         */
        if (method.equals("title")) {
            showInformationByTitle(content, request, response);
        } else if (method.equals("author")) {

            showInformationByAuthor(content, request, response);

        } else {
            showAllByContent(content, request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }


    /**
     * query by title
     *
     * @param title
     * @param request
     * @param response
     */
    private void showInformationByTitle(String title, HttpServletRequest request, HttpServletResponse response) {
        com.yongming.model.poetoryModel poetory = new PoetiesService().queryPoetryByTitle(title);

        session.setAttribute("poetoriesContent", poetory);
        try {
            response.sendRedirect("/displayContent.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    /**
     * query by author name
     *
     * @param name
     * @param request
     * @param response
     */
    private void showInformationByAuthor(String name, HttpServletRequest request, HttpServletResponse response) {
        com.yongming.model.poetModel poet = new PoetService().queryInformationByname(name);

        List<poetoryModel> list = poetiesService.queryPoetryByUid(poet.getId());

        session.setAttribute("poetoriesTitle", list);
        try {
            response.sendRedirect("/display.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * query by content
     *
     * @param content
     * @param request
     * @param response
     */
    private void showAllByContent(String content, HttpServletRequest request, HttpServletResponse response) {

        List<poetoryModel> list = poetiesService.queryPoertiesByContent(content);

        session.setAttribute("poetoriesAll", list);

        try {
            response.sendRedirect("/displayAll.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
