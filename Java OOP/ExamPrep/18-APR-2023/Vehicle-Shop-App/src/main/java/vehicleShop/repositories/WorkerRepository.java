package vehicleShop.repositories;

import vehicleShop.models.worker.Worker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class WorkerRepository implements Repository<Worker> {

    private Collection<Worker> workers;

    public WorkerRepository(){
        this.workers = new ArrayList<>();
    }

    @Override
    public Collection<Worker> getWorkers() {
        return Collections.unmodifiableCollection(workers);
    }

    @Override
    public void add(Worker model) {
        this.workers.add(model);
    }

    @Override
    public boolean remove(Worker model) {
        if(this.workers.contains(model)){
            this.workers.remove(model);
            return true;
        }
        return false;
    }

    @Override
    public Worker findByName(String name) {
        return this.workers.stream().filter(w ->
                        w.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}
