<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true"%>
<%
    session.invalidate(); // Clear the session
%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Logged Out | FoodieExpress</title>
  <style>
    * {
      box-sizing: border-box;
      margin: 0;
      padding: 0;
      font-family: 'Poppins', sans-serif;
    }

    body {
      height: 100vh;
      display: flex;
      justify-content: center;
      align-items: center;
      background: linear-gradient(135deg, #ffecd2, #fcb69f);
      background-attachment: fixed;
    }

    .logout-box {
      background: rgba(255, 255, 255, 0.15);
      padding: 50px 40px;
      border-radius: 20px;
      backdrop-filter: blur(12px);
      box-shadow: 0px 8px 25px rgba(0, 0, 0, 0.3);
      width: 100%;
      max-width: 420px;
      text-align: center;
      animation: fadeIn 1.2s ease-in-out;
    }

    .logout-box h2 {
      font-size: 30px;
      font-weight: bold;
      color: #ff6b00;
      margin-bottom: 15px;
    }

    .logout-box p {
      font-size: 17px;
      color: #222;
      margin-bottom: 25px;
    }

    .logout-box a {
      display: inline-block;
      padding: 14px 28px;
      background: linear-gradient(135deg, #ff6b00, #ff3b2f);
      color: white;
      text-decoration: none;
      border-radius: 10px;
      font-weight: bold;
      font-size: 16px;
      transition: 0.3s ease-in-out;
      box-shadow: 0px 4px 12px rgba(255, 107, 0, 0.5);
    }

    .logout-box a:hover {
      transform: scale(1.05);
      background: linear-gradient(135deg, #ff3b2f, #ff6b00);
      box-shadow: 0px 6px 18px rgba(255, 59, 47, 0.6);
    }

    @keyframes fadeIn {
      from { opacity: 0; transform: translateY(40px); }
      to { opacity: 1; transform: translateY(0); }
    }

    @media screen and (max-width: 500px) {
      .logout-box {
        margin: 20px;
        padding: 35px 25px;
      }
      .logout-box h2 {
        font-size: 24px;
      }
    }
  </style>
</head>
<body>

  <div class="logout-box">
    <h2>👋 You’ve been logged out</h2>
    <p>Thank you for visiting <b>FoodieExpress</b>. We hope to see you again!</p>
    <a href="login.jsp">🔑 Login Again</a>
  </div>

</body>
</html>
