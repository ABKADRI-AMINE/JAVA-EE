<!DOCTYPE html>
<html>
<head>
    <title>Currency Converter</title>
    <!-- Inclure Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
   <style>
    body {
        background-color: #f4f4f4;
        font-family: Arial, sans-serif;
    }

    h1 {
        text-align: center;
        color: #333;
    }

    form {
        background-color: #fff;
        padding: 20px;
        border: 1px solid #ccc;
        border-radius: 5px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }

    label {
        font-weight: bold;
    }

    .form-group {
        margin-bottom: 20px;
    }

    .btn-primary {
        background-color: #007bff;
        color: #fff;
    }

    .btn-primary:hover {
        background-color: #0056b3;
    }

    p {
        font-weight: bold;
        font-size: 18px;
        margin-top: 20px;
    }
</style>

</head>
<body>
    <div class="container mt-5">
        <h1 class="text-center">Convertisseur devise</h1>
        
        <form action="CurrencyConverterServlet" method="post" class="mt-4">
            <div class="form-group">
                <label for="amount">Montant:</label>
                <input type="number" id="amount" name="amount" class="form-control" required>
            </div>
            
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="fromCurrency">Devise de départ:</label>
                    <select id="fromCurrency" name="fromCurrency" class="form-control">
                        <option value="EURO">EURO</option>
                        <option value="USD">USD</option>
                        <option value="MAD">MAD</option>
                        <option value="GBP">GBP</option>
                        <option value="CNY">CNY</option>
                    </select>
                </div>
                
                <div class="form-group col-md-6">
                    <label for="toCurrency">Devise finale:</label>
                    <select id="toCurrency" name="toCurrency" class="form-control">
                        <option value="EURO">EURO</option>
                        <option value="USD">USD</option>
                        <option value="MAD">MAD</option>
                        <option value="GBP">GBP</option>
                        <option value="CNY">CNY</option>
                    </select>
                </div>
            </div>
            
            <button type="submit" class="btn btn-primary">Convert</button>
        </form>
        
        <c:if test="${not empty result}">
            <p class="mt-3">Résultat de conversion: ${result} ${toCurrencySymbol}</p>
        </c:if>
    </div>

    <!-- Inclure Bootstrap JavaScript (optionnel) -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
