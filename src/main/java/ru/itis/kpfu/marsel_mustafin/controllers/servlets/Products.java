package ru.itis.kpfu.marsel_mustafin.controllers.servlets;

import ru.itis.kpfu.marsel_mustafin.controllers.db.ProductDAO;
import ru.itis.kpfu.marsel_mustafin.models.Product;

import javax.servlet.http.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class Products extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) {
        try {
            rq.setAttribute("imgpath", getServletContext().getInitParameter("file_upload"));
            ProductDAO dao = new ProductDAO();
            List<Product> all = dao.getAll();
            int pages = all.size() / 10 + 1;
            rq.setAttribute("pages", pages);
            int page = Integer.parseInt(rq.getParameter("page"));
            int end = page * 10 < all.size() ? page * 10 : all.size();
            int start = 10 * (page - 1);
            LinkedList<Product> products = new LinkedList<Product>(all.subList(start, end));
            rq.setAttribute("products", products);
            rq.getRequestDispatcher("/views/products.jsp").forward(rq, rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) {

    }
}
