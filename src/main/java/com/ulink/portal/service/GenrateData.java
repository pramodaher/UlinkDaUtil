package com.ulink.portal.service;

import java.io.File;
import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Service;

import com.ulink.portal.domain.Drive;
import com.ulink.portal.domain.DriveManufacturer;
import com.ulink.portal.domain.DriveModel;
import com.ulink.portal.domain.InterfaceType;
import com.ulink.portal.domain.LicensePurchase;
import com.ulink.portal.domain.LicenseType;
import com.ulink.portal.domain.LicenseUserProduct;
import com.ulink.portal.domain.Product;
import com.ulink.portal.domain.ProductType;
import com.ulink.portal.domain.Rack;
import com.ulink.portal.domain.RaidConfig;
import com.ulink.portal.domain.RaidStatus;
import com.ulink.portal.domain.Role;
import com.ulink.portal.domain.User;
import com.ulink.portal.domain.UserProduct;
import com.ulink.portal.enumeration.GracePeriodUnit;
import com.ulink.portal.repository.DriveManufacturerRepository;
import com.ulink.portal.repository.DriveModelRepository;
import com.ulink.portal.repository.DriveRepository;
import com.ulink.portal.repository.LicensePurchaseRepository;
import com.ulink.portal.repository.LicenseTypeRepository;
import com.ulink.portal.repository.LicenseUserProductRepository;
import com.ulink.portal.repository.ProductRepository;
import com.ulink.portal.repository.ProductTypeRepository;
import com.ulink.portal.repository.RackRepository;
import com.ulink.portal.repository.RaidConfigRepository;
import com.ulink.portal.repository.RaidStatusRepository;
import com.ulink.portal.repository.RoleRepository;
import com.ulink.portal.repository.UserProductRepository;
import com.ulink.portal.repository.UserRepository;


@Service
public class GenrateData {

	
	static int userProductSerialNumber = 1;
	static int userProductIP1 = 1;
	static int userProductIp2 = 1;
	static int driveSerialNumber = 1;
	static int licenseToken = 1;
	static int licenseId = 1;


	@Autowired
	RoleRepository roleRepository; 
	
	@Autowired
	RaidStatusRepository raidStatusRepository;
	
	@Autowired
	RaidConfigRepository raidConfigRepository;
	
	@Autowired
	RackRepository rackRepository;
	
	@Autowired
	ProductTypeRepository productTypeRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	LicenseTypeRepository licenseTypeRepository;
	
	@Autowired
	LicensePurchaseRepository licensePurchaseRepository;
	
	@Autowired
	LicenseUserProductRepository licenseUserProductRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserProductRepository userProductRepository;
	
	@Autowired
	DriveRepository driveRepository;
	
	@Autowired
	DriveManufacturerRepository driveManufacturerRepository;
	
	@Autowired
	DriveModelRepository driveModelRepository;
	
	public void genrate(int noOfUser) throws Exception{
		
		
//		createRole();
//		System.out.println("Role Created");
//		
//		createRaidStatus();
//		System.out.println("RaidStatus Created");
//		
//		createRaidConfig();
//		System.out.println("RaidConfig Created");
//		
//		createProductType();
//		System.out.println("Product Type Created");
//		
//		createRack();
//		System.out.println("Rack Created");
//		
//		createLicenseType();
//		System.out.println("License Type Created");
//		
//		createProduct();
//		System.out.println("Product Created");
		
		createUser(noOfUser);
		System.out.println("User Created");

	}
	
	public  void createRole() {


		Role role = new Role();
		role.setRoleName("ADMIN");
		role.setRoleDesc("ROLE_ADMIN");
		roleRepository.save(role);

		role = new Role();
		role.setRoleName("USER");
		role.setRoleDesc("ROLE_USER");
		roleRepository.save(role);

	}

	public  void createRaidStatus() {

		RaidStatus raidStatus = new RaidStatus();
		raidStatus.setName("Ready");
		raidStatusRepository.save(raidStatus);

		raidStatus = new RaidStatus();
		raidStatus.setName("Degrade");
		raidStatusRepository.save(raidStatus);

		raidStatus = new RaidStatus();
		raidStatus.setName("Fail");
		raidStatusRepository.save(raidStatus);

	}

	public void createRaidConfig() {

		RaidConfig raidConfig = new RaidConfig();
		raidConfig.setGroupId(1L);
		raidConfig.setType("RAID 1");
		raidConfigRepository.save(raidConfig);

		raidConfig = new RaidConfig();
		raidConfig.setGroupId(1L);
		raidConfig.setType("RAID 5");
		raidConfigRepository.save(raidConfig);
		
		raidConfig = new RaidConfig();
		raidConfig.setGroupId(2L);
		raidConfig.setType("RAID 1");
		raidConfigRepository.save(raidConfig);

		raidConfig = new RaidConfig();
		raidConfig.setGroupId(2L);
		raidConfig.setType("RAID 5");
		raidConfigRepository.save(raidConfig);

	}

	public void createRack() {

		for (int i = 0; i <= 30; i++) {
			Rack rack = new Rack();
			rack.setSequecneNo(i);
			rackRepository.save(rack);
		}

	}

	public void createProductType() {

		ProductType productType = new ProductType();
		productType.setName("NAS");
		productType.setDescription("NAS");
		productTypeRepository.save(productType);

		productType = new ProductType();
		productType.setName("EXP");
		productType.setDescription("EXP");
		productTypeRepository.save(productType);

	}

	public void createProduct() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("How many product you want to enter:");
		int noOfProduct = scanner.nextInt();

		String modelNumber = "TVS-951X";
		int bay = 16;

		for (int i = 0; i < noOfProduct; i++) {

			Product product = new Product();
			product.setModel(modelNumber);
			product.setNumberOfBays(bay);
			product.setCreatedAt(new Date());
			product.setUpdatedAt(new Date());

			productRepository.save(product);
		}

	}
	
	public void createLicenseType() {
		
		LicenseType licenseType=new LicenseType();
		licenseType.setName("L1-1");
		licenseType.setDescription("1-4 bay NAS");
		ProductType productType=new ProductType();
		productType.setId(1L);
		licenseType.setProductType(productType);
		licenseTypeRepository.save(licenseType);
		
		licenseType=new LicenseType();
		licenseType.setName("L1E-1");
		licenseType.setDescription("Expansion attached to L1");
		productType=new ProductType();
		productType.setId(2L);
		licenseType.setProductType(productType);
		licenseTypeRepository.save(licenseType);
		
		licenseType=new LicenseType();
		licenseType.setName("L2-1");
		licenseType.setDescription("5-12 bay NAS");
		productType=new ProductType();
		productType.setId(1L);
		licenseType.setProductType(productType);
		licenseTypeRepository.save(licenseType);
		
		licenseType=new LicenseType();
		licenseType.setName("L2E-1");
		licenseType.setDescription("Expansion attached to L2");
		productType=new ProductType();
		productType.setId(2L);
		licenseType.setProductType(productType);
		licenseTypeRepository.save(licenseType);
		
		licenseType=new LicenseType();
		licenseType.setName("L3-1");
		licenseType.setDescription("13 bay and above NAS");
		productType=new ProductType();
		productType.setId(1L);
		licenseType.setProductType(productType);
		licenseTypeRepository.save(licenseType);
		
		licenseType=new LicenseType();
		licenseType.setName("L3E-3");
		licenseType.setDescription("Expansion attached to L3");
		productType=new ProductType();
		productType.setId(2L);
		licenseType.setProductType(productType);
		licenseTypeRepository.save(licenseType);
		
		
	}
	
	public LicensePurchase purchaseLicense(User user,long userProductTypeId,long noOfBay,LicensePurchase parentLicensePerches)throws Exception {
		
		LicensePurchase licensePurchase=new LicensePurchase();
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
		
		licensePurchase.setLicenseToken("d3637hduydkosjyo9465dhd"+licenseToken++);
		licensePurchase.setPurchaseDate(new Date());
		licensePurchase.setLicenseId("d3637hdsdgkjhskj"+licenseId++);
		licensePurchase.setActive(true);
		licensePurchase.setExpirationDate(dateFormat.parse("2020-08-12 00:00:00"));
		licensePurchase.setActivationDate(new Date());
		licensePurchase.setGracePeriod(30);
		licensePurchase.setGracePeriodUnit(GracePeriodUnit.DAY);
		

		if(userProductTypeId==1) {
				if(noOfBay>=13) {					
					LicenseType licenseType=new LicenseType();
					licenseType.setId(5L);
					licensePurchase.setLicenseType(licenseType);					
				}
				else if(noOfBay>=5) {					
					LicenseType licenseType=new LicenseType();
					licenseType.setId(3L);
					licensePurchase.setLicenseType(licenseType);					
				}
				else{					
					LicenseType licenseType=new LicenseType();
					licenseType.setId(1L);
					licensePurchase.setLicenseType(licenseType);					
				}
		}
		else {
			long id=parentLicensePerches.getId();
			
			if(id==1) {
				LicenseType licenseType=new LicenseType();
				licenseType.setId(2L);
				licensePurchase.setLicenseType(licenseType);		
			} else if(id==3) {
				LicenseType licenseType=new LicenseType();
				licenseType.setId(4L);
				licensePurchase.setLicenseType(licenseType);		
			}else {
				LicenseType licenseType=new LicenseType();
				licenseType.setId(6L);
				licensePurchase.setLicenseType(licenseType);	
			}
			
		}
		if(parentLicensePerches==null) {
			licensePurchase.setParentLicensePurchaseId(null);
		}else {
			licensePurchase.setParentLicensePurchaseId(parentLicensePerches.getId());
		}
		
		licensePurchase.setUser(user);
		licensePurchase.setCreatedAt(new Date());
		licensePurchase.setUpdatedAt(new Date());
		
		licensePurchase=licensePurchaseRepository.save(licensePurchase);
		return licensePurchase;	
		
	}
	
	public void createLicenseUserProduct(UserProduct userProduct,LicensePurchase licensePurchase) {
	
		LicenseUserProduct licenseUserProduct=new LicenseUserProduct();
		licenseUserProduct.setUserProduct(userProduct);
		licenseUserProduct.setLicensePurchase(licensePurchase);
		licenseUserProductRepository.save(licenseUserProduct);
		
	}

	public void createUser(int noOfuser) throws Exception {

		Scanner scanner = new Scanner(System.in);
		String userEmailList[] = { "apramod@agsft.com", "amit@agsft.com", "bpawar@agsft.com", };
//		System.out.println("How many user you want to create:");
//		int noOfUser = scanner.nextInt();
		Random random = new Random();
		for (int i = 0; i < noOfuser; i++) {

//			User user = new User();
////			user.setEmail(userEmailList[random.nextInt((2-0)+1)+0]);
//			user.setEmail("1000System@agsft.com");
//			user.setLogin("5cca619d48cfd06b2a1467c3");
//			user.setPassword("$2a$10$hsoiIqbJDiuJdJWSRtvfdu19beHNiWrxltSR1m160aIOwJZUjlw0y");
//			user.setAccountId(1L);
//			user.setActive(true);
//			user.setCreatedAt(new Date());
//			user.setProfileFetch(false);
//			user.setProfileUpdatedAt(null);
//			user.setUpdatedAt(new Date());
//			List<Role> roleList=new ArrayList<>();
//			Role role=new Role();
//			role.setId(1L);
//			roleList.add(role);
//			user.setRoles(roleList);
//			user = userRepository.save(user);
//
//			createUserProductNAS(user);
			
			User user = userRepository.findById(7L).get();
			
			createUserProductNAS(user);
		}

	}


	public void createUserProductNAS(User user) throws Exception {

		List<Product> productList = productRepository.findAll();
//		Scanner scanner = new Scanner(System.in);
		int noOfSystem = 791;

//		System.out.println("How Many NAS for userId:" + user.getId());
//		noOfSystem = scanner.nextInt();
//		scanner.nextLine();

		for (int j = 1; j <= noOfSystem; j++) {

			String hostID = user.getEmail().split("@")[0] + "@ags-d-158";
			UserProduct userProduct = new UserProduct();
			userProduct.setSerialNumber("Q171B24828" + Integer.toString(userProductSerialNumber++));
			userProduct.setFirmware("4.4.1");
			userProduct.setOperatingSystem("QTS 4.4.0(Embedded Linux)");

			if (userProductIP1 == 254) {
				userProductIp2++;
				userProductIP1 = 1;
			}
			userProduct.setHostIp("172.156." + userProductIp2 + "." + userProductIP1++);

			userProduct.setHostId(hostID);

			Rack rack = new Rack();
			rack.setId(1L);
			userProduct.setRack(rack);
			userProduct.setParentUserProduct(null);

			userProduct.setUser(user);

			Random random = new Random();
			Product product = productList.get(random.nextInt(((productList.size() - 1) - 0) + 1) + 0);
			userProduct.setProduct(product);

			ProductType productType = new ProductType();
			productType.setId(1L);
			userProduct.setProductType(productType);

			userProduct.setCreatedAt(new Date());
			userProduct.setUpdatedAt(new Date());
			userProduct = userProductRepository.save(userProduct);
			
			LicensePurchase parentLicensePurchase=purchaseLicense(user, userProduct.getProductType().getId(),userProduct.getProduct().getNumberOfBays(), null);
			createLicenseUserProduct(userProduct,parentLicensePurchase);
			
			LicensePurchase ExpLicensePurchase=purchaseLicense(user,2L,userProduct.getProduct().getNumberOfBays(), parentLicensePurchase);

			createDrive(userProduct, product.getNumberOfBays());
			createUserProductEXP(userProduct, user,ExpLicensePurchase);

		}

	}

	public void createUserProductEXP(UserProduct parentUserProduct,
			User user,LicensePurchase licensePerches) throws Exception {

		List<Product> productList = productRepository.findAll();
		Scanner scanner = new Scanner(System.in);

//		System.out.println("How many Expansion For ProductId:" + parentUserProduct.getId());
//		int noOfExpansion = scanner.nextInt();
	
		Random random = new Random();
		int noOfExpansion=random.nextInt((30-0)+1)+0;

		for (int i = 1; i <= noOfExpansion; i++) {

			UserProduct userProduct = new UserProduct();
			userProduct.setSerialNumber("Q171B24829" + userProductSerialNumber++);
			userProduct.setFirmware("4.4.1");
			userProduct.setOperatingSystem("QTS 4.4.0(Embedded Linux)");

			if (userProductIP1 == 254) {
				userProductIp2++;
				userProductIP1 = 1;
			}
			userProduct.setHostIp("172.156." + userProductIp2 + "." + userProductIP1++);

			userProduct.setHostId(parentUserProduct.getSerialNumber());

			Rack rack = new Rack();
			rack.setId((long) i + 1);
			userProduct.setRack(rack);
			userProduct.setParentUserProduct(parentUserProduct);
			userProduct.setUser(user);

			Product product = productList.get(random.nextInt(((productList.size() - 1) - 0) + 1) + 0);
			userProduct.setProduct(product);

			ProductType productType = new ProductType();
			productType.setId(2L);
			userProduct.setProductType(productType);

			userProduct.setCreatedAt(new Date());
			userProduct.setUpdatedAt(new Date());
			userProduct = userProductRepository.save(userProduct);
			
		
			createLicenseUserProduct(userProduct,licensePerches);
			

			createDrive(userProduct, product.getNumberOfBays());

		}

	}

	public void createDrive(UserProduct userProduct, int noOfbays)
			throws Exception {

		Random random = new Random();
	//	int noOfDrive = random.nextInt((noOfbays - 0) + 1) + 0;
		int duplicateDrive = 0;
		int storageCapacity[] = new int[] { 100, 200, 500, 1000 };
		String driveType[] = new String[] { "HDD", "SSD" };

		List<Drive> list = new ArrayList<>();

		for (int i = 1; i <= noOfbays; i++) {

			Drive drive = new Drive();
			drive.setSerialNumber("DRNHNX0H401817M" + Integer.toString(driveSerialNumber++));
			drive.setStorageCapacity(storageCapacity[(random.nextInt((3 - 0) + 1)) + 0]);
			drive.setStorageUnit("GB");
			drive.setSlotNumber(Integer.toString(i));

			InterfaceType interfaceType = new InterfaceType();
			interfaceType.setId((long) (random.nextInt((3 - 1) + 1)) + 1);
			drive.setInterfaceType(interfaceType);

			RaidStatus raidStatus = new RaidStatus();
			raidStatus.setId((long)random.nextInt((3 - 1) + 1)+1);
			drive.setStatus(raidStatus);

			DriveModel driveModel = new DriveModel();
			driveModel.setId((long) (random.nextInt((5 - 1) + 1)) + 1);
			drive.setModel(driveModel);

			RaidConfig raidConfig = new RaidConfig();
			raidConfig.setId(1L);
			drive.setRaidConfig(raidConfig);

			random = new Random();
			drive.setDriveType(driveType[(random.nextInt((1 - 0) + 1)) + 0]);

			drive.setUserProduct(userProduct);

			drive.setCreatedAt(new Date());

			if (duplicateDrive > 0) {

				DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
				Date thisDate = new Date();
				int day = (random.nextInt((24 - 19) + 1)) + 19;
				thisDate.setDate(day);

				drive.setCreatedAt(thisDate);
				drive.setUpdatedAt(thisDate);
				drive = driveRepository.save(drive);
				drive.setId(null);
				drive.setSerialNumber("DRNHNX0H401817M" + Integer.toString(driveSerialNumber++));
				drive.setStorageCapacity(storageCapacity[(random.nextInt((3 - 0) + 1)) + 0]);
				duplicateDrive--;

			}
			drive.setCreatedAt(new Date());
			drive.setUpdatedAt(new Date());

			drive = driveRepository.save(drive);

		}

	}

	///////// this method is not used for data genration

	public void readDriveModel() {



		List<DriveManufacturer> DriveManufacturerList = new ArrayList<>();

		List<String> model = new ArrayList<>();

		List<String> manufactureList = new ArrayList<>();
		Map<String, List<String>> manufactureModel = new HashMap<>();
		try {
			FileInputStream file = new FileInputStream(
					new File("/home/pramod/Downloads/drive model SA (SSD or HDD) 20190629 001.xlsx"));

			XSSFWorkbook workbook = new XSSFWorkbook(file);

			for (int j = 2; j <= 3; j++) {

				XSSFSheet sheet = workbook.getSheetAt(j);

				Iterator<Row> rowIterator = sheet.iterator();
				while (rowIterator.hasNext()) {
					Row row = rowIterator.next();
					// For each row, iterate through all the columns
					Iterator<Cell> cellIterator = row.cellIterator();
					int i = 1;
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (i == 2) {
							model.add(cell.getStringCellValue());
							break;
						}
						i++;
					}
				}

			}

			file.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		model.forEach(madelObj -> {
			String manf[] = madelObj.split(" ");
			manufactureList.add(manf[0].toUpperCase());
		});
		List<String> manf = manufactureList.stream().distinct().collect(Collectors.toList());

		manf.forEach(manf1 -> {
			List<String> modelList = model.stream().filter(obj -> obj.startsWith(manf1)).collect(Collectors.toList());
			List<String> modelList1 = modelList.stream().map(obj -> obj.substring(manf1.length(), obj.length()))
					.collect(Collectors.toList());

			manufactureModel.put(manf1, modelList1);
			;
		});

		Set<String> key = manufactureModel.keySet();

		key.forEach(key1 -> {
			DriveManufacturer driveManufacturer = new DriveManufacturer();
			driveManufacturer.setName(key1);
			driveManufacturerRepository.save(driveManufacturer);

		});

		key.forEach(key1 -> {

			DriveManufacturer driveManufacturer = driveManufacturerRepository.findByName(key1).get();

			List<String> values = manufactureModel.get(key1);

			values.forEach(value -> {
				DriveModel driveModel = new DriveModel();
				driveModel.setName(value);
				driveModel.setManufacturer(driveManufacturer);
				driveModelRepository.save(driveModel);
			});

		});
		// model.forEach(System.out::println);

	}
	
	
	/////////// addProductBay ////////////////
	
	public void addProductBay(ConfigurableApplicationContext context) {
		
		ProductRepository productRepository=context.getBean(ProductRepository.class);
	
		List<String> modelList=new ArrayList<String>();
		List<Integer> bayList=new ArrayList<Integer>();
		
		
		try
        {
            FileInputStream file = new FileInputStream(new File("/home/pramod/Downloads/JBOD Expansion Unit Search Tool (JBOD Matrix) external 20190426.xlsx"));
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            int k=1;
            while (rowIterator.hasNext())
            {
            	
                Row row = rowIterator.next();
                if(k<=4) {
            		k++;
            		continue;
            	}
                //For each row, iterate through all the columns
                Iterator<Cell> cellIterator = row.cellIterator();
                 int i=1;
                while (cellIterator.hasNext())
                {
                	Cell cell = cellIterator.next();
                	if(i==2) {
                		modelList.add(cell.getStringCellValue());
                		
                	}
                	if(i==3) {
                		bayList.add((int)cell.getNumericCellValue());
                	}
                	i++;               
                }  
            }
            file.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        

		for(int i=0;i<modelList.size();i++) {
			Optional<Product> product=productRepository.findByModelIgnoreCase(modelList.get(i));
			Product prod=null;
			if(product.isPresent()) {
				prod=product.get();
				prod.setNumberOfBays(bayList.get(i));
				productRepository.save(prod);
			}
		}
		
		
	}
	////////// Update product image_url from folder
	public void updateProductImageURL() {

		final File folder = new File("/home/pramod/Downloads/ChassisView");
		List<String> fileList=new ArrayList<String>();
		
		 for (final File fileEntry : folder.listFiles()) {
		        if (fileEntry.isDirectory()) {
		            continue;
		        } else {
		        	String str=fileEntry.getName();
		        	String model[]=str.split(".png");
		        	
		        	Optional<Product> product=productRepository.findByModelIgnoreCase(model[0]);
					Product prod=null;
					if(product.isPresent()) {
						prod=product.get();
						if(prod.getImageURL()==null) {
							
							prod.setImageURL(fileEntry.getName());
							productRepository.save(prod);
						}
						
						
					}

		        }
		    }
	}


}
