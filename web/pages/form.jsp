<%--suppress HtmlFormInputWithoutLabel --%>
<% int size = 5; int maxLength = 7; %>
<form method="post" action="${pageContext.request.contextPath}/calculator">
    <div class="form-div">
        <input class="input-box" type="text" size="<%=size%>" name="addFirst" maxlength="<%=maxLength%>" pattern="\d{1,<%=maxLength%>}"
               title="Numbers only please." value=${param.addFirst}>
        <span class="operator">+</span>
        <input class="input-box" type="text" size="<%=size%>" name="addSecond" maxlength="<%=maxLength%>" pattern="\d{1,<%=maxLength%>}"
               title="Numbers only please." value=${param.addSecond}>
        <span class="operator">=</span>
        <input class="input-box" type="text" name="addResult" readonly value=${param.addResult}>

        <input class="input-box" type="text" size="<%=size%>" name="multiplyFirst" maxlength="<%=maxLength%>" pattern="\d{1,<%=maxLength%>}"
               title="Numbers only please." value=${param.multiplyFirst}>
        <span class="operator">x</span>
        <input class="input-box" type="text" size="<%=size%>" name="multiplySecond" maxlength="<%=maxLength%>" pattern="\d{1,<%=maxLength%>}"
               title="Numbers only please." value=${param.multiplySecond}>
        <span class="operator">=</span>
        <input class="input-box" type="text" name="multiplyResult" readonly value=${param.multiplyResult}>

        <button id="clear-form" >Clear</button>
        <button type="submit" value="Calculate">Calculate</button>
    </div>
</form>