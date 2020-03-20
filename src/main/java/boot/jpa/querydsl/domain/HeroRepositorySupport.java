package boot.jpa.querydsl.domain;

import boot.jpa.querydsl.query.OrderByNull;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

import static boot.jpa.querydsl.domain.QHero.hero;

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

    public List<Integer> getGroupOne() {
        return jpaQueryFactory.select(Expressions.ONE)
                .from(hero)
                .groupBy(hero.age)
                .fetch();
    }

    public List<Integer> getGroupOneOrderByNull() {
        return jpaQueryFactory.select(Expressions.ONE)
                .from(hero)
                .groupBy(hero.age)
                .orderBy(OrderByNull.DEFAULT) // order by null
                .fetch();
    }
}
