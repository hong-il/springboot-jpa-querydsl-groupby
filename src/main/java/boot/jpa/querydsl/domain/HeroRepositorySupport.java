package boot.jpa.querydsl.domain;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

@Repository
public class HeroRepositorySupport extends QuerydslRepositorySupport {
    
    private final JPAQueryFactory jpaQueryFactory;

    /**
     * Creates a new {@link QuerydslRepositorySupport} instance for the given domain type.
     *
     * @param jpaQueryFactory
     */
    public HeroRepositorySupport(JPAQueryFactory jpaQueryFactory) {
        super(Hero.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }
}
