package com.example.backend.model;


// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.Lob;
// import jakarta.persistence.Table;
// import lombok.AllArgsConstructor;
// import lombok.Builder;
// import lombok.Data;
// import lombok.NoArgsConstructor;

// @Entity
// @Table(name = "ImageData")
// @AllArgsConstructor
// @NoArgsConstructor
// @Builder
// @Data // for getter setter tostring
// public class ImageData {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private long id;
//     private String type;
//     private String name;

//     @Lob
//     @Column(name = "imageData")
//     private byte[] imageData;


// }

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ImageData")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data // for getter setter tostring
public class ImageData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String type;
    private String name;

    @Lob
    @Column(name = "imageData",columnDefinition = "LONGBLOB")
    private byte[] imageData;


}
