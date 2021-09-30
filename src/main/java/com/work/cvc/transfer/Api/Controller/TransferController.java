package com.work.cvc.transfer.Api.Controller;

import com.work.cvc.transfer.Domain.Command.TransferCommand.Inputs.SaveTransferCommand;
import com.work.cvc.transfer.Domain.Service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/Transfer")
public class TransferController extends BaseController{

    private final TransferService _handler;

    @Autowired
    public TransferController(TransferService _handler) {
        super(_handler);
        this._handler = _handler;
    }

    @GetMapping("/schedules")
    public ResponseEntity<?> getSchedules(){
        return Response(_handler.getSchedules());
    }

    @PostMapping("/saveTransfer")
    public ResponseEntity<?> saveTransfer(@RequestBody SaveTransferCommand command){
        return Response(_handler.saveTransfer(command));
    }

}
