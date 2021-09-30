package com.work.cvc.transfer;

import com.work.cvc.transfer.Domain.Command.TransferCommand.Inputs.SaveTransferCommand;
import com.work.cvc.transfer.Domain.Command.TransferCommand.Outputs.TransferDTO;
import com.work.cvc.transfer.Domain.Service.TransferService;
import org.joda.time.LocalDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;


import java.util.Date;

@SpringBootTest
@WebAppConfiguration
class BankTransferApplicationTests {

    private final TransferService _handler;

    @Autowired
    public BankTransferApplicationTests(TransferService handler) {
        _handler = handler;
    }

    @Test
    void contextLoads() {
    }

    @Test
    void SameDayTransferTest() {
        _handler.ClearNotification();
        SaveTransferCommand command = new SaveTransferCommand();

        command.setSourceAccount("XXXXXX");
        command.setTargetAccount("XXXXXX");
        command.setTransferAmount(10);
        command.setTransferDate(LocalDate.now());

        TransferDTO transferDTO = _handler.saveTransfer(command);
        Assertions.assertTrue(_handler.isValid());
        Assertions.assertEquals(3.3, transferDTO.getRate());
        Assertions.assertNotEquals(null, transferDTO);
    }

    @Test
    void TransferUpTo10DaysTest() {
        _handler.ClearNotification();
        SaveTransferCommand command = new SaveTransferCommand();

        command.setSourceAccount("XXXXXX");
        command.setTargetAccount("XXXXXX");
        command.setTransferAmount(10);
        command.setTransferDate(LocalDate.fromDateFields(new Date()).plusDays(9));

        TransferDTO transferDTO = _handler.saveTransfer(command);
        Assertions.assertTrue(_handler.isValid());
        Assertions.assertEquals(108, transferDTO.getRate());
        Assertions.assertNotEquals(null, transferDTO);
    }

    @Test
    void RateAggressiveGreaterThan10AndLessThan20Test() {
        _handler.ClearNotification();
        SaveTransferCommand command = new SaveTransferCommand();

        command.setSourceAccount("XXXXXX");
        command.setTargetAccount("XXXXXX");
        command.setTransferAmount(10);
        command.setTransferDate(LocalDate.fromDateFields(new Date()).plusDays(19));

        TransferDTO transferDTO = _handler.saveTransfer(command);
        Assertions.assertTrue(_handler.isValid());
        Assertions.assertEquals(0.8, transferDTO.getRate());
        Assertions.assertNotEquals(null, transferDTO);
    }

    @Test
    void RateAggressiveGreaterThan20AndLessThan30Test() {
        _handler.ClearNotification();
        SaveTransferCommand command = new SaveTransferCommand();

        command.setSourceAccount("XXXXXX");
        command.setTargetAccount("XXXXXX");
        command.setTransferAmount(10);
        command.setTransferDate(LocalDate.fromDateFields(new Date()).plusDays(29));

        TransferDTO transferDTO = _handler.saveTransfer(command);
        Assertions.assertTrue(_handler.isValid());
        Assertions.assertEquals(0.6, transferDTO.getRate());
        Assertions.assertNotEquals(null, transferDTO);
    }

    @Test
    void RateAggressiveGreaterThan30AndLessThan40Test() {
        _handler.ClearNotification();
        SaveTransferCommand command = new SaveTransferCommand();

        command.setSourceAccount("XXXXXX");
        command.setTargetAccount("XXXXXX");
        command.setTransferAmount(10);
        command.setTransferDate(LocalDate.fromDateFields(new Date()).plusDays(39));

        TransferDTO transferDTO = _handler.saveTransfer(command);
        Assertions.assertTrue(_handler.isValid());
        Assertions.assertEquals(0.4, transferDTO.getRate());
        Assertions.assertNotEquals(null, transferDTO);
    }

    @Test
    void RateAggressiveGreaterThan40AndTransactionGreaterThan100000Test() {
        _handler.ClearNotification();
        SaveTransferCommand command = new SaveTransferCommand();

        command.setSourceAccount("XXXXXX");
        command.setTargetAccount("XXXXXX");
        command.setTransferAmount(200000);
        command.setTransferDate(LocalDate.fromDateFields(new Date()).plusDays(50));

        TransferDTO transferDTO = _handler.saveTransfer(command);
        Assertions.assertTrue(_handler.isValid());
        Assertions.assertEquals(4000, transferDTO.getRate());
        Assertions.assertNotEquals(null, transferDTO);
    }

    @Test
    void FastValidationSaveTransferCommandTest() {
        _handler.ClearNotification();
        SaveTransferCommand command = new SaveTransferCommand();

        command.setSourceAccount("XXXXXX");
        command.setTargetAccount("XXXXXX");
        command.setTransferDate(LocalDate.fromDateFields(new Date()));

        TransferDTO transferDTO = _handler.saveTransfer(command);
        Assertions.assertFalse(_handler.isValid());
        Assertions.assertNull(transferDTO);
    }
}
