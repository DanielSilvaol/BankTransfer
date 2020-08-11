package com.work.cvc.transfer;

import com.work.cvc.transfer.Domain.Command.TransferCommand.Inputs.SaveTransferCommand;
import com.work.cvc.transfer.Domain.Command.TransferCommand.Outputs.TransferTO;
import com.work.cvc.transfer.Domain.Handler.TransferHandler;
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

    private final TransferHandler _handler;

    @Autowired
    public BankTransferApplicationTests(TransferHandler handler) {
        _handler = handler;
    }

    @Test
    void contextLoads() {
    }

    @Test
    void SameDayTransferTest() {

        SaveTransferCommand command = new SaveTransferCommand();

        command.setSourceAccount("XXXXXX");
        command.setTargetAccount("XXXXXX");
        command.setTransferAmount(10);
        command.setTransferDate(LocalDate.now());

        TransferTO transferTO = _handler.Handler(command);
        Assertions.assertTrue(_handler.isValid());
        Assertions.assertEquals(3.3, transferTO.getFee());
        Assertions.assertNotEquals(null, transferTO);
    }
    @Test
    void TransferUpTo10DaysTest() {

        SaveTransferCommand command = new SaveTransferCommand();

        command.setSourceAccount("XXXXXX");
        command.setTargetAccount("XXXXXX");
        command.setTransferAmount(10);
        command.setTransferDate(LocalDate.fromDateFields(new Date("2020/08/19")));

        TransferTO transferTO = _handler.Handler(command);
        Assertions.assertTrue(_handler.isValid());
        Assertions.assertEquals(108, transferTO.getFee());
        Assertions.assertNotEquals(null, transferTO);
    }
    @Test
    void FeeAggressiveGreaterThan10AndLessThan20Test() {

        SaveTransferCommand command = new SaveTransferCommand();

        command.setSourceAccount("XXXXXX");
        command.setTargetAccount("XXXXXX");
        command.setTransferAmount(10);
        command.setTransferDate(LocalDate.fromDateFields(new Date("2020/08/21")));

        TransferTO transferTO = _handler.Handler(command);
        Assertions.assertTrue(_handler.isValid());
        Assertions.assertEquals(0.8, transferTO.getFee());
        Assertions.assertNotEquals(null, transferTO);
    }
    @Test
    void FeeAggressiveGreaterThan20AndLessThan30Test() {

        SaveTransferCommand command = new SaveTransferCommand();

        command.setSourceAccount("XXXXXX");
        command.setTargetAccount("XXXXXX");
        command.setTransferAmount(10);
        command.setTransferDate(LocalDate.fromDateFields(new Date("2020/08/31")));

        TransferTO transferTO = _handler.Handler(command);
        Assertions.assertTrue(_handler.isValid());
        Assertions.assertEquals(0.6, transferTO.getFee());
        Assertions.assertNotEquals(null, transferTO);
    }
    @Test
    void FeeAggressiveGreaterThan30AndLessThan40Test() {

        SaveTransferCommand command = new SaveTransferCommand();

        command.setSourceAccount("XXXXXX");
        command.setTargetAccount("XXXXXX");
        command.setTransferAmount(10);
        command.setTransferDate(LocalDate.fromDateFields(new Date("2020/09/10")));

        TransferTO transferTO = _handler.Handler(command);
        Assertions.assertTrue(_handler.isValid());
        Assertions.assertEquals(0.4, transferTO.getFee());
        Assertions.assertNotEquals(null, transferTO);
    }
    @Test
    void FeeAggressiveGreaterThan40AndTransactionGreaterThan100000Test() {

        SaveTransferCommand command = new SaveTransferCommand();

        command.setSourceAccount("XXXXXX");
        command.setTargetAccount("XXXXXX");
        command.setTransferAmount(200000);
        command.setTransferDate(LocalDate.fromDateFields(new Date("2020/09/31")));

        TransferTO transferTO = _handler.Handler(command);
        Assertions.assertTrue(_handler.isValid());
        Assertions.assertEquals(4000, transferTO.getFee());
        Assertions.assertNotEquals(null, transferTO);
    }

    @Test
    void FastValidationSaveTransferCommandTest() {

        SaveTransferCommand command = new SaveTransferCommand();

        command.setSourceAccount("XXXXXX");
        command.setTargetAccount("XXXXXX");
        command.setTransferDate(LocalDate.fromDateFields(new Date("2019/09/31")));

        TransferTO transferTO = _handler.Handler(command);
        Assertions.assertFalse(_handler.isValid());
        Assertions.assertNull(transferTO);
    }
}
