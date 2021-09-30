package com.work.cvc.transfer.Api.Controller;

import com.work.cvc.transfer.Api.Config.Error.Notification;
import com.work.cvc.transfer.Domain.Interface.IService;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class BaseController {
    private final IService _service;

    protected BaseController(IService service)
    {
        _service = service;
    }

    protected ResponseEntity<?> Response(Object result)
    {
        List<Notification> notifications = _service.Notifications();
        if (notifications.size() == 0)
        {
            return ResponseEntity.ok(result);
        }
        ResponseEntity<?> response = ResponseEntity.badRequest().body(notifications);

        _service.ClearNotification();
        return response;
    }
}
