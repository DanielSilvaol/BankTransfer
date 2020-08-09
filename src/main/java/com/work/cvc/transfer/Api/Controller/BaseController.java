package com.work.cvc.transfer.Api.Controller;

import com.work.cvc.transfer.Domain.Config.Error.Notification;
import com.work.cvc.transfer.Domain.Interface.IHandler;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class BaseController {
    private final IHandler _handler;

    protected BaseController(IHandler handler)
    {
        _handler = handler;
    }

    protected ResponseEntity<?> Response(Object result)
    {
        List<Notification> notifications = _handler.Notifications();
        if (notifications.size() == 0)
        {
            return ResponseEntity.ok(result);
        }
        ResponseEntity<?> response = ResponseEntity.badRequest().body(notifications);
        _handler.ClearNotification();
        return response;
    }
}
