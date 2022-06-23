package ru.netology;
import java.util.Objects;

public class Tickets implements Comparable<Tickets> {

    private int id;
    private int sum;
    private int time;
    private String sending;
    private String arrival;

public Tickets(int id,int sum,int time,String sending,String arrival){
    this.id = id;
    this.arrival = arrival;
    this.sending = sending;
    this.sum = sum;
    this.time = time;
}


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getSending() {
        return sending;
    }

    public void setSending(String sending) {
        this.sending = sending;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    @Override

    public int compareTo(Tickets otherTicket) {
        if (sum < otherTicket.sum) {
            return -1;
        }
        if (sum > otherTicket.sum) {
            return +1;
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tickets tickets = (Tickets) o;
        return id == tickets.id && sum == tickets.sum && time == tickets.time && Objects.equals
                (arrival, tickets.arrival) && Objects.equals(sending, tickets.sending);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sending, sum, arrival, time);
    }
}
