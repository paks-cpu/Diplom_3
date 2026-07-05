package myhome;

import com.github.javafaker.Faker;

public class Resources {
    public static Faker faker = new Faker();

    public static final String HOME_PAGE = "https://stellarburgers.education-services.ru"; // домашняя страница
    public static final String REGISTRATION_PAGE = "https://stellarburgers.education-services.ru/register";//страница регистрация пользоваля
    public static final String POST_REGISTRATION_USER = "/api/auth/register"; //создание пользователя
    public static final String AUTHORIZATION_PAGE = "https://stellarburgers.education-services.ru/login"; //страница авторизация пользователя
    public static final String POST_AUTHORIZATION_USER = "/api/auth/login";//авторизация
    public static final String FORGOT_PASSWORD_PAGE = "https://stellarburgers.education-services.ru/forgot-password"; //страница восстановление пароля
    public static final String POST_FORGOT_PASSWORD = "/api/password-reset";//восстановление пароля
    public static final String DELETE_USER = "/api/auth/user"; //удаление полььзователя
}
