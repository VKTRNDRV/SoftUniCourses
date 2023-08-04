package vehicleShop.core;

import vehicleShop.common.ConstantMessages;
import vehicleShop.common.ExceptionMessages;
import vehicleShop.models.shop.Shop;
import vehicleShop.models.shop.ShopImpl;
import vehicleShop.models.tool.Tool;
import vehicleShop.models.tool.ToolImpl;
import vehicleShop.models.vehicle.Vehicle;
import vehicleShop.models.vehicle.VehicleImpl;
import vehicleShop.models.worker.FirstShift;
import vehicleShop.models.worker.SecondShift;
import vehicleShop.models.worker.Worker;
import vehicleShop.repositories.VehicleRepository;
import vehicleShop.repositories.WorkerRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ControllerImpl implements Controller{

    private WorkerRepository workerRepository;

    private VehicleRepository vehicleRepository;

    private Shop shop;

    private int vehiclesMadeCount;

    public ControllerImpl(){
        this.workerRepository = new WorkerRepository();
        this.vehicleRepository = new VehicleRepository();
        this.shop = new ShopImpl();
        this.vehiclesMadeCount = 0;
    }

    @Override
    public String addWorker(String type, String workerName) {
        Worker worker;
        if(type.equals("FirstShift")){
            worker = new FirstShift(workerName);
        }else if(type.equals("SecondShift")){
            worker = new SecondShift(workerName);
        }else {
            throw new IllegalArgumentException(ExceptionMessages
                    .WORKER_TYPE_DOESNT_EXIST);
        }

        this.workerRepository.add(worker);
        return String.format(ConstantMessages
                .ADDED_WORKER, type, workerName);
    }

    @Override
    public String addVehicle(String vehicleName, int strengthRequired) {
        Vehicle vehicle = new VehicleImpl(vehicleName, strengthRequired);
        this.vehicleRepository.add(vehicle);
        return String.format(ConstantMessages
                .SUCCESSFULLY_ADDED_VEHICLE, vehicleName);
    }

    @Override
    public String addToolToWorker(String workerName, int power) {
        Worker worker = this.workerRepository.findByName(workerName);
        if(worker == null){
            throw new IllegalArgumentException(ExceptionMessages
                    .HELPER_DOESNT_EXIST);
        }
        Tool tool = new ToolImpl(power);
        worker.addTool(tool);
        return String.format(ConstantMessages
                .SUCCESSFULLY_ADDED_TOOL_TO_WORKER, power, worker.getName());
    }

    @Override
    public String makingVehicle(String vehicleName) {
        Collection<Worker> fitWorkers = new ArrayList<>();
        for(Worker worker : workerRepository.getWorkers()){
            if(worker.getStrength() > 70){
                fitWorkers.add(worker);
            }
        }
        if(fitWorkers.isEmpty()){
            throw new IllegalArgumentException(ExceptionMessages
                    .NO_WORKER_READY);
        }

        int initialUnfitToolsCount = getCountOfUnfitTools(fitWorkers);
        Vehicle vehicle = vehicleRepository.findByName(vehicleName);
        for(Worker worker : fitWorkers){
            if(!vehicle.reached()){
                this.shop.make(vehicle, worker);
            }
        }

        int toolsBrokenCount = getCountOfUnfitTools(fitWorkers) - initialUnfitToolsCount;
        String isDone = vehicle.reached() ? "done" : "not done";
        if(vehicle.reached()){
            this.vehiclesMadeCount++;
        }
        return String.format(
                ConstantMessages.VEHICLE_DONE + ConstantMessages.COUNT_BROKEN_INSTRUMENTS,
                vehicleName, isDone, toolsBrokenCount);
    }

    private int getCountOfUnfitTools(Collection<Worker> workers){
        int count = 0;
        for(Worker worker : workers){
            for(Tool tool : worker.getTools()){
                if(tool.isUnfit()){
                    count++;
                }
            }
        }
        return count;
    }

    private int getCountOfFitTools(Worker worker){
        int count = 0;
        for(Tool tool : worker.getTools()){
            if(!tool.isUnfit()){
                count++;
            }
        }
        return count;
    }

    @Override
    public String statistics() {
        StringBuilder output = new StringBuilder();
        output.append(String.format("%d vehicles are ready!", this.vehiclesMadeCount))
                .append(System.lineSeparator())
                .append("Info for workers:")
                .append(System.lineSeparator());
        for(Worker worker : workerRepository.getWorkers()){
            int fitToolsCount = getCountOfFitTools(worker);
            output.append(String.format(
                    "Name: %s, Strength: %d",
                            worker.getName(), worker.getStrength()))
                    .append(System.lineSeparator())
                    .append(String.format(
                            "Tools: %d fit left", fitToolsCount))
                    .append(System.lineSeparator());
        }

        return output.toString().trim();
    }
}
