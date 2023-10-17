package com.resellerapp.service;

import com.resellerapp.model.entity.Condition;
import com.resellerapp.model.enums.ConditionName;
import com.resellerapp.repository.ConditionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ConditionService {

    private ConditionRepository conditionRepository;

    @Autowired
    public ConditionService(ConditionRepository conditionRepository) {
        this.conditionRepository = conditionRepository;
    }

    @PostConstruct
    public void init() {
        boolean hasConditions = conditionRepository.count() > 0;

        if (!hasConditions) {
            List<Condition> conditions = new ArrayList<>();

            Arrays.stream(ConditionName.values())
                    .forEach(conditionName -> {
                        Condition condition = new Condition();
                        condition.setName(conditionName);
                        conditions.add(condition);
                    });

            conditionRepository.saveAll(conditions);
        }
    }
}
