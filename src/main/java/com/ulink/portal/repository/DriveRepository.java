package com.ulink.portal.repository;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ulink.portal.domain.Drive;
import com.ulink.portal.domain.UserProduct;

/**
 * Spring Data repository for the Drive entity.
 */
@Repository
public interface DriveRepository extends JpaRepository<Drive, Long> {

//	@Query("select drive from Drive drive where drive.user.login = ?#{principal.username}")
//	List<Drive> findByUserIsCurrentUser();

	Optional<Drive> findBySerialNumber (String serialNumber);
	
	Optional<Drive> findBySlotNumber (String slotNumber);
	
	

	@Query(
		nativeQuery = true,
		value =
			"SELECT " +
			"    dr.serial_number AS serialNumber, " +
			"    dr.storage_capacity AS totalCapacity, " +
			"    dr.storage_unit AS storageUnit, " +
			"    dm.name AS modelName, " +
			"    mnf.name AS manufactName, " +
			"    mnf.image_url AS manufactImageUrl, " +
			"    it.name AS interfaceType, " +
			"    us.firmware AS firmware, " +
			"    us.host_id AS hostId, " +
			"    us.host_ip AS hostIp, " +
			"    us.operating_system AS operatingSystem, " +
			"    rc.group_id AS raidGroupId, " +
			"    rc.type AS raidType, " +
			"    rs.name AS raidStatus " +
			"FROM " +
			"    drive dr " +
			"        INNER JOIN " +
			"    drive_model dm ON dm.id = dr.model_id " +
			"        INNER JOIN " +
			"    drive_manufacturer mnf ON mnf.id = dr.manufacturer_id " +
			"        INNER JOIN " +
			"    interface_type it ON it.id = dr.interface_type_id " +
			"        INNER JOIN " +
			"    user_system us ON us.id = dr.user_system_id " +
			"        INNER JOIN " +
			"    raid_config rc ON rc.id = dr.raid_config_id " +
			"        INNER JOIN " +
			"    raid_status rs ON rs.id = dr.raid_status_id " +
			"WHERE " +
			"    dr.is_active = 1 AND " +
			"    dr.id = :driveId AND dr.user_id = :userId ")
	Object[][] findDriveInfoById (
			@Param(value = "driveId") long driveId,
			@Param(value = "userId") long userId);

	@Query(
		nativeQuery = true,
		value =
		"SELECT " +
		"	 dms.minute_year AS dataTime, " +
		"    dms.drive_health AS driveHealth, " +
		"    dms.power_on_hours AS powerOnHours, " +
		"    dms.available_spare AS availableSpare, " +
		"    dms.head_flying_hrs AS headFlyingHours, " +
		"    dms.spindle_motor_poh AS spindleMotorPOH, " +
		"    dms.long_latency_write_count AS longLatencyWriteCount, " +
		"    dms.long_latency_read_count AS LongLatencyReadCount, " +
		"    dms.hardware_resets AS hardwareResets, " +
		"    dms.head_load_events AS headLoadEvents, " +
		"    dms.lifetime_power_on_resets AS powerOnResets, " +
		"    dms.power_cycles_count AS powerCyclesCount, " +
		"    dms.write_retry_count AS writeRetryCount, " +
		"    dms.read_retry_count AS readRetryCount, " +
		"    dms.current_temperature AS temperature " +
		"FROM " +
		"    devices_minute_summary dms " +
		"        INNER JOIN " +
		"    drive dr ON dr.id = dms.drive_id " +
		"        INNER JOIN " +
		"    user us ON us.id = dr.user_id " +
		"WHERE " +
		"    dr.is_active = 1 AND " +
		"    dms.drive_id = :driveId AND us.id = :userId " +
		"ORDER BY dms.minute_year DESC " +
		"LIMIT 7")
	Object[][] findDriveAttributesByMinute (
			@Param(value = "driveId") long driveId,
			@Param(value = "userId") long userId);

	@Query(
		nativeQuery = true,
		value =
			"SELECT " +
			"    dms.hour_year AS dataTime, " +
			"    dms.drive_health AS driveHealth, " +
			"    dms.power_on_hours AS powerOnHours, " +
			"    dms.available_spare AS availableSpare, " +
			"    dms.head_flying_hrs AS headFlyingHours, " +
			"    dms.spindle_motor_poh AS spindleMotorPOH, " +
			"    dms.long_latency_write_count AS longLatencyWriteCount, " +
			"    dms.long_latency_read_count AS LongLatencyReadCount, " +
			"    dms.hardware_resets AS hardwareResets, " +
			"    dms.head_load_events AS headLoadEvents, " +
			"    dms.lifetime_power_on_resets AS powerOnResets, " +
			"    dms.power_cycles_count AS powerCyclesCount, " +
			"    dms.write_retry_count AS writeRetryCount, " +
			"    dms.read_retry_count AS readRetryCount, " +
			"    dms.current_temperature AS temperature " +
			"FROM " +
			"    devices_hourly_summary dms " +
			"        INNER JOIN " +
			"    drive dr ON dr.id = dms.drive_id " +
			"        INNER JOIN " +
			"    user us ON us.id = dr.user_id " +
			"WHERE " +
			"    dr.is_active = 1 AND " +
			"    dms.drive_id = :driveId AND us.id = :userId " +
			"ORDER BY dms.hour_year DESC " +
			"LIMIT 7")
		Object[][] findDriveAttributesByHour(
				@Param(value = "driveId") long driveId,
				@Param(value = "userId") long userId);

	@Query(
		nativeQuery = true,
		value =
    		"SELECT " +
    		"    dms.hour_year AS timeValue, " +
    		"    dms.highest_temperature AS highestTemp, " +
    		"    dms.current_temperature AS currentTemp, " +
    		"    dms.lowest_temperature AS lowestTemp " +
    		"FROM " +
    		"    devices_hourly_summary dms " +
    		"        INNER JOIN " +
    		"    drive dr ON dr.id = dms.drive_id " +
    		"        INNER JOIN " +
    		"    user us ON us.id = dr.user_id " +
    		"WHERE " +
    		"    dr.is_active = 1 AND " +
    		"    dms.drive_id = :driveId AND us.id = :userId " +
    		"ORDER BY dms.hour_year DESC " +
    		"LIMIT 7")
	Object[][] findDriveTemperature (
    		@Param(value = "driveId") long driveId,
    		@Param(value = "userId") long userId);

	@Query(
	        nativeQuery = true,
	        value =
	            "SELECT " +
	            "   (100 - dms.ssd_drive_life_used) AS value, " +
	            "   (CASE " +
	            "       WHEN ((100 - dms.ssd_drive_life_used) BETWEEN (SELECT min_value FROM drive_health_range WHERE id = 3) AND " +
	            "            (SELECT max_value FROM drive_health_range WHERE id = 3)) THEN (SELECT state FROM drive_health_range WHERE id = 3) " +
	            "       WHEN ((100 - dms.ssd_drive_life_used) BETWEEN (SELECT min_value FROM drive_health_range WHERE id = 2) AND " +
	            "            (SELECT max_value FROM drive_health_range WHERE id = 2)) THEN (SELECT state FROM drive_health_range WHERE id = 2) " +
	            "       WHEN ((100 - dms.ssd_drive_life_used) BETWEEN (SELECT min_value FROM drive_health_range WHERE id = 1) AND " +
	            "            (SELECT max_value FROM drive_health_range WHERE id = 1)) THEN (SELECT state FROM drive_health_range WHERE id = 1) " +
	            "   END) AS status " +
	            "FROM" +
	            "   devices_hourly_summary dms " +
	            "       INNER JOIN" +
	            "   drive dr ON dr.id = dms.drive_id " +
	            "       INNER JOIN" +
	            "   storage_medium sm ON sm.id = dr.storage_medium_id " +
	            "WHERE" +
	            "    dr.is_active = 1 AND " +
	            "   dms.drive_id = :driveId AND dr.user_id = :userId AND sm.name = 'SSD' " +
	            "ORDER BY dms.hour_year DESC " +
	            "LIMIT 1")
	Object[][] findDriveSSDLifeUsed (
    		@Param(value = "driveId") long driveId,
    		@Param(value = "userId") long userId);

	@Query(
		nativeQuery = true,
		value =
			"SELECT " +
			"    dms.drive_health AS value, " +
			"    (CASE " +
			"        WHEN (dms.drive_health BETWEEN (SELECT min_value FROM drive_health_range WHERE id = 3) AND  " +
			"			 (SELECT max_value FROM drive_health_range WHERE id = 3)) THEN (SELECT state FROM drive_health_range WHERE id = 3) " +
			"        WHEN (dms.drive_health BETWEEN (SELECT min_value FROM drive_health_range WHERE id = 2) AND  " +
			"			 (SELECT max_value FROM drive_health_range WHERE id = 2)) THEN (SELECT state FROM drive_health_range WHERE id = 2) " +
			"        WHEN (dms.drive_health BETWEEN (SELECT min_value FROM drive_health_range WHERE id = 1) AND  " +
			"			 (SELECT max_value FROM drive_health_range WHERE id = 1)) THEN (SELECT state FROM drive_health_range WHERE id = 1) " +
			"    END) AS status " +
			"FROM " +
			"    devices_hourly_summary dms " +
			"        INNER JOIN " +
			"    drive dr ON dr.id = dms.drive_id " +
			"WHERE " +
			"    dr.is_active = 1 AND " +
			"    dms.drive_id = :driveId AND dr.user_id = :userId " +
			"ORDER BY dms.hour_year DESC " +
			"LIMIT 1")
	Object[][] findDriveHealth (
    		@Param(value = "driveId") long driveId,
			@Param(value = "userId") long userId);

	@Query(
	        nativeQuery = true,
	        value =
	            "SELECT " +
	            "    dms.drive_health AS value, " +
	            "    (CASE " +
	            "        WHEN (dms.drive_health BETWEEN (SELECT min_value FROM drive_health_range WHERE id = 3) AND  " +
	            "            (SELECT max_value FROM drive_health_range WHERE id = 3)) THEN 'Normal' " +
	            "        WHEN (dms.drive_health BETWEEN (SELECT min_value FROM drive_health_range WHERE id = 2) AND  " +
	            "            (SELECT max_value FROM drive_health_range WHERE id = 2)) THEN  'Warning' " +
	            "        WHEN (dms.drive_health BETWEEN (SELECT min_value FROM drive_health_range WHERE id = 1) AND  " +
	            "            (SELECT max_value FROM drive_health_range WHERE id = 1)) THEN 'Critical' " +
	            "    END) AS status " +
	            "FROM " +
	            "    devices_hourly_summary dms " +
	            "        INNER JOIN " +
	            "    drive dr ON dr.id = dms.drive_id " +
	            "WHERE " +
	            "    dr.is_active = 1 AND " +
	            "    dms.drive_id = :driveId AND dr.user_id = :userId " +
	            "ORDER BY dms.hour_year DESC " +
	            "LIMIT 1")
	    Object[][] findDriveHealth2 (
	            @Param(value = "driveId") long driveId,
	            @Param(value = "userId") long userId);

	@Query(
		nativeQuery = true,
		value =
			"SELECT " +
			"    dr.user_system_id as userSystemId, " +
			"    dr.id as driveId, " +
			"    s.drive_health AS health, " +
			"    (CASE " +
			"        WHEN (s.drive_health BETWEEN (SELECT min_value FROM drive_health_range WHERE id = 3) AND  " +
			"			 (SELECT max_value FROM drive_health_range WHERE id = 3)) THEN (SELECT state FROM drive_health_range WHERE id = 3) " +
			"        WHEN (s.drive_health BETWEEN (SELECT min_value FROM drive_health_range WHERE id = 2) AND  " +
			"			 (SELECT max_value FROM drive_health_range WHERE id = 2)) THEN (SELECT state FROM drive_health_range WHERE id = 2) " +
			"        WHEN (s.drive_health BETWEEN (SELECT min_value FROM drive_health_range WHERE id = 1) AND  " +
			"			 (SELECT max_value FROM drive_health_range WHERE id = 1)) THEN (SELECT state FROM drive_health_range WHERE id = 1) " +
			"    END) AS status " +
			"FROM " +
			"    devices_hourly_summary s " +
			"        INNER JOIN " +
			"    drive dr ON dr.id = s.drive_id " +
			"WHERE " +
			"           dr.is_active = 1 " +
			"    and    dr.user_id = :userId " +
			"ORDER BY s.hour_year DESC ")
	Object[][] getSystemDriveHealthStats(@Param(value = "userId") long userId);

	@Query(
		nativeQuery = true,
		value =
			"SELECT " +
			"    dms.hour_year AS timeValue, " +
			"    dms.current_temperature AS currentTemp " +
			"FROM " +
			"    devices_hourly_summary dms " +
			"        INNER JOIN " +
			"    drive dr ON dr.id = dms.drive_id " +
			"WHERE " +
			"           dr.is_active = 1 " +
			"    and    dms.drive_id = :driveId AND dr.user_id = :userId " +
			"ORDER BY dms.hour_year DESC " +
			"LIMIT 7")
	Object[][] findDriveCurrentTemperature (
    		@Param(value = "driveId") long driveId,
    		@Param(value = "userId") long userId);

	@Query(
		nativeQuery = true,
		value =
    		"SELECT " +
    		"    dms.read_retry_count AS readRetryCount, " +
    		"    dms.write_retry_count AS writeRetryCount, " +
    		"    dms.other_command_retry_count AS otherRetryCount " +
    		"FROM " +
    		"    devices_hourly_summary dms " +
    		"        INNER JOIN " +
    		"    drive dr ON dr.id = dms.drive_id " +
    		"WHERE " +
    		"           dr.is_active = 1 " +
    		"    and    dms.drive_id = :driveId AND dr.user_id = :userId " +
    		"ORDER BY dms.hour_year DESC " +
    		"LIMIT 1")
	Object[][] findRetryCount(
    		@Param(value = "driveId") long driveId,
    		@Param(value = "userId") long userId);

	@Query(
		nativeQuery = true,
		value =
			"SELECT " +
			"    id as id, " +
			"    user_system_id as storageSystemId "+
			"FROM " +
			"    drive " +
			"WHERE " +
			"    is_active = 1 " +
			"    and is_deleted = 0 "+
			"    and user_id = :userId ")
	Object[][] findAllByUserId(Long userId);

	@Query(
			nativeQuery = true,
			value =
				"SELECT * "+
				"FROM " +
				"    drive " +
				"WHERE " +
				"    and user_id = :id ")
	List<Drive> findByUserId(Long id);

	@Query(
		nativeQuery = true,
		value =
        	"SELECT " +
        	"    id " +
        	"FROM " +
        	"    drive " +
        	"WHERE " +
        	"		is_active = 1 " +
        	"	AND is_deleted = FALSE " +
        	"	AND user_id = :userId " +
        	"	AND user_system_id IN (:systemIds)")
	List<BigInteger> findAllByUserAndSystemAndExpansion (
			@Param(value = "systemIds") List<Long> systemIds,
    		@Param(value = "userId") long userId);

	@Query(
		nativeQuery = true,
		value =
			"SELECT " +
			"    dhs.drive_health AS driveHealth " +
			"FROM " +
			"    devices_hourly_summary dhs " +
			"WHERE " +
			"    dhs.drive_id = :driveId " +
			"ORDER BY dhs.hour_year DESC " +
			"LIMIT 1")
	BigInteger findDriveHealthById(
			@Param(value = "driveId") long driveId);

	@Query(
	        nativeQuery = true,
	        value =
	            "SELECT " +
	            "    ds.drive_id as driveId, " +
	            "    d.storage_system_id as  storageSystemId, " +
	            "    ds.drive_health AS health " +
	            "FROM ( " +
	            " select * from " +
	            "    devices_hourly_summary dhs " +
	            "  WHERE " +
	            "    dhs.user_id = :userId " +
	            "ORDER by " +
	            "   dhs.hour_year DESC ) as ds " +
	            "join drive d on d.id = ds.drive_id and  d.is_active = 1 " +
	            "group by d.id ")
    Object[][] findDriveHealthByUserId(@Param(value = "userId") long userId);

	@Query(
		nativeQuery = true,
		value =
			"SELECT " +
			"    dr.id AS driveId, " +
			"    dr.name AS driveName " +
			"FROM " +
			"    drive dr " +
			"WHERE " +
			"           dr.is_active = TRUE " +
			"       AND dr.user_id = :userId " +
			"		AND dr.user_system_id = :systemId")
	Object[][] findDrivesBySystem(
			@Param(value = "systemId") long systemId,
    		@Param(value = "userId") long userId);

	@Query(
		nativeQuery = true,
		value =
			"SELECT " +
			"    rc.group_id AS groups, " +
			"    COUNT(dr.id) AS drives, " +
			"    rc.type AS type, " +
			"    rs.name AS status " +
			"FROM " +
			"    drive dr " +
			"        INNER JOIN " +
			"    raid_config rc ON rc.id = dr.raid_config_id " +
			"        INNER JOIN " +
			"    raid_status rs ON rs.id = dr.raid_status_id " +
			"WHERE " +
			"           dr.is_active = 1 " +
			"    AND    dr.user_id = :userId " +
			"    AND    dr.user_system_id = :systemId " +
			"GROUP BY rc.group_id")
	Object[][] findRaidByExpansion(
			@Param(value = "systemId") long systemId,
    		@Param(value = "userId") long userId);

	@Query(
		nativeQuery = true,
		value =
			"SELECT " +
			"    rc.group_id AS groups, " +
			"    COUNT(dr.id) AS drives, " +
			"    rc.type AS type, " +
			"    rs.name AS status " +
			"FROM " +
			"    drive dr " +
			"        INNER JOIN " +
			"    raid_config rc ON rc.id = dr.raid_config_id " +
			"        INNER JOIN " +
			"    raid_status rs ON rs.id = dr.raid_status_id " +
			"        INNER JOIN " +
			"    user_system us ON us.id = dr.user_system_id " +
			"WHERE " +
			"    dr.is_active = 1 AND " +
			"    dr.user_id = :userId " +
			"        AND    dr.is_active = 1 " +
			"		 AND    us.id = :systemId " +
			"        OR     us.parent_user_system_id = :systemId " +
			"GROUP BY rc.group_id")
	Object[][] findRaidBySystem(
			@Param(value = "systemId") long systemId,
    		@Param(value = "userId") long userId);

	@Query(
		nativeQuery = true,
		value =
			"SELECT " +
			"    read_iops AS readIops, " +
			"    write_iops AS writeIops, " +
			"    hour_year AS hours, " +
			"    date_utc AS dateUTC " +
			"FROM " +
			"    qnap.devices_hourly_summary " +
			"WHERE " +
			"    drive_id = :driveId " +
			"ORDER BY hour_year DESC " +
			"LIMIT 7")
	Object[][] findIopsById(@Param(value = "driveId") long driveId);

	@Query(
		nativeQuery = true,
		value =
			"SELECT " +
			"    * " +
			"FROM " +
			"    drive " +
			"WHERE " +
			"           is_active = 1 " +
			"    AND    id = :driveId " +
			"    AND    user_id = :userId")
	Optional<Drive> findByIdAndUserId(
			@Param(value = "driveId") long driveId,
			@Param(value = "userId") long userId);

    /**
     *
     * @param driveId
     * @return
     */
	@Query(
        nativeQuery = true,
        value =
            "select                                         " +
            "         id,                                   " +
            "         attribute,                            " +
            "         current,                              " +
            "         worst,                                " +
            "         threshold,                            " +
            "         rawValue                              " +
            "from                                           " +
            "(   SELECT                                     " +
            "         hour_year,                            " +
            "         attribute_id AS id,                   " +
            "         attribute_id AS attribute,            " +
            "         attribute_value AS current,           " +
            "         worst_value AS worst,                 " +
            "         threshold_value AS threshold,         " +
            "         raw_value AS rawValue                 " +
            "     FROM                                      " +
            "         smart_raw_data                        " +
            "     where                                     " +
            "        drive_id = :driveId                    " +
            "     ORDER BY                                  " +
            "        hour_year DESC                         " +
            ") as smart_summary                             " +
            " group by                                      " +
            "    id                                         " +
            " order by                                      " +
            "    hour_year,                                 " +
            "    id                                         ")
    Object[][] findSmartAttributesByDriveId(@Param(value = "driveId") long driveId);
	

	
	@Query(nativeQuery=true,value="SELECT  " + 
			"    * " + 
			"FROM " + 
			"    drive " + 
			"WHERE " + 
			"    user_product_id = :userProductId " + 
			"        AND CAST(updated_at AS DATE) > :updatedDate " + 
			"ORDER BY updated_at DESC")
	List<Drive> findAllWithUpdatedAtAfter(
		      @Param("updatedDate") Date updatedDate,@Param("userProductId") Long userProductId);
	
	
	Page<Drive> findByUpdatedAtAfterAndUserProductOrderByUpdatedAtDesc(Date updatedDate,UserProduct userProduct,Pageable pageable);
	


	@Query(nativeQuery = true,
			value = 
			"SELECT " + 
			"	up.id " + 
			"FROM " + 
			"	user_product up " + 
			"WHERE " + 
			"	up.user_id= :userId")
	List<Object> getUserProduct(@Param(value = "userId") Long userId);
	
	
	@Query(nativeQuery = true,
			value = 
			"SELECT " + 
			"	number_of_bays " + 
			"FROM " + 
			"	product p inner join " + 
			"    user_product up on up.product_id=p.id " + 
			"WHERE " + 
			"	up.id= :userProductId")
	Long getNumberOfBays(@Param(value = "userProductId") Long userProductId);
	
	@Query(nativeQuery = true,
			value = 
			"SELECT " + 
			"	 dr.id as id, " + 
			"    dr.name as name, " + 
			"    dr.serial_number as serialNumber, " + 
			"    dr.storage_capacity as storageCapacity, " + 
			"    dr.storage_unit as storageUnit, " + 
			"    dr.slot_number as slotNumber, " + 
			"    dr.interface_type_id as interfaceTypeId, " + 
			"    dr.raid_status_id as raidStatusId, " + 
			"    dr.drive_model_id as driveModelId, " + 
			"    dr.raid_config_id as raidConfigId, " + 
			"    dr.user_product_id as userProductId, " + 
			"    dr.created_at as createdAt, " + 
			"    dr.created_by as createdBy, " + 
			"    dr.updated_by as updatedBy, " + 
			"    dr.updated_at as updatedAt " + 
			"FROM " + 
			"	drive dr inner join " + 
			"    user_product up on up.id=dr.user_product_id " + 
			"WHERE " + 
			"	up.id= :userProductId " + 
			"ORDER BY dr.updated_at DESC ")
	Object[][] getMostResentActiveDrive(@Param(value = "userProductId") Long userProductId);


}
