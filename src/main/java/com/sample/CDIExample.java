package com.sample;

import com.sample.model.Account;
import java.io.PrintStream;
import javax.inject.Inject;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.kie.api.cdi.KSession;
import org.kie.api.runtime.KieSession;

public class CDIExample {

    @Inject
    @KSession("ksession-rules")
    KieSession kSession;

    public void go(PrintStream out) {
        Account account = new Account(1, 200);
        account.withdraw(150);
        kSession.insert(account);
        kSession.fireAllRules();
    }

    public static void main(String[] args) {
        Weld w = new Weld();

        WeldContainer wc = w.initialize();
        CDIExample bean = wc.instance().select(CDIExample.class).get();
        bean.go(System.out);

        w.shutdown();
    }

}
