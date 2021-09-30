package com.work.cvc.transfer.Domain.Service;

import com.work.cvc.transfer.Domain.Command.TransferCommand.Inputs.SaveTransferCommand;
import com.work.cvc.transfer.Domain.Command.TransferCommand.Outputs.TransferDTO;
import com.work.cvc.transfer.Domain.Entity.Transfer;
import com.work.cvc.transfer.Domain.Model.RateCalculator;
import com.work.cvc.transfer.Infra.Repository.ITransferRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransferService extends BaseService {

    private final ITransferRepository _repository;

    public TransferService(ITransferRepository _repository) {
        this._repository = _repository;
    }

    public List<TransferDTO> getSchedules() {
        return TransferDTO.Converter(_repository.findAll());
    }

    public TransferDTO saveTransfer(SaveTransferCommand command) {
        if (!command.IsValid()) {
            this.Notifications = command.Notifications;
            return null;
        }
        Transfer transfer = new Transfer();

        transfer.configSave(command.getSourceAccount(), command.getTargetAccount(), command.getTransferAmount(), command.getTransferDate());

        double rate = RateCalculator.Calculates(transfer);

        if(rate == 0){
            this.AddNotification(CreateNotification("Rate","Not applicable."));
            return null;
        }

        transfer.setRate(rate);
        _repository.save(transfer);

        return new TransferDTO(transfer);
    }

}
