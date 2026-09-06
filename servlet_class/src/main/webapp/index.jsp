<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.time.LocalTime" %>

<%
    LocalTime time = LocalTime.now();
    String greeting;

    if (time.getHour() < 12) {
        greeting = "Good Morning";
    } else if (time.getHour() < 18) {
        greeting = "Good Afternoon";
    } else {
        greeting = "Good Evening";
    }
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Radhe | Beautiful JSP</title>

    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: "Segoe UI", Arial, sans-serif;
            min-height: 100vh;
            background: linear-gradient(135deg, #fff1f8, #f5e9ff, #e8f4ff);
            color: #333;
        }

        .navbar {
            width: 100%;
            padding: 20px 8%;
            display: flex;
            justify-content: space-between;
            align-items: center;
            background: rgba(255, 255, 255, 0.65);
            backdrop-filter: blur(12px);
            border-bottom: 1px solid rgba(255, 255, 255, 0.5);
        }

        .logo {
            font-size: 28px;
            font-weight: 700;
            color: #c026d3;
        }

        .nav-link {
            text-decoration: none;
            color: #555;
            font-weight: 500;
        }

        .hero {
            min-height: calc(100vh - 80px);
            display: flex;
            align-items: center;
            justify-content: center;
            padding: 60px 8%;
        }

        .card {
            width: 100%;
            max-width: 1100px;
            display: grid;
            grid-template-columns: 1fr 1fr;
            overflow: hidden;

            background: rgba(255, 255, 255, 0.72);
            backdrop-filter: blur(18px);

            border: 1px solid rgba(255, 255, 255, 0.8);
            border-radius: 30px;

            box-shadow:
                0 25px 70px rgba(120, 70, 150, 0.18);
        }

        .content {
            padding: 70px;
            display: flex;
            flex-direction: column;
            justify-content: center;
        }

        .small-text {
            color: #c026d3;
            font-weight: 600;
            letter-spacing: 2px;
            text-transform: uppercase;
            margin-bottom: 15px;
        }

        h1 {
            font-size: clamp(55px, 8vw, 100px);
            line-height: 0.95;
            margin-bottom: 25px;

            background: linear-gradient(90deg, #be185d, #9333ea);
            -webkit-background-clip: text;
            -webkit-text-fill-color: transparent;
        }

        .description {
            font-size: 18px;
            line-height: 1.7;
            color: #666;
            max-width: 500px;
            margin-bottom: 30px;
        }

        .button {
            display: inline-block;
            width: fit-content;
            padding: 14px 28px;

            color: white;
            text-decoration: none;
            font-weight: 600;

            border-radius: 50px;

            background: linear-gradient(
                135deg,
                #db2777,
                #9333ea
            );

            box-shadow: 0 10px 25px rgba(147, 51, 234, 0.25);

            transition: 0.3s ease;
        }

        .button:hover {
            transform: translateY(-3px);
            box-shadow: 0 15px 30px rgba(147, 51, 234, 0.35);
        }

        .image-container {
            min-height: 550px;
            position: relative;
            overflow: hidden;
        }

        .image-container img {
            width: 100%;
            height: 100%;
            object-fit: cover;
            transition: transform 0.7s ease;
        }

        .image-container:hover img {
            transform: scale(1.06);
        }

        .image-overlay {
            position: absolute;
            inset: 0;

            background: linear-gradient(
                135deg,
                rgba(190, 24, 93, 0.15),
                rgba(147, 51, 234, 0.2)
            );
        }

        .quote {
            position: absolute;
            bottom: 30px;
            left: 30px;
            right: 30px;

            padding: 20px;

            color: white;
            font-size: 17px;
            font-style: italic;

            border-radius: 18px;

            background: rgba(0, 0, 0, 0.25);
            backdrop-filter: blur(10px);
        }

        footer {
            text-align: center;
            padding: 25px;
            color: #777;
            font-size: 14px;
        }

        @media (max-width: 800px) {
            .card {
                grid-template-columns: 1fr;
            }

            .content {
                padding: 45px 30px;
            }

            .image-container {
                min-height: 400px;
            }

            .navbar {
                padding: 18px 6%;
            }
        }
    </style>
</head>

<body>

    <nav class="navbar">
        <div class="logo">Radhe ✨</div>

        <a href="#" class="nav-link">
            Home
        </a>
    </nav>

    <main class="hero">

        <section class="card">

            <div class="content">

                <div class="small-text">
                    <%= greeting %> ❤️
                </div>

                <h1>Radhe</h1>

                <p class="description">
                    Welcome to a beautiful JSP experience.
                    Simple design, elegant colors and a little
                    randomness brought together in one page.
                </p>

                <a href="#" class="button">
                    Explore More →
                </a>

            </div>

            <div class="image-container">

                <!-- Lorem Picsum random image -->
                <img
                    src="https://picsum.photos/900/700?random=<%= System.currentTimeMillis() %>"
                    alt="Random beautiful scenery"
                >

                <div class="image-overlay"></div>

                <div class="quote">
                    “Every moment has its own beauty.
                    Pause, breathe, and enjoy it.”
                </div>

            </div>

        </section>

    </main>

    <footer>
        © <%= java.time.Year.now().getValue() %> Radhe • Made with JSP ❤️
    </footer>

</body>
</html>
