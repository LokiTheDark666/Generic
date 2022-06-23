package ru.netology;
import java.security.PublicKey;
import java.util.Arrays;

public class TicketManager {

    private Repository repository;
    private Tickets[] tickets = new Tickets[0];

    public TicketManager (Repository repository){
        this.repository = repository;
    }

    public Tickets[] findAllByFromTo(String from, String to) {
        Tickets[] ans = new Tickets[0];
        for (Tickets tickets : repository.findAll()) {
            if (tickets.getSending() == from && tickets.getArrival() == to) {
                Tickets[] tmp = new Tickets[ans.length + 1];
                for (int i = 0; i < ans.length; i++) {
                    tmp[i] = ans[i];
                }
                tmp[tmp.length - 1] = tickets;
                ans = tmp;
            }
        }
        Arrays.sort(ans);
        return ans;
    }
}
