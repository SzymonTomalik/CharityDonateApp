<%@ page contentType="text/html;charset=UTF-8" language="java" %><%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %><%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %><%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %><!DOCTYPE html><html lang="pl"><%@include file="/WEB-INF/head.jspf" %><body><%@include file="/WEB-INF/header.jspf" %><section class="form--steps">    <div class="form--steps-instructions">        <div class="form--steps-container">            <h3>Ważne!</h3>            <p data-step="1" class="active">                Uzupełnij szczegóły dotyczące Twoich rzeczy. Dzięki temu będziemy                wiedzieć komu najlepiej je przekazać.            </p>            <p data-step="2">                Uzupełnij szczegóły dotyczące Twoich rzeczy. Dzięki temu będziemy                wiedzieć komu najlepiej je przekazać.            </p>            <p data-step="3">                Wybierz jedną, do                której trafi Twoja przesyłka.            </p>            <p data-step="4">Podaj adres oraz termin odbioru rzeczy.</p>        </div>    </div>    <div class="form--steps-container">        <div class="form--steps-counter">Krok <span>1</span>/4</div>        <form:form modelAttribute="donation">            <!-- STEP 1: class .active is switching steps -->            <div data-step="1" class="active">                <h3>Zaznacz co chcesz oddać:</h3>                <c:forEach items="${categories}" var="category">                    <div class="form-group form-group--checkbox">                        <label>                            <form:checkbox path="categories" value="${category.id}"/>                            <span class="checkbox"></span>                            <span class="description">${category.name}</span>                        </label>                    </div>                </c:forEach>                <div class="form-group form-group--buttons">                    <button type="button" class="btn next-step">Dalej</button>                </div>            </div>            <!-- STEP 2 -->            <div data-step="2">                <h3>Podaj liczbę 60l worków, w które spakowałeś/aś rzeczy:</h3>                <div class="form-group form-group--inline">                    <form:label path="quantity">Liczba 60l worków:</form:label>                    <form:input path="quantity"/>                </div>                <div class="form-group form-group--buttons">                    <button type="button" class="btn prev-step">Wstecz</button>                    <button type="button" class="btn next-step">Dalej</button>                </div>            </div>            <!-- STEP 3 -->            <div data-step="3">                <h3>Wybierz organizacje, której chcesz pomóc:</h3>                <c:forEach items="${institutions}" var="i">                    <div class="form-group form-group--checkbox">                        <label>                            <form:radiobutton path="institution" value="${i.id}"/>                            <span class="checkbox radio"></span>                            <span class="description">                  <div class="title">${i.name}</div>                  <div class="subtitle">                    Cel i misja: ${i.description}                  </div>                </span>                        </label>                    </div>                </c:forEach>                <div class="form-group form-group--buttons">                    <button type="button" class="btn prev-step">Wstecz</button>                    <button type="button" class="btn next-step">Dalej</button>                </div>            </div>            <!-- STEP 4 -->            <div data-step="4">                <h3>Podaj adres oraz termin odbioru rzecz przez kuriera:</h3>                <div class="form-section form-section--columns">                    <div class="form-section--column">                        <h4>Adres odbioru</h4>                        <div class="form-group form-group--inline">                            <form:label path="street">Ulica i numer domu</form:label>                            <form:input path="street"/>                        </div>                        <div class="form-group form-group--inline">                            <form:label path="city">Miasto</form:label>                            <form:input path="city"/>                        </div>                        <div class="form-group form-group--inline">                            <form:label path="zipCode">Kod pocztowy</form:label>                            <form:input path="zipCode"/>                        </div>                        <div class="form-group form-group--inline">                            <form:label path="phoneNumber">Numer telefonu</form:label>                            <form:input path="phoneNumber"/>                        </div>                    </div>                    <div class="form-section--column">                        <h4>Termin odbioru</h4>                        <div class="form-group form-group--inline">                            <form:label path="pickUpDate">Data</form:label>                            <form:input path="pickUpDate"/>                        </div>                        <div class="form-group form-group--inline">                            <form:label path="pickUpTime">Godzina</form:label>                            <form:input path="pickUpTime"/>                        </div>                        <div class="form-group form-group--inline">                            <form:label path="pickUpComment">Uwagi dla kuriera</form:label>                            <form:input path="pickUpComment"/>                        </div>                    </div>                </div>                <div class="form-group form-group--buttons">                    <button type="button" class="btn prev-step">Wstecz</button>                    <button type="button" class="btn next-step">Dalej</button>                </div>            </div>            <!-- STEP 5 -->            <div data-step="5">                <h3>Podsumowanie Twojej darowizny</h3>                <div class="summary">                    <div class="form-section">                        <h4>Oddajesz:</h4>                        <ul>                            <li>                                <span class="summary--text" id="summaryQuantity"></span>                                <span class="icon icon-bag"></span>                                <span class="summary--text" id="summaryCategories"></span>                            </li>                            <li>                                Dla fundacji:                                <span class="icon icon-hand"></span>                                <span class="summary--text" id="summaryInstitution"></span>                            </li>                        </ul>                    </div>                    <div class="form-section form-section--columns">                        <div class="form-section--column">                            <h4>Adres odbioru:</h4>                            <ul>                                <li id="summaryStreet"></li>                                <li id="summaryCity"></li>                                <li id="summaryZipCode"></li>                                <li id="summaryPhoneNumber"></li>                            </ul>                        </div>                        <div class="form-section--column">                            <h4>Termin odbioru:</h4>                            <ul>                                <li id="summaryPickUpDate"></li>                                <li id="summaryPickUpTime"></li>                                <li id="summaryPickUpComment"></li>                            </ul>                        </div>                    </div>                </div>                <div class="form-group form-group--buttons">                    <button type="button" class="btn prev-step">Wstecz</button>                    <button type="submit" class="btn">Potwierdzam</button>                </div>            </div>        </form:form>    </div></section><%@include file="/WEB-INF/footer.jspf" %></body></html>