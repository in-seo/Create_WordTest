package word.spring.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import word.spring.repository.WordRepository;

@Service
@AllArgsConstructor
public class wordService {

    private final WordRepository wordRepository;


}
