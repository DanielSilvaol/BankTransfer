package com.work.cvc.transfer.Domain.Enum;

import com.work.cvc.transfer.Domain.Interface.IFeeRule;
import com.work.cvc.transfer.Domain.Model.SameDayTransfer;
import com.work.cvc.transfer.Domain.Model.TransferUpTo10Days;

public enum EFee {
    FEE_A(new SameDayTransfer()),
    FEE_B(new TransferUpTo10Days()),
    FEE_C(new SameDayTransfer());

    private IFeeRule _iFeeRule;

    EFee(IFeeRule iFeeRule) {
        this._iFeeRule = iFeeRule;
    }

    public IFeeRule getFee(){
        return _iFeeRule;
    }
}
