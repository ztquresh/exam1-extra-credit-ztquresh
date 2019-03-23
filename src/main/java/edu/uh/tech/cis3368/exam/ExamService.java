package edu.uh.tech.cis3368.exam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.ArrayList;



@Service
public class ExamService {
    //DONE

    private ServerRepository serverRepository;

    @Autowired
    public ExamService(ServerRepository serverRepository) {
        this.serverRepository = serverRepository;
    }

    public void createData() {

        Server server = new Server();

        server.setName("Web");
        server.setLocation("T2 120");
        server.setReplacementCost(new BigDecimal("4424.73"));
        server.setRunningCost(new BigDecimal("0.002"));
        serverRepository.save(server);

        Server server2 = new Server();

        server2.setName("HR");
        server2.setLocation("T2 110");
        server2.setReplacementCost(new BigDecimal("1549.14"));
        server2.setRunningCost(new BigDecimal("0.010"));
        serverRepository.save(server2);

        Server server3 = new Server();

        server3.setName("DNS");
        server3.setLocation("T3 121");
        server3.setReplacementCost(new BigDecimal("4040.34"));
        server3.setRunningCost(new BigDecimal("0.021"));
        serverRepository.save(server3);

        Server server4 = new Server();

        server4.setName("DNS2");
        server4.setLocation("T3 121");
        server4.setReplacementCost(new BigDecimal("4494.27"));
        server4.setRunningCost(new BigDecimal("0.001"));
        serverRepository.save(server4);

        Server server5 = new Server();

        server5.setName("Application");
        server5.setLocation("T2 110");
        server5.setReplacementCost(new BigDecimal("2904.44"));
        server5.setRunningCost(new BigDecimal("0.02"));
        serverRepository.save(server5);

    }




    public BigDecimal calculateTotalRunningCost() {
        // get a list of all the servers
        ArrayList<Server> servers = serverRepository.findAll();
        return servers.stream().map(server -> server.getRunningCost()).reduce(BigDecimal.ZERO, BigDecimal::add);
    }





    public void updateCosts() {
        Iterable<Server> servers = serverRepository.findAll();
        servers.forEach(server -> {
            var currentCost = server.getReplacementCost();
            var updatedCost = currentCost.add(new BigDecimal("200.00"));
            server.setReplacementCost(updatedCost);
            serverRepository.save(server);

        });
    }
}





