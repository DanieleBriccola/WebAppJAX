<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Chat Example</title>
        <style>
            body {
                font-family: Arial, sans-serif;
            }
            #chat-container {
                width: 400px;
                margin: 0 auto;
                padding: 20px;
                border: 1px solid #ccc;
                border-radius: 5px;
            }
            #chat-messages {
                height: 300px;
                overflow-y: auto;
                border: 1px solid #eee;
                padding: 10px;
                margin-bottom: 10px;
            }
            #chat-input {
                width: 100%;
                padding: 8px;
                box-sizing: border-box;
            }
        </style>
    </head>
    <body>
        <div id="chat-container">
            <div id="chat-messages"></div>
            <input type="text" id="chat-input" placeholder="Type your message..." onchange="invia(this)">
        </div>
        <script>
            var ws;
            window.onload = connessione();
            function connessione() {
                ws = new WebSocket("ws://localhost:8080/ws/endpoint?nomeUtente=<%= request.getParameter("nome")%>");                
                ws.onmessage = function (event) {
                    document.getElementById("chat-messages").innerHTML += (event.data + "<br>");
                }
            }

            function invia(input) {
                ws.send(input.value);
                input.value = "";
            }
        </script>
    </body>
</html>