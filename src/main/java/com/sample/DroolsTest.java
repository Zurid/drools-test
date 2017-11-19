package com.sample;

import com.sample.model.Account;
import com.sample.model.Transaction;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * This is a sample class to launch a rule.
 */
public class DroolsTest {

    public static void main(String[] args) {
        System.out.println("starting the programm");
        try {
            // load up the knowledge base
            KieServices ks = KieServices.Factory.get();
            KieContainer kContainer = ks.getKieClasspathContainer();
            KieSession kSession = kContainer.newKieSession("ksession-rules");
            String expectedPattern = "MM/dd/yyyy";
            SimpleDateFormat formatter = new SimpleDateFormat(expectedPattern);

            // go !
            Account account = new Account(1, 50);
  //          List<Transaction> transactions = new ArrayList<>();
            kSession.insert(new Transaction(1, 1, formatter.parse("09/22/2009"), new BigDecimal("100")));
            kSession.insert(new Transaction(2, 1, formatter.parse("09/22/2012"), new BigDecimal("101")));
            kSession.insert(new Transaction(3, 1, formatter.parse("09/22/2015"), new BigDecimal("103")));
//            account.withdraw(250);
            kSession.insert(account);
//            kSession.insert(transactions);
            kSession.fireAllRules();
        } catch (ParseException t) {
            t.printStackTrace();
        }
        System.out.println("finished the programm");
    }

    public static class Message {

        public static final int HELLO = 0;
        public static final int GOODBYE = 1;

        private String message;

        private int status;

        public String getMessage() {
            return this.message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public int getStatus() {
            return this.status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

    }

}
