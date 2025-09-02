package colombe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class RestaurantTest {
    Plat plat1;
    Plat plat2;
    Commande commande1;
    Client client1;


    @BeforeEach
    void setUp() {
        plat1 = new Plat(1,"Saucisse",10);
        plat2 = new Plat(2,"Poisson",5);
        commande1 = new Commande(1, Instant.now());
        commande1.addPlat(plat1);
        commande1.addPlat(plat2);
        client1 = new Client(1,"Coco","0612345678","coco@gmail.com", Collections.singletonList(commande1));
    }

    @Test
    void should_return_current_plat_price_ok(){
        assertEquals(10,plat1.getLastPrix());
    }

    @Test
    void should_return_total_price_of_a_command_ok(){
        assertEquals(15,commande1.getTotalPrice());
    }

    @Test
    void should_change_price_of_plat_and_keep_record_of_it(){
        plat1.changePrix(30.0,"Inflation");
        assertEquals(2,plat1.getHistoriquePrix().size());
    }

    @Test
    void should_return_command_between_two_instant_ok(){
        assertEquals(1,client1.getCommandeBetweenTwoInstants(Instant.now().minusSeconds(1000),Instant.now()).size());
    }




}
