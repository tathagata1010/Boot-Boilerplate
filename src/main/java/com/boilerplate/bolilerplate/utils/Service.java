package com.boilerplate.bolilerplate.utils;
@org.springframework.stereotype.Service
public class Service {
public boolean checkHealth(String hello)
{
    return !hello.isEmpty();
}
}
