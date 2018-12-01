package com.models.db;

import com.enums.SareeType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.models.db.intefaces.Product;
import io.dropwizard.jackson.JsonSnakeCase;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.NotEmpty;

import javax.annotation.Nonnull;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonSnakeCase
@Table(name = "product_details")
@Entity
@JsonIgnoreProperties
public class ProductDetails implements Product {

    @JsonProperty
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reference_id", unique = true)
    private long referenceId;

    @JsonProperty
    @Nonnull
    @NotEmpty
    @Column(name = "product_id", unique = true)
    @Id
    private String productId;

    @JsonProperty
    @Column(name = "saree_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private SareeType sareeType;

    @JsonProperty
    @NotEmpty
    @Column(name = "original_price", nullable = false)
    private Double originalPrice;

    @Column(name = "created_at", updatable = false)
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss z", timezone = "IST")
    private Date createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss z", timezone = "IST")
    private Date updatedAt;

    @JsonProperty
    @NotEmpty
    @Column(name = "selling_price", nullable = false)
    private Double sellingPrice;

    @JsonProperty
    @Column(name =  "saved_amount")
    private Double savedAmount;

    @JsonProperty
    @Column(name = "promotional_percentage")
    private Double promotionalPercentage;

    @JsonProperty
    @NotEmpty
    @Column(name = "available_qty", nullable = false)
    private Integer availableQty;

    @JsonProperty
    @NotEmpty
    @Column(name = "title", nullable = false)
    private String title;

    @JsonProperty
    @Column(name = "sub_title")
    private String subTitle;

    @JsonProperty
    @NotEmpty
    @Column(name = "description", nullable = false)
    private String description;

    @JsonProperty
    @Column(name = "category_type")
    private String categoryType;

    @JsonProperty
    @NotEmpty
    @Column(name = "colors", nullable = false)
    private String colors;

    @JsonProperty
    @NotEmpty
    @Column(name = "materials", nullable = false)
    private String materials;

    @JsonProperty
    @Column(name = "image_url1")
    private String imageUrl1;

    @JsonProperty
    @Column(name = "image_url2")
    private String imageUrl2;

    @JsonProperty
    @Column(name = "image_url3")
    private String imageUrl3;

    @JsonProperty
    @Column(name = "image_url4")
    private String imageUrl4;

    @JsonProperty
    @Column(name = "image_url5")
    private String imageUrl5;

    @JsonProperty
    @NotEmpty
    @Column(name = "is_active", nullable = false)
    private boolean isActive;

    @JsonProperty
    @NotEmpty
    @Column(name = "blouse_available", nullable = false)
    private boolean blouseAvailable;

    @JsonProperty
    @NotEmpty
    @Column(name = "owner", nullable = false)
    private String owner;

    @JsonProperty
    @Column(name = "sub_owner")
    private String subOwner;

}
