package com.work.cvc.transfer.Domain.Handler;

import com.work.cvc.transfer.Domain.Command.TransferCommand.Inputs.SaveTransferCommand;
import com.work.cvc.transfer.Domain.Command.TransferCommand.Outputs.TransferTO;
import com.work.cvc.transfer.Domain.Entity.Transfer;
import com.work.cvc.transfer.Domain.Model.RateCalculator;
import com.work.cvc.transfer.Infra.Repository.ITransferRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransferHandler extends BaseHandler {

    private final ITransferRepository _repository;

    public TransferHandler(ITransferRepository _repository) {
        this._repository = _repository;
    }

    public List<TransferTO> Handler() {
        return TransferTO.Converter(_repository.findAll());
    }

    public TransferTO Handler(SaveTransferCommand command) {
        if (!command.IsValid()) {
            this.Notifications = command.Notifications;
            return null;
        }
        Transfer transfer = new Transfer();

        transfer.ConfigSave(
                command.getSourceAccount(),
                command.getTargetAccount(),
                command.getTransferAmount(),
                command.getTransferDate());
        double fee = RateCalculator.Calculates(transfer);

        if(fee == 0){
            this.AddNotification(CreateNotification("Fee","Not applicable."));
            return null;
        }

        transfer.setFee(fee);
        _repository.save(transfer);

        return new TransferTO(transfer);
    }

}
