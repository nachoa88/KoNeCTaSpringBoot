package com.curso.apievents.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "events") // Creará la tabla con el nombre "events" (se podrá ver en MySQL)
public class Event {
    
    @Getter @Setter 
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int eventID;
    
    @Getter @Setter
    private String eventName;
    
    @Getter @Setter
    private String eventType;

    @Getter @Setter
    private String description;

    @Getter @Setter
    @Lob // Use @Lob annotation to store binary data
    private byte[] img; // Change the data type to byte[] or Blob

    @Getter @Setter
    private String location;

    @Getter @Setter
    private String locationHtml;
    
    @Getter @Setter
    private String startingDate;
    
    @Getter @Setter
    private String finishingDate;
    
    @Getter @Setter
    private String startingTime;
    
    @Getter @Setter
    private String finishingTime;
}
