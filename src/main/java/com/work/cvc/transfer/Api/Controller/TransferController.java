package com.work.cvc.transfer.Api.Controller;

import com.work.cvc.transfer.Domain.Command.TransferCommand.Inputs.SaveTransferCommand;
import com.work.cvc.transfer.Domain.Handler.TransferHandler;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/Transfer")
public class TransferController extends BaseController{

    private TransferHandler _handler;

    @Autowired
    public TransferController(TransferHandler _handler) {
        super(_handler);
        this._handler = _handler;
    }

    @GetMapping("/Schedules")
    public ResponseEntity<?> Get(){
        return Response(_handler.Handler());
    }

    @PostMapping("/Save")
    public ResponseEntity<?> Post(@RequestBody SaveTransferCommand command){
        return Response(_handler.Handler(command));
    }

}
