package boot.jpa.querydsl.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest
public class HeroRepositoryTest {

    @Autowired
    HeroRepository heroRepository;

    @Autowired
    HeroRepositorySupport heroRepositorySupport;

    @Test
    public void ReturnTheResultBasedOnTheAge() {
        //given
        int myAge = 27;
        int heroAge = 500;
        heroRepository.saveAll(
                Arrays.asList(
                        new Hero("hong-il", 100, "github.com/hong-il"),
                        new Hero("hong-il", myAge, "github.com/hong-il"),
                        new Hero("hong-il", heroAge, "github.com/hong-il")
                ));
        //when
        List<Integer> result = heroRepositorySupport.getGroupOneOrderByNull();

        //then
        assertThat(result.size(), is(3));
    }
}
