package io.pivotal.bds.mastercard.ess.query.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProcessedTransactionsQueryDAO {
    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    private String customerQuery =
            "SELECT " +
                " PT.PRCSS_TRAN_ID,\n" +
                " MPS_STRT_ACCT_RNG_NUM,\n" +
                " MPS_ENDNG_ACCT_RNG_NUM,\n" +
                " AUTH_ACCT_RNG_ID,\n" +
                " PRCSS_DT_TM,\n" +
                " DE2_PAN_NUM,\n" +
                " SUBSTR ( DE22_POS_ENT_MODE_CD, 1, 2) AS posPANEntryMode,\n" +
                " SUBSTR ( DE48_SE39_ADC_DATA_TXT, 13, 6) AS caseKeyCode2,\n" +
                " SUBSTR ( DE48_SE39_ADC_DATA_TXT, 29, 1) AS numberOfEventsForMagneticStr3,\n" +
                " DE48_SE87_MAGSTRIP_CVC_CD AS cardValidationCodeResult,\n" +
                " SUBSTR ( DE48_SE39_ADC_DATA_TXT, 28, 1) AS numberOfEventsForPIN,\n" +
                " TRIM (SUBSTR ( DE43_CARD_ACPT_NAM_LOC, 24, 13)) AS merchantsCity,\n" +
                " SUBSTR ( DE61_POS_DATA_TXT, 10, 1) AS cardholderActivatedTerminalL7,\n" +
                " SUBSTR ( DE61_POS_DATA_TXT, 14, 3) AS posCountryCode,\n" +
                " SUBSTR ( DE48_SE39_ADC_DATA_TXT, 26, 1) AS numberOfEventsForExpirationD9,\n" +
                " DE4_TRAN_AMT AS transactionAmount,\n" +
                " SUBSTR ( DE61_POS_DATA_TXT, 11, 1) AS posCardDataTermInputCapabili11,\n" +
                " SUBSTR ( DE3_PRCSS_CD, 1, 2) AS transactionType,\n" +
                " DE42_CARD_ACPT_ID_CD AS cardAcceptorIdCode,\n" +
                " DE48_SE20_CRDHLDR_VER_MTHD_CD AS cardholderVerificationMethod,\n" +
                " DE18_MERCH_TYPE_CD AS merchantType,\n" +
                " SUBSTR ( DE48_SE39_ADC_DATA_TXT, 19, 6) AS caseKeyCode3,\n" +
                " IPREVENT_SCR_NUM AS emsAdjustedScore,\n" +
                " DE39_ISSR_RESP_CD AS responseCode,\n" +
                " SUBSTR ( DE48_SE39_ADC_DATA_TXT, 27, 1) AS numberOfEventsForCVC2,\n" +
                " DE5_SETL_AMT AS settlementAmount,\n" +
                " SUBSTR ( DE48_SE39_ADC_DATA_TXT, 25, 1)\n" +
                " AS numberOfEventsForAccountNumber,\n" +
                " SUBSTR ( DE48_SE39_ADC_DATA_TXT, 30, 1)\n" +
                " AS numberOfEventsForPersonalInf22,\n" +
                " IPREVENT_RSN_CD AS emsAdjustedReasonCode,\n" +
                " SUBSTR ( DE48_SE39_ADC_DATA_TXT, 7, 6) AS caseKeyCode1,\n" +
                " DE32_ACQ_INST_ID AS acquireInstitutionIdCode,\n" +
                " SUBSTR ( DE43_CARD_ACPT_NAM_LOC, 38, 3) AS merchantsState,\n" +
                " DE49_TRAN_CURR_CD AS transactionCurrencyCode,\n" +
                " TRIM (SUBSTR ( DE43_CARD_ACPT_NAM_LOC, 1, 22)) AS merchantName,\n" +
                " SUBSTR ( DE61_POS_DATA_TXT, 5, 1) AS posCardPresence,\n" +
                " SUBSTR ( DE22_POS_ENT_MODE_CD, 3, 1) AS posPINEntryMode,\n" +
                " DE41_CARD_ACPT_TERM_ID AS cardAcceptorTerminalId,\n" +
                " SUBSTR ( DE61_POS_DATA_TXT, 4, 1) AS posCardholderPresence,\n" +
                " DE6_BILL_AMT AS cardholderBillingAmount\n" +
            "   FROM public.PROCESSED_TRAN PT\n" +
            "   WHERE PT.PRCSS_DT_TM >= TO_DATE ( :startDate, 'MM/dd/yyyy HH24:mi:ss')\n" +
            "   AND PT.PRCSS_DT_TM <= TO_DATE ( :endDate, 'MM/dd/yyyy HH24:mi:ss')\n" +
//            "   AND PT.AUTH_ACCT_RNG_ID IN\n" +
//                " (5739,\n" +
//                " 640,\n" +
//                " 6405,\n" +
//                " 139725,\n" +
//                " 100416,\n" +
//                " 104223,\n" +
//                " 80385,\n" +
//                " 8850,\n" +
//                " 8851,\n" +
//                " 8854,\n" +
//                " 47161,\n" +
//                " 96428,\n" +
//                " 125223,\n" +
//                " 109459,\n" +
//                " 9139,\n" +
//                " 9140,\n" +
//                " 9173,\n" +
//                " 41906,\n" +
//                " 9174,\n" +
//                " 11471,\n" +
//                " 11472,\n" +
//                " 11473,\n" +
//                " 19355,\n" +
//                " 23031)\n" +
            "   AND PT.CUST_CLSTR_ID IN (1, 2, 3)\n" +
            "   ORDER BY PRCSS_DT_TM LIMIT 900000;";

    public List queryByCustomer(String startDate, String endDate) {
        Map namedParameters = new HashMap();
        namedParameters.put("startDate", startDate);
        namedParameters.put("endDate", endDate);
        return namedParameterJdbcTemplate.queryForList(customerQuery, namedParameters).subList(0,20);
    }

    public List queryByCustomerTest(String lastName) {
        Map namedParameters = new HashMap();
        namedParameters.put("lastName", lastName);
        return namedParameterJdbcTemplate.queryForList("select * from people where lastName = :lastName", namedParameters);
    }
}
