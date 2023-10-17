package com.resellerapp.model.entity;

import com.resellerapp.model.enums.ConditionName;

import javax.persistence.*;

@Entity
@Table(name = "conditions")
public class Condition extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private ConditionName name;

    @Column(nullable = false)
    private String description;

    public ConditionName getName() {
        return name;
    }

    public void setName(ConditionName name) {
        this.name = name;
        this.setDescription(name);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private void setDescription(ConditionName name) {
        String description = "";

        switch (name) {
            case EXCELLENT:
                description = "In perfect condition";
                break;
            case GOOD:
                description = "Some signs of wear and tear or minor defects";
                break;
            case ACCEPTABLE:
                description = "The item is fairly worn but continues to function properly";
                break;
        }

        this.description = description;
    }
}
