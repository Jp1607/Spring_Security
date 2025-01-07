package com.jp.Spring_Security.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class DateService {

public Instant createExpirationDate(){
    return LocalDateTime.now().plusDays(3).toInstant(ZoneOffset.of("-03:00"));
}
}
