package com.ulink.portal.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ulink.portal.domain.ProductType;
import com.ulink.portal.domain.User;
import com.ulink.portal.domain.UserProduct;

/**
 * Spring Data repository for the UserSystem entity.
 *
 * @author bpawar
 *
 */
@Repository
public interface UserProductRepository extends JpaRepository<UserProduct, Long> {

	
   public Optional<UserProduct> findBySerialNumber(String serialNumber);
	
	@Query(
        nativeQuery = true,
        value =
            "SELECT " +
            "    us.id AS id, " +
            "    us.parent_user_system_id AS parentSystemId, " +
            "    us.firmware AS firmware, " +
            "    us.operating_system AS operatingSystem, " +
            "    us.host_id AS hostId, " +
            "    us.host_ip AS hostIp, " +
            "    us.updated_at AS lastUpdated, " +
            "    ss.name AS name, " +
            "    ss.model AS model, " +
            "    ss.image_url AS imageUrl, " +
            "    ss.description AS description, " +
            "    li.license_type AS licenseType, " +
            "    sl.expiry_date AS licenseExpiryDate, " +
            "    sl.is_expired AS isLicenseExpired, " +
            "    st.name AS systemType " +
            "FROM " +
            "    user_product us " +
            "        INNER JOIN " +
            "    product ss ON ss.id = us.product_id " +
            "        INNER JOIN " +
            "    system_type st ON st.id = us.system_type_id " +
            "        INNER JOIN " +
            "    system_license sl ON sl.user_product_id = us.id " +
            "        INNER JOIN " +
            "    license li ON li.id = sl.license_id " +
            "WHERE " +
            "        us.user_id = :userId")

    Object[][] getAllSystemInfos(
            @Param(value = "userId") long userId);

    @Query(
        nativeQuery = true,
        value =
            "SELECT " +
            "    count(us.id) AS count, " +
            "    st.name AS systemType  " +
            "FROM " +
            "    user_product us " +
            "        INNER JOIN " +
            "    product ss ON ss.id = us.product_id " +
            "        INNER JOIN " +
            "    system_type st ON st.id = us.system_type_id " +
            "        INNER JOIN " +
            "    system_license sl ON sl.user_product_id = us.id " +
            "        INNER JOIN " +
            "    license li ON li.id = sl.license_id " +
            "WHERE " +
            "        us.user_id = :userId " +
            "group by " +
            "        st.name")

    Object[][] getAllSystemTypesCount(@Param(value = "userId") long userId);

    @Query(
        nativeQuery = true,
        value =
            "SELECT " +
            "    us.id AS id, " +
            "    us.parent_user_system_id AS parentSystemId, " +
            "    us.firmware AS firmware, " +
            "    us.operating_system AS operatingSystem, " +
            "    us.host_id AS hostId, " +
            "    us.host_ip AS hostIp, " +
            "    us.updated_at AS lastUpdated, " +
            "    ss.name AS name, " +
            "    ss.model AS model, " +
            "    ss.image_url AS imageUrl, " +
            "    ss.description AS description, " +
            "    li.license_type AS licenseType, " +
            "    sl.expiry_date AS licenseExpiryDate, " +
            "    sl.is_expired AS isLicenseExpired, " +
            "    st.name AS systemType " +
            "FROM " +
            "    user_product us " +
            "        INNER JOIN " +
            "    product ss ON ss.id = us.product_id " +
            "        INNER JOIN " +
            "    system_type st ON st.id = us.system_type_id " +
            "        INNER JOIN " +
            "    system_license sl ON sl.user_product_id = us.id " +
            "        INNER JOIN " +
            "    license li ON li.id = sl.license_id " +
            "WHERE " +
            "    (us.id = :systemId" +
            "        OR us.parent_user_system_id = :systemId) " +
            "        AND us.user_id = :userId")
    Object[][] findSystemInfo(
            @Param(value = "systemId") long systemId,
            @Param(value = "userId") long userId);

    @Query(
        nativeQuery = true,
        value =
            "SELECT " +
            "    us.id AS id, " +
            "    us.parent_user_system_id AS parentSystemId, " +
            "    us.firmware AS firmware, " +
            "    us.operating_system AS operatingSystem, " +
            "    us.host_id AS hostId, " +
            "    us.host_ip AS hostIp, " +
            "    us.updated_at AS lastUpdated, " +
            "    ss.name AS name, " +
            "    ss.model AS model, " +
            "    ss.image_url AS imageUrl, " +
            "    ss.description AS description, " +
            "    li.license_type AS licenseType, " +
            "    sl.expiry_date AS licenseExpiryDate, " +
            "    sl.is_expired AS isLicenseExpired, " +
            "    st.name AS systemType " +
            "FROM " +
            "    user_product us " +
            "        INNER JOIN " +
            "    product ss ON ss.id = us.product_id " +
            "        INNER JOIN " +
            "    system_type st ON st.id = us.system_type_id " +
            "        INNER JOIN " +
            "    system_license sl ON sl.product_id = us.id " +
            "        INNER JOIN " +
            "    license li ON li.id = sl.license_id " +
            "WHERE " +
            "    us.id = :systemId AND us.user_id = :userId ")
    Object[][] findExpansionInfo(
            @Param(value = "systemId") Long systemId,
            @Param(value = "userId") Long userId);

    @Query(
        nativeQuery = true,
        value =
            "SELECT " +
            "    COUNT(dr.id) AS driveCount, " +
            "	 sm.name AS driveType " +
            "FROM " +
            "    drive dr " +
            "        INNER JOIN " +
            "    storage_medium sm ON sm.id = dr.storage_medium_id " +
            "        INNER JOIN " +
            "    user_product us ON us.id = dr.user_product_id " +
            "WHERE " +
            "           dr.is_active = 1 and " +
            "    (us.id = :systemId " +
            "        OR us.parent_user_system_id = :systemId )" +
            "        AND dr.user_id = :userId " +
            "GROUP BY sm.name " +
            "ORDER BY sm.name ASC")
    Object[][] countDriveByTypes(
            @Param(value = "systemId") Long systemId,
            @Param(value = "userId") Long userId);

    @Query(
        nativeQuery = true,
        value =
            "SELECT " +
            "    COUNT(dr.id) AS driveCount, " +
            "	 sm.name AS driveType " +
            "FROM " +
            "    drive dr " +
            "        INNER JOIN " +
            "    storage_medium sm ON sm.id = dr.storage_medium_id " +
            "        INNER JOIN " +
            "    user_product us ON us.id = dr.user_product_id " +
            "WHERE " +
            "           dr.is_active = 1 " +
            "     and   dr.user_id = :userId " +
            "GROUP BY sm.name " +
            "ORDER BY sm.name ASC")

    Object[][] countAllSystemDriveByTypes(@Param(value = "userId") Long userId);

    @Query(
        nativeQuery = true,
        value =
            "SELECT " +
            "    * " +
            "FROM " +
            "    ((SELECT  " +
            "        SUM(ss.number_of_bays) AS totalBays " +
            "    FROM " +
            "        user_product us " +
            "    INNER JOIN product ss ON ss.id = us.product_id " +
            "    WHERE " +
            "        us.id = :systemId " +
            "            OR us.parent_user_system_id = :systemId " +
            "            AND us.user_id = :userId) AS totalBays, " +
            "	(SELECT " +
            "        COUNT(*) AS totalDrives " +
            "    FROM " +
            "        drive dr " +
            "    INNER JOIN user_product us ON us.id = dr.user_product_id " +
            "    WHERE " +
            "           dr.is_active = 1 and " +
            "        ( us.id = :systemId " +
            "            OR us.parent_user_system_id = :systemId )" +
            "            AND us.user_id = :userId) AS totalDrives " +
            "	)")
    Object[][] countDrivesAndEmptySlots(
            @Param(value = "systemId") Long systemId,
            @Param(value = "userId") Long userId);

    @Query(
        nativeQuery = true,
        value =
            "SELECT " +
            "    * " +
            "FROM " +
            "    ((SELECT  " +
            "        SUM(ss.number_of_bays) AS totalBays " +
            "    FROM " +
            "        user_product us " +
            "    INNER JOIN storage_system ss ON ss.id = us.storage_product_id " +
            "    WHERE " +
            "        us.id = :systemId AND us.user_id = :userId) AS totalBays,  " +
            "	(SELECT  " +
            "        COUNT(*) AS totalDrives " +
            "    FROM " +
            "        drive dr " +
            "    INNER JOIN user_product us ON us.id = dr.user_product_id " +
            "    WHERE " +
            "           dr.is_active = 1 and " +
            "        us.id = :systemId AND us.user_id = :userId) AS totalDrives)")
    Object[][] countSystemTotalDrivesAndEmptySlots(
            @Param(value = "systemId") Long systemId,
            @Param(value = "userId") Long userId);

    @Query(
        nativeQuery = true,
        value =
            "SELECT " +
            "    SUM(dr.storage_capacity) AS totalCapacity " +
            "FROM " +
            "    drive dr " +
            "        INNER JOIN " +
            "    user_product us ON us.id = dr.user_product_id " +
            "WHERE " +
            "           dr.is_active = 1 and " +
            "    us.id = :systemId " +
            "        OR us.parent_user_system_id = :systemId " +
            "        AND us.user_id = :userId")
    Long calculateTotalStorageCapacity(
            @Param(value = "systemId") Long systemId,
            @Param(value = "userId") Long userId);

    @Query(
        nativeQuery = true,
        value =
            "SELECT " +
            "    SUM(dr.storage_capacity) AS storageCapacity, " +
            "    us.id as userSystemId "+
            "FROM " +
            "    drive dr " +
            "        INNER JOIN " +
            "    user_product us ON us.id = dr.user_product_id " +
            "WHERE " +
            "           dr.is_active = 1 " +
            "       and us.user_id = :userId " +
            "group by "+
            "       us.id ")
    Object[][] calculateTotalStorageCapacityAllSystem(@Param(value = "userId") Long userId);

    @Query(
        nativeQuery = true,
        value =
            "SELECT " +
            "    SUM(dr.storage_capacity) AS totalCapacity " +
            "FROM " +
            "    drive dr " +
            "        INNER JOIN " +
            "    user_product us ON us.id = dr.user_product_id " +
            "WHERE " +
            "           dr.is_active = 1 " +
            "    and    us.id = :systemId AND us.user_id = :userId")
    Long calculateExpansionTotalStorageCapacity(
            @Param(value = "systemId") Long systemId,
            @Param(value = "userId") Long userId);

    @Query(
        nativeQuery = true,
        value =
            "SELECT " +
            "    dr.id AS driveId, " +
            "    dr.name AS driveName, " +
            "    dr.serial_number AS serialNumber, " +
            "    dr.storage_capacity AS capacity, " +
            "    dr.created_at AS monitoredSince, " +
            "    dm.name AS model, " +
            "    mnf.name AS manufacturer, " +
            "    rc.group_id AS raidGroupId, " +
            "    rc.type AS raidType, " +
            "    rs.name AS raidStatus " +
            "FROM " +
            "    drive dr " +
            "        INNER JOIN " +
            "    drive_manufacturer mnf ON mnf.id = dr.manufacturer_id " +
            "        INNER JOIN " +
            "    drive_model dm ON dm.id = dr.model_id " +
            "        INNER JOIN " +
            "    raid_config rc ON rc.id = dr.raid_config_id " +
            "        INNER JOIN " +
            "    raid_status rs ON rs.id = dr.raid_status_id " +
            "WHERE " +
            "           dr.is_active = 1 " +
            "    and    dr.user_product_id = :systemId AND dr.user_id = :userId")

    Object[][] findExpansionDriveInfo(
            @Param(value = "systemId") Long systemId,
            @Param(value = "userId") Long userId);

    @Query(
        nativeQuery = true,
        value =
            "SELECT " +
            "    dhs.drive_health AS health, " +
            "    dhs.data_read AS dataRead, " +
            "    dhs.data_write AS dataWrite, " +
            "    dhs.updated_at AS lastReceived " +
            "FROM " +
            "    devices_hourly_summary dhs " +
            "WHERE " +
            "    dhs.drive_id = :driveId " +
            "ORDER BY dhs.updated_at DESC " +
            "LIMIT 1")
    Object[][] findExpansionDriveDataInfo(@Param(value = "driveId") Long driveId);

    List<UserProduct> findByUserId(Long userId);

    @Query(
    	nativeQuery = true,
    	value =
    		"SELECT " +
    		"    dr.user_product_id AS userSystemId, " +
    		"    dr.id AS driveId, " +
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
    		"    drive dr ON dr.id = s.drive_info_id " +
    		"        INNER JOIN " +
    		"    user_product us ON us.id = dr.user_product_id " +
    		"WHERE " +
    		"    dr.user_id = :userId " +
    		"        AND   dr.is_active = 1 " +
    		"        AND (us.id = :systemId " +
    		"        OR us.parent_user_product_id = :systemId) " +
    		"ORDER BY s.hour_year DESC")
	Object[][] getSystemDriveHealthStats(
			@Param(value = "userId") long userId,
	        @Param(value = "systemId") long systemId);

    @Query(
		nativeQuery = true,
		value =
			"SELECT " +
			"    id " +
			"FROM " +
			"    user_product " +
			"WHERE " +
			"    parent_user_product_id = :systemId" +
			"        AND user_id = :userId")
	List<Long> findAllExpansionIds(
			@Param(value = "userId") long userId,
	        @Param(value = "systemId") long systemId);

	boolean existsByIdAndUser(long id, User user);

	@Query(
		nativeQuery = true,
		value =
			"SELECT " +
			"    us.id AS systemId, " +
			"    r.name AS systemName, " +
			"    st.name AS systemType, " +
			"    ss.number_of_bays as totalDrives " +
			"FROM " +
			"    user_product us " +
			"    inner join product ss on ss.id = us.product_id " +
			"        INNER JOIN " +
			"    system_type st ON st.id = us.system_type_id " +
			"        INNER JOIN " +
			"    rack r ON r.id = us.rack_id " +
			"WHERE " +
			"    us.user_id = :userId AND st.name = 'NAS'")
	Object[][] findSystems(@Param(value = "userId") long userId);

	@Query(
		nativeQuery = true,
		value =
			"SELECT " +
			"    us.id AS systemId, " +
			"    r.name AS systemName, " +
			"    st.name AS systemType, " +
			"    ss.number_of_bays as totalDrives " +
			"FROM " +
			"    user_product us " +
			"    inner join product ss on ss.id = us.product_id " +
			"        INNER JOIN " +
			"    system_type st ON st.id = us.system_type_id " +
			"        INNER JOIN " +
			"    rack r ON r.id = us.rack_id " +
			"WHERE " +
			"    us.user_id = :userId " +
			"        AND us.parent_user_product_id = :systemId " +
			"        AND st.name = 'EXP'")
	Object[][] findExpansions(
			@Param(value = "userId") long userId,
			@Param(value = "systemId") long systemId);

	@Query(
		nativeQuery = true,
		value =
    		"SELECT " +
    		"    * " +
    		"FROM " +
    		"    user_product " +
    		"WHERE " +
    		"    id = :systemId AND user_id = :userId")
	Optional<UserProduct> existsByIdAndUser(
			@Param(value = "systemId")long systemId,
			@Param(value = "userId")long userId);

	@Query(
		nativeQuery = true,
		value =
			"SELECT " +
			"    ss.number_of_bays AS totalBays " +
			"FROM " +
			"    user_product us " +
			"        INNER JOIN " +
			"    product ss ON ss.id = us.product_id " +
			"WHERE " +
			"    us.id = :systemId AND us.user_id = :userId ")
	Long findTotalBays(
			@Param(value = "systemId")long systemId,
			@Param(value = "userId")long userId);

	
	// New Methods
	List<UserProduct> findAllByUserAndProductTypeOrderByCreatedAtDesc(User loggedInUser, ProductType productType);

	List<UserProduct> findAllByUserAndParentUserProductAndProductType(User loggedUser, UserProduct nas, ProductType productType);

	Optional<UserProduct> findByIdAndUserAndParentUserProductIsNull(long id, User loggedInUser);

	List<UserProduct> findByParentUserProduct(UserProduct userProduct);

	
}
