package ru.netology;
import java.util.Arrays;

public class TicketManager {

    private Repository repository;


    public TicketManager (Repository repository){
        this.repository = repository;
    }

    public Tickets[] findAllByFromArrival(String sanding, String arrival) {
        Tickets[] ans = new Tickets[0];
        for (Tickets tickets : repository.findAll()) {
            if (tickets.getArrival().equals(arrival) && tickets.getSending().equals(sanding)) {
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
