package web.persist;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
@Repository
public class CarRepository {
    private Map<Long,Car> carMap = new ConcurrentHashMap<>();
    private AtomicLong identity = new AtomicLong(0);

    @PostConstruct
    public void init(){
        this.insert(new Car("LADA"));
        this.insert(new Car("MAZDA"));
        this.insert(new Car("VAZDA"));
        this.insert(new Car("ZVEZDA"));
        this.insert(new Car("ZDA"));
    }

    public void insert(Car car){
        long id = identity.incrementAndGet();
        car.setId(id);
        carMap.put(id,car);
    }
}
