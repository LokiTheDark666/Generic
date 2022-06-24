package ru.netology;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestManager {

    private Repository repository = new Repository();
    private TicketManager ticketManager = new TicketManager(repository);

    private Tickets ticket1 = new Tickets(1,2000,522,"GOJ","LED");
    private Tickets ticket2 = new Tickets(2,3999,511,"LED","KUF");
    private Tickets ticket3 = new Tickets(3,2500,155,"LED","KUF");
    private Tickets ticket4 = new Tickets(4,5000,215,"KUF","LED");
    private Tickets ticket5 = new Tickets(5,4500,211,"GOJ","KUF");
    private Tickets ticket6 = new Tickets(6,4800,112,"KUF","GOJ");

  @BeforeEach
    public void setUp(){
      repository.add(ticket1);
      repository.add(ticket2);
      repository.add(ticket3);
      repository.add(ticket4);
      repository.add(ticket5);

  }


  @Test
    public void shouldAdd(){
      repository.add(ticket6);
      Tickets[] actual = repository.findAll();
      Tickets[] expected = {ticket1,ticket2,ticket3,ticket4,ticket5,ticket6};
      Assertions.assertArrayEquals(expected,actual);
  }

  @Test
    public void shouldRemoveById(){
      repository.removeById(1);
      repository.removeById(2);
      Tickets[] actual = repository.findAll();
      Tickets[] expected = {ticket3,ticket4,ticket5};
      Assertions.assertArrayEquals(expected,actual);
  }

  @Test
    public void shouldFindBySendingAndArrival(){
      Tickets[] actual = ticketManager.findAllByFromArrival("KUF","LED");
      Tickets[] expected = {ticket4};
      Assertions.assertArrayEquals(expected,actual);
  }

  @Test
    public void shouldFindIncorrectSanding(){
      Tickets[] actual = ticketManager.findAllByFromArrival("ggg","LED");
      Tickets[] expected = {};
      Assertions.assertArrayEquals(expected,actual);
  }

@Test
    public void shouldFindIncorrectArrival(){
      Tickets[] actual = ticketManager.findAllByFromArrival("LED","ggg");
      Tickets[] expected = {};
      Assertions.assertArrayEquals(expected,actual);
}

@Test
    public void shouldBy2SortSum(){
      Tickets[] actual = ticketManager.findAllByFromArrival("LED","KUF");
      Tickets[] expected = {ticket3,ticket2};
      Assertions.assertArrayEquals(expected,actual);
}

}
