package com.example.pokemonappagilecontent.exception

class InternetConnectionException(
    errorMsg: String = "Please, check your internet connection and try again !!!"
): Throwable(errorMsg)