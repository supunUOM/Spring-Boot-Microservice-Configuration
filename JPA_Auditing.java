Source: https://youtu.be/lGULtrZqk-c?si=RWEKpdRAF8r20-fb
/*
  * we can add 
  * created_at
  * modified_at options for any entity using below
*/
================================ Step 1 ================================
@Data
@Entity
@EntityListners(AuditingEntityListners.class)
public class Book{
@Id
private String bookId;

@CreatedData
private LocatDateTime createDate;
@LastModifiedDate
private LocalDateTime modifiedDate;
}

================================ Step 2 ================================

in the application entry point we need to add the @EnableJpaAuditing below annotation

@SpringBootApplication
@EnableJpaAuditing

================================ Step 3 ================================
specify the below @Column annotations
    @CreatedBy
    @Column(
            nullable = false,
            updatable = false
    )
    private Integer createdBy;

    @LastModifiedBy
    @Column(insertable = false)
    private Integer lastModifiedBy;
