package ru.netology;

public class Repository {
    private Tickets[] tickets = new Tickets[0];

    public void add(Tickets ticket) {
        Tickets[] tmp = new Tickets[tickets.length + 1];
        for (int i = 0; i < tickets.length; i++) {
            tmp[i] = tickets[i];
        }
        tmp[tmp.length - 1] = ticket;
        tickets = tmp;
    }

    public Tickets[] findAll() {
        return tickets;
    }

    public void removeById(int id) {
        Tickets[] tmp = new Tickets[tickets.length - 1];
        int index = 0;
        for (Tickets ticket : tickets) {
            if (ticket.getId() != id) {
                tmp[index] = ticket;
                index++;
            }
        }
        tickets = tmp;
    }
}
