import java.io.*;
import javax.servlet.http.HttpServletRequest;

import java.math.*;

public class BMIcalculator extends HttpServlet {
  public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    // get the weight and height from the form
    double weight = Double.parseDouble(request.getParameter("weight"));
    double height = Double.parseDouble(request.getParameter("height"));

    // convert height from cm to meters
    height /= 100;

    // calculate the BMI
    double bmi = weight / (height * height);

    // format the BMI to one decimal place
    BigDecimal bd = new BigDecimal(bmi).setScale(1, RoundingMode.HALF_UP);

    // set the response type to HTML
    response.setContentType("text/html");

    // write the response to the client
    PrintWriter out = response.getWriter();
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("  <title>BMI Calculator</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("  <h1>BMI Calculator</h1>");
    out.println("  <p>Your BMI is: " + bd + "</p>");
    out.println("</body>");
    out.println("</html>");
  }
}
