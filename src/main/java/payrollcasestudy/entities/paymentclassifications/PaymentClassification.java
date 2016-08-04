
package main.java.payrollcasestudy.entities.paymentclassifications;

import java.util.Calendar;

import main.java.payrollcasestudy.entities.PayCheck;

/**
 * Created by zhangshijie on 7/22/16.
 */
public abstract class PaymentClassification
{

	public abstract double calculatePay( PayCheck payCheck );

	public static boolean isInPayPeriod( Calendar date, PayCheck payCheck )
	{
		Calendar payPeriodStart = payCheck.getPayPeriodStart( );
		Calendar payPeriodEnd = payCheck.getPayPeriodEnd( );
		return date.equals( payPeriodEnd )
				|| date.equals( payPeriodStart )
				|| ( date.after( payPeriodStart )
						&& date.before( payPeriodEnd ) );
	}
}