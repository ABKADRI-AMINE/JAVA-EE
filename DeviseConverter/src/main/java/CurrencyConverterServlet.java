import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/CurrencyConverterServlet")
public class CurrencyConverterServlet extends HttpServlet {
    private static final Map<String, String> currencySymbols = new HashMap<>();
    
    static {
        currencySymbols.put("EURO", "€");
        currencySymbols.put("USD", "$");
        currencySymbols.put("MAD", "MAD");
        currencySymbols.put("GBP", "£");
        currencySymbols.put("CNY", "¥");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double amount = Double.parseDouble(request.getParameter("amount"));
        String fromCurrency = request.getParameter("fromCurrency");
        String toCurrency = request.getParameter("toCurrency");

        double euroToDollarRate = 1.18;
        double euroToMadRate = 10.65;
        double euroToSterlingRate = 0.86;
        double euroToYenRate = 130.08;

        double result = 0.0;
        switch (fromCurrency) {
            case "EURO":
                switch (toCurrency) {
                    case "EURO":
                        result = amount;
                        break;
                    case "USD":
                        result = amount * euroToDollarRate;
                        break;
                    case "MAD":
                        result = amount * euroToMadRate;
                        break;
                    case "GBP":
                        result = amount * euroToSterlingRate;
                        break;
                    case "CNY":
                        result = amount * euroToYenRate;
                        break;
                }
                break;
            case "USD":
                switch (toCurrency) {
                    case "EURO":
                        result = amount / euroToDollarRate;
                        break;
                    case "USD":
                        result = amount;
                        break;
                    case "MAD":
                        result = amount * (1 / euroToDollarRate) * euroToMadRate;
                        break;
                    case "GBP":
                        result = amount * (1 / euroToDollarRate) * euroToSterlingRate;
                        break;
                    case "CNY":
                        result = amount * (1 / euroToDollarRate) * euroToYenRate;
                        break;
                }
                break;
            case "MAD":
                switch (toCurrency) {
                case "MAD":
                    result = amount;
                    break;
                    case "EURO":
                        result = amount / euroToMadRate;
                        break;
                    case "USD":
                        result = amount / euroToMadRate / euroToDollarRate;
                        break;
                    case "GBP":
                        result = amount / euroToMadRate / euroToSterlingRate;
                        break;
                    case "CNY":
                        result = amount / euroToMadRate / euroToYenRate;
                        break;
                }
                break;

            case "GBP":
                switch (toCurrency) {
                case "GBP":
                    result = amount;
                    break;
                    case "EURO":
                        result = amount * euroToSterlingRate;
                        break;
                    case "USD":
                        result = amount * euroToSterlingRate / euroToDollarRate;
                        break;
                    case "MAD":
                        result = amount * euroToSterlingRate / euroToMadRate;
                        break;
                    case "CNY":
                        result = amount * euroToSterlingRate / euroToYenRate;
                        break;
                }
                break;

            case "CNY":
                switch (toCurrency) {
                case "CNY":
                    result = amount;
                    break;
                    case "EURO":
                        result = amount * euroToYenRate;
                        break;
                    case "USD":
                        result = amount * euroToYenRate / euroToDollarRate;
                        break;
                    case "MAD":
                        result = amount * euroToYenRate / euroToMadRate;
                        break;
                    case "GBP":
                        result = amount * euroToYenRate / euroToSterlingRate;
                        break;
                }
                break;

        }

        String fromCurrencySymbol = currencySymbols.get(fromCurrency);
        String toCurrencySymbol = currencySymbols.get(toCurrency);

        request.setAttribute("result", result);
        request.setAttribute("fromCurrencySymbol", fromCurrencySymbol);
        request.setAttribute("toCurrencySymbol", toCurrencySymbol);

        request.getRequestDispatcher("currency-converter.jsp").forward(request, response);
    }
}
