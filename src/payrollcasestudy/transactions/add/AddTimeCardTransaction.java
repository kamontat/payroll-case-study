package payrollcasestudy.transactions.add;

import payrollcasestudy.boundaries.PayrollDatabase;
import payrollcasestudy.entities.Employee;
import payrollcasestudy.entities.TimeCard;
import payrollcasestudy.entities.paymentclassifications.HourlyClassification;
import payrollcasestudy.entities.paymentclassifications.PaymentClassification;
import payrollcasestudy.transactions.Transaction;

import java.util.Calendar;

/**
 * Created by zhangshijie on 7/25/16.
 */
public class AddTimeCardTransaction implements Transaction {
    private Calendar date;
    private double hours;
    private int employeeId;

    @Override
    public void execute() {
        Employee employee = PayrollDatabase.globalPayrollDatabase.getEmployee( employeeId );
        if ( employee != null )
        {
            PaymentClassification paymentClassification = employee.getPaymentClassification();
            if ( paymentClassification instanceof HourlyClassification ) {
                HourlyClassification classification = ( HourlyClassification ) paymentClassification;
                classification.addTimeCard( new TimeCard( date, hours ) );
            }
        }
    }
}
