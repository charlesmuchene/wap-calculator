package com.charlesmuchene.calculator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CalculatorServlet", urlPatterns = "/calculator")
public class CalculatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        Pair<String> addPair = getPairParameters(request, "addFirst", "addSecond");
        Pair<String> multiplyPair = getPairParameters(request, "multiplyFirst", "multiplySecond");

        String result = performBusinessLogic(addPair, multiplyPair);
        RequestDispatcher dispatcher = request.getRequestDispatcher(result);
        dispatcher.forward(request, response);
    }

    /**
     * Perform business logic
     *
     * @param addPair      {@link Pair} of addition values
     * @param multiplyPair {@link Pair} of multiplication values
     * @return Output string
     */
    private String performBusinessLogic(Pair<String> addPair, Pair<String> multiplyPair) {
        StringBuilder builder = new StringBuilder("index.jsp?");

        String addResult = performAddition(addPair);
        builder.append("addResult=");
        if (addResult != null) builder.append(addResult);

        String multiplyResult = performMultiplication(multiplyPair);
        if (builder.lastIndexOf("?") == -1) builder.append("?");
        builder.append("&multiplyResult=");
        if (multiplyResult != null) builder.append(multiplyResult);

        return builder.toString();
    }

    /**
     * Get parameters as pairs
     *
     * @param request {@link ServletRequest}
     * @param first   First number's parameter value
     * @param second  Second number's parameter value
     * @return {@link Pair} of numbers as strings
     */
    private Pair<String> getPairParameters(ServletRequest request, String first, String second) {
        String firstString = request.getParameter(first);
        String secondString = request.getParameter(second);
        return new Pair<>(firstString, secondString);
    }

    /**
     * Perform addition of the given pair of numbers
     *
     * @param pair {@link Pair} of numbers
     * @return Resulting addition as string or null if any of the numbers is null
     */
    private String performAddition(Pair<String> pair) {
        if (pair.isAnyValueNull()) return null;

        String first = pair.getFirst();
        String second = pair.getSecond();

        try {
            int result = Integer.parseInt(first) + Integer.parseInt(second);
            return String.valueOf(result);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    /**
     * Perform multiplication of the given pair of numbers
     *
     * @param pair {@link Pair} of numbers
     * @return Resulting multiplication as string or null if any of the numbers is null
     */
    private String performMultiplication(Pair<String> pair) {
        if (pair.isAnyValueNull()) return null;

        String first = pair.getFirst();
        String second = pair.getSecond();

        try {
            int result = Integer.parseInt(first) * Integer.parseInt(second);
            return String.valueOf(result);
        } catch (NumberFormatException e) {
            return null;
        }
    }

}
