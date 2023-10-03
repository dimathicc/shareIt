package com.dimathicc.shareit.booking;

import com.dimathicc.shareit.user.User;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Data
public class Booking {
    private long id;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private BookingStatus bookingStatus;
    private Map<User, String> reviews; // TODO: Нужно сделать возможность сделать пользователя анонимным
    private boolean isCompleted; // Подтвердить что задача выполнена
}