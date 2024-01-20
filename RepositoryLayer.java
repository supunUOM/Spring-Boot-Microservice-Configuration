//Methods for create custom queries with JPA
/**
** CUSTOM QUERIES
**
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
