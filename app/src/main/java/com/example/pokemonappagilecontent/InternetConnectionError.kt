package com.example.pokemonappagilecontent

class InternetConnectionError(
    errorMsg: String = "Please, check your internet connection and try again !!!"
): Throwable(errorMsg)