package com.bppl.SACCR_Reporting.repository;

import java.sql.Date;
import java.util.List;

import javax.persistence.Id;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

// tables required
import com.bppl.SACCR_Reporting.model.CR2;

public interface CR2Repository extends CrudRepository<CR2, Integer>{

	//CR1
	//1a
	@Query("select sum(EOP_BALANCE_AMT) from CR2 where (STD_PRODUCT_TYPE_CD = 'LOAN' or STD_PRODUCT_TYPE_CD = 'RME') and ACCT_PASTDUE_FLAG = 'Y'")
	Double LoansDefaultedExposure();
	
	//1b
	@Query("select sum(EOP_BALANCE_AMT) from CR2 where (STD_PRODUCT_TYPE_CD = 'LOAN' or STD_PRODUCT_TYPE_CD = 'RME') and ACCT_PASTDUE_FLAG = 'N'")
	Double LoansNotDefaultedExposure();
	
	//1c
	@Query("select (sum(TOT_WRITE_OFF_AMT) + sum(COLLECTIVE_PROVISION_AMT) + sum(SPECIFIC_PROVISION_AMT) + sum(OTH_PROVISION_AMT)) from CR2 where (STD_PRODUCT_TYPE_CD = 'LOAN' or STD_PRODUCT_TYPE_CD = 'RME')")
	Double LoansAllowances();
	
	//1d
	@Query("select sum(SPECIFIC_PROVISION_AMT) from CR2 where (STD_PRODUCT_TYPE_CD = 'LOAN' or STD_PRODUCT_TYPE_CD = 'RME')")
	Double LoansAllocatedSpecific();
	
	//1e
	@Query("select (sum(TOT_WRITE_OFF_AMT) + sum(COLLECTIVE_PROVISION_AMT) + sum(OTH_PROVISION_AMT)) from CR2 where (STD_PRODUCT_TYPE_CD = 'LOAN' or STD_PRODUCT_TYPE_CD = 'RME')")
	Double LoansAllocatedGeneral();
	
	//2a
	@Query("select sum(EOP_BALANCE_AMT) from CR2 where STD_PRODUCT_TYPE_CD = 'BOND' and ACCT_PASTDUE_FLAG = 'Y'")
	Double DebtDefalutedExposure();
		
	//2b
	@Query("select sum(EOP_BALANCE_AMT) from CR2 where STD_PRODUCT_TYPE_CD = 'BOND' and ACCT_PASTDUE_FLAG = 'N'")
	Double DebtNotDefalutedExposure();
	
	//2c
	@Query("select sum(TOT_WRITE_OFF_AMT) + sum(COLLECTIVE_PROVISION_AMT) +sum(SPECIFIC_PROVISION_AMT) from CR2 where STD_PRODUCT_TYPE_CD = 'BOND'")
	Double DebtAllowances();
		
	//2d
	@Query("select sum(SPECIFIC_PROVISION_AMT) from CR2 where STD_PRODUCT_TYPE_CD = 'BOND' ")
	Double DebtAllocatedSpecific();
		
	//2e
	@Query("select sum(TOT_WRITE_OFF_AMT) + sum(COLLECTIVE_PROVISION_AMT) +sum(OTH_PROVISION_AMT) from CR2 where STD_PRODUCT_TYPE_CD = 'BOND'")
	Double DebtAllocatedGeneral();
	
	//3a
	@Query("select sum(EOP_BALANCE_AMT) from CR2 where ACCT_PASTDUE_FLAG = 'Y' and( STD_PRODUCT_TYPE_CD = 'LC' or STD_PRODUCT_TYPE_CD = 'GUAR' or STD_PRODUCT_TYPE_CD = 'COMM')")
	Double OffBalanceDefaultedExposure();
	
	//3b
	@Query("select sum(EOP_BALANCE_AMT) from CR2 where ACCT_PASTDUE_FLAG = 'N' and( STD_PRODUCT_TYPE_CD = 'LC' or STD_PRODUCT_TYPE_CD = 'GUAR' or STD_PRODUCT_TYPE_CD = 'COMM')")
	Double OffBalanceNotDefaultedExposure();
	
	//3c
	@Query("select sum(TOT_WRITE_OFF_AMT + COLLECTIVE_PROVISION_AMT + SPECIFIC_PROVISION_AMT + OTH_PROVISION_AMT) from CR2 where STD_PRODUCT_TYPE_CD = 'LC' or STD_PRODUCT_TYPE_CD = 'GUAR' or STD_PRODUCT_TYPE_CD = 'COMM'")
	Double OffBalanceAllowances();
	
	//3d
	@Query("select sum(SPECIFIC_PROVISION_AMT) from CR2 where STD_PRODUCT_TYPE_CD = 'LC' or STD_PRODUCT_TYPE_CD = 'GUAR' or STD_PRODUCT_TYPE_CD = 'COMM'")
	Double OffBalanceAllocatedSpecific();
	
	//3e
	@Query("select sum(TOT_WRITE_OFF_AMT + COLLECTIVE_PROVISION_AMT +  OTH_PROVISION_AMT) from CR2 where STD_PRODUCT_TYPE_CD = 'LC' or STD_PRODUCT_TYPE_CD = 'GUAR' or STD_PRODUCT_TYPE_CD = 'COMM'")
	Double OffBalanceAllocatedGeneral();
	
	//CR2
	//13d
	@Query("select sum(DEF_EXP_PAST_PRD) from CR2 where (STD_PRODUCT_TYPE_CD = 'LOAN' or STD_PRODUCT_TYPE_CD = 'RME' or STD_PRODUCT_TYPE_CD = 'BOND')")
	Double DefaultedExpenditurePrevPeriod();
	
	//14d
	@Query("select sum(DEF_EXP_CUR_PRD) from CR2 where (STD_PRODUCT_TYPE_CD = 'LOAN' or STD_PRODUCT_TYPE_CD = 'RME' or STD_PRODUCT_TYPE_CD = 'BOND')")
	Double DefaultedExpenditureCurPeriod();
	
	//15d
	@Query("select sum(EOP_BALANCE_AMT) from CR2 where (STD_PRODUCT_TYPE_CD = 'LOAN' or STD_PRODUCT_TYPE_CD = 'RME' or STD_PRODUCT_TYPE_CD = 'BOND') and RET_TO_NDEFAULT_DT > LST_REP_DT")
	Double RetToNonDefaulted();
	
	//16d
	@Query("select sum(TOT_WRITE_OFF_AMT) from CR2 where (STD_PRODUCT_TYPE_CD = 'LOAN' or STD_PRODUCT_TYPE_CD = 'RME' or STD_PRODUCT_TYPE_CD = 'BOND')")
	Double AmountWriteOff();
	
	//17d
	@Query("select sum(OTH_PROVISION_AMT) from CR2 where (STD_PRODUCT_TYPE_CD = 'LOAN' or STD_PRODUCT_TYPE_CD = 'RME' or STD_PRODUCT_TYPE_CD = 'BOND')")
	Double OtherChanges();
}
