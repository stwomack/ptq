package io.pivotal.bds.mastercard.ess.query.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ProcessedTransactionResponse {
    @Id
    @GeneratedValue
    private Long PRCSS_TRAN_ID;
    private Long MPS_STRT_ACCT_RNG_NUM;
    private Long MPS_ENDNG_ACCT_RNG_NUM;
    private Long AUTH_ACCT_RNG_ID;
    private Long PRCSS_DT_TM;
    private Long DE2_PAN_NUM;
    private Long posPANEntryMode;
    private Long caseKeyCode2;
    private Long numberOfEventsForMagneticStr3;
    private Long cardValidationCodeResult;
    private Long numberOfEventsForPIN;
    private Long merchantsCity;
    private Long cardholderActivatedTerminalL7;
    private Long posCountryCode;
    private Long numberOfEventsForExpirationD9;
    private Long transactionAmount;
    private Long posCardDataTermInputCapabili11;
    private Long transactionType;
    private Long cardAcceptorIdCode;
    private Long cardholderVerificationMethod;
    private Long merchantType;
    private Long caseKeyCode3;
    private Long emsAdjustedScore;
    private Long responseCode;
    private Long numberOfEventsForCVC2;
    private Long settlementAmount;
    private Long numberOfEventsForAccountNumber;
    private Long numberOfEventsForPersonalInf22;
    private Long emsAdjustedReasonCode;
    private Long caseKeyCode1;
    private Long acquireInstitutionIdCode;
    private Long merchantsState;
    private Long transactionCurrencyCode;
    private Long merchantName;
    private Long posCardPresence;
    private Long posPINEntryMode;
    private Long cardAcceptorTerminalId;
    private Long posCardholderPresence;
    private Long cardholderBillingAmount;

    public ProcessedTransactionResponse() {
    }
}