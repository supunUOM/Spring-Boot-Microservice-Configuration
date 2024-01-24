############## PERSISTANCE ANNOTATION ###############
====================== 1 optinal ======================
/** if we try to save courseMaterial without a course it will going to throw error **/
public class CourseMaterial{
    @OneToOne(
        cascade = CascadeType.ALL,
        optional = true
    )
    private Course course;

}
________________________
public class Course {
    @OneToOne
    private CourseMaterial courseMaterial;
}

====================== ======================




############# WRITE CUSTOM QUERIES WITH HIBERNATE ###############
====================== 0 JPQL ======================
public interface SampleRepository extends JpaRepository<Sample, Integer> {

    @Query(value = "SELECT s FROM sample s WHERE s.deviceId=?1 AND STR_TO_DATE(s.timeStamp, '%Y-%m-%d %H:%i:%s') BETWEEN ?2 AND ?3")
    List<Sample> getSampleDataForTimeInterval(String deviceId, String startTime, String endTime);

    //JPQL with named parameters
    @Query("SELECT e from Employee e where e.firstName=:firstname")
    List<Employee> findByFirstName(@Param("firstname") String firstName, Sort sort);

    //JPQL with index parameters
    @Query("SELECT e from Employee e where e.firstName=?1 and e.department= ?2")
    List<Employee> findByFirstNamewithIndexParam( String firstName, String department);

    //Native SQL with named parameters
    @Query(value = "SELECT * from Employee e where e.lastname=:lastname", nativeQuery = true)
    List<Employee> findByLastName(@Param("lastname") String lastname);

    //Native SQL with Index parameters
    @Query(value = "SELECT * from Employee e where e.lastname= ?1 and e.department= ?2", nativeQuery = true)
    List<Employee> findByLastNamewithIndexParam(String lastname, String department);

    //SQL IN UNNEST
    @Query("SELECT * FROM tbl_team_profile  WHERE team_id in UNNEST(@teamIds) AND language_code = @languageCode")
    List<TeamProfile> findTeamsByIDsAndLanguageCode(@Param("teamIds") List<Long> teamIds, @Param("languageCode") String languageCode);
}

====================== 1 ====================== ( https://youtu.be/56pK77U307g?si=vQHIaKdE_vf9SuIO )
  public class EmpCustomRepositoryImpl implements EmpCustomRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Employee> findByFirstName(String firstname) {
        String sql = "select e from Employee e where e.firstName = :firstname";
        final TypedQuery<Employee> query = entityManager.createQuery(sql, Employee.class);
        query.setParameter("firstname", firstname);
        return query.getResultList();
    }
}

====================== 2 Bouli Ali ====================== 
Spring Data JPA - Criteria Queries
https://youtu.be/qpSasUow1XI?si=aQ0VKCT1QZUAuZvH 
