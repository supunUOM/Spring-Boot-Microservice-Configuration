
// Write custom queries with hibernate
public interface SampleRepository extends JpaRepository<Sample, Integer> {

    @Query(value = "SELECT s FROM sample s WHERE s.deviceId=?1 AND STR_TO_DATE(s.timeStamp, '%Y-%m-%d %H:%i:%s') BETWEEN ?2 AND ?3")
    List<Sample> getSampleDataForTimeInterval(String deviceId, String startTime, String endTime);
}
