
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.* ,com.pj.bean.CompanyBean"%>

    <!DOCTYPE html>
    <html lang="en">
 
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>jQuery UI Menu - Icons</title>
        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <script>
            $(function() {
                $("#menu").menu();
            });
            $(function() {
                $("#tabs").tabs();
            });

            // dialog
            $(function() {
                var dialog, form,

                    // From http://www.whatwg.org/specs/web-apps/current-work/multipage/states-of-the-type-attribute.html#e-mail-state-%28type=email%29
                    emailRegex = /^[a-zA-Z0-9.!#$%&'*+\/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$/,
                    name = $("#name"),
                    email = $("#email"),
                    password = $("#password"),
                    allFields = $([]).add(name).add(email).add(password),
                    tips = $(".validateTips");

                function updateTips(t) {
                    tips
                        .text(t)
                        .addClass("ui-state-highlight");
                    setTimeout(function() {
                        tips.removeClass("ui-state-highlight", 1500);
                    }, 500);
                }

                function checkLength(o, n, min, max) {
                    if (o.val().length > max || o.val().length < min) {
                        o.addClass("ui-state-error");
                        updateTips("Length of " + n + " must be between " +
                            min + " and " + max + ".");
                        return false;
                    } else {
                        return true;
                    }
                }

                function checkRegexp(o, regexp, n) {
                    if (!(regexp.test(o.val()))) {
                        o.addClass("ui-state-error");
                        updateTips(n);
                        return false;
                    } else {
                        return true;
                    }
                }

                function addUser() {
                    var valid = true;
                    allFields.removeClass("ui-state-error");

                    //驗證先用掉
                    //   valid = valid && checkLength( name, "username", 3, 16 );
                    //   valid = valid && checkLength( email, "email", 6, 80 );
                    //   valid = valid && checkLength( password, "password", 5, 16 );

                    //   valid = valid && checkRegexp( name, /^[a-z]([0-9a-z_\s])+$/i, "Username may consist of a-z, 0-9, underscores, spaces and must begin with a letter." );
                    //   valid = valid && checkRegexp( email, emailRegex, "eg. ui@jquery.com" );
                    //   valid = valid && checkRegexp( password, /^([0-9a-zA-Z])+$/, "Password field only allow : a-z 0-9" );

                    if (valid) {
                        $("#users tbody").append("<tr>" +
                            "<td>" + name.val() + "</td>" +
                            "<td>" + email.val() + "</td>" +
                            "<td>" + password.val() + "</td>" +
                            "</tr>");
                        dialog.dialog("close");
                    }
                    return valid;
                }

                dialog = $("#dialog-form").dialog({
                    autoOpen: false,
                    height: 400,
                    width: 350,
                    modal: true,
                    buttons: {
                        "Create an account": addUser,
                        Cancel: function() {
                            dialog.dialog("close");
                        }
                    },
                    close: function() {
                        form[0].reset();
                        allFields.removeClass("ui-state-error");
                    }
                });

                form = dialog.find("form").on("submit", function(event) {
                    event.preventDefault();
                    addUser();
                });

                $("#create-user").button().on("click", function() {
                    dialog.dialog("open");
                });
            });
            //dialog
        </script>
        <style>
            .ui-menu {
                width: 180px;
            }
            
            * {
                box-sizing: border-box;
                padding: 0;
                margin: 0px;
            }
            
            .box {
                float: left;
                width: 10%;
            }
            
            .box2 {
                float: left;
                width: 89%;
                height: 100%;
            }
            
            .clearfix::after {
                content: "";
                clear: both;
                display: table;
            }
        </style>
        <!--dialog-->
        <style>
            label,
            input {
                display: block;
            }
            
            input.text {
                margin-bottom: 12px;
                width: 95%;
                padding: .4em;
            }
            
            fieldset {
                padding: 0;
                border: 0;
                margin-top: 25px;
            }
            
            h1 {
                font-size: 1.2em;
                margin: .6em 0;
            }
            
            div#users-contain {
                width: 350px;
                margin: 20px 0;
            }
            
            div#users-contain table {
                margin: 1em 0;
                border-collapse: collapse;
                width: 100%;
            }
            
            div#users-contain table td,
            div#users-contain table th {
                border: 1px solid #eee;
                padding: .6em 10px;
                text-align: left;
            }
            
            .ui-dialog .ui-state-error {
                padding: .3em;
            }
            
            .validateTips {
                border: 1px solid transparent;
                padding: 0.3em;
            }
        </style>
        
    </head>

    <body>
<jsp:useBean id="company" scope="request" class="com.pj.bean.CompanyBean" />

        <div class="clearfix">
            <h1>愛食記MAX</h1>
            <div class="box">
                <ul id="menu">

                    <li>
                        <div><span class="ui-icon ui-icon-play"></span><a href="${pageContext.request.contextPath}/HomePage.html/HomePage.html">首頁</a></div>
                    </li>
                    <li>
                        <div><span class="ui-icon ui-icon-play"></span>1</div>
                    </li>
                    <li>
                        <div><span class="ui-icon ui-icon-play"></span><a href="Rmain.html" style="text-decoration:none;">2</a></div>
                    </li>
                    <li class="ui-state-disabled">
                        <div><span class="ui-icon ui-icon-play"></span>分析</div>
                    </li>
                    <li>
                        <div>個人資訊</div>
                        <ul>
                            <li>
                                <div><span class="ui-icon ui-icon-stop"></span>設定</div>
                            </li>
                            <li>
                                <div><span class="ui-icon ui-icon-seek-end"></span>登出</div>
                            </li>
                        </ul>
                    </li>

                </ul>
            </div>


            <span id="tabs" class="box2">
            <ul>
                <li><a href="#tabs-1">商品</a></li>
                <li><a href="#tabs-2">我的菜單</a></li>
                <li><a href="#tabs-3">我的餐廳</a></li>
            </ul>
            <div id="tabs-1">
                <p>
                    <div id="dialog-form" title="建立新商品">
                        <p class="validateTips">All form fields are required.</p>
    
                        <form>
                            <fieldset>
                                <label for="name">商品名稱</label>
                                <input type="text" name="name" id="name" value="菜單01"
                                    class="text ui-widget-content ui-corner-all">
                                <label for="email">餐廳</label>
                                <input type="text" name="name" id="email" value="taipei01"
                                    class="text ui-widget-content ui-corner-all">
                                <label for="password">供應時間</label>
                                <input type="text" name="name" id="password" value="12:30-17:00"
                                    class="text ui-widget-content ui-corner-all">
    
                                <!-- Allow form submission with keyboard without duplicating the dialog button -->
                                <input type="submit" tabindex="-1" style="position:absolute; top:-1000px">
                            </fieldset>
                        </form>
                    </div>
    
    
                    <div id="users-contain" class="ui-widget">
                        <h1>上架中:</h1>
                        <table id="users" class="ui-widget ui-widget-content">
                            <thead>
                                <tr class="ui-widget-header ">
                                    <th>商品</th>
                                    <th>餐廳</th>
                                    <th>供應時間</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>菜單01</td>
                                    <td>taipei01</td>
                                    <td>12:30-17:00</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                    <button id="create-user">上架</button>
            </p>

            </div>
            <div id="tabs-2">
                <p>秀出已建立菜單</p>
                <iframe src="${pageContext.request.contextPath}/ShowAllMenu?companyId=<%=session.getAttribute("id") %>" width=100% height="400" style="border:0; border-radius: 30px" allowfullscreen="" loading="lazy"></iframe>
                
            </div>
            
            <div id="tabs-3">
                <p>秀出餐廳</p>
                 <iframe src="${pageContext.request.contextPath}/frontend/Rmain.jsp" width=100% height="400" style="border:0; border-radius: 30px" allowfullscreen="" loading="lazy"></iframe>
            </div>
        </span>
        </div>




    </body>

    </html>