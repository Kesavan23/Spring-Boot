package com.write.batch;

import org.springframework.batch.item.ItemProcessor;

public class AmountItemProcessor implements ItemProcessor<Amount, Amount>{

	@Override
	public Amount process(Amount arg0) throws Exception {
		// TODO Auto-generated method stub
		//Once the amount is read from both the files under the same transaction name. They 
		//are summed together  and stored in the DB
		return null;
	}
	
	

}
