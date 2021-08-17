<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
            integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
            integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
            integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <title>Список дел</title>
</head>
<script src="https://code.jquery.com/jquery-3.4.1.min.js" ></script>

$ajax

<body>
<div class="container">
    <h3>Список дел</h3>
    <form class="form-horizontal" action="<%=request.getContextPath()%>/add.do" method="POST">
        <div class="form-group">
            <label class="control-label col-sm-2" for="description">Описание задания:</label>
            <div class="col-sm-10">
                <textarea id="description" name="description" class="form-control" rows="3" placeholder="Введите описание..." required></textarea>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-primary">Добавить</button>
            </div>
        </div>
    </form>
</div>

<div class="row">
    <div class="card" style="width: 100%">
        <div class="card-header">
            Задания
        </div>
        <div class="card-body">
            <div class="form-check">
                <input type="checkbox" class="form-check-input" id="showAllTasks" name="showAllTasks" onclick="fillInTable();">
                <label class="form-check-label" for="showAllTasks">Показать все задания</label>
            </div>
            <table id="myTable" class="table">
                <thead>
                <tr>
                    <th scope="col">No.</th>
                    <th scope="col">Описание</th>
                    <th scope="col">Дата создания</th>
                    <th scope="col">Выполнено</th>
                </tr>
                </thead>
                <tbody id="myTableBody">
                </tbody>
            </table>
        </div>
    </div>
</div>
</div>
</body>
</html>