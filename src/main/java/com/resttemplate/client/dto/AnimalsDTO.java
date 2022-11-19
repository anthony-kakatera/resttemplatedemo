package com.resttemplate.client.dto;

import java.util.List;

public class AnimalsDTO {
    private String count;
    private EntryDTO [] entries;

    public AnimalsDTO(){}

    public AnimalsDTO(String count, EntryDTO[] entries) {
        this.count = count;
        this.entries = entries;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public EntryDTO[] getEntries() {
        return entries;
    }

    public void setEntries(EntryDTO[] entries) {
        this.entries = entries;
    }
}
