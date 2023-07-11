package com.example.productsshop;

import com.example.productsshop.domain.DTOs.categoryDTOs.CategoryProductCountsInfoDTO;
import com.example.productsshop.domain.DTOs.productDTOs.ProductWithBuyerNamesDTO;
import com.example.productsshop.domain.DTOs.userDTOs.UserWithSoldProductsDTO;
import com.example.productsshop.domain.DTOs.userDTOs.UsersAndProductsDTO;
import com.example.productsshop.domain.entities.Category;
import com.example.productsshop.domain.entities.Product;
import com.example.productsshop.domain.entities.User;
import com.example.productsshop.services.CategoryService;
import com.example.productsshop.services.ProductService;
import com.example.productsshop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class ConsoleRunner implements CommandLineRunner {
    private UserService userService;
    private ProductService productService;
    private CategoryService categoryService;

    @Autowired
    public ConsoleRunner(UserService userService, ProductService productService, CategoryService categoryService){
        this.userService = userService;
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @Override
    public void run(String... args) throws Exception {

//        String json = USERS_INSERT;
//        UserInsertJsonDTO[] userDTOs = UserInsertJsonDTO.getInstancesFromJson(json);
//        for(UserInsertJsonDTO dto : userDTOs){
//            User user = dto.mapToUser();
//            this.userService.insert(user);
//        }



//        String json = PRODUCTS_INSERT;
//        ProductInsertJsonDTO[] productDTOs = ProductInsertJsonDTO.getInstancesFromJson(json);
//        Random rnd = new Random();
//        int coin = rnd.nextInt(2);
//        for(ProductInsertJsonDTO dto : productDTOs){
//            Product product = dto.mapToEntity();
//            User seller = this.userService.getRandomUser();
//            product.setSeller(seller);
//            coin = rnd.nextInt(2);
//            if(coin > 0){
//                product.setBuyer(this.userService.getRandomUserThatIsNot(seller));
//            }
//            this.productService.insert(product);
//        }



//        String json = CATEGORIES_JSON;
//        CategoryInsertJsonDTO[] catDTOs = CategoryInsertJsonDTO.getInstancesFromJson(json);
//        for(CategoryInsertJsonDTO catDTO : catDTOs){
//            Category category = catDTO.mapToEntity();
//            Set<Product> products = this.productService.getRandomProducts(10);
//            products.forEach(product -> {
//                category.addProduct(product);
//                product.addCategory(category);
//            });
//            this.categoryService.insert(category);
//            products.forEach(product -> this.productService.save(product));
//        }



//        List<Product> products = this.productService.getInPriceRangeNoBuyerSortedPriceAsc(500, 1000);
//        ProductInPriceRangeDTO[] dtos = new ProductInPriceRangeDTO[products.size()];
//        for (int i = 0; i < products.size(); i++) {
//            Product product = products.get(i);
//            ProductInPriceRangeDTO dto = ProductInPriceRangeDTO.mapToDTO(product);
//            dtos[i] = dto;
//        }
//        String json = ProductInPriceRangeDTO.toJSON(dtos);
//        System.out.println(json);


//        List<User> users = this.userService.findUsersWithSoldProductsOrderedByLastNameFirstName();
//        List<UserWithSoldProductsDTO> dtos = new ArrayList<>();
//        for(User user : users){
//            List<Product> unsoldProducts = this.productService.getAllSoldProductsByUser(user);
//            List<ProductWithBuyerNamesDTO> productDTOs = new ArrayList<>();
//            for(Product product : unsoldProducts){
//                ProductWithBuyerNamesDTO productDTO = ProductWithBuyerNamesDTO.mapToDTO(product);
//                productDTOs.add(productDTO);
//            }
//            if(unsoldProducts.size() > 0) {
//                UserWithSoldProductsDTO dto = UserWithSoldProductsDTO.mapToDTO(user, productDTOs);
//                dtos.add(dto);
//            }
//        }
//        UserWithSoldProductsDTO[] usersWithSoldProductsDTOS = dtos.toArray(new UserWithSoldProductsDTO[0]);
//        String json = UserWithSoldProductsDTO.toJSON(usersWithSoldProductsDTOS);
//        System.out.println(json);



//        List<Category> sortedCategories = this.categoryService.getAllCategoriesWithProductsSorted();
//        CategoryProductCountsInfoDTO[] dtos = new CategoryProductCountsInfoDTO[sortedCategories.size()];
//        for (int i = 0; i < sortedCategories.size(); i++) {
//            dtos[i] = CategoryProductCountsInfoDTO
//                    .mapToDTO(sortedCategories.get(i));
//        }
//        String json = CategoryProductCountsInfoDTO.toJson(dtos);
//



//        List<User> usersWithSoldProducts = this.userService.getUsersWithProductsSold();;
//        User[] users = usersWithSoldProducts.toArray(new User[0]);
//        UsersAndProductsDTO dto = UsersAndProductsDTO.create(users);
//        String json = dto.toJson();
//        System.out.println(json);
    }

    public static final String USERS_INSERT = """
            [
            	{ "firstName":"Eugene", "lastName":"Stewart", "age":65},
            	{ "firstName":"Fred", "lastName":"Allen", "age":57 },
            	{ "firstName":"Clarence", "lastName":"Fowler","age":50},
            	{ "firstName":"Betty", "lastName":"Lawson","age":38},
            	{ "firstName":"Anna", "lastName":"Clark","age":41},
            	{ "firstName":"Carl", "lastName":"Daniels","age":59},
            	{ "firstName":"Carl", "lastName":"Lawson","age":19},
            	{ "firstName":null,"lastName":"Fox","age":68},
            	{ "firstName":"Gary","lastName":"Stevens", "age": 0},
            	{ "firstName":null,"lastName":"Mitchell","age":41},
            	{ "firstName":null,"lastName":"Bennett", "age": 0},
            	{ "firstName":"Brenda","lastName":"Howell","age":75},
            	{ "firstName":null,"lastName":"Schmidt","age":70},
            	{ "firstName":"Brandon","lastName":"Fuller","age":30},
            	{ "firstName":null,"lastName":"Moreno","age":37},
            	{ "firstName":null, "lastName":"Stewart","age":39},
            	{ "firstName":null, "lastName":"Peterson","age":72},
            	{ "firstName":"Patrick","lastName":"King", "age": 0},
            	{ "firstName":"Rachel","lastName":"Johnson","age":24},
            	{ "firstName":"Sandra","lastName":"Riley","age":74},
            	{ "firstName":"Gloria","lastName":"Alexander","age":61},
            	{ "firstName":null, "lastName":"Harrison","age":"18"},
            	{ "firstName":"Nicole","lastName":"Harris","age":43},
            	{ "firstName":"Benjamin","lastName":"Henry","age":63},
            	{ "firstName":"Nicole","lastName":"Martinez","age":28},
            	{ "firstName":null, "lastName":"Baker", "age": 0},
            	{ "firstName":"Patricia","lastName":"Cooper","age":72},
            	{ "firstName":null,"lastName":"Thompson","age":46},
            	{ "firstName":"Ann","lastName":"Stevens", "age": 0},
            	{ "firstName":"Christina","lastName":"Patterson","age":63},
            	{ "firstName":"Sarah","lastName":"Day","age":33},
            	{ "firstName":"Jennifer","lastName":"Riley", "age": 0},
            	{ "firstName":"Jacqueline","lastName":"Perez","age":25},
            	{ "firstName":"Amanda","lastName":"Frazier", "age": 0},
            	{ "firstName":"Joshua","lastName":"Murray","age":41},
            	{ "firstName":"Jean","lastName":"Henry", "age": 0},
            	{ "firstName":"Diana","lastName":"Harvey","age":46},
            	{ "firstName":"Emily","lastName":"Parker","age":41},
            	{ "firstName":"Paula","lastName":"Hill","age":74},
            	{ "firstName":"Billy","lastName":"Parker","age":68},
            	{ "firstName":"Jeremy","lastName":"Woods","age":20},
            	{ "firstName":"Christine","lastName":"Gomez","age":28},
            	{ "firstName":"Jonathan","lastName":"Rodriguez", "age": 0},
            	{ "firstName":"Kathy","lastName":"Gilbert","age":51},
            	{ "firstName":"Fred","lastName":"Barnes", "age": 0},
            	{ "firstName":"Anna","lastName":"Parker","age":56},
            	{ "firstName":"Betty","lastName":"Ward","age":70},
            	{ "firstName":"Patricia","lastName":"Fuller","age":36},
            	{ "firstName":"Bonnie","lastName":"Fox","age":18},
            	{ "firstName":"Chris","lastName":"Mitchell","age":59},
            	{ "firstName":null, "lastName":"Cunningham", "age": 0},
            	{ "firstName":"Arthur","lastName":"Reynolds","age":32},
            	{ "firstName":"Thomas","lastName":"Snyder","age":40},
            	{ "firstName":"Marie","lastName":"Williamson", "age": 0},
            	{ "firstName":"Wanda","lastName":"Harris","age":26},
            	{ "firstName":"Doris","lastName":"Cook","age":61}
            ]""";

    public static final String PRODUCTS_INSERT = """
            [{"name":"Care One Hemorrhoidal","price":932.18},
            {"name":"SNORING HP","price":53.59},
            {"name":"ROPINIROLE HYDROCHLORIDE","price":266.44},
            {"name":"kirkland signature minoxidil","price":49.17},
            {"name":"Agaricus Equisetum Special Order","price":585.93},
            {"name":"Lamotrigine Extended Release","price":245.63},
            {"name":"CLARINS Ever Matte SPF 15 - 105 Nude","price":696.06},
            {"name":"Childrens Allegra Allergy","price":650.97},
            {"name":"PredniSONE","price":286.43},
            {"name":"Spironolactone","price":933.69},
            {"name":"U-max Multi BB","price":137.16},
            {"name":"Phenylephrine HCl","price":459.89},
            {"name":"Finasteride","price":1374.01},
            {"name":"Clarins Paris Skin Illusion - 114 cappuccino","price":811.42},
            {"name":"Enalapril Maleate","price":72.71},
            {"name":"MEDICATED DANDRUFF","price":1351.02},
            {"name":"Pleo Lat","price":720.08},
            {"name":"Myristica Argentum Sinus Relief","price":904.52},
            {"name":"Glyburide","price":95.1},
            {"name":"Burn Jel","price":209.57},
            {"name":"CHAMOMILLA","price":37.97},
            {"name":"NEO-POLY-BAC HYDRO","price":967.32},
            {"name":"Prednisone","price":550.72},
            {"name":"Isosorbide Mononitrate","price":789.91},
            {"name":"Glipizide and Metformin Hydrochloride","price":953.6},
            {"name":"TERSI","price":554.91},
            {"name":"SEPHORA Acne-Fighting Mattifying Moisturizer","price":1019.28},
            {"name":"Smooth texture Orange flavor","price":976.65},
            {"name":"DAYWEAR PLUS MULTI PROTECTION TINTED MOISTURIZER","price":555.12},
            {"name":"Zonisamide","price":1305.41},
            {"name":"Peter Island Continous sunscreen kids","price":471.3},
            {"name":"GOONG SECRET CALMING BATH","price":742.47},
            {"name":"Clearskin","price":968.59},
            {"name":"No7 Protect and Perfect Foundation Sunscreen Broad Spectrum SPF 15 Cool Ivory","price":616.19},
            {"name":"Alcohol Free Antiseptic","price":1486.07},
            {"name":"smart sense nighttime cold and flu relief","price":1101.77},
            {"name":"Warfarin Sodium","price":1379.79},
            {"name":"Oxygen","price":1242.92},
            {"name":"Amlodipine Besylate","price":122.57},
            {"name":"CVS Therapeutic Menthol Pain Reliever","price":1033.42},
            {"name":"Warfarin Sodium","price":770.05},
            {"name":"Gilotrif","price":1454.77},
            {"name":"Shopko Lip Treatment","price":861.42},
            {"name":"Albuterol","price":108.95},
            {"name":"Eszopiclone","price":405.03},
            {"name":"EMEND","price":1365.51},
            {"name":"Etomidate","price":393.94},
            {"name":"Megestrol Acetate","price":976.15},
            {"name":"Head and Shoulders Conditioner","price":1099.59},
            {"name":"ERYTHROMYCIN Base Filmtab","price":117.84},
            {"name":"Flumazenil","price":1151.37},
            {"name":"LANEIGE MYSTIC VEIL FOUNDATION","price":20.86},
            {"name":"EPZICOM","price":895.65},
            {"name":"Almond","price":367.32},
            {"name":"Etoposide","price":1483.96},
            {"name":"ESIKA 3-IN-1 PRO MAKE UP FOUNDATION SPF 20 BASE DE MAQUILLAJE PARA ROSTRO 3-EN-1 PRO FPS 20","price":1097.6},
            {"name":"Levothyroxine Sodium","price":885.86},
            {"name":"Dawn Ultra Antibacterial Hand","price":969.86},
            {"name":"cough and sore throat","price":1482.68},
            {"name":"Moore Medical Sinus Pain and Pressure Relief","price":855.39},
            {"name":"Glipizide","price":621.78},
            {"name":"Fosphenytoin Sodium","price":1334.06},
            {"name":"ENALAPRIL MALEATE","price":210.42},
            {"name":"LV-FX","price":820.87},
            {"name":"Wintergreen Isopropyl Alcohol","price":1397.57},
            {"name":"ORCHID SECRET PACT","price":59.53},
            {"name":"Metaxalone","price":79.94},
            {"name":"Allergena","price":109.32},
            {"name":"XANTHIUM STRUMARIUM VAR CANADENSE POLLEN","price":1091.38},
            {"name":"Ampicillin","price":674.63},
            {"name":"Buprenorphine hydrochloride and naloxone hydrochloride dihydrate","price":293.33},
            {"name":"Acnezzol Base","price":710.6},
            {"name":"AMARANTHUS PALMERI POLLEN","price":623.16},
            {"name":"PANTOPRAZOLE SODIUM","price":293.89},
            {"name":"Cold and Cough","price":218.14},
            {"name":"Metformin Hydrochloride","price":953.99},
            {"name":"LBEL Couleur Luxe Rouge Amplifier XP amplifying SPF 15","price":1069.43},
            {"name":"Diastat","price":614.14},
            {"name":"Topical 60 Sec Sodium Fluoride","price":1228.84},
            {"name":"TRAMADOL HYDROCHLORIDE","price":516.48},
            {"name":"Fexofenadine HCl and Pseudoephedrine HCI","price":73.07},
            {"name":"equaline","price":520.45},
            {"name":"Leg Cramp Relief","price":1345.69},
            {"name":"CD CAPTURE TOTALE Triple Correcting Serum Foundation Wrinkles-Dark Spots-Radiance with sunscreen Broad Spectrum SPF 25 010","price":77.23},
            {"name":"PRIMAXIN","price":686.66},
            {"name":"H-Rosacea Formula","price":99.74},
            {"name":"Benazepril Hydrochloride and Hydrochlorothiazide","price":1187.27},
            {"name":"Leflunomide","price":312.85},
            {"name":"BareMinerals Golden Tan matte","price":110.93},
            {"name":"CEDAX","price":342.86},
            {"name":"Topex","price":1258.49},
            {"name":"DIVALPROEX SODIUM","price":1287.03},
            {"name":"Acetic Acid","price":1060.43},
            {"name":"MEDI-FIRST Non-Aspirin","price":1301.28},
            {"name":"Lorazepam","price":1134.96},
            {"name":"Alternaria alternata","price":61.24},
            {"name":"Budpak Hemorrhoid Anesthetic","price":1499.29},
            {"name":"Ringers","price":1054.37},
            {"name":"Allopurinol","price":518.5},
            {"name":"REYATAZ","price":41.97},
            {"name":"Carbon Dioxide Oxygen Mixture","price":95.49},
            {"name":"IOPE RETIGEN MOISTURE TWIN CAKE NO.21","price":1257.71},
            {"name":"MOIST MOISTURE SKIN TONER","price":152.43},
            {"name":"Strattera","price":658.54},
            {"name":"Aquafresh","price":849.93},
            {"name":"Nighttime Sleep Aid","price":1217.11},
            {"name":"Pollens - Weeds and Garden Plants, Nettle Urtica dioica","price":782.77},
            {"name":"Perrigo Benzoyl Peroxide","price":873.24},
            {"name":"ENBREL","price":673.97},
            {"name":"Propranolol Hydrochloride","price":546.95},
            {"name":"Allopurinol","price":48.8},
            {"name":"Trihexyphenidyl Hydrochloride","price":64.88},
            {"name":"Archangelica Eucalyptus","price":1334.91},
            {"name":"Effervescent Cold Relief","price":1436.07},
            {"name":"Allopurinol","price":336.81},
            {"name":"Parsley","price":519.06},
            {"name":"Protonix","price":466.7},
            {"name":"Pollens - Trees, Birch Mix","price":1153.54},
            {"name":"ropinirole hydrochloride","price":103.58},
            {"name":"olio activ mouthwash","price":206.06},
            {"name":"CARBIDOPA AND LEVODOPA","price":441.64},
            {"name":"Pollens - Weeds and Garden Plants, Scotch Broom Cytisus scoparius","price":135.82},
            {"name":"Azithromycin","price":813.87},
            {"name":"Meloxicam","price":809.18},
            {"name":"pain relief","price":938.23},
            {"name":"GEMCITABINE","price":1468.11},
            {"name":"Topiramate","price":578.77},
            {"name":"Cefadroxil","price":1302.2},
            {"name":"Warfarin Sodium","price":138.83},
            {"name":"PAMO Kill Natural","price":1181.06},
            {"name":"Fluoxetine","price":385.37},
            {"name":"Gemcitabine","price":594.79},
            {"name":"Aspen","price":1046.46},
            {"name":"AIR","price":581.69},
            {"name":"AVANDAMET","price":632.08},
            {"name":"Fair Foundation SPF 15","price":1394.24},
            {"name":"Pleo Ginkgo","price":613.65},
            {"name":"Irbesartan and Hydrochlorothiazide","price":308.3},
            {"name":"IOPE SUPER VITAL","price":824.68},
            {"name":"Ibuprofen","price":1088.04},
            {"name":"PREMIER VALUE ALLERGY","price":1127.61},
            {"name":"Labetalol Hydrochloride","price":1345.11},
            {"name":"Prednisone","price":1285.99},
            {"name":"Growing Pains","price":1077.37},
            {"name":"Extra Strength Pain Reliever PM","price":542.72},
            {"name":"Americaine","price":1165.75},
            {"name":"Echinacea Quartz Gum Support","price":570.08},
            {"name":"SUMATRIPTAN SUCCINATE","price":1265.94},
            {"name":"Amitiza","price":666.58},
            {"name":"Goats Milk","price":298.53},
            {"name":"Glycopyrrolate","price":1471.43},
            {"name":"Ondansetron","price":1249.76},
            {"name":"Baza Antifungal","price":1162.34},
            {"name":"Imipramine Hydrochloride","price":648.69},
            {"name":"Aspirin","price":925.45},
            {"name":"Retin-A MICRO","price":995.98},
            {"name":"VITALUMIERE AQUA","price":1293.09},
            {"name":"Stila Hydrating Primer Oil-Free SPF 30","price":179.28},
            {"name":"Enchanted Moments Mistletoe Kisses Hand Sanitizer","price":384.99},
            {"name":"PCA SKIN ACNE","price":1356.22},
            {"name":"CALMING DIAPER RASH","price":700.92},
            {"name":"Labetalol hydrochloride","price":436.38},
            {"name":"Ketorolac Tromethamine","price":608.18},
            {"name":"Foaming Hand Sanitizer","price":624.72},
            {"name":"Aspergillus repens","price":1231.42},
            {"name":"ISOPROPYL ALCOHOL","price":339.48},
            {"name":"XtraCare Foam Antibacterial Hand Wash","price":1251.97},
            {"name":"smart sense nicotine","price":1444.12},
            {"name":"up and up temporary minor arthritis pain relief","price":1085.78},
            {"name":"RESCRIPTOR","price":850.52},
            {"name":"Buprenorphine hydrochloride","price":391.05},
            {"name":"PLANTAGO LANCEOLATA POLLEN","price":561.68},
            {"name":"Gehwol med Lipidro","price":421.24},
            {"name":"Triamterene and Hydrochlorothiazide","price":1416.59},
            {"name":"Ranitidine","price":926.64},
            {"name":"Air","price":331.53},
            {"name":"Metoprolol Tartrate","price":1405.74},
            {"name":"Pioglitazone","price":306.56},
            {"name":"Butalbital, Aspirin and Caffeine","price":1010.98},
            {"name":"Hydralazine Hydrochloride","price":1309.72},
            {"name":"Nevirapine","price":1374.72},
            {"name":"ESIKA","price":879.37},
            {"name":"Homeopathic Rheumatism","price":967.08},
            {"name":"Amitriptyline Hydrochloride","price":1453.96},
            {"name":"Ibuprofen","price":1305.96},
            {"name":"Laser Block 100","price":1135.43},
            {"name":"ANXIETY/STRESS RELIEF","price":324.66},
            {"name":"TYLENOL COLD MULTI-SYMPTOM DAYTIME","price":1010.81},
            {"name":"Naproxen","price":807.22},
            {"name":"Dover Aminophen","price":192.07},
            {"name":"DIPYRIDAMOLE","price":1150.67},
            {"name":"Etodolac","price":1443.13},
            {"name":"ziprasidone hydrochloride","price":628.66},
            {"name":"Treatment Set TS336667","price":1466.47},
            {"name":"Prostate","price":716.05},
            {"name":"Acid Reducer","price":1443.51},
            {"name":"leader pain reliever","price":1179.79},
            {"name":"allergy eye","price":426.91},
            {"name":"Yellow Jacket hymenoptera venom Venomil Diagnostic","price":23.58},
            {"name":"Acetaminophen, Chlorpheniramine Maleate, Dextromethorphan Hydrobromide, Phenylephrine Hydrochloride","price":1028.27}]""";

    private static final String CATEGORIES_JSON = """
            [{"name":"Drugs"},
            {"name":"Adult"},
            {"name":"Electronics"},
            {"name":"Garden"},
            {"name":"Weapons"},
            {"name":"For Children"},
            {"name":"Sports"},
            {"name":"Fashion"},
            {"name":"Autoparts"},
            {"name":"Business"},
            {"name":"Other"}]""";
}
