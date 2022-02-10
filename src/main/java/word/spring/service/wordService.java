package word.spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import word.spring.repository.WordRepository;

@Service
@RequiredArgsConstructor
public class wordService {

    private final WordRepository wordRepository;



}
