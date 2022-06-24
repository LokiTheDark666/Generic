package ru.netology;
import java.util.Arrays;

public class TicketManager {

    private Repository repository;
    private Tickets[] tickets = new Tickets[0];

    public TicketManager (Repository repository){
        this.repository = repository;
    }

    public Tickets[] findAllByFromArrival(String sanding, String arrival) {
        Tickets[] ans = new Tickets[0];
        for (Tickets tickets : repository.findAll()) {
            if (tickets.getSending() == sanding && tickets.getArrival() == arrival) {
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
