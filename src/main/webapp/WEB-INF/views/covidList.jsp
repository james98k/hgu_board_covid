<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel = "stylesheet" type = "text/css" href = "./covidListStyle.css" >


</head>
<body>
    <div class = "header-main-wrapper">
        <h1>Handong Covid Status</h1>
        <img src = "./img/hgu_logo_black.png">
    </div>

    <section class = "main-section">
        <div class = "covid-left-side-float-wrapper">
            <form action="">
                <p>All confirmed Student : ${u.getAll_confirmed_count()}</p>
                <p>All Pohang Confirmed Student : $</p>
                <p></p>

            </form>
        </div>
        <div class = "covid-main-wrapper">
           <div class = "left-sidebar-detail">
                <div class = "left-main-count">
    
                </div>
           </div>
           <div class = "main-covid-list-wrapper">
            <table class = "main-covld-list-table">
                <tr>
                    <th>id</th>
                    <th>거주지역</th>
                    <th>확진날짜</th>
                    <th>환자 상태</th>
                </tr>
        
                <c:forEach items = "${list}" var = "u">
                        <tr class = "covid-list-table" onclick="gotoCovildDetailList(u.getId())">
                            <td>${u.getId()}</td>
                            <td>${u.getResidence_type()}</td>
                            <td>${u.getConfirmed_date()}</td>
                            <td>${u.getConfirmed_status()}</td>
                        </tr>
                    </c:forEach>
            </table>
           </div>
        </div>
    </section>
    
   

</body>
</html>