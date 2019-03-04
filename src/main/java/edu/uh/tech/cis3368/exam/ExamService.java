package edu.uh.tech.cis3368.exam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ExamService {

    private ServerRepository serverRepository;

    @Autowired
    public ExamService(ServerRepository serverRepository) {
        this.serverRepository = serverRepository;
    }


    public void createData() {
    }


}
