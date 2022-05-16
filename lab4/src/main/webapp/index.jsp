<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="dots" scope="session" class="java.util.ArrayList"/>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Lab 2</title>
    <link rel="stylesheet" href="style.css">
    <script src="js/jquery-3.6.0.js"></script>
</head>
<body>
<header>
    <div class="header_content">
        <div>Stukov Egor Alexandrovich<br>
            Antonov Vsevolod Vladimirovich
        </div>
        <div>P3232<br>P3233</div>
        <div>34601</div>
    </div>
</header>
<article>
    <form>
        <div class="selectors">
            <div class="x-selector">
                <label class="selector-description">Choose X value:</label>
                <div class="checkbox-with-label">
                    <input type="checkbox" id="-3_x" name="x_value" value="-3">
                    <label for="-3_x">-3</label>
                </div>
                <div class="checkbox-with-label">
                    <input type="checkbox" id="-2_x" name="x_value" value="-2">
                    <label for="-2_x">-2</label>
                </div>
                <div class="checkbox-with-label">
                    <input type="checkbox" id="-1_x" name="x_value" value="-1">
                    <label for="-1_x">-1</label>
                </div>
                <div class="checkbox-with-label">
                    <input type="checkbox" id="0_x" name="x_value" value="0">
                    <label for="0_x">0</label>
                </div>
                <div class="checkbox-with-label">
                    <input type="checkbox" id="1_x" name="x_value" value="1">
                    <label for="1_x">1</label>
                </div>
                <div class="checkbox-with-label">
                    <input type="checkbox" id="2_x" name="x_value" value="2">
                    <label for="2_x">2</label>
                </div>
                <div class="checkbox-with-label">
                    <input type="checkbox" id="3_x" name="x_value" value="3">
                    <label for="3_x">3</label>
                </div>
                <div class="checkbox-with-label">
                    <input type="checkbox" id="4_x" name="x_value" value="4">
                    <label for="4_x">4</label>
                </div>
                <div class="checkbox-with-label">
                    <input type="checkbox" id="5_x" name="x_value" value="5">
                    <label for="5_x">5</label>
                </div>
            </div>
            <div class="y-selector">
                <div class="selector-description">Choose Y value:</div>
                <input type="text" id="y" name="y_value">
            </div>
            <div class="r-selector">
                <div class="selector-description">Choose R value:</div>
                <select name="r_value" id="r">
                    <option value="1">1</option>
                    <option value="1.5">1.5</option>
                    <option value="2">2</option>
                    <option value="2.5">2.5</option>
                    <option value="3">3</option>
                </select>
            </div>
            <button class="submit" type="submit">Check</button>
        </div>
        <div class="svg-container">
            <svg height="300" width="300" xmlns="http://www.w3.org/2000/svg">
                <!-- Стрелки и оси -->
                <line stroke="black" x1="0" x2="300" y1="150" y2="150"></line>
                <line stroke="black" x1="150" x2="150" y1="0" y2="300"></line>
                <polygon fill="black" points="150,0 145,20 155,20" stroke="black"></polygon>
                <polygon fill="black" points="300,150 280,155 280,145" stroke="black"></polygon>

                <!-- Деления -->
                <line stroke="black" x1="200" x2="200" y1="155" y2="145"></line>
                <line stroke="black" x1="250" x2="250" y1="155" y2="145"></line>

                <line stroke="black" x1="50" x2="50" y1="155" y2="145"></line>
                <line stroke="black" x1="100" x2="100" y1="155" y2="145"></line>

                <line stroke="black" x1="145" x2="155" y1="100" y2="100"></line>
                <line stroke="black" x1="145" x2="155" y1="50" y2="50"></line>

                <line stroke="black" x1="145" x2="155" y1="200" y2="200"></line>
                <line stroke="black" x1="145" x2="155" y1="250" y2="250"></line>

                <!-- Подписи к делениям и осям -->
                <text fill="black" x="195" y="140">R/2</text>
                <text fill="black" x="250" y="140">R</text>

                <text fill="black" x="40" y="140">-R</text>
                <text fill="black" x="85" y="140">-R/2</text>

                <text fill="black" x="160" y="55">R</text>
                <text fill="black" x="160" y="105">R/2</text>

                <text fill="black" x="160" y="204">-R/2</text>
                <text fill="black" x="160" y="255">-R</text>

                <text fill="black" x="285" y="140">x</text>
                <text fill="black" x="160" y="15">y</text>

                <!-- Прямоугольник -->
                <polygon fill="fuchsia"
                         fill-opacity="0.48"
                         stroke="fuchsia"
                         points="200,150 150,150 150,250 200,250"></polygon>

                <!-- Треугольник -->
                <polygon fill="fuchsia"
                         fill-opacity="0.48"
                         stroke="fuchsia"
                         points="150,150 100,150 150,250"></polygon>

                <!-- Четверть круга -->
                <path fill="fuchsia"
                      fill-opacity="0.48"
                      stroke="fuchsia"
                      d="M100,150 Q100,100 150,100 L 150 150 Z"></path>

                <!-- Точка на графике -->
                <c:forEach var="dot" items="${dots}">
                    <circle r="3.5"
                            cx=${((300 / 2 + (dot.x) / dot.r * 100))}
                                    cy=${((300 / 2 + (dot.y) / dot.r * -100))}
                            id="target-dot"
                            fill=${dot.result ? "green" : "red"}>
                    </circle>
                </c:forEach>
            </svg>
        </div>
    </form>
    <table class="results" id="results">
        <thead>
        <tr>
            <th>X</th>
            <th>Y</th>
            <th>R</th>
            <th>Hit</th>
            <th>Turnaround time</th>
            <th>Script execution time</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="dot" items="${dots}">
            <tr>
                <td>${dot.x}</td>
                <td>${dot.y}</td>
                <td>${dot.r}</td>
                <td>${dot.result}</td>
                <td>${dot.localTime}</td>
                <td>${dot.executionTime}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</article>
<script src="js/validation.js"></script>
<script src="js/interaction.js"></script>
</body>
</html>