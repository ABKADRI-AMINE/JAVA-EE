<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Password Generator</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 100vh;
        }

        h1 {
            font-size: 24px;
            color: #333;
        }

        p {
            font-size: 18px;
            color: #007BFF;
            margin-top: 10px;
        }

        button {
            background-color: #007BFF;
            color: #fff;
            border: none;
            padding: 10px 20px;
            font-size: 16px;
            cursor: pointer;
        }
    </style>
</head>
<body>
    <h1>Password généré :</h1>
    <p id="passwordDisplay"></p>
    <button id="generateButton">Generate Password</button>

    <script>
        document.getElementById("generateButton").addEventListener("click", function() {
            // Generate a random password here and display it
            var password = generateRandomPassword();
            document.getElementById("passwordDisplay").textContent = password;
        });

        function generateRandomPassword() {
            // Your password generation logic here (replace with your actual logic)
            // Example: Generating a random 8-character password
            var charset = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
            var password = "";
            for (var i = 0; i < 8; i++) {
                var randomIndex = Math.floor(Math.random() * charset.length);
                password += charset.charAt(randomIndex);
            }
            return password;
        }
    </script>
</body>
</html>