package com.example.demo.model;

import javax.persistence.MappedSuperclass;
import java.time.Instant;

@MappedSuperclass
public class Auditable {

    public Instant createdDate;
}
